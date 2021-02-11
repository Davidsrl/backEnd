package co.com.nexos.automotriz.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.nexos.automotriz.model.Producto;
import co.com.nexos.automotriz.service.ProductoService;

@RestController
@RequestMapping("/producto")
@CrossOrigin(value = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class ProductoRest {

	@Autowired(required = true)
	private ProductoService productoService;

	@GetMapping("/get/all")
	private ResponseEntity<List<Producto>> getAllProducto() {
		return ResponseEntity.ok(productoService.findAll());

	}

	@PostMapping
	private ResponseEntity<Producto> saveProducto(@RequestBody Producto producto) {
		try {
			Long codigo = productoService.getMaxProducto();
			producto.setId(codigo);
			producto.setNombreProducto(producto.getNombreProducto().toUpperCase());
			producto.setNombreUsuario(producto.getNombreUsuario().toLowerCase());
			Producto productoGuardado = productoService.save(producto);
			return ResponseEntity.created(new URI("/producto/" + productoGuardado.getId())).body(productoGuardado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@DeleteMapping(value = "delete/{id}")
	private ResponseEntity<Boolean> deletePersona(@PathVariable("id") Long id) {
		Long idLong = new Long(id);
		productoService.deleteById(idLong);
		return ResponseEntity.ok(!(productoService.findById(idLong) != null));

	}

	@PutMapping()
	public ResponseEntity<Producto> updateUser(@RequestBody Producto producto) {
		try {
			Long idLong = new Long(producto.getId());
			producto.setId(idLong);
			producto.setNombreProducto(producto.getNombreProducto().toUpperCase());
			producto.setNombreUsuario(producto.getNombreUsuario().toLowerCase());
			productoService.updateProducto(producto);
			return ResponseEntity.created(new URI("/producto/" + producto.getId())).body(producto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

		}
	}
}
