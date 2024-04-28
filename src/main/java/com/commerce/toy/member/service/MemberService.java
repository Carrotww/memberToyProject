package com.commerce.toy.member.service;

import com.commerce.toy.global.error.ApplicationError;
import com.commerce.toy.global.error.ApplicationException;
import com.commerce.toy.member.dto.MemberRegisterRequest;
import com.commerce.toy.member.dto.UpdateMemberRequest;
import com.commerce.toy.member.dto.UpdateMemberResponse;
import com.commerce.toy.member.entity.Member;
import com.commerce.toy.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.NoSuchElementException;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerMember(MemberRegisterRequest memberRegisterRequest) {

        Member member = Member.builder()
                .memberLoginId(memberRegisterRequest.getMemberLoginId())
                .password(encodingPassword(memberRegisterRequest.getPassword()))
                .nickname(memberRegisterRequest.getNickname())
                .memberName(memberRegisterRequest.getMemberName())
                .phoneNumber(memberRegisterRequest.getPhoneNumber())
                .email(memberRegisterRequest.getEmail())
                .build();

        memberRepository.save(member);
    }

    public Page<Member> getAllMember(int page, int pageSize, String orderBy, String sort) {
        PageRequest pageRequest = (sort.equals("asc")) ?
                PageRequest.of(page - 1, pageSize, Sort.by(Sort.Direction.ASC, orderBy))
                : PageRequest.of(page - 1, pageSize, Sort.by(Sort.Direction.DESC, orderBy));

        return memberRepository.findAll(pageRequest);
    }

    public UpdateMemberResponse updateMemberByMemberLoginId(String memberLoginId, UpdateMemberRequest updateMemberRequest) {
        Member member = memberRepository.findByMemberLoginId(memberLoginId)
                .orElseThrow(() -> new ApplicationException(ApplicationError.MEMBER_LOGIN_ID_NOT_FOUND));
        if (updateMemberRequest.getPassword() != null) {
            member.updatePassword(encodingPassword(updateMemberRequest.getPassword()));
        }
        if (updateMemberRequest.getNickname() != null) {
            member.updateNickname(updateMemberRequest.getNickname());
        }
        if (updateMemberRequest.getMemberName() != null) {
            member.updateMemberName(updateMemberRequest.getMemberName());
        }
        if (updateMemberRequest.getPhoneNumber() != null) {
            member.updatePhoneNumber(updateMemberRequest.getPhoneNumber());
        }
        if (updateMemberRequest.getEmail() != null) {
            member.updateEmail(updateMemberRequest.getEmail());
        }

        // 저장 후 응답 객체 생성
        memberRepository.save(member);
        return UpdateMemberResponse.builder()
                .nickname(member.getNickname())
                .memberName(member.getMemberName())
                .phoneNumber(member.getPhoneNumber())
                .email(member.getEmail())
                .build();
    }

    public String encodingPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
