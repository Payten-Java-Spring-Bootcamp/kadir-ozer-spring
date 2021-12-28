package com.example.week2.model;

import com.example.week2.model.util.RandomUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Random;

@Getter
@Setter
public class Member {

    private Long id;
    private String name;
    private Date birthDate;
    private String email;

    public Member() {
        this.id = RandomUtils.randomLong();
    }

    public static final class MemberBuilder {
        private Long id;
        private String name;
        private Date birthDate;
        private String email;

        private MemberBuilder() {
        }

        public static MemberBuilder aMember() {
            return new MemberBuilder();
        }

        public MemberBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public MemberBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public MemberBuilder withBirthDate(Date birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public MemberBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Member build() {
            Member member = new Member();
            member.setId(id);
            member.setName(name);
            member.setBirthDate(birthDate);
            member.setEmail(email);
            return member;
        }
    }

    public static final class RandomMemberGenerator{

        public static Member generateMemberById(Long memberId){
            return MemberBuilder.aMember()
                    .withId(memberId)
                    .withEmail("user"+memberId.toString()+"@gmail.com")
                    .withBirthDate(RandomUtils.randomDate())
                    .withName("user"+memberId)
                    .build();
        }

        public static Member generateMember(){
            return MemberBuilder.aMember()
                    .withEmail("user-x@gmail.com")
                    .withName("user-x")
                    .withBirthDate(RandomUtils.randomDate())
                    .build();
        }

    }
}