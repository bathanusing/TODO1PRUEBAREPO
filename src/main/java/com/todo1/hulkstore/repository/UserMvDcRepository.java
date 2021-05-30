package com.todo1.hulkstore.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.todo1.hulkstore.entity.UserMvDc;

public interface UserMvDcRepository extends PagingAndSortingRepository<UserMvDc, Integer>{
	
	Optional<UserMvDc> findByuserName(String userName);

}
