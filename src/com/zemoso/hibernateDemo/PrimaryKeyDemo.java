package com.zemoso.hibernateDemo;

import com.zemoso.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String args[]){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create Session
        Session session = factory.getCurrentSession();

        try{
            //use the session object to save the object
            //Create 3 student object::
            System.out.println("Creating 3 Student Object");
            Student tempStudent = new Student("Vineet","G","vineet.g@zemosolabs.com");
            Student tempStudent1= new Student("Kalyan","C","kalyan.c@zemosolabs.com");
            Student tempStudent2 = new Student("Rahul","G","rahul.g@zemosolabs.com");


            //Start the transaction
            session.beginTransaction();

            //Save the student object
            session.save(tempStudent);
            session.save(tempStudent1);
            session.save(tempStudent2);

            //commit the transaction:
            session.getTransaction().commit();
            System.out.println("Done");

        }finally {
            factory.close();
        }
    }
}
