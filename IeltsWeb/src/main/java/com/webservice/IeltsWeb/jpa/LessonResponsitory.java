package com.webservice.IeltsWeb.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservice.IeltsWeb.Model.Course;
import com.webservice.IeltsWeb.Model.Lesson;

public interface LessonResponsitory extends JpaRepository<Lesson, String> {

}
