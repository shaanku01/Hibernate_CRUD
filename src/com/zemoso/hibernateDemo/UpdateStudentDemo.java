package com.zemoso.hibernateDemo;

import com.zemoso.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String args[]){
        //create Session Factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();



        try{
            int studentId = 1;
            Session session = factory.getCurrentSession();

            //Start the transaction
            session.beginTransaction();

            System.out.println("Getting student with Student ID "+ studentId);

            Student myStudent  = session.get(Student.class,studentId);

            System.out.println("Updating Student");
            myStudent.setLastName("Garikapati");


            //commit the transaction
            session.getTransaction().commit();



            // BULK UPDATES:



            //Start the transaction
            Session session1 = factory.getCurrentSession();
            session1.beginTransaction();

            //Update the email for all users:
            System.out.println("Update email for all the students");
            session1.createQuery("update Student s set email='kalyanc@zemosolabs.com' where s.id=2").executeUpdate();



            //Commit the  transaction:
            session1.getTransaction().commit();



            System.out.println("Done");

        }finally {
            factory.close();
        }

    }
}
