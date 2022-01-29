package com.example.week3.model.request;

import com.example.week3.model.Rate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class RateAddRequest {
    @NotNull
    private Long memberId;
    @NotNull
    private Long movieId;

    @NotNull
    @Min(0)
    @Max(10)
    private Integer point;

    public Rate convert(){
        return Rate.builder()
                .memberId(getMemberId())
                .movieId(getMovieId())
                .point(getPoint())
                .createdDate(new Date(System.currentTimeMillis()))
                .build();
    }
}
