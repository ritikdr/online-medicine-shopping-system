package onlineMedicineshoppingSystem.demo.controller;

import onlineMedicineshoppingSystem.demo.entity.Medicine;
import onlineMedicineshoppingSystem.demo.server.MedicineServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Medicine")
public class MedicineController {

    @Autowired
    private MedicineServer medicineServer;

    @GetMapping("")
    public List<Medicine> getAllMedicines() {
        return medicineServer.getAllMedicines();
    }

    @GetMapping("/{id}")
    public Optional<Medicine> findMedicineByID(@PathVariable Long id) {
        return medicineServer.findMedicineById(id);
    }

    @PostMapping("/save")
    public Medicine saveMedicine(@RequestBody Medicine medicine) {
        return medicineServer.saveMedicine(medicine);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        medicineServer.deleteMedicineById(id);
    }
}
