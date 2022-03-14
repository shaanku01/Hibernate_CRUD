package com.zemoso.hibernateDemo;

import com.zemoso.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String args[]){
        //create Session Factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create Session
        Session session = factory.getCurrentSession();

        try{
            //use the session object to save the object
            //Create the student object::
            System.out.println("Creating the Student Object");
            Student tempStudent = new Student("Shanker","Sai","shankersai.gr@zemosolabs.com");

            //Start the transaction
            session.beginTransaction();

            //Save the student object
            session.save(tempStudent);

            //commit the transaction:
            session.getTransaction().commit();
            System.out.println("Done");

        }finally {
            factory.close();
        }


    }

}
