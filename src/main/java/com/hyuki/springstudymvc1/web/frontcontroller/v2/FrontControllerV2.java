package com.hyuki.springstudymvc1.web.frontcontroller.v2;

import com.hyuki.springstudymvc1.web.frontcontroller.MView;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerV2 extends HttpServlet {
  private final Map<String, ControllerV2> controllerHandler = new HashMap<>();

  public FrontControllerV2() {
    controllerHandler.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
    controllerHandler.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
    controllerHandler.put("/front-controller/v2/members", new MemberListControllerV2());
  }
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ControllerV2 controller = controllerHandler.get(request.getRequestURI());
    if (controller == null) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return;
    }

    MView process = controller.process(request, response);
    process.render(request, response);
  }
}
