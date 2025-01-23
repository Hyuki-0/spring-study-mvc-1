package com.hyuki.springstudymvc1.web.frontcontroller.v4;

import com.hyuki.springstudymvc1.domain.Member;
import com.hyuki.springstudymvc1.domain.MemberRepository;
import com.hyuki.springstudymvc1.web.frontcontroller.ModelView;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {

  private final MemberRepository memberRepository = MemberRepository.getInstance();

  @Override
  public String process(Map<String, String> param, Map<String, Object> model)
      throws ServletException, IOException {

    model.put("members", memberRepository.findAll());
    return "members";
  }
}
