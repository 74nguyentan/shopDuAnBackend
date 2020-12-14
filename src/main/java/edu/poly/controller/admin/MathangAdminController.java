package edu.poly.controller.admin;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.poly.model.MatHang;
import edu.poly.repository.MatHangRepository;

@RestController @CrossOrigin(origins = "http://localhost:4300")
@RequestMapping("/api/admin")
public class MathangAdminController {
	
	@Autowired
	private MatHangRepository mathangrepository;
	
	@GetMapping("/mathang")
    public List<MatHang> getAllMatHangDetails(Date ngaylap) {
		Sort sort = Sort.by("ngayLap").descending();
        return mathangrepository.findAll(sort);
    }

	// xóa mặt hàng theo id  http//localhost/8989/api/mathang nhớ là delete nhé
    @DeleteMapping("/mathang/{id}")
    public Map<String, Boolean> deleteMatHang(@PathVariable(value = "id") int MatHangId)
         throws ResourceNotFoundException {
        MatHang MatHang = mathangrepository.findById(MatHangId)
       .orElseThrow(() -> new ResourceNotFoundException("MatHang not found for this id :: " + MatHangId));

        mathangrepository.delete(MatHang);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    
    @GetMapping("/thongke")
    public Object[] getthongke() {
  	  Object[] thongke = mathangrepository.getthongke();
        return thongke;
    }
}
