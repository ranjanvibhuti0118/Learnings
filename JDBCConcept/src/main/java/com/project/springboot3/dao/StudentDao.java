package com.project.springboot3.dao;

import com.project.springboot3.entity.Student;

public interface StudentDao {

	Student fetchStudentByName(String name);
}
