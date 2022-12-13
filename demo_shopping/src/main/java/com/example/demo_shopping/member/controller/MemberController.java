package com.example.demo_shopping.member.controller;

import com.example.demo_shopping.member.data.MemberDto;
import com.example.demo_shopping.member.data.MemberJoinResponseData;
import com.example.demo_shopping.member.exception.AddressErrorException;
import com.example.demo_shopping.member.exception.MemberErrorException;
import com.example.demo_shopping.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @PostMapping("/member/join")
  public ResponseEntity<MemberJoinResponseData> joinMember(@RequestBody MemberDto memberDto) {
    try {
      return ResponseEntity.ok().body(memberService.joinMember(memberDto));
    } catch (AddressErrorException | MemberErrorException e) {
      return ResponseEntity.badRequest().body(
          MemberJoinResponseData.builder()
              .msg(e.getMessage())
              .build()
      );
    }
  }
}
