package edu.poly.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jayway.jsonpath.Option;

import edu.poly.model.BinhLuan;
import edu.poly.model.LichSu;
import edu.poly.model.MatHang;
import edu.poly.model.Users;
import edu.poly.model.productFavourite;
import edu.poly.repository.LichSuRepository;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class LichSuController {
	@Autowired LichSuRepository lichsurepository;
	
	 @PostMapping("/lichsu")
	    public LichSu createlichsu(@Valid @RequestBody LichSu lichsu) {
		 	lichsu.setTrangThai(true);
		 	return lichsurepository.save(lichsu);
	    }
	 
	 @GetMapping("/lichsu")
	    public List<LichSu> getAllLichSu() {
	        return lichsurepository.findAll();
	   }
	 
	 @GetMapping("/lichsu/{id}")
		public void deleteFavourite(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
		 	  lichsurepository.findByUsersId1(id);
		}
	 

	 @GetMapping("/idlichsu/{id}")
	    public List<LichSu> getidlichsu(@PathVariable("id") Integer id){
		 Sort sort = Sort.by("ngayLap").descending();
	    	return lichsurepository.findByUsersId(id, sort);
	  }
	 
	 @GetMapping("/thongkelichsu")
	  public Object[] getthongke() {
		  Object[] thongke = lichsurepository.getthongkelichsu();
	      return thongke;
	  }
	 
}
