package com.springproject.sms.controller;

import com.springproject.sms.dto.StudentDto;
import com.springproject.sms.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String listStudents(Model model){
        List<StudentDto> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/students/new")
    public String newStudent(Model model){
        StudentDto studentDto = new StudentDto();
        model.addAttribute("student", studentDto);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@Valid @ModelAttribute("student") StudentDto studentDto, BindingResult result, Model model){
        // Save the student and redirect to the list of students
        if(result.hasErrors()){
            model.addAttribute("student", studentDto);
            return "create_student";
        }
        studentService.createStudent(studentDto);
        return "redirect:/students";
    }

    @GetMapping("/students/{studentId}/edit")
    public String editStudent(@PathVariable Long studentId, Model model){
        StudentDto studentDto = studentService.getStudent(studentId);
        model.addAttribute("student", studentDto);
        return "edit_student";
    }

    @PostMapping("/students/{studentId}")
    public String updateStudent(@PathVariable Long studentId,
                                @Valid @ModelAttribute("student") StudentDto studentDto,
                                BindingResult result,
                                Model model){
        // Update the student and redirect to the list of students
        if(result.hasErrors()){
            model.addAttribute("student", studentDto);
            return "edit_student";
        }
        studentDto.setId(studentId);
        studentService.updateStudent(studentDto);
        return "redirect:/students";
    }

    @GetMapping("/students/{studentId}/delete")
    public String deleteStudent(@PathVariable Long studentId){
        studentService.deleteStudent(studentId);
        return "redirect:/students";
    }
}
