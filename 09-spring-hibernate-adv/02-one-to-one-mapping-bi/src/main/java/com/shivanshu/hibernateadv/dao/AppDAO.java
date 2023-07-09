package com.shivanshu.hibernateadv.dao;

import com.shivanshu.hibernateadv.entity.Instructor;
import com.shivanshu.hibernateadv.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
}
