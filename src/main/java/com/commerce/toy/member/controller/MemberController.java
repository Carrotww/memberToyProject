package com.commerce.toy.member.controller;

import com.commerce.toy.global.dto.ApiResponse;
import com.commerce.toy.member.dto.MemberRegisterRequest;
import com.commerce.toy.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity<ApiResponse<Void>> memberRegister(
            @RequestBody MemberRegisterRequest memberRegisterRequest) {
        memberService.registerMember(memberRegisterRequest);

        return ResponseEntity.ok().body(ApiResponse.success(null, HttpStatus.CREATED));
    }

    @GetMapping("/list")
    public ResponseEntity<Void> getMembers(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "memberName, asc") String sort) {

        return ResponseEntity.ok().build();
    }

    @PostMapping("{memberId}")
    public ResponseEntity<Void> updateMember(@PathVariable("memberId") Long memberId) {

        return ResponseEntity.ok().build();
    }
}
