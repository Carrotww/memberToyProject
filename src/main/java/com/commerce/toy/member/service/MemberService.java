package com.commerce.toy.member.service;

import com.commerce.toy.member.dto.MemberRegisterRequest;
import com.commerce.toy.member.entity.Member;
import com.commerce.toy.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void registerMember(MemberRegisterRequest memberRegisterRequest) {
        Member member = Member.builder()
                .memberId(memberRegisterRequest.getMemberId())
                .password(memberRegisterRequest.getPassword())
                .nickname(memberRegisterRequest.getNickname())
                .memberName(memberRegisterRequest.getMemberName())
                .phoneNumber(memberRegisterRequest.getPhoneNumber())
                .email(memberRegisterRequest.getEmail())
                .build();

        memberRepository.save(member);
    }
}
