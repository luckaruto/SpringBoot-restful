package com.webservice.IeltsWeb.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservice.IeltsWeb.Model.Course;

public interface CourseResponsitory extends JpaRepository<Course, String> {

}
