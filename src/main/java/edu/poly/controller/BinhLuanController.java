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
import edu.poly.model.BinhLuan;
import edu.poly.model.LoaiHang;
import edu.poly.service.BinhLuanService;
import edu.poly.service.LoaiHangService;

@RestController
@RequestMapping("/binhluan")
public class BinhLuanController {

	@Autowired
	private BinhLuanService binhluanservices;
	
	// hiển thị binh luan theo id
	@GetMapping("/get/{id}")
	public BinhLuan get(@PathVariable Integer id) {
		BinhLuan binhluan = binhluanservices.findById(id).orElseThrow(()->new UserNotFoundException());
		return binhluan;
	}
    
	//Save binh luan
	@PostMapping("save")
	public BinhLuan save(@RequestBody BinhLuan binhluan) {
		return binhluanservices.save(binhluan);
	}
	
	//hiển thị tất binh luan
	@GetMapping("list")
	public List<BinhLuan> listAll(){
		return (List<BinhLuan>) binhluanservices.findAll();
	}
	
	@PutMapping("update/{id}")
	public BinhLuan update(@PathVariable Integer id, @RequestBody BinhLuan binhluans) {
		return binhluanservices.findById(id)
				.map(binhluan ->{
					binhluan.setNoiDungBinhLuan(binhluans.getNoiDungBinhLuan());
					
				 return binhluanservices.save(binhluan);
				}).get();
	}
}
