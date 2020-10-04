package edu.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.poly.exception.UserNotFoundException;
import edu.poly.model.DanhGia;
import edu.poly.model.LoaiHang;
import edu.poly.service.DanhGiaService;

@RestController
@RequestMapping("/danhgia")
public class DanhGiaController {

	@Autowired
	private DanhGiaService danhgiaservice;
	
	// hiển thị danh gia theo id
			@GetMapping("/get/{id}")
			public DanhGia get(@PathVariable Integer id) {
				DanhGia danhgia = danhgiaservice.findById(id).orElseThrow(()->new UserNotFoundException());
				return danhgia;
			}
		    
			//Save danh gia 
			@PostMapping("save")
			public DanhGia save(@RequestBody DanhGia danhgia) {
				return danhgiaservice.save(danhgia);
			}
			
			//hiển thị tất cả danh gia
			@GetMapping("list")
			public List<DanhGia> listAll(){
				return (List<DanhGia>) danhgiaservice.findAll();
			}
			
			@PutMapping("update/{id}")
			public DanhGia update(@PathVariable Integer id, @RequestBody DanhGia danhgias) {
				return danhgiaservice.findById(id)
						.map(danhgia ->{
							danhgia.setSoSao(danhgias.getSoSao());
							danhgia.setNgayLap(danhgias.getNgayLap());
							danhgia.setNgaySua(danhgias.getNgaySua());
							return danhgiaservice.save(danhgia);
						}).get();
			}
			
}
