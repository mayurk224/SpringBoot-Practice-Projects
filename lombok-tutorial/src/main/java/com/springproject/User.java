package com.springproject;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
public class User {

    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String firstName;

    @Getter(AccessLevel.PROTECTED)
    @Setter(AccessLevel.PROTECTED)
    private String lastName;
    private String email;
    private int age;
    private String phone;
}
