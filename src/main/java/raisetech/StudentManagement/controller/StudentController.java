package raisetech.StudentManagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.StudentManagement.controller.converter.StudentConverter;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.Studentcourse;
import raisetech.StudentManagement.domain.StudentDetail;
import raisetech.StudentManagement.service.StudentService;

@RestController
public class StudentController {

  private StudentService service;
  private  StudentConverter converter;

  @Autowired
  public StudentController(StudentService service, StudentConverter converter) {
    this.service = service;
    this.converter = converter;
  }

  @GetMapping("/studentList")
  public List<StudentDetail> getStudentList() {
    List<Student> students = service.searchStudentList();
    List<Studentcourse> studentCourses = service.searchStudentcourseList();

    return converter.convertStudentDetails(students, studentCourses);
  }

  @GetMapping("/studentcourseList")
  public List<Studentcourse> getStudentcourseList() {
    return service.searchStudentcourseList();

  }
  @GetMapping("/students30")
  public List<Student> getStudents30() {
    return service.searchStudents30();
  }

  @GetMapping("/englishcourse")
  public List<Studentcourse> getEnglishCourseStudents() {
    return service.getEnglishCourseStudents();
  }

}

