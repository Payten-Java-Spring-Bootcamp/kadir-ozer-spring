package com.example.week2.model.util;


import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class RandomUtils {

    public static final Random random = new Random();

    public static final Faker faker = new Faker();

    public static <T extends Enum<?>> T randomEnum(Class<T> clazz) {
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    public static Date randomDate() {
        return new Date(random.nextInt() * 1000L);
    }

    public static Long randomLong() {
        return random.nextLong();
    }

    public static Integer randomYear() {
        return random.nextInt(1940, 2022);
    }

    public static String randomName() {
        return faker.name().fullName();
    }

    public static String randomTitle() {
        return faker.book().title();
    }

    public static String randomEmail() {
        return faker.bothify("######@gmail.com");
    }

    public static List<String> randomNameList(){
        List<String> arr = new ArrayList<>();
        for (int i = 0; i < random.nextInt(0,20); i++) {
            arr.add(randomName());
        }
        return arr;
    }
    public static  List<Long> randomLongList(){
        List<Long> arr = new ArrayList<>();
        for (int i = 0; i < random.nextInt(0,20); i++) {
            arr.add(randomLong());
        }
        return arr;
    }
    public static String randomFunnyName(){
        return faker.funnyName().name();
    }
}
