package com.empMySql;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class DbClass {
    public String qry;
   PreparedStatement ps;
    dbConnector db = new dbConnector();
    Connection con1 = db.open();
    ResultSet resultSet;
    public void insertFunc(emp empObj)throws SQLException,ClassNotFoundException {
        try{

            qry = "insert into Edetails(Id,name,age,salary) values(?,?,?,?)";
            ps =con1.prepareStatement(qry);
            ps.setInt(1, empObj.getId());
            ps.setString(2, empObj.getName());
            ps.setInt(3, empObj.getAge());
            ps.setString(4, empObj.getSalary());
            ps.executeUpdate();
        }catch (Exception e){}


    }
    public List<emp> viewAll(){
        List<emp> empl = new ArrayList<>();
        emp e = new emp();


        try{
            qry = "select * from Edetails";
            ps= con1.prepareStatement(qry);
            resultSet = ps.executeQuery();
            while(resultSet.next())
            {
                e.setId(resultSet.getInt(1));
                e.setName(resultSet.getString(2));
                e.setAge(resultSet.getInt(3));
                e.setSalary(resultSet);

            }
        }catch (Exception exception){

        }
        return empl;
    }
//    public static void main(String[] args) {
//        try{
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection con = DriverManager.getConnection("jdbc:mysql://localhost","root","root");
//        Statement state = con.createStatement();
//        String str = "create database vibhanhsu111";
//        state.executeUpdate(str);
//            System.out.println("database creation succesful");
//            con.close();
//    }catch(Exception e)
//    {
//        e.printStackTrace();
//    }
//}

    public static void main(String[] args) throws SQLException, ClassNotFoundException { DbClass dbc = new DbClass();
        emp empobj = new emp();
        System.out.println("enter ID");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        empobj.setId(id);
        System.out.println("enter name");
        String name = sc.nextLine();
        empobj.getName();
        System.out.println("enter age");
        int age = sc.nextInt();
        empobj.setAge(age);
        System.out.println("enter salary");
        String salary=sc.next();
        empobj.setSalary(salary);
        dbc.insertFunc(empobj);
    }
}
