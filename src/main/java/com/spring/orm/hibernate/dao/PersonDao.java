package com.spring.orm.hibernate.dao;

import com.spring.orm.hibernate.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class PersonDao {
    @Autowired
    HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Transactional
    public int save(Person person){
       Integer personId = (Integer) this.hibernateTemplate.save(person);
       return personId;
    }

    public Person get(int personId){
        Person person = hibernateTemplate.get(Person.class, personId);
        return person;
    }

    public List<Person> getAll(){
        List<Person> list = hibernateTemplate.loadAll(Person.class);
        return list;
    }

    @Transactional
    public void update(Person person){
        hibernateTemplate.update(person);
    }

    @Transactional
    public void delete(Person person){
        hibernateTemplate.delete(person);
    }
}
