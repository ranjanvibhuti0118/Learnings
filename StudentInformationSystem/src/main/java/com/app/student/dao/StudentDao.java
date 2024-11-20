package com.app.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.student.entity.Student;

public interface StudentDao extends JpaRepository<Student, Long> {

}
