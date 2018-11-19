package com.pm.globalGO.domain;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String>{

	User findByUserID(String userID);
	List<User> findAll();
	String deleteByUserID(String userID);
}
