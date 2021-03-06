package com.example.week3.model.request;

import com.example.week3.model.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
public class MemberAddRequest {

    @NotBlank
    private String name;

    private Date birthDate;

    private String email;

    public Member convert(){
        return Member.builder()
                .name(getName())
                .birthDate(getBirthDate())
                .email(getEmail())
                .build();
    }
}
