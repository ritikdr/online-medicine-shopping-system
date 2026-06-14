package onlineMedicineshoppingSystem.demo.controller;

import onlineMedicineshoppingSystem.demo.entity.Medicine;
import onlineMedicineshoppingSystem.demo.server.MedicineServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Medicine")
public class MedicineController {

    @Autowired
    private MedicineServer medicineServer;

    @GetMapping("")
    public ResponseEntity<List<Medicine>> getAllMedicines() {
        List<Medicine> list = medicineServer.getAllMedicines();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findMedicineByID(@PathVariable Long id) {
        Optional<Medicine> medicine = medicineServer.findMedicineById(id);
        if(medicine.isPresent()) {
            return new ResponseEntity<>(medicine, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<Medicine> saveMedicine(@RequestBody Medicine medicine) {
        Medicine saveMedicine = medicineServer.saveMedicine(medicine);
        return ResponseEntity.ok(saveMedicine);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        medicineServer.deleteMedicineById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/search")
    public ResponseEntity<List<Medicine>> searchMedicines(@RequestParam("name") String name) {
        List<Medicine> list = medicineServer.searchMedicine(name);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Medicine>> getMedicinesByCategory(@PathVariable Long categoryId) {
        List<Medicine> list = medicineServer.getMedicinesByCategory(categoryId);
        return ResponseEntity.ok(list);
    }
}
