package com.shecodes.jdbc;

import com.shecodes.exceptions.DateException;
import com.shecodes.exceptions.GenderException;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws GenderException, SQLException, DateException, ClassNotFoundException, IOException, ParseException {
        int choice;
        StudentOperations s=new StudentOperations();
        Database db=new Database();
        System.out.println("Welcome To Nancy's Students Management System");

        do {
            System.out.println("Main Menu: ");
            System.out.println("1. New Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Students");
            System.out.println("4. Delete Students");
            System.out.println("5. Edit Student");
            System.out.println("0. Exit");

            Scanner scanner=new Scanner(System.in);
            choice=scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    s.newStudent();
                    break;
                case 2:
                    s.readStudents();
                    break;
                case 3:
                    s.search();
                    break;
                case 4:
                    s.delete();
                    break;
                case 5:
                    System.out.println("Enter registration number of student to edit details");
                   String reg= scanner.nextLine();
                    s.update(reg);
                    break;
            }

        }while (choice!=0);
    }
}
