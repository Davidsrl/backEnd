package co.com.nexos.automotriz.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.nexos.automotriz.model.Usuario;
import co.com.nexos.automotriz.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(value = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class UsuarioRest {

	@Autowired(required = true)
	private UsuarioService usuarioService;

	@GetMapping("/get/all")
	private ResponseEntity<List<Usuario>> getAllUsuario() {
		return ResponseEntity.ok(usuarioService.findAll());

	}

	@PostMapping
	private ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario) {
		try {
			int codigo = usuarioService.getMaxUsuario();
			usuario.setId(codigo);
			usuario.setNombreUsuario(usuario.getNombreUsuario().toLowerCase());
			Usuario usuarioGuardado = usuarioService.save(usuario);
			return ResponseEntity.created(new URI("/usuario/" + usuarioGuardado.getId())).body(usuarioGuardado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
