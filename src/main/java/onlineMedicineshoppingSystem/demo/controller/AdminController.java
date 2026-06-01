package onlineMedicineshoppingSystem.demo.controller;

import onlineMedicineshoppingSystem.demo.entity.Admin;
import onlineMedicineshoppingSystem.demo.server.AdminServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Admin")
public class AdminController {

    @Autowired
    private AdminServer adminServer;

    @GetMapping("")
    public List<Admin> getAllAdmin() {
        return adminServer.getAllAdmin();
    }

    @GetMapping("/{Id}")
    public Optional<Admin> findAdminByID(@PathVariable("Id") Long id) {
        return adminServer.findAdminById(id);
    }

    @PostMapping("/save")
    public Admin saveAdmin(@RequestBody Admin admin) {
        return adminServer.saveAdmin(admin);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        adminServer.deleteAdminById(id);
    }

}
