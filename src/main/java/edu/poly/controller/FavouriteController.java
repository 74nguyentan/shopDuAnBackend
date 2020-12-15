package edu.poly.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.poly.model.MatHang;
import edu.poly.model.productFavourite;
import edu.poly.repository.FavouriteRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/favourite")
public class FavouriteController {
	@Autowired
	private FavouriteRepository favouriteRepository;

	@PostMapping("/favourite")
	public productFavourite createProFavourite(@Valid @RequestBody productFavourite productFavourite) {
		productFavourite.setNgayLap(new Date());
		return favouriteRepository.save(productFavourite);
	}

	@GetMapping("/favourite/{id}")
	public List<productFavourite> getFavourite(@PathVariable("id") Integer id) {
		Sort sort = Sort.by("ngayLap").descending();
		return favouriteRepository.getAllByUsers_Id(id, sort);
	}

	@GetMapping("/favourite/mathang/{id}")
	public List<productFavourite> getFavouriteByMatHang(@PathVariable("id") Integer id) {

		return favouriteRepository.findmathangid(id);
	}

	@DeleteMapping("/favourite/{id}")
	public Map<String, Boolean> deleteFavourite(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
		productFavourite fv = favouriteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("MatHang not found for this id: " + id));

		favouriteRepository.delete(fv);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	@GetMapping("/thongkeyeuthich")
	  public Object[] getthongke() {
		  Object[] thongke = favouriteRepository.getthongkeyeuthich();
	      return thongke;
	  }
	
	@GetMapping("/yeuthich/{id}")
	 public Optional<productFavourite> getyeuthich(@PathVariable(value = "id") Integer id) {
		 Optional<productFavourite> yeuthich = favouriteRepository.findById(id);
	      return yeuthich;
	  }
}
