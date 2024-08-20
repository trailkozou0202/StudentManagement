package raisetech.StudentManagement.controller.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.Studentcourse;
import raisetech.StudentManagement.domain.StudentDetail;

@Component
public class StudentConverter {

  public List<StudentDetail> convertStudentDetails(List<Student> students, List<Studentcourse> studentCourses) {
    List<StudentDetail> studentDetails = new ArrayList<>();
    students.forEach(student -> {
      StudentDetail studentDetail = new StudentDetail();
      studentDetail.setStudent(student);

      List<Studentcourse> convertStudentCourse = studentCourses.stream()
          .filter(studentCourse -> student.getId().equals(studentCourse.getId()))
          .collect(Collectors.toList());

      studentDetail.setStudentcourse(convertStudentCourse);
      studentDetails.add(studentDetail);
    });
    return studentDetails;
  }
}
