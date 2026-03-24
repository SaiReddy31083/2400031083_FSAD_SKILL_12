package klu.studentcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import klu.studentcrud.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>
{
}