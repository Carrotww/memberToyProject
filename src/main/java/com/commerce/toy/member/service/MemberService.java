package com.commerce.toy.member.service;

import com.commerce.toy.member.dto.MemberRegisterRequest;
import com.commerce.toy.member.entity.Member;
import com.commerce.toy.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerMember(MemberRegisterRequest memberRegisterRequest) {

        String encodedPassword = passwordEncoder.encode(memberRegisterRequest.getPassword());

        Member member = Member.builder()
                .memberLoginId(memberRegisterRequest.getMemberLoginId())
                .password(encodedPassword)
                .nickname(memberRegisterRequest.getNickname())
                .memberName(memberRegisterRequest.getMemberName())
                .phoneNumber(memberRegisterRequest.getPhoneNumber())
                .email(memberRegisterRequest.getEmail())
                .build();

        memberRepository.save(member);
    }
}
