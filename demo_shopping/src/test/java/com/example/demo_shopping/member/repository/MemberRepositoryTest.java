package com.example.demo_shopping.member.repository;

import com.example.demo_shopping.member.entity.Member;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
@Slf4j
class MemberRepositoryTest {

  @Autowired
  MemberRepository memberRepository;


  @Test
  @DisplayName("Member entity 저장 테스트")
  void saveMemberTest() {
    LocalDateTime current = LocalDateTime.now();
    Member member = Member.builder()
        .id(1L)
        .name("TESTER")
        .email("test@naver.com")
        .build();

    memberRepository.save(member);

    Member savedMember = memberRepository.findById(1L).orElseThrow();
    Assertions.assertEquals(member.getId(), savedMember.getId());
    Assertions.assertEquals(member.getEmail(), savedMember.getEmail());
    Assertions.assertFalse(current.isAfter(savedMember.getCreateTime()));
  }
}