package com.zemoso.hibernateDemo;

import com.zemoso.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String args[]){

        //create Session Factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try{



            //Start the transaction
            session.beginTransaction();

            //Query the Students
            List<Student> theStudent = session.createQuery("from Student").getResultList();

            //Display the Students:
            for(Student tempStudent : theStudent){
                System.out.println(tempStudent.toString());
            }

            //Query Students with last name is :G
            List<Student> studentList1 = session.createQuery("from Student s where s.lastName='G'").getResultList();
            for(Student tempStudent : studentList1){
                System.out.println("Last Name : G"+tempStudent.toString());
            }

            //Query Students with lastName="G" or firstName = Shanker
            theStudent = session.createQuery("from Student s where"
            +" s.lastName='G' OR s.firstName='Shanker'").getResultList();
            for(Student tempStudent : theStudent){
                System.out.println("OR Query "+tempStudent.toString());
            }

            //Query using the like Clause::

            theStudent = session.createQuery("from Student s where"+
                    " s.email LIKE '%@zemosolabs.com'").getResultList();
            for(Student tempStudent : theStudent){
                System.out.println("Like Query "+tempStudent.toString());
            }




            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Done");


        }finally {
            factory.close();
        }
    }

}
