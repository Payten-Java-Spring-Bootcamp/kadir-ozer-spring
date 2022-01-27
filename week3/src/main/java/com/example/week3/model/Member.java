package com.example.week3.model;

import com.example.week3.model.entity.MemberEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class Member {

    private Long id;
    private String name;
    private Date birthDate;
    private String email;
    private Set<WatchList> watchLists;


    public static Member convertFromEntity(MemberEntity memberEntity) {
        return builder()
                .id(memberEntity.getId())
                .name(memberEntity.getName())
                .birthDate(memberEntity.getBirthDate())
                .email(memberEntity.getEmail())
                .watchLists(memberEntity.getWatchlists()
                        .stream()
                        .map(WatchList::convertFromEntity)
                        .collect(Collectors.toSet()))
                .build();
    }

    public static MemberEntity convertToEntity(Member member) {
        return MemberEntity.builder()
                .id(member.getId())
                .name(member.getName())
                .birthDate(member.getBirthDate())
                .email(member.getEmail())
                .watchlists(member.getWatchLists()
                        .stream()
                        .map(WatchList::convertToEntity)
                        .collect(Collectors.toSet()))
                .build();
    }
}
