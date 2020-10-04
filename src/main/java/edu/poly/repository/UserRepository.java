package edu.poly.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.poly.model.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {



}
