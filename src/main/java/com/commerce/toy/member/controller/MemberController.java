package com.commerce.toy.member.controller;

import com.commerce.toy.global.dto.ApiResponse;
import com.commerce.toy.member.dto.MemberRegisterRequest;
import com.commerce.toy.member.dto.UpdateMemberRequest;
import com.commerce.toy.member.dto.UpdateMemberResponse;
import com.commerce.toy.member.entity.Member;
import com.commerce.toy.member.repository.MemberRepository;
import com.commerce.toy.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @PostMapping("/join")
    public ResponseEntity<ApiResponse<Void>> memberRegister(
            @RequestBody MemberRegisterRequest memberRegisterRequest) {
        memberService.registerMember(memberRegisterRequest);

        return ResponseEntity.ok().body(ApiResponse.success(null, HttpStatus.CREATED));
    }

    @GetMapping("/list")
    public ResponseEntity<ApiResponse<Page<Member>>> getMembers(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "memberName") String orderBy,
            @RequestParam(defaultValue = "asc") String sort) {

        Page<Member> allMemberList = memberService.getAllMember(page, pageSize, orderBy, sort);

        return ResponseEntity.ok().body(ApiResponse.success(allMemberList, HttpStatus.OK));
    }

    @PutMapping("{memberLoginId}")
    public ResponseEntity<ApiResponse<UpdateMemberResponse>> updateMember(
            @PathVariable("memberLoginId") String memberLoginId,
            @RequestBody UpdateMemberRequest updateMemberRequest) {
        UpdateMemberResponse response = memberService.updateMemberByMemberLoginId(memberLoginId, updateMemberRequest);

        return ResponseEntity.ok().body(ApiResponse.success(response, HttpStatus.OK));
    }
}
