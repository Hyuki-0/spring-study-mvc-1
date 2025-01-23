package com.hyuki.springstudymvc1.web.frontcontroller.v4;

import com.hyuki.springstudymvc1.domain.Member;
import com.hyuki.springstudymvc1.domain.MemberRepository;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {

  private final MemberRepository memberRepository = MemberRepository.getInstance();

  @Override
  public String process(Map<String, String> param, Map<String, Object> model)
      throws ServletException, IOException {
    Member member = new Member(param.get("username"), Integer.parseInt(param.get("age")));

    memberRepository.save(member);
    model.put("member", member);

    return "save-result";
  }
}
