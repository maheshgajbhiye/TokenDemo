package com.docplexus.Tokendemo.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.docplexus.Tokendemo.bean.Token;

@Repository
@Transactional
public interface TokenRepository extends JpaRepository<Token, Long> {
	
	@Query("SELECT token FROM Token token WHERE token.creationDate=cast((:date) as date)")
	List<Token> findAllByCreationDate(@Param("date") String date);

	@Query("SELECT token FROM Token token join Customer customer on token.customerid = customer.id WHERE token.status = 'A' order by customer.priorityId, token.creationDate")
	List<Token> findByStatusAndPriority();

	@Query("UPDATE Token SET staus=(:status) WHERE id=(:id)")
	void updateTokenStatus(@Param("status")String status, @Param("id") long id);

	@Query("UPDATE Token SET counter=(:counterid) WHERE id=(:id)")
	void updateTokenCounter(@Param("counterid") int counterNumber, @Param("id") long id);

	@Query("SELECT token FROM Token token WHERE token.id=(:id)")
	Token findById(@Param("id")long id);

	Token saveAndFlush(Token token);
		
}