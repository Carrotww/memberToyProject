package com.commerce.toy.member.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UpdateMemberResponse {
    private String nickname;
    private String memberName;
    private String phoneNumber;
    private String email;
}
