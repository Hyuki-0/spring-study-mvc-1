package com.hyuki.springstudymvc1.web.frontcontroller.advance;

import com.hyuki.springstudymvc1.web.frontcontroller.ModelView;
import com.hyuki.springstudymvc1.web.frontcontroller.v4.ControllerV4;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {

  @Override
  public boolean supports(Object handler) {
    return (handler instanceof ControllerV4);
  }

  @Override
  public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler)  throws ServletException, IOException {
    ControllerV4 controller = (ControllerV4) handler;
    Map<String, String> params = createParamMap(request);
    Map<String, Object> model = new HashMap<>();

    ModelView mv = new ModelView(controller.process(params, model));
    mv.setModel(model);

    return mv;
  }

  private Map<String, String> createParamMap(HttpServletRequest request) {
    Map<String, String> data = new HashMap<>();

    request.getParameterNames()
        .asIterator()
        .forEachRemaining(param -> data.put(param, request.getParameter(param)));

    return data;
  }
}
