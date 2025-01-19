package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @GetMapping("student")
    public Student getStudent(){
        Student student = new Student(
                1,
                "Mayur",
                "Kamble"
        );
        return student;
    }

    @GetMapping("students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Mayur", "Kamble"));
        students.add(new Student(2, "Rajesh", "Kamble"));
        students.add(new Student(3, "ramesh", "Kamble"));
        students.add(new Student(4, "suresh", "Kamble"));
        return students;
    }
}
