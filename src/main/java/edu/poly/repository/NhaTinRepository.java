package edu.poly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.poly.model.NhanTin;

public interface NhaTinRepository extends JpaRepository<NhanTin, Integer> {
	@Query("SELECT n FROM NhanTin n WHERE n.toUser.id = ?1")
	List<NhanTin> getAllBytouser_Id(@Param("id") Integer id);
	
	@Query("SELECT n FROM NhanTin n WHERE n.fromUser.id = ?1")
	List<NhanTin> getAllByfromuser_Id(@Param("id") Integer id);
//	
//	@Query("SELECT n FROM NhanTin n WHERE n.fromUser.id = ?1 and n.toUser.id = ?1 ")
//	List<NhanTin> getAllByfromuser_Idandtouser_id(@Param("idfromuer") Integer idfromuer , @Param("idtouser") Integer idtouser);
}
