package com.hyuki.springstudymvc1.web_custom.frontcontroller.advance;

import com.hyuki.springstudymvc1.web_custom.frontcontroller.ModelView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {

  /*
  * handler : Controller
  * */
  boolean supports(Object handler);

  ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;
}
