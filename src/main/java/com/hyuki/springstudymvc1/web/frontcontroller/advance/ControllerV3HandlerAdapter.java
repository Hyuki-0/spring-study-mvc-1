package com.hyuki.springstudymvc1.web.frontcontroller.advance;

import com.hyuki.springstudymvc1.web.frontcontroller.ModelView;
import com.hyuki.springstudymvc1.web.frontcontroller.v3.ControllerV3;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {

  @Override
  public boolean supports(Object handler) {
    return (handler instanceof ControllerV3);
  }

  @Override
  public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {

    ControllerV3 controller = (ControllerV3) handler;
    Map<String, String> params = createParamMap(request);

    return controller.process(params);
  }

  private Map<String, String> createParamMap(HttpServletRequest request) {
    Map<String, String> data = new HashMap<>();

    request.getParameterNames()
        .asIterator()
        .forEachRemaining(param -> data.put(param, request.getParameter(param)));

    return data;
  }
}
