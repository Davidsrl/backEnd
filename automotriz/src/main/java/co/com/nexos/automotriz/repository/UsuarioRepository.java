package co.com.nexos.automotriz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.com.nexos.automotriz.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
