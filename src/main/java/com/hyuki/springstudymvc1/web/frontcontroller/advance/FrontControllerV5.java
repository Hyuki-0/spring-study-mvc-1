package com.hyuki.springstudymvc1.web.frontcontroller.advance;

import com.hyuki.springstudymvc1.web.frontcontroller.MView;
import com.hyuki.springstudymvc1.web.frontcontroller.ModelView;
import com.hyuki.springstudymvc1.web.frontcontroller.v3.MemberFormControllerV3;
import com.hyuki.springstudymvc1.web.frontcontroller.v3.MemberListControllerV3;
import com.hyuki.springstudymvc1.web.frontcontroller.v3.MemberSaveControllerV3;
import com.hyuki.springstudymvc1.web.frontcontroller.v4.MemberFormControllerV4;
import com.hyuki.springstudymvc1.web.frontcontroller.v4.MemberListControllerV4;
import com.hyuki.springstudymvc1.web.frontcontroller.v4.MemberSaveControllerV4;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerV5 extends HttpServlet {

  private static final String URL_PREFIX = "/WEB-INF/views/";
  private static final String EXTEND = ".jsp";

  private final Map<String, Object> handlerMappingMap = new HashMap<>();
  private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

  public FrontControllerV5() {
    initHandlerMappingMap();
    initHandlerAdapters();
  }

  void initHandlerMappingMap() {
    handlerMappingMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
    handlerMappingMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
    handlerMappingMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());

    handlerMappingMap.put("/front-controller/v5/v4/members/new-form", new MemberFormControllerV4());
    handlerMappingMap.put("/front-controller/v5/v4/members/save", new MemberSaveControllerV4());
    handlerMappingMap.put("/front-controller/v5/v4/members", new MemberListControllerV4());
  }

  void initHandlerAdapters() {
    handlerAdapters.addAll(Arrays.asList(new ControllerV3HandlerAdapter(), new ControllerV4HandlerAdapter()));
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    Object handler = getHandler(request);
    if (handler == null) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return;
    }

    MyHandlerAdapter adapter = getHandlerAdapter(handler);
    ModelView mv = adapter.handle(request, response, handler);

    MView view = viewResolver(mv.getViewName());
    view.render(request, response, mv.getModel());
  }

  private Object getHandler(HttpServletRequest request) {
    String requestURI = request.getRequestURI();
    return handlerMappingMap.get(requestURI);
  }

  private MyHandlerAdapter getHandlerAdapter(Object handler) {
    for (MyHandlerAdapter adapter : handlerAdapters) {
      if (adapter.supports(handler)) {
        return adapter;
      }
    }
    throw new IllegalArgumentException("handler adapter를 찾을 수 없습니다. handler=" + handler);
  }

  private MView viewResolver(String viewName) {
    return new MView(URL_PREFIX + viewName + EXTEND);
  }
}
