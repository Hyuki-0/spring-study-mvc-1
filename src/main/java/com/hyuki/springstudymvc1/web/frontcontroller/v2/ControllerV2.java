package com.hyuki.springstudymvc1.web.frontcontroller.v2;

import com.hyuki.springstudymvc1.web.frontcontroller.MView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV2 {

  MView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
