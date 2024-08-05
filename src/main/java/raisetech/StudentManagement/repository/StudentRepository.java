package raisetech.StudentManagement.repository;

import java.util.List;
//import org.apache.ibatis.annotations.Delete.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.Studentcourse;


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
    List<Studentcourse> find();

  @Mapper
  public interface StudentMapper {


  }
}


