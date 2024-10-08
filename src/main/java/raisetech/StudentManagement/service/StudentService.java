package raisetech.StudentManagement.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;
import raisetech.StudentManagement.domain.StudentDetail;
import raisetech.StudentManagement.repository.StudentRepository;


@Service
public class StudentService {

  @Autowired
  private StudentRepository repository;


  @Autowired
  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  public List<Student> searchStudentList() {
    return repository.search();
  }

  public List<StudentsCourses> searchStudentcourseList() {
    return repository.find();
  }


  public List<Student> searchStudents30() {
    return repository.students30();
  }


  public List<StudentsCourses> getEnglishCourseStudents() {
    return repository.findEnglishCourse();
  }

  @Transactional
  public void registerStudent(StudentDetail studentDetail) {
    repository.registerStudent(studentDetail.getStudent());
    for(StudentsCourses studentsCourses:studentDetail.getStudentsCourses()) {
      studentsCourses.setStudentsInfoId(studentDetail.getStudent().getId());
      studentsCourses.setCourseStartDate(LocalDateTime.now());
      studentsCourses.setCourseEndDate(LocalDateTime.now().plusYears(1));
      repository.registerStudentsCourses(studentsCourses);
    }
  }
}

