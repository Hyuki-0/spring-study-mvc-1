package com.hyuki.springstudymvc1.web_spring.v1;

import com.hyuki.springstudymvc1.domain.Member;
import com.hyuki.springstudymvc1.domain.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
class SpringMemberControllerV1 {

  private MemberRepository memberRepository = MemberRepository.getInstance();

  @RequestMapping("/springmvc/v1/members/new-form")
  public ModelAndView process() {
    return new ModelAndView("new-form");
  }

  @RequestMapping("/springmvc/v1/members/save")
  public String saveResult(
      @RequestParam("username") String username,
      @RequestParam("age") int age,
      Model model
  ) {

    Member member = new Member(username, age);
    memberRepository.save(member);

    model.addAttribute("member", member);
    return "save-result";
  }

  @RequestMapping("/springmvc/v1/members")
  public String getMembers(Model model) {

    model.addAttribute("members", memberRepository.findAll());
    return "members";
  }
}