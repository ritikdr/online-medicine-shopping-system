package onlineMedicineshoppingSystem.demo.controller;

import onlineMedicineshoppingSystem.demo.entity.Admin;
import onlineMedicineshoppingSystem.demo.server.AdminServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Admin")
public class AdminController {

    @Autowired
    private AdminServer adminServer;

    @GetMapping("")
    public ResponseEntity<List<Admin>> getAllAdmin() {
        List<Admin> list = adminServer.getAllAdmin();
        return  ResponseEntity.ok(list);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<?> findAdminByID(@PathVariable("Id") Long id) {
        Optional<Admin> admin = adminServer.findAdminById(id);
        if(admin.isPresent()) {
            return new ResponseEntity<>(admin, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin) {
        Admin saveAdmin = adminServer.saveAdmin(admin);
        return ResponseEntity.ok(saveAdmin);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        adminServer.deleteAdminById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
