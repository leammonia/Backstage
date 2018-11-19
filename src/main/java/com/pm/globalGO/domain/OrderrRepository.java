package com.pm.globalGO.domain;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderrRepository extends JpaRepository<Orderr,Long>{

	Orderr findByOrderID(Long orderID);
	Orderr findByUserID(String userID);
	List<Orderr> findAll();
}
