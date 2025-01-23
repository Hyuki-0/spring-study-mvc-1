package com.hyuki.springstudymvc1.web.frontcontroller.v4;

import com.hyuki.springstudymvc1.web.frontcontroller.MView;
import com.hyuki.springstudymvc1.web.frontcontroller.ModelView;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerV4", urlPatterns = "/front-controller/v4/*")
public class FrontControllerV4 extends HttpServlet {

  private static final String URL_PREFIX = "/WEB-INF/views/";
  private static final String EXTEND = ".jsp";

  private final Map<String, ControllerV4> controllerHandler = new HashMap<>();

  public FrontControllerV4() {
    controllerHandler.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
    controllerHandler.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
    controllerHandler.put("/front-controller/v4/members", new MemberListControllerV4());
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ControllerV4 controller = controllerHandler.get(request.getRequestURI());
    if (controller == null) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return;
    }

    Map<String, Object> model = new HashMap<>();
    MView view = viewResolver(controller.process(createParamMap(request), model));

    view.render(request, response, model);
  }

  private Map<String, String> createParamMap(HttpServletRequest request) {
    Map<String, String> data = new HashMap<>();

    request.getParameterNames()
        .asIterator()
        .forEachRemaining(param -> data.put(param, request.getParameter(param)));

    return data;
  }

  private MView viewResolver(String viewName) {
    return new MView(URL_PREFIX + viewName + EXTEND);
  }
}
