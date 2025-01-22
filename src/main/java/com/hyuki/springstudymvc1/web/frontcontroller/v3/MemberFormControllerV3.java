package com.hyuki.springstudymvc1.web.frontcontroller.v3;

import com.hyuki.springstudymvc1.web.frontcontroller.ModelView;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {

  @Override
  public ModelView process(Map<String, String> data)
      throws ServletException, IOException {

    return new ModelView("new-form");
  }
}
