package com.example.demo_shopping;

import com.example.demo_shopping.member.repository.MemberRepository;
import com.example.demo_shopping.member.service.MemberService;
import com.example.demo_shopping.member.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@RequiredArgsConstructor
@Configuration
public class AppConfig {

  private final MemberRepository memberRepository;

  @Bean
  public MemberService memberService() {
    return new MemberServiceImpl(memberRepository);
  }
}
