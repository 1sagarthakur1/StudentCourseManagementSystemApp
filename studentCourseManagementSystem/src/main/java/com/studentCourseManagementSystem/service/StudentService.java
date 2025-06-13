package com.studentCourseManagementSystem.service;

import com.studentCourseManagementSystem.exceptions.CourseException;
import com.studentCourseManagementSystem.model.Course;
import com.studentCourseManagementSystem.model.Student;

import java.util.List;

public interface StudentService {
    Student addStudent(Student student);
    Course addCourse(Course course);
    void enrollStudent(Long studentId, Long courseId) throws SecurityException, CourseException;
    List<Student> getAllStudents();
    List<Course> getAllCourse();
    List<Student> getStudentsByCourseName(String courseName);
    void deleteStudent(Long id);
    void deleteCourse(Long id);
}