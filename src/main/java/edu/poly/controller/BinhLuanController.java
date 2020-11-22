package edu.poly.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.poly.exception.NotFoundException;
import edu.poly.model.BinhLuan;
import edu.poly.model.MatHang;
import edu.poly.repository.BinhLuanRepository;
import edu.poly.repository.MatHangRepository;
@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class BinhLuanController {
	@Autowired
	private BinhLuanRepository binhluanrepository;
	
	@GetMapping("/binhluan")
    public List<BinhLuan> getAllBinhLuans() {
        return binhluanrepository.findAll();
    }
	 @PostMapping("/binhluan")
	    public BinhLuan createMatHang(@Valid @RequestBody BinhLuan binhluan) {
	        return binhluanrepository.save(binhluan);
	    }
	
	@GetMapping("/idusers/{id}")
    public List<BinhLuan> getiduser(@PathVariable("id") Integer id){
    	return binhluanrepository.findByUsersId(id);
    }
		
	@GetMapping("/idmathang/{id}")
    public List<BinhLuan> getidmathang(@PathVariable("id") Integer id){
    	return binhluanrepository.getAllByMatHang_Id(id);
   }
    
}
