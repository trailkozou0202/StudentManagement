package raisetech.StudentManagement;

//import org.apache.ibatis.annotations.Delete.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.Studentcourse;
import raisetech.StudentManagement.repository.StudentRepository;

@SpringBootApplication

public class StudentManagementApplication {




	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}



}




