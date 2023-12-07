package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("student")
    public Student getStudent(){
        Student student = new Student(1, "Eduardo","Vicente");
        return student;
    }

    @GetMapping("students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Eduardo", "Vicente"));
        students.add(new Student(2, "Juan", "Perez"));
        students.add(new Student(3, "Jorge", "Perez"));

        return students;
    }

    @GetMapping("student/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(
            @PathVariable("id") int studentId,
            @PathVariable("first-name") String firstName,
            @PathVariable("last-name") String lastName){
        return new Student(studentId, firstName, lastName);
    }

    @GetMapping("student/query")
    public Student studentRequestVariable(
            @RequestParam int id,
            @RequestParam String firstName,
            @RequestParam String lastName){
        return new Student(id, firstName, lastName);
    }

    //Spring boot Rest Api that handles HTTP Post Request
    //@PostMapping and @RequstBody
    @PostMapping("student/create")
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return student;
    }
}
