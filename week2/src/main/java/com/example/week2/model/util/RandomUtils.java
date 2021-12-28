package com.example.week2.model.util;

import io.swagger.models.auth.In;

import java.util.Date;
import java.util.Random;

public class RandomUtils {

    public static final Random random = new Random();

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


}
