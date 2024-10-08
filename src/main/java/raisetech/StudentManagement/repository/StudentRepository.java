package raisetech.StudentManagement.repository;

import java.util.List;
//import org.apache.ibatis.annotations.Delete.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;


/**
 * 受講生情報を扱うリポジトリ。
 *
 * 全体検索や単一条件での検索、コース情報の検索が行えるクラスです。
 */
@Mapper
public interface StudentRepository {

  /**
   *
   * @return 全件検索した受講生情報の一覧
   */
  @Select("SELECT * FROM students")
  List<Student> search();

  @Select("SELECT * FROM students WHERE age BETWEEN 30 AND 39")
  List<Student> students30();

    @Select("SELECT * FROM students_courses")
    List<StudentsCourses> find();

  @Select("SELECT * FROM students_courses WHERE coursename = 'ENGLISH'")
  List<StudentsCourses> findEnglishCourse();


    @Insert("INSERT INTO students(name,kanaName,nickname,mailAddress,area,age,gender,remark,isDeleted)"
        + " VALUES(#{name}, #{kanaName}, #{nickname}, #{mailAddress}, #{area}, #{age}, #{gender}, #{remark}, false)")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void registerStudent(Student student);

  @Insert("Insert INTO students_courses(student_info_id, course_name, course_start_date, course_end_date)"
        +"VALUES(#{studentsInfoId}, #{courseName},#{courseStartDate},#{courseEndDate})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void registerStudentsCourses(StudentsCourses studentsCourses);

}


