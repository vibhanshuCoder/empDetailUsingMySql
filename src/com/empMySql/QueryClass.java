package com.empMySql;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class QueryClass {
    public String query;
    public EmpServices empServices = new EmpServices();
   PreparedStatement preparedStatement;
   Statement statement;
    dbConnector connector = new dbConnector();
    public Connection con1;

    {
        con1 = connector.conOpen();
    }

    ResultSet resultSet;
    public void insertFunc(EmpModelClass empObj)throws SQLException{
        try{

            query = "insert into Edetails(`Id`,`name`,`age`,`salary`) values (?,?,?,?)";
            preparedStatement =con1.prepareStatement(query);
            preparedStatement.setInt(1, empObj.getId());
            preparedStatement.setString(2, empObj.getName());
            preparedStatement.setInt(3, empObj.getAge());
            preparedStatement.setString(4, empObj.getSalary());
            preparedStatement.executeUpdate();


        }catch (Exception e){
            e.printStackTrace();
        }


    }
    public  void viewFunc() throws SQLException,ClassNotFoundException{

        try{

            statement= con1.createStatement();
            query = "select * from Edetails";
            resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                int Id = resultSet.getInt(1);
                String name =resultSet.getString(2);
                int age = resultSet.getInt(3);
                String sal =resultSet.getString(4);

             if(resultSet != null){   System.out.println("\nId :" +Id+
                        "\nName :" +name+
                        "\nAge :" +age+
                        "\nSalary :"+sal);
             }
             else
             {
                 System.out.println("no record to show");
             }
            }
            resultSet.close();
        }catch (Exception exception){
            exception.printStackTrace();
        }

    }
    public void deleteFunc()throws SQLException,ClassNotFoundException
    {
        query = "DELETE FROM Edetails";
        statement = con1.createStatement();
        statement.executeUpdate(query);
        System.out.println("record deleted succesfully");

    }
    public void deleteByIdFunc()throws SQLException,ClassNotFoundException{
        Scanner sc = new Scanner(System.in);
        int idref = sc.nextInt();
        query = "delete from Edetails" +
                "where Id = idref";
        statement = con1.createStatement();
        statement.executeUpdate(query);
        System.out.println("record deleted succesfully");
    }

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


