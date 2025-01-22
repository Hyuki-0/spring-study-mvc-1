package com.hyuki.springstudymvc1.web.frontcontroller.v1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerV1 extends HttpServlet {
  private final Map<String, ControllerV1> controllerHandler = new HashMap<>();

  public FrontControllerV1() {
    controllerHandler.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
    controllerHandler.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
    controllerHandler.put("/front-controller/v1/members", new MemberListControllerV1());
  }
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    controllerHandler.get(request.getRequestURI()).process(request, response);
  }
}
