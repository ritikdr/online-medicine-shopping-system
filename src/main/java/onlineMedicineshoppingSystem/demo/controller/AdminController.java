package onlineMedicineshoppingSystem.demo.controller;

import onlineMedicineshoppingSystem.demo.entity.Admin;
import onlineMedicineshoppingSystem.demo.server.AdminServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Admin")
public class AdminController {

    @Autowired
    private AdminServer adminServer;
    @GetMapping("")
    public List<Admin> getAllAdmin() {
        return adminServer.getAllAdmin();
    }


    @PostMapping("/save")
    public Admin saveAdmin(@RequestBody Admin admin) {
        System.out.println(admin);
        return adminServer.saveAdmin(admin);
    }
//    @PostMapping("/save")
//    public Admin saveAdmin(@RequestBody Admin admin) {
//        System.out.println("admin");
//        return adminServer.saveAdmin(admin);
//    }

    @DeleteMapping("/delete")
    public void deleteById(@PathVariable long id) {
//        deleteAdminById(id);
        return;
    }

}
