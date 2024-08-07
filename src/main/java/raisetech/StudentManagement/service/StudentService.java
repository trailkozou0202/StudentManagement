package raisetech.StudentManagement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.Studentcourse;
import raisetech.StudentManagement.repository.StudentRepository;

@Service
public class StudentService {

  private StudentRepository repository;


  @Autowired
  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

 public List<Student> searchStudentList(){
    return repository.search();
 }
  public List<Studentcourse> searchStudentcourseList() {
    return repository.find();
  }


  public List<Student> searchStudents30() {
    return repository.students30();
  }


  public List<Studentcourse> getEnglishCourseStudents() {
    return repository.findEnglishCourse();
  }

}

