package com.hyuki.springstudymvc1.web.frontcontroller.v4;

import jakarta.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

public interface ControllerV4 {

  String process(Map<String, String> param, Map<String, Object> model) throws ServletException, IOException;
}
