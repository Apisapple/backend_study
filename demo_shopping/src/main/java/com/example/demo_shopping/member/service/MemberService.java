package com.example.demo_shopping.member.service;

import com.example.demo_shopping.member.data.AddressDto;
import com.example.demo_shopping.member.data.MemberDto;
import com.example.demo_shopping.member.data.MemberJoinResponseData;
import com.example.demo_shopping.member.exception.AddressErrorException;
import com.example.demo_shopping.member.exception.MemberErrorException;
import java.util.List;

public interface MemberService {

  MemberJoinResponseData joinMember(MemberDto memberDto)
      throws AddressErrorException, MemberErrorException;

  MemberJoinResponseData updateMember(MemberDto memberDto) throws MemberErrorException;

  MemberJoinResponseData addAddress(Long id, AddressDto addressDto) throws MemberErrorException;

  MemberJoinResponseData removeAddress(Long id, AddressDto addressDto) throws MemberErrorException;


  void removeMember(MemberDto memberDto) throws MemberErrorException;

  MemberJoinResponseData findMemberByEmail(String email) throws MemberErrorException;
}
