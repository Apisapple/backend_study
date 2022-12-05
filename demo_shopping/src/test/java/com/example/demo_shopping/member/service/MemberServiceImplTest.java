package com.example.demo_shopping.member.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import com.example.demo_shopping.member.data.AddressDto;
import com.example.demo_shopping.member.data.MemberDto;
import com.example.demo_shopping.member.data.MemberJoinResponseData;
import com.example.demo_shopping.member.entity.Member;
import com.example.demo_shopping.member.exception.AddressErrorException;
import com.example.demo_shopping.member.exception.MemberErrorException;
import com.example.demo_shopping.member.repository.MemberRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MemberServiceImplTest {

  @InjectMocks
  MemberServiceImpl memberService;
  @Mock
  MemberRepository memberRepository;


  @Test
  void joinMember() throws AddressErrorException, MemberErrorException {
    //given
    MemberDto joinRequestData = getJoinRequestData();
    Member member = joinRequestData.toEntity();
    Long id = 1L;
    member.setId(id);

    //mocking
    Mockito.lenient().when(memberRepository.save(any(Member.class))).thenReturn(member);
    given(memberRepository.findMemberByEmail(joinRequestData.getEmail())).willReturn(
        Optional.of(member));

    //when
    MemberJoinResponseData responseData = memberService.findMemberByEmail(
        joinRequestData.getEmail());

    //then
    assertEquals(responseData.getEmail(), joinRequestData.getEmail());
    assertEquals(responseData.getPassword(), joinRequestData.getPassword());
    assertEquals(responseData.getAddresses(), joinRequestData.getAddresses());
  }

  @Test
  void updateMember() {
  }

  @Test
  void removeMember() {
  }

  private MemberDto getJoinRequestData() {
    List<AddressDto> addressDtoList = new ArrayList<>();
    addressDtoList.add(AddressDto.builder().address("남양주시").build());
    return MemberDto.builder()
        .name("박상아")
        .email("psa8210@naver.com")
        .password("password5245")
        .addresses(addressDtoList)
        .build();
  }

}