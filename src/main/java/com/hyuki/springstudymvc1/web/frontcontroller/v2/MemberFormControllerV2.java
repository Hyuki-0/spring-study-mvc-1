package com.hyuki.springstudymvc1.web.frontcontroller.v2;

import com.hyuki.springstudymvc1.web.frontcontroller.MView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV2 implements ControllerV2 {

  @Override
  public MView process(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    return new MView("/WEB-INF/views/new-form.jsp");
  }
}
