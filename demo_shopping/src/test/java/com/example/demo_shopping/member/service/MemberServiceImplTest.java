package com.example.demo_shopping.member.service;

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
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ExtendWith(MockitoExtension.class)
class MemberServiceImplTest {

  private static final Logger LOGGER = LoggerFactory.getLogger(MemberServiceImplTest.class);
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
    Assertions.assertThat(responseData.getAddresses()).usingRecursiveComparison()
        .isEqualTo(joinRequestData.getAddresses());
    Assertions.assertThat(responseData.getPassword())
        .isEqualTo(joinRequestData.getPassword());
    Assertions.assertThat(responseData.getName())
        .isEqualTo(joinRequestData.getName());
  }

  @Test
  void updateMember() throws MemberErrorException {
    MemberDto savedMemberDto = getJoinRequestData();
    Member savedMember = savedMemberDto.toEntity();
    Long id = 1L;
    savedMember.setId(id);

    given(memberRepository.findMemberByEmail(savedMemberDto.getEmail()))
        .willReturn(Optional.of(savedMember));

    savedMemberDto.setName("SON");
    savedMemberDto.setPassword("password221207");

    MemberJoinResponseData result = memberService.updateMember(savedMemberDto);

    Assertions.assertThat(result.getEmail()).isEqualTo(savedMember.getEmail());
    Assertions.assertThat(result.getPassword()).isEqualTo(savedMember.getPassword());
    Assertions.assertThat(result.getName()).isEqualTo(savedMember.getName());
  }

  @Test
  void removeMember() {
  }

  private MemberDto getJoinRequestData() {
    List<AddressDto> addressDtoList = new ArrayList<>();
    addressDtoList.add(AddressDto.builder().address("NewYork").build());
    return MemberDto.builder()
        .name("HONG")
        .email("HONG_12345@naver.com")
        .password("password9876")
        .addresses(addressDtoList)
        .build();
  }

}