package com.shivanshu.cruddemo.dao;

import com.shivanshu.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("from Student order by firstName", Student.class);

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findSByLastName(String theLastName) {
        TypedQuery<Student> theQuery = entityManager.createQuery("from Student where lastName=:theData", Student.class);

        theQuery.setParameter("theData", theLastName);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Student myStudent = entityManager.find(Student.class, id);

        entityManager.remove(myStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("delete from Student").executeUpdate();

        return numRowsDeleted;
    }
}
