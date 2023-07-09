package com.shivanshu.hibernateadv.dao;

import com.shivanshu.hibernateadv.entity.Instructor;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findById(int id);

    void deleteById(int id);
}
