package com.commerce.toy.member.service;

import com.commerce.toy.global.error.ApplicationError;
import com.commerce.toy.global.error.ApplicationException;
import com.commerce.toy.member.dto.MemberRegisterRequest;
import com.commerce.toy.member.dto.UpdateMemberRequest;
import com.commerce.toy.member.entity.Member;
import com.commerce.toy.member.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private MemberService memberService;

    private MemberRegisterRequest memberRegisterRequest;

    private UpdateMemberRequest updateMemberRequest;

    private List<Member> memberList;

    private Member member3;

    @BeforeEach
    void setUp() {
        memberRegisterRequest = MemberRegisterRequest.builder()
                .memberLoginId("aa")
                .password("1234")
                .nickname("user")
                .memberName("aa")
                .phoneNumber("010-1111-1111")
                .email("user@example.com")
                .build();

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime yesterday = now.minusDays(1);

        memberList = new ArrayList<>();
        Member memberA = Member.builder()
                .memberLoginId("unique1")
                .password("1234")
                .nickname("userA")
                .memberName("AA")
                .phoneNumber("010-1111-1111")
                .email("user@example.com")
                .build();
        ReflectionTestUtils.setField(memberA, "createdAt", now);

        Member memberB = Member.builder()
                .memberLoginId("unique2")
                .password("1234")
                .nickname("userB")
                .memberName("BB")
                .phoneNumber("010-1111-1111")
                .email("user@example.com")
                .build();
        ReflectionTestUtils.setField(memberB, "createdAt", yesterday);

        memberList = Arrays.asList(memberA, memberB);

        updateMemberRequest = UpdateMemberRequest.builder()
                .password("2222222")
                .nickname("userD")
                .memberName("DD")
                .phoneNumber("010-2222-2222")
                .email("userdd@example.com")
                .build();

        member3 = Member.builder()
                .memberLoginId("unique3")
                .password("1111111")
                .nickname("userC")
                .memberName("CC")
                .phoneNumber("010-1111-1111")
                .email("user@example.com")
                .build();
    }

    @Test
    @DisplayName("MemberName 오름차순 정렬")
    void sortedByMemberNameAsc() {
        PageRequest pageRequest = PageRequest.of(0, 2, Sort.by(Sort.Direction.ASC, "memberName"));
        Page<Member> expectedPage = new PageImpl<>(Arrays.asList(memberList.get(0), memberList.get(1)), pageRequest, 2);

        when(memberRepository.findAll(any(PageRequest.class))).thenReturn(expectedPage);

        Page<Member> result = memberService.getAllMember(1, 2, "memberName", "asc");

        assertEquals("AA", result.getContent().get(0).getMemberName());
        assertEquals("BB", result.getContent().get(1).getMemberName());
    }

    @Test
    @DisplayName("MemberName 내림차순 정렬")
    void sortedByMemberNameDesc() {
        PageRequest pageRequest = PageRequest.of(0, 2, Sort.by(Sort.Direction.DESC, "memberName"));
        Page<Member> expectedPage = new PageImpl<>(Arrays.asList(memberList.get(1), memberList.get(0)), pageRequest, 2);

        when(memberRepository.findAll(any(PageRequest.class))).thenReturn(expectedPage);

        Page<Member> result = memberService.getAllMember(1, 2, "memberName", "desc");

        assertEquals("AA", result.getContent().get(1).getMemberName());
        assertEquals("BB", result.getContent().get(0).getMemberName());
    }

    @Test
    @DisplayName("createdAt 오름차순 정렬")
    void sortedByCreatedAtAsc() {
        PageRequest pageRequest = PageRequest.of(0, 2, Sort.by(Sort.Direction.ASC, "createdAt"));
        Page<Member> expectedPage = new PageImpl<>(Arrays.asList(memberList.get(0), memberList.get(1)), pageRequest, 2);

        when(memberRepository.findAll(any(PageRequest.class))).thenReturn(expectedPage);

        Page<Member> result = memberService.getAllMember(1, 2, "createdAt", "asc");

        assertEquals("AA", result.getContent().get(0).getMemberName());
        assertEquals("BB", result.getContent().get(1).getMemberName());
    }

    @Test
    @DisplayName("createdAt 내림차순 정렬")
    void sortedByCreatedAtDesc() {
        PageRequest pageRequest = PageRequest.of(0, 2, Sort.by(Sort.Direction.ASC, "memberName"));
        Page<Member> expectedPage = new PageImpl<>(Arrays.asList(memberList.get(1), memberList.get(0)), pageRequest, 2);

        when(memberRepository.findAll(any(PageRequest.class))).thenReturn(expectedPage);

        Page<Member> result = memberService.getAllMember(1, 2, "createdAt", "desc");

        assertEquals("AA", result.getContent().get(1).getMemberName());
        assertEquals("BB", result.getContent().get(0).getMemberName());
    }

    @Test
    @DisplayName("Member 가입 테스트")
    void registerMember() {
        when(passwordEncoder.encode(anyString())).thenReturn("1234");

        Member member = Member.builder()
                .memberLoginId(memberRegisterRequest.getMemberLoginId())
                .password(memberService.encodingPassword(memberRegisterRequest.getPassword()))
                .nickname(memberRegisterRequest.getNickname())
                .memberName(memberRegisterRequest.getMemberName())
                .phoneNumber(memberRegisterRequest.getPhoneNumber())
                .email(memberRegisterRequest.getEmail())
                .build();

        // when
        when(memberRepository.save(any(Member.class))).thenReturn(member);

        memberService.registerMember(memberRegisterRequest);

        verify(memberRepository, times(1)).save(any(Member.class));

        assertAll(
                () -> assertEquals(member.getMemberLoginId(), memberRegisterRequest.getMemberLoginId()),
                () -> assertEquals(member.getPassword(), memberService.encodingPassword(memberRegisterRequest.getPassword())),
                () -> assertEquals(member.getNickname(), memberRegisterRequest.getNickname()),
                () -> assertEquals(member.getMemberName(), memberRegisterRequest.getMemberName()),
                () -> assertEquals(member.getPhoneNumber(), memberRegisterRequest.getPhoneNumber()),
                () -> assertEquals(member.getEmail(), memberRegisterRequest.getEmail())
        );
    }

    @Test @DisplayName("Member 수정 테스트")
    void updateMemberByMemberLoginId() {
        // when
        when(memberRepository.findByMemberLoginId("unique3")).thenReturn(Optional.of(member3));
        memberService.updateMemberByMemberLoginId(member3.getMemberLoginId(), updateMemberRequest);

        // verify
        verify(memberRepository).save(member3);

        assertAll(
                () -> assertEquals(member3.getNickname(), updateMemberRequest.getNickname()),
                () -> assertEquals(member3.getMemberName(), updateMemberRequest.getMemberName()),
                () -> assertEquals(member3.getPhoneNumber(), updateMemberRequest.getPhoneNumber()),
                () -> assertEquals(member3.getEmail(), updateMemberRequest.getEmail()),
                () -> assertEquals(member3.getPassword(), memberService.encodingPassword(updateMemberRequest.getPassword()))
        );
    }

    @Test
    @DisplayName("updateMemberByMemberLoginId 함수 LoginId로 사용자를 찾을 수 없을때")
    void updateMemberByMemberLoginIdNotFound() {
        // when
        when(memberRepository.findByMemberLoginId("noting")).thenReturn(Optional.empty());

        ApplicationException thrown = assertThrows(ApplicationException.class, () ->
                        memberService.updateMemberByMemberLoginId("noting", updateMemberRequest)
        );

        // 예외 메시지 검증
        assertAll(
                () -> assertEquals(thrown.getCode(), ApplicationError.MEMBER_LOGIN_ID_NOT_FOUND.getCode()),
                () -> assertEquals(thrown.getStatus(), HttpStatus.NOT_FOUND)
        );
    }
}