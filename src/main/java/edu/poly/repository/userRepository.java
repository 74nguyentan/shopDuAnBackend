package edu.poly.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.poly.model.Users;

@Repository
public interface userRepository extends CrudRepository<Users, Integer> {

}
