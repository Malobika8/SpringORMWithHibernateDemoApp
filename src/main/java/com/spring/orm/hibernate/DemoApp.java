package com.spring.orm.hibernate;

import com.spring.orm.hibernate.config.AppConfig;
import com.spring.orm.hibernate.dao.PersonDao;
import com.spring.orm.hibernate.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        PersonDao personDao = applicationContext.getBean("personDao", PersonDao.class);

        Person person1 = new Person();
        person1.setName("Mona");
        person1.setAddress("BBS");
        Person person2 = new Person();
        person2.setName("Sona");
        person2.setAddress("BBS");

        //Save person
        System.out.println("Saving..");
        int id1 = personDao.save(person1);
        System.out.println("Saved person with id: " + id1);
        int id2 = personDao.save(person2);
        System.out.println("Saved person with id: " + id2);

        //Get person with id 1
        System.out.println("\n Person with id 1");
        System.out.println(personDao.get(1));

        //Get all persons
        System.out.println("\n All persons");
        System.out.println(personDao.getAll());

        //Update person
        System.out.println("\n Updating person address");
        person2.setAddress("RKL");
        personDao.update(person2);
        System.out.println(personDao.getAll());

        //Delete person
        System.out.println("\n Deleting person2");
        personDao.delete(person2);
        System.out.println(personDao.getAll());

    }
}
