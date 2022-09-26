package com.example.studentsmanagement.dao;

import com.example.studentsmanagement.model.Student;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

// <Student, Long> -> <Table, primary key>
public interface StudentDao extends CrudRepository<Student, Long> {

  List<Student> findByName(String name);
}
