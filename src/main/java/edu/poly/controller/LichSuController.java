package edu.poly.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import edu.poly.repository.LichSuRepository;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class LichSuController {
	@Autowired LichSuRepository lichsurepository;
	
	 @PostMapping("/lichsu")
	    public LichSu createlichsu(@Valid @RequestBody LichSu lichsu) {
	        return lichsurepository.save(lichsu);
	    }
	 
	 @GetMapping("/lichsu")
	    public List<LichSu> getAllLichSu() {
	        return lichsurepository.findAll();
	   }
	 
	 @PutMapping("/lichsu/{LichsuId}")
	    public ResponseEntity<LichSu> updatelichsu(@PathVariable(value = "LichsuId") int LichsuId,
	         @Valid @RequestBody LichSu LichsuDetails) throws ResourceNotFoundException {
		 LichSu lichsu = lichsurepository.findById(LichsuId)
		 .orElseThrow(() -> new ResourceNotFoundException("MatHang not found for this id :: " + LichsuId));
		 lichsu.setMatHang(LichsuDetails.getMatHang());
		 lichsu.setUsers(LichsuDetails.getUsers());
		 lichsu.setNgayLap(new Date());
		 final LichSu updatedlichsu = lichsurepository.save(lichsu);
	        return ResponseEntity.ok(updatedlichsu);
		 
		 
	 }
	 
//	 @DeleteMapping("/lichsu/{Users_id}")
//	    public LichSu deletelichsu(@PathVariable(value = "Users_id") int Users_id){
//		 LichSu lichsu = lichsurepository.findByUsersId(Users_id);		 
//		 return (LichSu) lichsurepository.deleteLichsuWithIds(lichsu);
//	    }
	 @GetMapping("/idlichsu/{id}")
	    public List<LichSu> getidlichsu(@PathVariable("id") Integer id){
	    	return lichsurepository.findByUsersId(id);
	    }
	 
}
