package com.example.week2.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
public class MemberAddRequest {
    private String name;
    private Date birthDate;
    private String email;
}
