package com.lazaretov.testData;


import com.github.javafaker.Faker;

import java.util.Locale;

import static com.lazaretov.utils.RandomDate.*;

public class UserInfo {

    private static final Faker faker = new Faker(new Locale("en"));

    public static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            phone = faker.phoneNumber().subscriberNumber(10),
            pic = "pic.JPG",
            subject = "English",
            hobby = "Reading",
            state = "Haryana",
            city = "Karnal",
            address = faker.address().fullAddress(),
            gender = faker.demographic().sex(),
            day = String.format("%02d", generateDay()),
            month = generateMonth().substring(0, 1).toUpperCase() + generateMonth().substring(1).toLowerCase(),
            year = generateYear(),
            date = day + " " + month + "," + year;
}