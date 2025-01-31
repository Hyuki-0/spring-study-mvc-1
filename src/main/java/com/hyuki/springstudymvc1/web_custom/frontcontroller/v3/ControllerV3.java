package com.hyuki.springstudymvc1.web_custom.frontcontroller.v3;

import com.hyuki.springstudymvc1.web_custom.frontcontroller.ModelView;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

public interface ControllerV3 {

  ModelView process(Map<String, String> data) throws ServletException, IOException;
}
