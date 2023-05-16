package com.tutorial.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.mapping.model.Course;

public interface CourseRepository  extends JpaRepository<Course, Long>{

}
