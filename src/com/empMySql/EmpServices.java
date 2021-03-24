package com.empMySql;
import java.util.*;
import java.sql.*;
public class EmpServices {



    public void view()
    {

    }

    public void homePage()
    {



    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        QueryClass queryClass = new QueryClass();
        EmpModelClass empobj1 = new EmpModelClass();

        System.out.println("Enter your choice\n" +
                "add - 1\n" +
                "view- 2\n" +
                "exit- 3\n");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        try{ switch (i){
            case 1:{
                System.out.println("enter ID");
                int id = sc.nextInt();
                empobj1.setId(id);
                System.out.println("enter name");
                String name = sc.next();
                empobj1.getName();
                System.out.println("enter age");
                int age = sc.nextInt();
                empobj1.setAge(age);
                System.out.println("enter salary");
                String salary=sc.next();
                empobj1.setSalary(salary);
                queryClass.insertFunc(empobj1);
                break;
            }
            case 2:{
                queryClass.viewFunc();
                break;
            }
            case 3:{
                queryClass.deleteFunc();
            }
            case 4:
            {
                queryClass.deleteByIdFunc();
            }
            case 5:
            {
                System.out.println("thaks for using our service....have a nice day");
            }
        }}catch (Exception exception){
            exception.printStackTrace();
        }

    }

}
