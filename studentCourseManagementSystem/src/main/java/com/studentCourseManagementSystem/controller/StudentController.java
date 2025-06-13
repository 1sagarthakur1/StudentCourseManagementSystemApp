package com.studentCourseManagementSystem.controller;

import com.studentCourseManagementSystem.model.Course;
import com.studentCourseManagementSystem.model.Student;
import com.studentCourseManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PostMapping("/course")
    public Course addCourse(@RequestBody Course course) {
        return studentService.addCourse(course);
    }

    @PostMapping("/students/{studentId}/enroll/{courseId}")
    public void enroll(@PathVariable Long studentId, @PathVariable Long courseId) {
        studentService.enrollStudent(studentId, courseId);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
    @GetMapping("/courses")
    public List<Course> getAllCourse() {
        return studentService.getAllCourse();
    }

    @GetMapping("/students/course/{name}")
    public List<Student> getByCourse(@PathVariable String name) {
        return studentService.getStudentsByCourseName(name);
    }


    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @DeleteMapping("/course/{id}")
    public void deleteCourse(@PathVariable Long id) {
        studentService.deleteCourse(id);
    }
}
