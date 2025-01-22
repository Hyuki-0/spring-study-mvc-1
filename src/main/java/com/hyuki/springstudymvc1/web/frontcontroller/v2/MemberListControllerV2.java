package com.hyuki.springstudymvc1.web.frontcontroller.v2;

import com.hyuki.springstudymvc1.domain.Member;
import com.hyuki.springstudymvc1.domain.MemberRepository;
import com.hyuki.springstudymvc1.web.frontcontroller.MView;
import com.hyuki.springstudymvc1.web.frontcontroller.v1.controller.ControllerV1;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberListControllerV2 implements ControllerV2{

  private final MemberRepository memberRepository = MemberRepository.getInstance();

  @Override
  public MView process(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    List<Member> members = memberRepository.findAll();
    request.setAttribute("members", members);

    return new MView("/WEB-INF/views/members.jsp");
  }
}
