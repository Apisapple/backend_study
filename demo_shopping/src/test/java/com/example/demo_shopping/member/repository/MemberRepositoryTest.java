package com.example.demo_shopping.member.repository;

import com.example.demo_shopping.member.entity.Member;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
class MemberRepositoryTest {
  static final Logger LOG = LoggerFactory.getLogger(MemberRepositoryTest.class);
  @Autowired
  MemberRepository memberRepository;


  @Test
  @DisplayName("Member entity 저장 테스트")
  void saveMemberTest() {
    LocalDateTime current = LocalDateTime.now();
    Member member = Member.builder()
        .name("TESTER")
        .email("test@naver.com")
        .build();

    Member savedMember = memberRepository.save(member);

    Assertions.assertEquals(member.getId(), savedMember.getId());
    Assertions.assertEquals(member.getEmail(), savedMember.getEmail());
    Assertions.assertFalse(current.isAfter(savedMember.getCreateTime()));
  }

  @Test
  void findMemberByEmailTest() {
    Member member = Member.builder()
        .name("TESTER")
        .email("test@naver.com")
        .build();

    memberRepository.save(member);

    Member savedMember = memberRepository.findMemberByEmail("test@naver.com").orElseThrow();
    Assertions.assertNotNull(savedMember);
  }

  @Test
  void findMembersByNameTest() {
    Member member = Member.builder()
        .name("TESTER")
        .email("test@naver.com")
        .build();

    Member member2 = Member.builder()
        .name("TESTER")
        .email("test2@naver.com")
        .build();

    Member member3 = Member.builder()
        .name("TEST")
        .email("test3@naver.com")
        .build();

    memberRepository.save(member);
    memberRepository.save(member2);
    memberRepository.save(member3);

    List<Member> memberList = memberRepository.findMembersByName("TESTER");

    Assertions.assertEquals(2, memberList.size());
  }
}