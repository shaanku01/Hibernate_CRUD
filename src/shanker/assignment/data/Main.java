package shanker.assignment.data;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
        String user = "hbstudent";
        String pass = "Welcome123$";
	    try{
            System.out.println("Connecting to Data base"+ jdbcUrl);
            Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);
            System.out.println("Connection Successfull");


        }catch (Exception exp){
            exp.printStackTrace();
        }
    }
}
