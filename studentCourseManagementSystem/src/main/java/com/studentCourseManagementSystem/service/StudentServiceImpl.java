package com.studentCourseManagementSystem.service;

import com.studentCourseManagementSystem.exceptions.CourseException;
import com.studentCourseManagementSystem.exceptions.StudentException;
import com.studentCourseManagementSystem.model.Course;
import com.studentCourseManagementSystem.model.Student;
import com.studentCourseManagementSystem.repository.CourseRepository;
import com.studentCourseManagementSystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private CourseRepository courseRepo;

    @Override
    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public void enrollStudent(Long studentId, Long courseId) throws StudentException, CourseException {
        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new StudentException("Student not found"));
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new CourseException("Course not found"));
        student.getCourses().add(course);
        studentRepo.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> list = studentRepo.findAll();
        if(list.isEmpty()) throw new StudentException("no any student exist");
        return  list;
    }

    @Override
    public List<Course> getAllCourse() {
        List<Course> list = courseRepo.findAll();
        if(list.isEmpty()) throw new CourseException("no any course exist");
        return  list;
    }

    @Override
    public List<Student> getStudentsByCourseName(String courseName) {
        List<Student> list = studentRepo.findByCourseName(courseName);
        if(list.isEmpty()) throw new StudentException("no any student exist in this course");
        return  list;
    }


    @Override
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepo.deleteById(id);
    }
}
