package raisetech.StudentManagement.data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter



public class StudentsCourses {
  private String id;
  private String studentsInfoId;
  private String courseName;
  private LocalDateTime courseStartDate;
  private LocalDateTime courseEndDate;


}
