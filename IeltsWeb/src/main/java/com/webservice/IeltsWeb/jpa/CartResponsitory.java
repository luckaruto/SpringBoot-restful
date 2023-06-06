package com.webservice.IeltsWeb.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.webservice.IeltsWeb.Model.Cart;
import com.webservice.IeltsWeb.Model.CartId;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CartResponsitory extends JpaRepository<Cart,CartId> {

	    @Modifying
	    @Transactional
	    @Query("DELETE FROM Cart c WHERE c.id.courseId = :courseId AND c.id.userId = :userId")
	    void deleteByCourseIdAndUserId(@Param("courseId") String courseId, @Param("userId") String userId);
}
