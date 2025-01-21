package com.hyuki.springstudymvc1.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemberRepositoryTest {


  MemberRepository memberRepository = MemberRepository.getInstance();

  @AfterEach
  void afterEach() {
    memberRepository.clearStore();
  }

  @Test
  void save() {
    Member member = new Member("hello", 20);

    Member savedMember = memberRepository.save(member);

    Member findMember = memberRepository.findById(savedMember.getId());
    assertThat(findMember).isEqualTo(savedMember);
  }

  @Test
  void findAll() {
    Member member = new Member("hello", 20);
    Member member2 = new Member("hello", 30);

    memberRepository.save(member);
    memberRepository.save(member2);

    List<Member> result = memberRepository.findAll();

    assertThat(result.size()).isEqualTo(2);
    assertThat(result).contains(member, member2);
  }
}