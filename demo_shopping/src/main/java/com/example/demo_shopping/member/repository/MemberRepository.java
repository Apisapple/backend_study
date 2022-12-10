package com.example.demo_shopping.member.repository;

import com.example.demo_shopping.member.entity.Member;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

  Optional<Member> findMemberByEmail(String email);
  Optional<Member> findMemberById(Long id);
  List<Member> findMembersByName(String name);
}
