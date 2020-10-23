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

import edu.poly.exception.NotFoundException;
import edu.poly.model.LoaiHang;
import edu.poly.model.MatHang;
import edu.poly.model.Users;


@RestController
@RequestMapping("/loaihang")
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
		
}
