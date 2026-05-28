package onlineMedicineshoppingSystem.demo.controller;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/Medicine")
public class MedicineController {

    @GetMapping("")
    public void getAllMedicine() {
        return;
    }

    @PostMapping("/save")
    public void saveMedicine() {
        return;
    }

    @DeleteMapping("/Delete")
    public void deleteById(@PathVariable long id) {
//        deleteMedicineById(id);
        return;
    }
}
