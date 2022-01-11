package com.example.week3.model.response;

import com.example.week3.util.RandomUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class MemberResponse {

    private Long id;
    private String name;
    private Date birthDate;
    private String email;

    public MemberResponse() {
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

        public MemberResponse build() {
            MemberResponse member = new MemberResponse();
            if (id != null)
                member.setId(id);
            member.setName(name);
            member.setBirthDate(birthDate);
            member.setEmail(email);
            return member;
        }
    }

}
