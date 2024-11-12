package com.project.springboot3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJdbcConceptApplication {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		SpringApplication.run(SpringJdbcConceptApplication.class, args);
		
//		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/jdbc";
		String username="root";
		String password="user";
		
		Connection conn = DriverManager.getConnection(url,username,password);
				
		
				
		Statement statement = conn.createStatement();
		
		
		String createTable="create table Student(name varchar(40) not null, age int not null)";
		String insertStudent= "insert into Student (name,age) values('Aman', 30)";
		String updateStudent= "update Student set age=28 where name='Aman'";
		String fetchStudent= "select * from student";
		
		
		System.out.println(statement.execute(insertStudent));
		System.out.println(statement.executeUpdate(updateStudent));
		

		/* Limitation of JDBC */
		
		/* 1. SQL Queries are hard coded(if RDBMS is changed the SQL Queries also need to be changed) 
		 * 2. Lot's of repetitive code(Boiler Plate code), establish connection and close connection
		 * 3. Named parameters are not possible in JDBC, only positional parameters
		 * 4. Object to data mapping not possible
		 * 5. Learn SQL language additional for java developer
		 * 
		 * Some of these limitations are handled in Hibernate and Spring Data JPA
		 * */
	
	
		
	}

}
