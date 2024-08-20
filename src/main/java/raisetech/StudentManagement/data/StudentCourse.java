package raisetech.StudentManagement.data;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter



public class StudentCourse {
  private String id;
  private String studentsinfoid;
  private String coursename;
  private Timestamp coursestartdate;
  private Timestamp courseenddate;


}
