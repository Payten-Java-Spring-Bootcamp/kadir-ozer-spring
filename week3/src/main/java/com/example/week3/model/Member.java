package com.example.week3.model;

import com.example.week3.model.entity.MemberEntity;
import com.example.week3.model.response.MemberResponse;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

    private Long id;
    private String name;
    private Date birthDate;
    private String email;


    public static Member convertFromEntity(MemberEntity memberEntity) {
        return builder()
                .id(memberEntity.getId())
                .name(memberEntity.getName())
                .birthDate(memberEntity.getBirthDate())
                .email(memberEntity.getEmail())
                .build();
    }

    public static MemberEntity convertToEntity(Member member) {
        return MemberEntity.builder()
                .id(member.getId())
                .name(member.getName())
                .birthDate(member.getBirthDate())
                .email(member.getEmail())
                .build();
    }

    public MemberResponse toResponse() {
        return MemberResponse.builder()
                .id(getId())
                .name(getName())
                .birthDate(getBirthDate())
                .email(getEmail())
                .build();
    }
}
