package com.example.week3.model.request;

import com.example.week3.model.WatchList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class WatchListAddRequest {
    @NotBlank
    private String name;

    @NotNull
    private Long memberId;

    public WatchList convert() {
        return WatchList.builder()
                .name(getName())
                .memberId(getMemberId())
                .build();
    }
}
