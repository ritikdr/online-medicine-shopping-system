package onlineMedicineshoppingSystem.demo.server;

import onlineMedicineshoppingSystem.demo.entity.Admin;
import onlineMedicineshoppingSystem.demo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServer {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Admin> getAllAdmin() {
        return adminRepository.findAll();
    }

    public Optional<Admin> findAdminById(Long id) {
        return adminRepository.findById(id);
    }

    public Admin saveAdmin(Admin admin) {
        if(admin.getPassword() != null && admin.getPassword().startsWith("$2a$")) {
            admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        }
        return adminRepository.save(admin);
    }

    public void deleteAdminById(long id) {
        adminRepository.deleteById(id);
    }
}
