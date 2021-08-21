package com.shecodes.jdbc;

import com.shecodes.exceptions.DateException;
import com.shecodes.exceptions.GenderException;
import com.shecodes.models.Gender;
import com.shecodes.models.Student;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class StudentOperations {

    void newStudent() throws DateException, GenderException, SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Whats your Registration No");
        String registrationNumber = scanner.nextLine();

        System.out.println("Whats your Name ");
        String name = scanner.nextLine();

        System.out.println("Whats your Date of Birth:dd/MM/yyyy");
        String dateOfBirth = scanner.nextLine();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dob;
        try {
            dob = simpleDateFormat.parse(dateOfBirth.trim());

        } catch (ParseException e) {
            throw new DateException(e.getMessage());
        }

        System.out.println("Whats your Registration Date:dd/MM/yyyy");
        String admissionDate = scanner.nextLine();
        Date admin;
        try {
            admin = simpleDateFormat.parse(admissionDate.trim());

        } catch (ParseException e) {
            throw new DateException(e.getMessage());
        }
        System.out.println("Whats your course ");
        String course = scanner.nextLine();

        //Enum class gender
        Gender g;
        try {
            System.out.println("Whats your Gender (Male or Female)");
            String gender = scanner.nextLine();
            g = Gender.valueOf(gender.trim());
        } catch (IllegalArgumentException e) {
            throw new GenderException(e.getMessage());
        }
        Student student = new Student(registrationNumber.trim(), name.trim(), dob, admin, course.trim(), g);
        Database db=new Database();
        db.addStudent(student);
        db.closeConnection();

    }

    void readStudents() throws ClassNotFoundException, SQLException {
        Database db=new Database();
        db.viewStudents();
        db.closeConnection();
    }
    void delete() throws ClassNotFoundException, SQLException {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter RegNo");
        String searchPhrase=scanner.nextLine();
        Database db=new Database();
        db.deleteStudent(searchPhrase);
        db.closeConnection();
        System.out.println("Deleted successfully....");


    }
    void search() throws ClassNotFoundException, SQLException {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter RegNo");
        String searchPhrase=scanner.nextLine();
        Database db=new Database();
        db.searchStudent(searchPhrase);
        db.closeConnection();

    }
    void update(String regNo) throws DateException, GenderException, ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Whats your Name ");
        String name = scanner.nextLine();

        System.out.println("Whats your Date of Birth:dd/MM/yyyy");
        String dateOfBirth = scanner.nextLine();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dob;
        try {
            dob = simpleDateFormat.parse(dateOfBirth.trim());

        } catch (ParseException e) {
            throw new DateException(e.getMessage());
        }

        System.out.println("Whats your Registration Date:dd/MM/yyyy");
        String admissionDate = scanner.nextLine();
        Date admin;
        try {
            admin = simpleDateFormat.parse(admissionDate.trim());

        } catch (ParseException e) {
            throw new DateException(e.getMessage());
        }
        System.out.println("Whats your course ");
        String course = scanner.nextLine();

        //Enum class gender
        Gender g;
        try {
            System.out.println("Whats your Gender (Male or Female)");
            String gender = scanner.nextLine();
            g = Gender.valueOf(gender.trim());
        } catch (IllegalArgumentException e) {
            throw new GenderException(e.getMessage());
        }
        Student student = new Student(regNo.trim(), name.trim(), dob, admin, course.trim(), g);
        Database db=new Database();
        db.updateStudent(student);
        System.out.println("Details Updated Successfully");
        db.closeConnection();
    }
}
