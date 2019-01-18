package repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import  ajeeth.*;

public class Repository {
	
	List<DataClass> dataList;
	String url="";
	String userName="";
	String password="";
	Statement st=null;
	ResultSet rs;
	Connection con=null;
	public Repository()
	{
		/* dataList=new ArrayList<>();
		System.out.println("Ente to getData");
		DataClass dc=new DataClass();
		dc.setName("ajeeth");
		dc.setValue(100);
		dataList.add(dc);
		DataClass dc1=new DataClass();
		dc1.setName("kumar");
		dc1.setValue(190);
		dataList.add(dc1);  */
		
		url="jdbc:mysql://localhost:3306/resttest";
		userName="root";
		password="root";
		dataList=new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,userName,password);
			st=con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception in sql");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception in sql enter");
		}
		
		
	}
	
	public List<DataClass> getData() 
	{
		try
		{
		System.out.println("Enter 1");
		String query="select * from rest";
		rs=st.executeQuery(query);
		System.out.println("Enter 2");
		if(!rs.next())
		{
			System.out.println("Null");
		}
		rs.beforeFirst();
		
		while(rs.next())
		{
			System.out.println("Enter into loop"+rs.getInt("number"));
			DataClass dc=new DataClass();
			dc.setValue(rs.getInt("number"));
			dc.setName(rs.getString("name"));
			System.out.println("Test");
			dataList.add(dc);
			System.out.println("Enter into loop"+rs.getString("name"));
			System.out.println("name.."+dc.getName());
			System.out.println("value.."+dc.getValue());
			
		}
		}
		catch(Exception e)
		{
			System.out.println("Enter into catch");
			e.printStackTrace();
			return null;
		}
		return dataList;
	}

	public DataClass getData(int id) 
	{
		/*for(int dataListIndex=0;dataListIndex<dataList.size();dataListIndex++)
		{
			if(dataList.get(dataListIndex).getValue()==id)
			{
				return dataList.get(dataListIndex);
			}
		}   */
		
		try
		{
		String query="select * from rest where number="+id;
		rs=st.executeQuery(query);
		DataClass dc=new DataClass();
		if(rs.next())
		{
			System.out.println("Enter for particular data");
			dc.setValue(rs.getInt("number"));
			dc.setName(rs.getString("name"));
			dataList.add(dc);
			
		}
		
		return dc;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public void createData(List<DataClass> dc) {
		// TODO Auto-generated method stub
		try
		{
			System.out.println("Enter into create data");
			String insertQuery="insert into rest values(?,?)";
			PreparedStatement st=con.prepareStatement(insertQuery);
			for(int dataClassIndex=0;dataClassIndex<dc.size();dataClassIndex++)
			{
				//dataList.add(dc);
				DataClass dataClass=dc.get(dataClassIndex);
				
				
				st.setInt(1,dataClass.getValue());
				st.setString(2,dataClass.getName());
				st.executeUpdate();
			}
		}
		catch(Exception e)
		{
			System.out.println("Error in create data");
			e.printStackTrace();
		}
		
	}

	public void madifyData(List<DataClass> dc) {
		// TODO Auto-generated method stub
		String sql="";
		try
		{
		String name="";
		int number;
		sql="UPDATE rest SET NAME=? WHERE NUMBER=?";
		PreparedStatement st=con.prepareStatement(sql);
		for(int dataclassListIndex=0;dataclassListIndex<dc.size();dataclassListIndex++)
		{
			DataClass dataClass=dc.get(dataclassListIndex);
			st.setString(1, dataClass.getName());
			st.setInt(2,dataClass.getValue());
			st.executeUpdate();
			
			
		}
		}
		catch(Exception e)
		{
			System.out.println("modify function error"+sql);
			e.printStackTrace();
			
		}
		
	}

	public void deleteData(int id) {
		// TODO Auto-generated method stub
		try
		{
			String sql="delete from rest where number=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("Data is deleted");
			e.printStackTrace();
		}
		
		
	}
}
