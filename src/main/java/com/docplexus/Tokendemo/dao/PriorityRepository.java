package com.docplexus.Tokendemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.docplexus.Tokendemo.bean.Priority;

public interface PriorityRepository extends JpaRepository<Priority, Long> {

}
