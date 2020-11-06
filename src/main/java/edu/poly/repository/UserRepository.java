package edu.poly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.poly.model.Users;


@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

}
