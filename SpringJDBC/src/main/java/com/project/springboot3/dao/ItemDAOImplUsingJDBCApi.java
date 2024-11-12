package com.project.springboot3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.springboot3.entity.Item;

@Repository("dao")
public class ItemDAOImplUsingJDBCApi implements ItemDAO{

	private static final String SQL = "SELECT * FROM ITEM";
	List<Item> itemList=null;
	
	@Autowired
	private DataSource dataSource;
	//Field Dependency Injection
	
	
	@Override
	public List<Item> getItemsList() {

		try {
			
			System.out.println("DataSource Impl Class :"+ dataSource.getClass().getName());
			
			Connection con= dataSource.getConnection();
			System.out.println("Connection Impl Class :"+ con.getClass().getName());

			PreparedStatement pstmnt = con.prepareStatement(SQL);
			ResultSet rs= pstmnt.executeQuery();
			itemList= new ArrayList<>();
			
			while(rs.next()) {
				
				Item item= new Item(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				itemList.add(item);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return itemList;
	}

}
