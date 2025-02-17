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

//    public static void main(String[] args) {
//        User user = new User();
//        User user1 = new User(1,"mayur","kamble","Mayur@gmail.com",25,"9860896318");
//        User user2 = new User("Mayur","Kamble");
//    }

//    public static void main(String[] args) {
//        User user = new User(1,"mayur","kamble","mayur@gmail.com",25,"9860896318");
//        System.out.println(user);
//    }

    public static void main(String[] args) {
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("johndoe@gmail.com");
        user.setAge(30);
        user.setPhone("9876543211");

        User user1 = new User();
        user1.setFirstName("John");
        user1.setLastName("Doe");
        user1.setEmail("johndoe@gmail.com");
        user1.setAge(10);
        user1.setPhone("9876543210");

        System.out.println(user.equals(user1));
    }
}
