package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	@Query("select u from User u where u.firstName =:name")
	public List<User> findByFirstName(@Param("name") String firstName);
}
