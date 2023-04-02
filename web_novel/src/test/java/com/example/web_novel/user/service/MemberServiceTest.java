package com.example.web_novel.user.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import com.example.web_novel.user.entity.Member;
import com.example.web_novel.user.repository.MemberRepository;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

  @InjectMocks
  private MemberService memberService;

  @Mock
  private MemberRepository memberRepository;

  @Test
  void saveMember() {
    Member member = Member.builder()
        .name("TESTER")
        .build();
    Member member2 = Member.builder()
        .name("TESTER")
        .build();
    member2.addPoint(200);

    given(memberRepository.save(any())).willReturn(member);
    given(memberRepository.findByName("TESTER")).willReturn(Optional.ofNullable(member));

    Member updatedMember = memberService.saveMember(member);
    Member updateMember2 = memberService.buyPoint(updatedMember.getName(), 200);

    Assertions.assertEquals(200, updateMember2.getPoint());
  }

  @Test
  void usePoint() {
    Member member = Member.builder()
        .name("TESTER")
        .build();

    member.addPoint(1000);

    given(memberRepository.findByName("TESTER")).willReturn(Optional.of(member));

    Member updateMember = memberService.usePoint(member.getName(), 200);

    Assertions.assertEquals(800, updateMember.getPoint());
  }
}