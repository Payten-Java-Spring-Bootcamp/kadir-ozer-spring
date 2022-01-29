package com.example.week3.model;

import com.example.week3.model.entity.MovieEntity;
import com.example.week3.model.entity.RateEntity;
import com.example.week3.model.response.RateResponse;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rate {
    private Long id;
    private Date createdDate;
    private Integer point;
    private Long memberId;
    private Long movieId;

    public static Rate convertFromEntity(RateEntity rateEntity) {
        return builder()
                .id(rateEntity.getId())
                .createdDate(rateEntity.getCreatedDate())
                .point(rateEntity.getPoint())
                .memberId(rateEntity.getMemberId())
                .movieId(rateEntity.getMovie().getId())
                .build();
    }

    public static RateEntity convertToEntity(Rate rate, MovieEntity movieEntity) {
        return RateEntity.builder()
                .id(rate.getId())
                .createdDate(rate.getCreatedDate())
                .point(rate.getPoint())
                .memberId(rate.getMemberId())
                .movie(movieEntity)
                .build();
    }

    public RateResponse toResponse() {
        return RateResponse.builder()
                .id(getId())
                .createdDate(getCreatedDate())
                .point(getPoint())
                .memberId(getMemberId())
                .movieId(getMovieId())
                .build();
    }
}
