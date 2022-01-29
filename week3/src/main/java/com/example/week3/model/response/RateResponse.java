package com.example.week3.model.response;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RateResponse {

    private Long id;
    private Integer point;
    private Date createdDate;
    private Long memberId;
    private Long movieId;
}
