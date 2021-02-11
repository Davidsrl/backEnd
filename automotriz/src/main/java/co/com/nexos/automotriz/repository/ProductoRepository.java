package co.com.nexos.automotriz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.com.nexos.automotriz.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
}
