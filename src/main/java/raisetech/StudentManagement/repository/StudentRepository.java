package raisetech.StudentManagement.repository;

import java.util.List;
//import org.apache.ibatis.annotations.Delete.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;


/**
 * 受講生情報を扱うリポジトリ。
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
    List<StudentsCourses> searchStudentCoursesList();

  @Select("SELECT * FROM students_courses WHERE course_name = 'ENGLISH'")
  List<StudentsCourses> findEnglishCourse();

  @Select("SELECT * FROM students WHERE id = #{id}")
  Student searchStudent(String id);

  @Select("SELECT * FROM students_courses WHERE student_info_id = #{student_info_id}")
  List<StudentsCourses> searchStudentsCourses(String student_info_id);


    @Insert("INSERT INTO students(name,kanaName,nickname,mailAddress,area,age,gender,remark,isDeleted)"
        + " VALUES(#{name}, #{kanaName}, #{nickname}, #{mailAddress}, #{area}, #{age}, #{gender}, #{remark}, false)")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void registerStudent(Student student);

  @Insert("Insert INTO students_courses(student_info_id, course_name, course_start_date, course_end_date)"
        +"VALUES(#{studentsInfoId}, #{courseName},#{courseStartDate},#{courseEndDate})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void registerStudentsCourses(StudentsCourses studentsCourses);

  @Update("UPDATE students SET(name = #{name}, kanaName = #{kanaName}, nickname = #{nickname},"
      + " mailAddress = #{mailAddress}, area = #{area}, age = #{age}, gender = #{gender}, remark = #{remark}, isDeleted = #{isDeleted} WHERE id = #{id}")
  void updateStudent(Student student);

  @Update("UPDATE students_courses SET(course_name = #{courseName}) WHERE id = #{id}")
  void updateStudentsCourses(StudentsCourses studentsCourses);



}


