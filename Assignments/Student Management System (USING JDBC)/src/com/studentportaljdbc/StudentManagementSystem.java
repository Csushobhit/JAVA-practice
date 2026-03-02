package com.studentportaljdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class StudentManagementSystem
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/--yourdatbasename--";
        String username = "--yourusername--";
        String password = "--yourpassword--";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            do
            {
                System.out.println("\n1. Add Student");
                System.out.println("2. Update Student");
                System.out.println("3. Delete Student");
                System.out.println("4. View All Students");
                System.out.println("5. View Student by ID");
                System.out.println("6. Exit");

                System.out.print("Enter choice: ");

                choice = sc.nextInt();


                switch(choice)
                {

                    case 1:
                    	try
                    	{
                        ps = con.prepareStatement("INSERT INTO Student VALUES (?, ?, ?)");
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Marks: ");
                        double marks = sc.nextDouble();
                        ps.setInt(1, id);
                        ps.setString(2, name);
                        ps.setDouble(3, marks);
                        ps.executeUpdate();
                        System.out.println("Student Added Successfully");
                    	}catch(SQLException e)
                    	{
                    		System.out.println("Database Error" + e);
                    	}
                        break;
                    case 2:
                    	try
                    	{
                        ps = con.prepareStatement("UPDATE Student SET marks=? WHERE id=?");
                        System.out.print("Enter ID: ");
                        int uid = sc.nextInt();
                        System.out.print("Enter New Marks: ");
                        double newMarks = sc.nextDouble();
                        ps.setDouble(1, newMarks);
                        ps.setInt(2, uid);
                        int j = ps.executeUpdate();
                        if(j>0)
                        System.out.println("Student Updated");
                        else
                        System.out.println("Student not found");
                    	}catch(SQLException e)
                    	{
                    		System.out.println("Database Error" + e);
                    	}
                        break;
                    case 3:
                    	try
                    	{
                        ps = con.prepareStatement("DELETE FROM Student WHERE id=?");
                        System.out.print("Enter ID: ");
                        int did = sc.nextInt();
                        ps.setInt(1, did);
                        int k = ps.executeUpdate();
                        if(k>0)
                        System.out.println("Student Deleted");
                        else
                        System.out.println("Student not found");
                    	}catch(SQLException e)
                    	{
                    		System.out.println("Database Error" + e);
                    	}
                        break;
                    case 4:
                    	try
                    	{
                        ps = con.prepareStatement("SELECT * FROM Student");
                        rs = ps.executeQuery();
                        System.out.println("\nID   Name   Marks");
                        while(rs.next())
                        {
                            System.out.println(rs.getInt("id")+"   "+rs.getString("name")+"   "+rs.getDouble("marks"));
                        }
                    	}catch(SQLException e)
                    	{
                    		System.out.println("Database Error" + e);
                    	}
                        break;
                    case 5:
                    	try
                    	{
                        ps = con.prepareStatement("SELECT * FROM Student WHERE id=?");
                        System.out.print("Enter ID: ");
                        int sid = sc.nextInt();
                        ps.setInt(1, sid);
                        rs = ps.executeQuery();
                        if(rs.next())
                        {
                        	System.out.println("ID: " + rs.getInt("id")+ " Name: " + rs.getString("name")+ " Marks: " + rs.getDouble("marks"));

                        }
                        else
                        {
                            System.out.println("Student not found");
                        }
                    	}catch(SQLException e)
                    	{
                    		System.out.println("Database Error" + e);
                    	}
                        break;
                        
                    case 6:
                        System.out.println("Thank You");
                        break;
                    default:
                        System.out.println("Invalid Choice");
                }
            }
            while(choice!=6);
        }
        catch(Exception e)
        {
            e.printStackTrace();

        }
    }

}