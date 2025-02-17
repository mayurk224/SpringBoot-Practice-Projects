package com.springproject;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
//@NoArgsConstructor(force = true)
//@AllArgsConstructor
//@RequiredArgsConstructor
//@ToString(includeFieldNames = false)
@EqualsAndHashCode
public class User {

//    @Getter
//    @Setter
    private int id;

//    @Getter
//    @Setter
    private  String firstName;

//    @Getter(AccessLevel.PROTECTED)
//    @Setter(AccessLevel.PROTECTED)
    private  String lastName;

//    @ToString.Exclude
    private String email;
    private int age;

//    @ToString.Exclude
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


//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", email='" + email + '\'' +
//                ", age=" + age +
//                ", phone='" + phone + '\'' +
//                '}';
//    }


//    @Override
//    public boolean equals(Object o) {
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return id == user.id && age == user.age && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(phone, user.phone);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, firstName, lastName, email, age, phone);
//    }
}
