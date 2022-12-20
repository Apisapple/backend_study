package com.example.demo_shopping.member.controller;

import com.example.demo_shopping.member.data.MemberDto;
import com.example.demo_shopping.member.data.MemberJoinResponseData;
import com.example.demo_shopping.member.exception.AddressErrorException;
import com.example.demo_shopping.member.exception.MemberErrorException;
import com.example.demo_shopping.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @GetMapping("/member/info/{id}")
  public ResponseEntity<MemberJoinResponseData> getMemberInfo(@PathVariable Long id) {
    try {
      return ResponseEntity.ok(memberService.findMemberById(id));
    } catch (MemberErrorException e) {
      return ResponseEntity.badRequest().body(
          MemberJoinResponseData.builder()
              .msg(e.getMessage())
              .build()
      );
    }
  }

  @PostMapping("/member/join")
  public ResponseEntity<MemberJoinResponseData> joinMember(@RequestBody MemberDto memberDto) {
    try {
      return ResponseEntity.ok(memberService.joinMember(memberDto));
    } catch (AddressErrorException | MemberErrorException e) {
      return ResponseEntity.badRequest().body(
          MemberJoinResponseData.builder()
              .msg(e.getMessage())
              .build()
      );
    }
  }

  @PutMapping("/member/update")
  public ResponseEntity<MemberJoinResponseData> updateMember(@RequestBody MemberDto memberDto) {
    try {
      return ResponseEntity.ok(memberService.updateMember(memberDto));
    } catch (MemberErrorException e) {
      return ResponseEntity.badRequest().body(
          MemberJoinResponseData.builder()
              .msg(e.getMessage())
              .build()
      );
    }
  }

  @DeleteMapping("/member/delete")
  public ResponseEntity<MemberJoinResponseData> removeMember(@RequestBody MemberDto memberDto) {
    try {
      return ResponseEntity.ok(memberService.removeMember(memberDto));
    } catch (MemberErrorException e) {
      return ResponseEntity.badRequest().body(
          MemberJoinResponseData.builder()
              .msg(e.getMessage())
              .build()
      );
    }
  }
}
