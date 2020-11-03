package edu.poly.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.poly.model.MatHang;
import edu.poly.repository.MatHangRepository;



@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class MatHangController {

	@Autowired
	private MatHangRepository mathangrepository;
	
	// hiển thị tất cả mặt hàng http//localhost/8989/api/mathang
	@GetMapping("/mathang")
    public List<MatHang> getAllMatHangDetails() {
        return mathangrepository.findAll();
    }
	
	// hiển thị mặt hàng theo id http//localhost/8989/api/mathang/{id}
    @GetMapping("/mathang/{id}")
    public ResponseEntity<MatHang> getMatHangById(@PathVariable(value = "id") int MatHangId)
        throws ResourceNotFoundException {
        MatHang MatHang = mathangrepository.findById(MatHangId)
          .orElseThrow(() -> new ResourceNotFoundException("MatHang not found for this id :: " + MatHangId));
        return ResponseEntity.ok().body(MatHang);
    }
    
    // thêm mặt hàng nhớ nhấn post nhé không phải là get http//localhost/8989/api/mathang
    @PostMapping("/mathang")
    public MatHang createMatHang(@Valid @RequestBody MatHang MatHang) {
        return mathangrepository.save(MatHang);
    }
    

    //cập nhật mặt hàng theo id n http//localhost/8989/api/mathang/{id} nhớ là put nhé chứ không phải là get and post
    @PutMapping("/mathang/{id}")
    public ResponseEntity<MatHang> updateMatHang(@PathVariable(value = "id") int MatHangId,
         @Valid @RequestBody MatHang MatHangDetails) throws ResourceNotFoundException {
        MatHang MatHang = mathangrepository.findById(MatHangId)
        .orElseThrow(() -> new ResourceNotFoundException("MatHang not found for this id :: " + MatHangId));
	        MatHang.setTenHang(MatHangDetails.getTenHang());
			MatHang.setGia(MatHangDetails.getGia());
			MatHang.setHinh0(MatHangDetails.getHinh0());
			MatHang.setHinh1(MatHangDetails.getHinh1());
			MatHang.setHinh2(MatHangDetails.getHinh2());
			MatHang.setHinh3(MatHangDetails.getHinh3());
			MatHang.setMoTa(MatHangDetails.getMoTa());
			MatHang.setThoiHan(MatHangDetails.getThoiHan());
			MatHang.setXuatXu(MatHangDetails.getXuatXu());
			MatHang.setNgayLap(MatHangDetails.getNgayLap());
			MatHang.setDiaChiBan(MatHangDetails.getDiaChiBan());
			MatHang.setTrangThai(MatHangDetails.isTrangThai());
        final MatHang updatedMatHang = mathangrepository.save(MatHang);
        return ResponseEntity.ok(updatedMatHang);
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
    
    @GetMapping("/idloaihang/{id}")
    public List<MatHang> getidloaihang(@PathVariable("id") Integer id){
    	return mathangrepository.findByLoaiHangId(id);
    }
    
    
   
}
