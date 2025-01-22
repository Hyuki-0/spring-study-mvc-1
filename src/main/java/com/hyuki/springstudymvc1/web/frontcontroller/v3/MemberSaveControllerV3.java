package com.hyuki.springstudymvc1.web.frontcontroller.v3;

import com.hyuki.springstudymvc1.domain.Member;
import com.hyuki.springstudymvc1.domain.MemberRepository;
import com.hyuki.springstudymvc1.web.frontcontroller.ModelView;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

  private final MemberRepository memberRepository = MemberRepository.getInstance();

  @Override
  public ModelView process(Map<String, String> param)
      throws ServletException, IOException {
    Member member = new Member(param.get("username"), Integer.parseInt(param.get("age")));
    memberRepository.save(member);

    ModelView mv =  new ModelView("save-result");
    mv.getModel().put("member", member);
    return mv;
  }
}
