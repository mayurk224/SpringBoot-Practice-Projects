package com.springproject;

import lombok.*;

//@Getter
//@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@RequiredArgsConstructor
public class User {

//    @Getter
//    @Setter
    private int id;

//    @Getter
//    @Setter
    private final String firstName;

//    @Getter(AccessLevel.PROTECTED)
//    @Setter(AccessLevel.PROTECTED)
    private final String lastName;
    private String email;
    private int age;
    private String phone;

//    public User() {
//        this.firstName = "";
//        this.lastName = "";
//    }
//
//    public User(int id, String firstName, String lastName, String email, int age, String phone) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.age = age;
//        this.phone = phone;
//    }
//
//    public User(String firstName, String lastName) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }
}
