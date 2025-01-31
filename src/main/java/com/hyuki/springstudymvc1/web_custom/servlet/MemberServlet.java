package com.hyuki.springstudymvc1.web_custom.servlet;

import com.hyuki.springstudymvc1.domain.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MemberServlet", urlPatterns = "/servlet/members/new-form")
public class MemberServlet extends HttpServlet {

  private final MemberRepository memberRepository = MemberRepository.getInstance();

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    resp.setContentType("text/html");
    resp.setCharacterEncoding("utf-8");

    PrintWriter writer = resp.getWriter();
    writer.write("<!DOCTYPE html>\n" +
        "<html>\n" +
        "<head>\n" +
        " <meta charset=\"UTF-8\">\n" +
        " <title>Title</title>\n" +
        "</head>\n" +
        "<body>\n" +
        "<form action=\"/servlet/members/save\" method=\"post\">\n" +
        " username: <input type=\"text\" name=\"username\" />\n" +
        " age: <input type=\"text\" name=\"age\" />\n" +
        " <button type=\"submit\">전송</button>\n" +
        "</form>\n" +
        "</body>\n" +
        "</html>\n");
  }
}