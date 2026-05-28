package onlineMedicineshoppingSystem.demo.controller;

import onlineMedicineshoppingSystem.demo.entity.Admin;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/Admin")
public class AdminController {

    @GetMapping
    public void getAllAdmin() {
        return;
    }

    @PostMapping("/save")
    public void saveAdmin(@RequestBody Admin admin) {
        return;
    }

    @DeleteMapping("/delete")
    public void deleteById(@PathVariable long id) {
//        deleteAdminById(id);
        return;
    }

}
