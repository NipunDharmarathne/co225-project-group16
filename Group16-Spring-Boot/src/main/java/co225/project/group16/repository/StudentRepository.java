package co225.project.group16.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co225.project.group16.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	List<Student> findRegisteredStudents(boolean registered);
}
