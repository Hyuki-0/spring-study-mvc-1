package com.hyuki.springstudymvc1.web.frontcontroller.v3;

import com.hyuki.springstudymvc1.domain.Member;
import com.hyuki.springstudymvc1.domain.MemberRepository;
import com.hyuki.springstudymvc1.web.frontcontroller.ModelView;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

  private final MemberRepository memberRepository = MemberRepository.getInstance();

  @Override
  public ModelView process(Map<String, String> data)
      throws ServletException, IOException {

    List<Member> members = memberRepository.findAll();

    ModelView mv = new ModelView("members");
    mv.getModel().put("members", members);
    return mv;
  }
}
