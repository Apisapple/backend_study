package com.example.demo_shopping.member.service;

import com.example.demo_shopping.member.data.MemberDto;
import com.example.demo_shopping.member.data.MemberJoinResponseData;
import com.example.demo_shopping.member.entity.Member;
import com.example.demo_shopping.member.exception.ErrorCode;
import com.example.demo_shopping.member.exception.MemberErrorException;
import com.example.demo_shopping.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

  private final MemberRepository memberRepository;

  /**
   * Member 등록 함수
   * @param memberDto member DTO
   * @return @{@link MemberJoinResponseData} 옳바른 등록 시
   */
  @Override
  public MemberJoinResponseData joinMember(MemberDto memberDto) {
    Member member = memberRepository.save(memberDto.toEntity());
    return MemberJoinResponseData.builder()
        .id(member.getId())
        .name(member.getName())
        .email(member.getEmail())
        .password(member.getPassword())
        .build();
  }

  @Override
  public MemberJoinResponseData updateMember(MemberDto memberDto) {

    return MemberJoinResponseData.builder()
        .build();
  }

  @Override
  public void removeMember(MemberDto memberDto) throws MemberErrorException {

    Member savedMember = memberRepository.findMemberByEmail(memberDto.getEmail())
        .orElseThrow(() -> new MemberErrorException(ErrorCode.CANNOT_FOUND_MEMBER.getMsg(),
            ErrorCode.CANNOT_FOUND_MEMBER.getCode()));
    memberRepository.delete(savedMember);
  }
}
