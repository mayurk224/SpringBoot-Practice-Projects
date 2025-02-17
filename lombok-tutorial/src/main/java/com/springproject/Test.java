package com.springproject;

public class Test {
//    public static void main(String[] args) {
//        User user = new User();
//        user.setFirstName("Mayur");
//        user.setLastName("Kamble");
//        user.setEmail("kamble@gmail.com");
//        user.setAge(25);
//        user.setPhone("9860896312");
//
//        System.out.println("First Name: " + user.getFirstName());
//        System.out.println("Last Name: " + user.getLastName());
//        System.out.println("Email: " + user.getEmail());
//        System.out.println("Age: " + user.getAge());
//        System.out.println("Phone: " + user.getPhone());
//    }

    public static void main(String[] args) {
        User user = new User();
        User user1 = new User(1,"mayur","kamble","Mayur@gmail.com",25,"9860896318");
        User user2 = new User("Mayur","Kamble");
    }
}
