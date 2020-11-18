package edu.poly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.poly.model.Users;


@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
List<Users> findByEmail(@Param("email") String email);
//	List<Users> findByEmail(String email);
}
