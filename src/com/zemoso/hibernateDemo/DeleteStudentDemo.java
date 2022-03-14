package com.zemoso.hibernateDemo;

import com.zemoso.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

    public static void main(String args[]) {
        //create Session Factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        try {
            int studentId = 1;
            Session session = factory.getCurrentSession();

            //Start the transaction
            session.beginTransaction();

            System.out.println("Getting student with Student ID " + studentId);

            Student myStudent = session.get(Student.class, studentId);

            //delete the Student
            System.out.println("Deleting the object"+myStudent.toString());
            session.delete(myStudent);


            //delete the student having the id=2::
            System.out.println("Deleting the object having id=2");
            session.createQuery("delete from Student where id=2").executeUpdate();




            //commit the transaction
            session.getTransaction().commit();



        } finally {
            factory.close();
        }
    }

}
