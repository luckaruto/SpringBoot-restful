package com.webservice.IeltsWeb.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservice.IeltsWeb.Model.Comment;


public interface CommentResponsitory extends JpaRepository<Comment,String> {

}
