package com.hyuki.springstudymvc1.web.frontcontroller.v2;

import com.hyuki.springstudymvc1.domain.Member;
import com.hyuki.springstudymvc1.domain.MemberRepository;
import com.hyuki.springstudymvc1.web.frontcontroller.MView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveControllerV2 implements ControllerV2 {

  private final MemberRepository memberRepository = MemberRepository.getInstance();

  @Override
  public MView process(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    request.setAttribute("member", member);
    memberRepository.save(member);


    return new MView("/WEB-INF/views/save-result.jsp");
  }
}
