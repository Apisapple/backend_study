package com.example.web_novel.user.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.example.web_novel.user.entity.Member;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = Replace.NONE)
class MemberRepositoryTest {

  @Container
  private static final MySQLContainer<?> MY_SQL_CONTAINER = new MySQLContainer<>("mysql:8.0.24")
      .withExposedPorts(3306)
      .withUsername("root")
      .withPassword("root")
      .withInitScript("initDB.sql");

  @DynamicPropertySource
  public static void properties(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", MY_SQL_CONTAINER::getJdbcUrl);
    registry.add("spring.datasource.username", MY_SQL_CONTAINER::getUsername);
    registry.add("spring.datasource.password", MY_SQL_CONTAINER::getPassword);
  }


  @Autowired
  MemberRepository memberRepository;

  @Test
  void findByName() {
    Member member = Member.builder()
        .name("TEST USER")
        .build();

    memberRepository.save(member);

    Member foundedMember = memberRepository.findByName("TEST USER").orElseThrow(
        () -> new IllegalArgumentException("TEST")
    );

    Assertions.assertEquals(member.getName(), foundedMember.getName());
  }

  @Test
  void findByNameContaining() {
    Member member1 = Member.builder()
        .name("TEST1")
        .build();

    Member member2 = Member.builder()
        .name("TEST2")
        .build();

    memberRepository.save(member1);
    memberRepository.save(member2);

    List<Member> memberList = memberRepository.findByNameContaining("TEST");

    Assertions.assertEquals(memberList.size(), 2);
  }
}

