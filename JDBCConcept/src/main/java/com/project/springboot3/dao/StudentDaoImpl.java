package com.project.springboot3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.springboot3.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao{

	@Autowired
	DataSource dataSource;
	
	@Override
	public Student fetchStudentByName(String name) {
		Connection conn=null;
		try {
			 conn = dataSource.getConnection();
				PreparedStatement prpdStatement = conn.prepareStatement("Select * from student where name=?");
				prpdStatement.setString(1, "Vibhuti");
				System.out.println(prpdStatement.execute());
			 
			 
			 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally
		{
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

}
