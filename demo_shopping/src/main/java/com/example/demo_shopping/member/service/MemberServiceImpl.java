package com.example.demo_shopping.member.service;

import com.example.demo_shopping.member.data.AddressDto;
import com.example.demo_shopping.member.data.MemberDto;
import com.example.demo_shopping.member.data.MemberJoinResponseData;
import com.example.demo_shopping.member.entity.Address;
import com.example.demo_shopping.member.entity.Member;
import com.example.demo_shopping.member.exception.AddressErrorException;
import com.example.demo_shopping.member.exception.ErrorCode;
import com.example.demo_shopping.member.exception.MemberErrorException;
import com.example.demo_shopping.member.repository.MemberRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

  private final MemberRepository memberRepository;

  /**
   * Member 등록 함수
   *
   * @param memberDto member DTO
   * @return @{@link MemberJoinResponseData} 옳바른 등록 시
   */
  @Override
  public MemberJoinResponseData joinMember(MemberDto memberDto)
      throws AddressErrorException, MemberErrorException {
    if (memberDto.getAddresses().isEmpty()) {
      throw new AddressErrorException(ErrorCode.ADDRESS_MUST_LEAST_ONE.getMsg(),
          ErrorCode.ADDRESS_MUST_LEAST_ONE.getCode());
    }

    if (memberRepository.findMemberByEmail(memberDto.getEmail()).isPresent()) {
      throw new MemberErrorException(ErrorCode.ALREADY_EXIST_MEMBER.getMsg(),
          ErrorCode.ALREADY_EXIST_MEMBER.getCode());
    }

    Member member = memberRepository.save(memberDto.toEntity());
    return MemberJoinResponseData.builder()
        .id(member.getId())
        .name(member.getName())
        .email(member.getEmail())
        .password(member.getPassword())
        .build();
  }

  @Override
  public MemberJoinResponseData updateMember(MemberDto memberDto) throws MemberErrorException {
    Member savedMember = memberRepository.findMemberByEmail(memberDto.getEmail()).orElseThrow(
        () -> new MemberErrorException(ErrorCode.CANNOT_FOUND_MEMBER.getMsg(),
            ErrorCode.CANNOT_FOUND_MEMBER.getCode())
    );

    Member updatedMember = savedMember.updateMember(memberDto);

    return MemberJoinResponseData.builder()
        .id(updatedMember.getId())
        .email(updatedMember.getEmail())
        .name(updatedMember.getName())
        .password(updatedMember.getPassword())
        .addresses(updatedMember.getAddresses().stream()
            .map(Address::toDto)
            .collect(Collectors.toList()))
        .build();
  }

  @Override
  public MemberJoinResponseData addAddress(Long id, AddressDto addressDto) throws MemberErrorException {
    Member member = memberRepository.findMemberById(id).orElseThrow(
        () -> new MemberErrorException(ErrorCode.CANNOT_FOUND_MEMBER.getMsg(),
            ErrorCode.CANNOT_FOUND_MEMBER.getCode())
    );
    member.addAddress(Address.builder()
        .addressData(addressDto.getAddress())
        .build());


    return MemberJoinResponseData.builder()
        .id(member.getId())
        .email(member.getEmail())
        .name(member.getName())
        .password(member.getPassword())
        .addresses(member.getAddresses().stream()
            .map(Address::toDto)
            .collect(Collectors.toList())
        )
        .build();
  }

  @Override
  public MemberJoinResponseData removeAddress(Long id, AddressDto addressDto) throws MemberErrorException {
    Member member = memberRepository.findMemberById(id).orElseThrow(
        () -> new MemberErrorException(ErrorCode.CANNOT_FOUND_MEMBER.getMsg(),
            ErrorCode.CANNOT_FOUND_MEMBER.getCode())
    );
    member.removeAddress(Address.builder()
        .addressData(addressDto.getAddress())
        .build());


    return MemberJoinResponseData.builder()
        .id(member.getId())
        .email(member.getEmail())
        .name(member.getName())
        .password(member.getPassword())
        .addresses(member.getAddresses().stream()
            .map(Address::toDto)
            .collect(Collectors.toList())
        )
        .build();
  }

  @Override
  public void removeMember(MemberDto memberDto) throws MemberErrorException {

    Member savedMember = memberRepository.findMemberByEmail(memberDto.getEmail())
        .orElseThrow(() -> new MemberErrorException(ErrorCode.CANNOT_FOUND_MEMBER.getMsg(),
            ErrorCode.CANNOT_FOUND_MEMBER.getCode()));
    memberRepository.delete(savedMember);
  }

  @Override
  public MemberJoinResponseData findMemberByEmail(String email) throws MemberErrorException {
    Member savedMember = memberRepository.findMemberByEmail(email).orElseThrow(
        () -> new MemberErrorException(ErrorCode.CANNOT_FOUND_MEMBER.getMsg(),
            ErrorCode.CANNOT_FOUND_MEMBER.getCode())
    );

    List<AddressDto> addressDtoList = new ArrayList<>();

    for (Address address : savedMember.getAddresses()) {
      addressDtoList.add(address.toDto());
    }

    return MemberJoinResponseData.builder()
        .name(savedMember.getName())
        .email(savedMember.getEmail())
        .password(savedMember.getPassword())
        .addresses(addressDtoList)
        .build();
  }
}
