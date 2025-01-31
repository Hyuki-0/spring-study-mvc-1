package com.hyuki.springstudymvc1.web_custom.frontcontroller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class MView {

  private String viewPath;

  public MView(String viewPath) {
    this.viewPath = viewPath;
  }

  public void render(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RequestDispatcher dispatcher = request.getRequestDispatcher(this.viewPath);
    dispatcher.forward(request, response);
  }

  public void render(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model)
      throws ServletException, IOException {
    modelToRequestAttribute(model, request);
    RequestDispatcher dispatcher = request.getRequestDispatcher(this.viewPath);
    dispatcher.forward(request, response);
  }

  private void modelToRequestAttribute(Map<String, Object> mv, HttpServletRequest request) {
    mv.forEach(request::setAttribute);
  }
}
