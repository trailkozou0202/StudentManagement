package raisetech.StudentManagement.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.Studentcourse;


@Getter
@Setter
public class StudentDetail {

  private Student student;
  private List<Studentcourse> studentcourse;

}