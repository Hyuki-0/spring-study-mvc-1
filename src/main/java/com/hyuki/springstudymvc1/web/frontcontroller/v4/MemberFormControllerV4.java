package com.hyuki.springstudymvc1.web.frontcontroller.v4;

import com.hyuki.springstudymvc1.web.frontcontroller.ModelView;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

public class MemberFormControllerV4 implements ControllerV4 {

  @Override
  public String process(Map<String, String> param, Map<String, Object> model)
      throws ServletException, IOException {
    return "new-form";
  }
}
