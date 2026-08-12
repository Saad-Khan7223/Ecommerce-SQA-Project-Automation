package com.opencart.utilities;

import java.util.UUID;

public class RandomDataGenerator {

    public static String getRandomEmail() {

        return "saad" + UUID.randomUUID().toString().substring(0,8) + "@gmail.com";

    }

}