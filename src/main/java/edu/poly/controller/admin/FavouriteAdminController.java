package edu.poly.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.poly.repository.FavouriteRepository;

@RestController @CrossOrigin(origins = "http://localhost:4300")
@RequestMapping("/favourite/admin")
public class FavouriteAdminController {
	@Autowired
	private FavouriteRepository favouriteRepository;
	
	@GetMapping("/thongkeyeuthich")
	  public Object[] getthongke() {
		  Object[] thongke = favouriteRepository.getthongkeyeuthich();
	      return thongke;
	  }
}
