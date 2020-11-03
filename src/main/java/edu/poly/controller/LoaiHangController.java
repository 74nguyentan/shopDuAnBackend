package edu.poly.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.poly.exception.NotFoundException;
import edu.poly.model.LoaiHang;
import edu.poly.model.MatHang;
import edu.poly.model.Users;
import edu.poly.repository.LoaiHangRepository;


@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/category")
public class LoaiHangController {
//
//		@Autowired
//		private LoaiHangService loaihangservices;
//		
//		// hiển thị loai hang theo id
//		@GetMapping("/get/{id}")
//		public LoaiHang get(@PathVariable Integer id) {
//			LoaiHang loaihang = loaihangservices.findById(id).orElseThrow(()->new NotFoundException());
//			return loaihang;
//		}
//	    
//		//Save loai hang
//		@PostMapping("save")
//		public LoaiHang save(@RequestBody LoaiHang loaihang) {
//			return loaihangservices.save(loaihang);
//		}
//		
//		//hiển thị tất cả loai hang
//		@GetMapping("list")
//		public List<LoaiHang> listAll(){
//			return (List<LoaiHang>) loaihangservices.findAll();
//		}
//		
//		@PutMapping("update/{id}")
//		public LoaiHang update(@PathVariable Integer id, @RequestBody LoaiHang loaihangs) {
//			return loaihangservices.findById(id)
//					.map(loaihang ->{
//						loaihang.setTenLoaiHang(loaihangs.getTenLoaiHang());
//						loaihang.setNgayLap(loaihangs.getNgayLap());
//						return loaihangservices.save(loaihang);
//					}).get();
//		}
//		
		
	@Autowired
	private LoaiHangRepository loaihangrepository;
		
		// hiển thị mặt hàng theo id http//localhost/8989/api/mathang/{id}
	    @GetMapping("/{id}")
	    public ResponseEntity<LoaiHang> getLoaiHangById(@PathVariable(value = "id") int loaihangId)
	        throws ResourceNotFoundException {
	        LoaiHang LoaiHang = loaihangrepository.findById(loaihangId)
	          .orElseThrow(() -> new ResourceNotFoundException("MatHang not found for this id :: " + loaihangId));
	        return ResponseEntity.ok().body(LoaiHang);
	    }
	    
	    @GetMapping("/")
	    public ResponseEntity<List<LoaiHang>> getAll() throws IOException{
	    	List<LoaiHang> loaiHangs = loaihangrepository.findAll();
	    	return new ResponseEntity<>(loaiHangs, HttpStatus.OK);
	    }
	    
}
