package com.StudentCrud.Students.Repository;

import com.StudentCrud.Students.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
