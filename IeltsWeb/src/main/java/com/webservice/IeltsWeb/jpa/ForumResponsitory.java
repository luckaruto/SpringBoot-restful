package com.webservice.IeltsWeb.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.webservice.IeltsWeb.Model.Forum;

public interface ForumResponsitory extends JpaRepository<Forum,String> {

}
