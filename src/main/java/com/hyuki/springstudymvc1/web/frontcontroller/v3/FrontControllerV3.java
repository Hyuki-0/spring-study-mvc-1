package com.hyuki.springstudymvc1.web.frontcontroller.v3;

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

@WebServlet(name = "frontControllerV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerV3 extends HttpServlet {

  private static final String URL_PREFIX = "/WEB-INF/views/";
  private static final String EXTEND = ".jsp";

  private final Map<String, ControllerV3> controllerHandler = new HashMap<>();

  public FrontControllerV3() {
    controllerHandler.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
    controllerHandler.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
    controllerHandler.put("/front-controller/v3/members", new MemberListControllerV3());
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ControllerV3 controller = controllerHandler.get(request.getRequestURI());
    if (controller == null) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return;
    }

    Map<String, String> data = createParamMap(request);
    ModelView mv = controller.process(data);

    MView view = viewResolver(mv.getViewName());
    view.render(mv.getModel(), request, response);
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
