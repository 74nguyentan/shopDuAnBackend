package edu.poly.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.poly.model.MatHang;
import edu.poly.model.ThongKe;
import edu.poly.repository.MatHangRepository;



@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class MatHangController {

	@Autowired
	private MatHangRepository mathangrepository;
	
	// hiển thị tất cả mặt hàng http//localhost/8989/api/mathang
	@GetMapping("/mathang")
    public List<MatHang> getAllMatHangDetails(Date ngaylap) {
		Sort sort = Sort.by("ngayLap").descending();
        return mathangrepository.findAll(sort);
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
    	MatHang.setNgayLap(new Date());
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
//			MatHang.setLoaiHang(MatHangDetails.getLoaiHang());
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
    	Sort sort = Sort.by("ngayLap").descending();
    	return mathangrepository.findByLoaiHangId(id, sort);
    }
    
    @GetMapping("/iduser/{id}")
    public List<MatHang> getidusers(@PathVariable("id") Integer id){
    	Sort sort = Sort.by("ngayLap").descending();
    	return mathangrepository.getAllByUsers_Id(id, sort);
    }
    
    @GetMapping("/top10/{id}")
    public List<MatHang> gettoploaihang(@PathVariable("id") Integer id){
    	Sort sort = Sort.by("ngayLap").descending();
    	return mathangrepository.findFirst10ByLoaiHangId(id, sort);
    }
    
   //tìm kiếm theo loại hàng 
  @GetMapping("/fitler/{id}")
  public List<MatHang> getfitler(@PathVariable("id") Integer id){
  	
  	return mathangrepository.findMatHangByLoaiHangId(id);
  }
  
  //tìm kiếm theo tên mat hang 
  @GetMapping("/mathang1/{tenHang}")
  public List<MatHang> getmathang(@PathVariable("tenHang") String tenHang){
  	return mathangrepository.findBytenHangContaining(tenHang);
  }
  
  //tìm kiếm theo giá bé hơn 100
  @GetMapping("/gia100/{gia}")
  public List<MatHang> getfitler(@PathVariable("gia") Double gia){
	  Sort sort = Sort.by("ngayLap").descending();
  	return mathangrepository.getAllgia(gia,sort);
  }

  //tìm kiếm theo giá bé hơn 300 và lớn 100
  @GetMapping("/gia300/{gia}")
  public List<MatHang> getfitler1(@PathVariable("gia") Double gia){
	  Sort sort = Sort.by("ngayLap").descending();
  	return mathangrepository.getgia(gia,sort);
  }
  //tìm kiếm theo giá lớn hơn 1000
  @GetMapping("/gia1000/{gia}")
  public List<MatHang> getfitler11(@PathVariable("gia") Double gia){
	  Sort sort = Sort.by("ngayLap").descending();
  	return mathangrepository.getprice(gia,sort);
  }
  
  
  @GetMapping("/ngayLap")
  public List<MatHang> getngaylap(@DateTimeFormat(pattern="yyyy-MM-dd") Date ngaylap){
	  ngaylap = new Date() ;
  	return mathangrepository.getAllngaylap(ngaylap);
  }
  
  @GetMapping("/thongke")
  public Object[] getthongke() {
	  Object[] thongke = mathangrepository.getthongke();
      return thongke;
  }
}
