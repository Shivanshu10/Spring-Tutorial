package com.shivanshu.hibernateadv.dao;

import com.shivanshu.hibernateadv.entity.Course;
import com.shivanshu.hibernateadv.entity.Instructor;
import com.shivanshu.hibernateadv.entity.InstructorDetail;
import com.shivanshu.hibernateadv.entity.Student;

import java.util.List;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    Instructor findInstructorAndDetailByIdJoinFetch(int id);

    void update(Instructor instructor);

    void update(Course course);

    Course findCourseById(int id);

    void deleteCourseById(int id);

    void save(Course course);

    Course findCourseAndReviewByCourseId(int id);

    Course findCourseAndStudentByCourseId(int id);

    Student findStudentAndCoursesByStudentId(int id);

    void update(Student student);

    void removeStudentById(int id);
}
