package edu.poly.controller;

import edu.poly.model.Users;
import edu.poly.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
     UserServices userservice;
    @GetMapping("/add")
    public String addOrEdit(ModelMap model) {
        Users u =new Users();
        model.addAttribute("USER", u);
        model.addAttribute("ACTION", "saveOrUpadate");
        return "users/register-user";
    }
    @PostMapping("saveOrUpadate")
    public String saveOrUpdate(ModelMap model,@ModelAttribute("USER") Users user) {
//	UserDao dao=new UserDao();
        //dao.save(user);
        userservice.save(user);
        return "users/register-user";
    }
    @RequestMapping("/list")
    public String list(ModelMap model) {

        model.addAttribute("USER",userservice.findAll());
        return "users/view-user";
    }

    @RequestMapping("/edit/{id}")
    public String edit(ModelMap model, @PathVariable(name="id") int id) {

        Optional<Users> u= userservice.findById(id);
        if(u.isPresent()) {
            model.addAttribute("USER", u.get() );
        }else {

            model.addAttribute("USER",new Users() );
        }

        model.addAttribute("ACTION", "/saveOrUpadate");
        return "users/register-user";
    }

    @RequestMapping("/delete/{id}")
    public String delete(ModelMap model, @PathVariable(name="id") int id) {

        //UserDao dao =new UserDao();
        //dao.delete(username);
        userservice.deleteById(id);
        model.addAttribute("USER", userservice.findAll());
        return "users/view-user";
    }
    @RequestMapping("/login")
    public String showlogin() {
        return "users/login";
    }

    @PostMapping("/checkinlogin")
    public String checkLogin(ModelMap model, @RequestParam("hovaten") String hovaten,
                             @RequestParam("password") String matkhau
            , HttpSession session) {
        if(userservice.checkLogin(hovaten, matkhau)) {
            session.setAttribute("USERNAME", hovaten);
            model.addAttribute("USER",userservice.findAll());
            return "users/view-user";
        }else {
            model.addAttribute("ERROR","Username or password not exist");
        }
        return "users/login";
    }
}
