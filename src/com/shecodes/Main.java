package com.shecodes;

import com.shecodes.jdbc.Database;
import com.shecodes.models.Gender;
import com.shecodes.models.Student;

import java.sql.*;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {

    }
    public static void addStudent(Student s) throws ClassNotFoundException, SQLException {
        Database db=new Database();
        Connection conn=db.connection();
        String regNo=s.getRegistrationNumber();
        String name=s.getName();
        String dob= new SimpleDateFormat("dd/MM/yyyy").format(s.getDateOfBirth());
        String admD=new SimpleDateFormat("dd/MM/yyyy").format(s.getDateOfAdmission());
        String course=s.getCourse();
        Gender gender=s.getGender();
        PreparedStatement preparedStatement= conn.prepareStatement("INSERT INTO `tbl_students`(`regNo`, `name`, `dob`, `dateOfAdm`,`course`, " +
                "`gender`) VALUES (?,?,?,?,?,?)");
        preparedStatement.setString(1,regNo);
        preparedStatement.setString(2,name);
        preparedStatement.setString(3, dob);
        preparedStatement.setString(4, admD);
        preparedStatement.setString(5, course);
        preparedStatement.setString(6, String.valueOf(gender));
        preparedStatement.executeUpdate();
        System.out.println("Added Successfully...");
        db.closeConnection();

    }
    public static void viewStudents() throws SQLException, ClassNotFoundException {
        Database db=new Database();
        Connection conn=db.connection();
        Statement statement=conn.createStatement();
        ResultSet resultSet=statement.executeQuery("SELECT * FROM tbl_students");
        while (resultSet.next()){
            System.out.println(resultSet.getString(1)+","+resultSet.getString(2)+","+resultSet.getString(3)+
                    ","+resultSet.getString(4)+","+resultSet.getString(5)+","+resultSet.getString(6));
        }
        db.closeConnection();
    }
    public static void searchStudent(String regNo) throws SQLException, ClassNotFoundException {
        Database db=new Database();
        Connection conn=db.connection();
        Statement statement=conn.createStatement();
        ResultSet rs=statement.executeQuery("SELECT * FROM `tbl_students` WHERE regNo='"+regNo+"'");
        while (rs.next()){
            System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+
                    ","+rs.getString(4)+","+rs.getString(5)+","+rs.getString(6));
        }
        db.closeConnection();
    }
    public static void deleteStudent(String regNo) throws SQLException, ClassNotFoundException {
        Database db=new Database();
        Connection conn=db.connection();
        Statement statement=conn.createStatement();
        statement.executeUpdate("DELETE FROM `tbl_students` WHERE regNo='"+regNo+"'");
        System.out.println("Student of regNo: "+regNo);
        db.closeConnection();
    }
    public static void updateStudent(Student s) throws SQLException, ClassNotFoundException {
        Database db=new Database();
        Connection conn=db.connection();
        String regNo=s.getRegistrationNumber();
        String name=s.getName();
        String dob= new SimpleDateFormat("dd/MM/yyyy").format(s.getDateOfBirth());
        String admD=new SimpleDateFormat("dd/MM/yyyy").format(s.getDateOfAdmission());
        String course=s.getCourse();
        Gender gender=s.getGender();
        PreparedStatement preparedStatement=conn.prepareStatement("UPDATE tbl_students SET regNo=?,name =?,dob=?,dateOfAdm=?,course=?," +
                "gender=? WHERE regNo="+regNo);
        preparedStatement.setString(1,regNo);
        preparedStatement.setString(2,name);
        preparedStatement.setString(3, dob);
        preparedStatement.setString(4, admD);
        preparedStatement.setString(5, course);
        preparedStatement.setString(6, String.valueOf(gender));
        preparedStatement.executeUpdate();
        db.closeConnection();



    }

}
