package com.example.demo_shopping.member.controller;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo_shopping.member.data.AddressDto;
import com.example.demo_shopping.member.data.MemberDto;
import com.example.demo_shopping.member.service.MemberService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(MemberController.class)
class MemberControllerTest {

  @Autowired
  MockMvc mvc;

  @MockBean
  MemberService memberService;

  @Test
  void joinMemberTest() throws Exception {
    MemberDto memberDto = getJoinRequestData();
    ObjectMapper mapper = new ObjectMapper();
    String memberDtoJsonData = mapper.writeValueAsString(memberDto);

    mvc.perform(post("/member/join")
        .contentType(MediaType.APPLICATION_JSON)
        .content(memberDtoJsonData)).andExpect(status().isOk());

    verify(memberService).joinMember(memberDto);
  }

  private MemberDto getJoinRequestData() {
    List<AddressDto> addressDtoList = new ArrayList<>();
    addressDtoList.add(AddressDto.builder().address("NewYork").build());
    return MemberDto.builder().name("HONG").email("HONG_12345@naver.com").password("password9876")
        .addresses(addressDtoList).build();
  }
}