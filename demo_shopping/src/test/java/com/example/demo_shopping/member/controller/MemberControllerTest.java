package com.example.demo_shopping.member.controller;

import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo_shopping.member.data.AddressDto;
import com.example.demo_shopping.member.data.MemberDto;
import com.example.demo_shopping.member.data.MemberJoinResponseData;
import com.example.demo_shopping.member.service.MemberService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

@WebMvcTest(MemberController.class)
class MemberControllerTest {

  private static final Logger LOGGER = LoggerFactory.getLogger(MemberControllerTest.class);
  @Autowired
  MockMvc mvc;

  @MockBean
  MemberService memberService;

  @Test
  void joinMemberTest() throws Exception {
    MemberDto memberDto = getJoinRequestData();
    ObjectMapper mapper = new ObjectMapper();
    String memberDtoJsonData = mapper.writeValueAsString(memberDto);
    LOGGER.info("JSON DATA : {}", memberDtoJsonData);

    mvc.perform(post("/member/join")
        .contentType(MediaType.APPLICATION_JSON)
        .content(memberDtoJsonData))
        .andExpect(status().isOk());

//    verify(memberService).joinMember(memberDto);
  }

  @Test
  void updateMemberTest() throws Exception {
    MemberDto memberDto = getJoinRequestData();
    ObjectMapper mapper = new ObjectMapper();
    String memberDtoJsonData = mapper.writeValueAsString(memberDto);

    mvc.perform(post("/member/join")
        .contentType(MediaType.APPLICATION_JSON)
        .content(memberDtoJsonData))
        .andExpect(status().isOk());

    memberDto.setEmail("CHANGE_12345@kakao.co.kr");
    String updateMemberDtoJsonData = mapper.writeValueAsString(memberDto);

    MvcResult mvcResult = mvc.perform(put("/member/update")
        .contentType(MediaType.APPLICATION_JSON)
        .content(memberDtoJsonData))
        .andExpect(status().isOk())
        .andReturn();

//    String responseBodyString = mvcResult.getResponse().getContentAsString();
//
//    Assertions.assertEquals(responseBodyString, getResponseData(memberDto).toString());
  }

  private MemberDto getJoinRequestData() {
    List<AddressDto> addressDtoList = new ArrayList<>();
    addressDtoList.add(AddressDto.builder().address("NewYork").build());
    return MemberDto.builder()
        .name("HONG")
        .email("HONG_12345@naver.com")
        .password("password9876")
        .addresses(addressDtoList).build();
  }

  private MemberJoinResponseData getResponseData(MemberDto memberDto) {
    return MemberJoinResponseData.builder()
        .name(memberDto.getName())
        .email(memberDto.getEmail())
        .password(memberDto.getPassword())
        .addresses(memberDto.getAddresses())
        .build();
  }
}