package com.example.demo_shopping.member.service;

import com.example.demo_shopping.member.data.MemberDto;
import com.example.demo_shopping.member.data.MemberJoinResponseData;
import com.example.demo_shopping.member.exception.MemberErrorException;

public interface MemberService {

  MemberJoinResponseData joinMember(MemberDto memberDto);

  MemberJoinResponseData updateMember(MemberDto memberDto);

  void removeMember(MemberDto memberDto) throws MemberErrorException;
}
