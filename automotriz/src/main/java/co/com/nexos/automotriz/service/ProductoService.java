package co.com.nexos.automotriz.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import co.com.nexos.automotriz.model.Producto;
import co.com.nexos.automotriz.repository.ProductoRepository;

@Service
@Scope
@Transactional
public class ProductoService implements ProductoRepository {

	@Autowired
	private ProductoRepository productoRepository;

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}

	@Override
	public List<Producto> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Producto> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Producto> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Producto> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public Producto getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Producto> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Producto> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Producto> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Producto> S save(S entity) {
		return productoRepository.save(entity);
	}

	@Override
	public Optional<Producto> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		productoRepository.deleteById(id);
	}

	@Override
	public void delete(Producto entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Producto> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Producto> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Producto> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Producto> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Producto> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	public Long getMaxProducto() {

		String consulta = "select COALESCE(MAX(id), 0) + 1 from Producto";

		Query query = entityManager.createNativeQuery(consulta);
		Long idLong = new Long(Integer.parseInt(query.getSingleResult().toString()));
		return idLong;

	}

	public void updateProducto(Producto producto) {
		String update = "UPDATE producto SET nombre_producto= ?1, cantidad= ?2, fecha_ingreso= ?3, nombre_usuario= ?4 WHERE id= ?5";

		Query query = entityManager.createNativeQuery(update);
		query.setParameter(1, producto.getNombreProducto());
		query.setParameter(2, producto.getCantidad());
		query.setParameter(3, producto.getFechaIngreso());
		query.setParameter(4, producto.getNombreUsuario());
		query.setParameter(5, producto.getId());
		query.executeUpdate();

	}

}
