package edu.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.poly.exception.UserNotFoundException;
import edu.poly.model.MatHang;
import edu.poly.model.Users;
import edu.poly.service.MatHangService;

@RestController
@RequestMapping("/mathang")
public class MatHangController {

	@Autowired
	private MatHangService mathangservice;
	
	//hiển thị mat hang theo id
	@GetMapping("/get/{id}")
	public MatHang get(@PathVariable Integer id) {
		MatHang mathang = mathangservice.findById(id).orElseThrow(()->new UserNotFoundException());
		return mathang;
	}
    
	//Save mat hang 
	@PostMapping("save")
	public MatHang save(@RequestBody MatHang mathang) {
		return mathangservice.save(mathang);
	}
	
	//Hiển thị tất cả các mặt hàng 
	@GetMapping("list")
	public List<MatHang> listAll(){
		return (List<MatHang>) mathangservice.findAll();
	}
	
	//Cập nhật mặt hàng theo id
	@PutMapping("update/{id}")
	public MatHang update(@PathVariable Integer id, @RequestBody MatHang mathangs) {
		return mathangservice.findById(id)
				.map(mathang ->{
					mathang.setTenHang(mathangs.getTenHang());
					mathang.setGia(mathangs.getGia());
					mathang.setHinh0(mathangs.getHinh0());
					mathang.setHinh1(mathangs.getHinh1());
					mathang.setHinh2(mathangs.getHinh2());
					mathang.setHinh3(mathangs.getHinh3());
					mathang.setMoTa(mathangs.getMoTa());
					mathang.setXuatXu(mathangs.getXuatXu());
					mathang.setNgayLap(mathangs.getNgayLap());
					mathang.setNgaySua(mathangs.getNgaySua());
					mathang.setDiaChiBan(mathangs.getDiaChiBan());
					mathang.setTrangThai(mathangs.isTrangThai());
					
					return mathangservice.save(mathang);
				}).get();
	}
	
	//xóa mat hang theo id
	@DeleteMapping("delete/{id}")
	public MatHang delete(@PathVariable Integer id) {
		return mathangservice.deleteById(id);
	}
	
	//tìm kiếm mặt hàng theo mặt hàng 
	@GetMapping("/find/{tenhang}")
	public List<MatHang> findByName(@PathVariable String tenhang){
		return mathangservice.findBytenHangLike(tenhang);
	}
}
