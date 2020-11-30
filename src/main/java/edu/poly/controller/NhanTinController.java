package edu.poly.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.poly.model.BinhLuan;
import edu.poly.model.NhanTin;
import edu.poly.repository.BinhLuanRepository;
import edu.poly.repository.NhaTinRepository;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class NhanTinController {
	
	@Autowired
	private NhaTinRepository nhantinrepository;
	
	@GetMapping("/nhantin")
    public List<NhanTin> getAlltinnhan() {
        return nhantinrepository.findAll();
    }
	
	 @PostMapping("/nhantin")
	    public NhanTin createtinnhan(@Valid @RequestBody NhanTin nhantin) {
	        return nhantinrepository.save(nhantin);
	    }
	 
	 @GetMapping("/tousers/{id}")
	    public List<NhanTin> gettouser(@PathVariable("id") Integer id){
	    	return nhantinrepository.getAllBytouser_Id(id);
	    }
	 
	 @GetMapping("/fromusers/{id}")
	    public List<NhanTin> getfromuser(@PathVariable("id") Integer id){
	    	return nhantinrepository.getAllByfromuser_Id(id);
	    }
	 
	 

}
