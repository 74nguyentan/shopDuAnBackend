package edu.poly.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.poly.model.productFavourite;

@Repository
public interface FavouriteRepository extends JpaRepository<productFavourite, Integer> {
	@Query("SELECT f FROM productFavourite f WHERE f.users.id = ?1")
	List<productFavourite> getAllByUsers_Id(@Param("id_user") Integer id_user, Sort sort);	
	
	@Query("SELECT l FROM productFavourite l WHERE l.MatHang.id = ?1")
	List<productFavourite> findmathangid(@Param("id") Integer id);
}
