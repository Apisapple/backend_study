package com.example.demo_shopping.member.service;

import com.example.demo_shopping.member.data.MemberDto;
import com.example.demo_shopping.member.data.MemberJoinResponseData;
import com.example.demo_shopping.member.exception.AddressErrorException;
import com.example.demo_shopping.member.exception.MemberErrorException;

public interface MemberService {

  MemberJoinResponseData joinMember(MemberDto memberDto)
      throws AddressErrorException, MemberErrorException;

  MemberJoinResponseData updateMember(MemberDto memberDto) throws MemberErrorException;

  void removeMember(MemberDto memberDto) throws MemberErrorException;

  MemberJoinResponseData findMemberByEmail(String email) throws MemberErrorException;
}
