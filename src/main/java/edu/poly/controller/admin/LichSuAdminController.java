package edu.poly.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.poly.repository.LichSuRepository;

@RestController @CrossOrigin(origins = "http://localhost:4300")
@RequestMapping("/api/admin")
public class LichSuAdminController {
	
	@Autowired LichSuRepository lichsurepository;
	
	@GetMapping("/thongkelichsu")
	  public Object[] getthongke() {
		  Object[] thongke = lichsurepository.getthongkelichsu();
	      return thongke;
	  }

}
