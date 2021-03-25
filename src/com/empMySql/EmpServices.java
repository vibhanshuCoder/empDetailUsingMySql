package com.empMySql;
import java.io.*;
import java.util.*;
import java.sql.*;
public class EmpServices {
    public EmpModelClass empModelClass = new EmpModelClass();
    public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int id = 1010;
    private int idexp;
    public int i;
    public PrintStream Out = new PrintStream(new FileOutputStream(FileDescriptor.out));

    public String addName() throws IOException, SQLException, ClassNotFoundException {
        Out.println("Enter Employee Name");
        String nameref = br.readLine();
        try {
            if (nameref.matches("^[a-zA-Z\\s]{4,30}$")) {
                empModelClass.setName(nameref);
            } else {
                Out.println("please enter a valid name");
                addName();
            }
        } catch (Exception exp) {
            Out.println("Please enter a valid name");
            addName();
        }
        return nameref;
    }

    public int IDvalid() throws IOException {
        Out.print("Enter ID : DZ");
        int idref = Integer.parseInt(br.readLine());
        try {
            if (idref != 0) {
                idexp = idref;
            } else {
                Out.println("Please enter a valid ID");
                IDvalid();
            }
        } catch (Exception exp) {
            Out.println("Please enter a valid ID");
            IDvalid();
        }
        return idexp;
    }

    public int addAge() {
        Out.println("Enter Employee Age");
        int ageref = 18;
        try {
            ageref = Integer.parseInt(br.readLine());
            if (ageref < 60 && ageref > 18) {
                empModelClass.setAge(ageref);

            } else {
                Out.println("Enter valid age");
                addAge();
            }
        } catch (Exception exp) {
            Out.println("Wrong input-type");
            addAge();
        }
        return ageref;
    }

    public String addSalary() throws IOException {
        Out.println("Enter Employee Salary");
        String salaryref = br.readLine();
        if (salaryref.matches("^[1-9]*\\d{4,10}$")) {
            empModelClass.setSalary(salaryref);
        } else {
            Out.println("please Enter valid salary");
            addSalary();
        }
        return salaryref;
    }

    public void homePage() throws IOException {

        QueryClass queryClass = new QueryClass();
        EmpModelClass empobj1 = new EmpModelClass();


        System.out.println("Enter your choice\n" +
                "Add - 1\n" +
                "View - 2\n" +
                "Delete - 3\n" +
                "Exit - 5");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        try {
            switch (i) {
                case 1: {
                    int id = IDvalid();
                    empobj1.setId(id);
                    String name = addName();
                    empobj1.getName();
                    int age = addAge();
                    empobj1.setAge(age);
                    String salary = addSalary();
                    empobj1.setSalary(salary);
                    queryClass.insertFunc(empobj1);
                    homePage();
                    break;
                }
                case 2: {
                    queryClass.viewFunc();
                    homePage();
                    break;
                }
                case 3: {
                    queryClass.deleteFunc();
                    homePage();
                }
                case 4: {
                    queryClass.deleteByIdFunc();
                    homePage();
                }
                case 5: {
                    System.out.println("thaks for using our service....have a nice day");
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        EmpServices empServices = new EmpServices();
        empServices.homePage();

    }
}