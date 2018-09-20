package com.example.demo.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.domain.Pedido;
import com.example.demo.services.PedidoService;

/* rest controller anotação para o rest precisa ser importada
*estamos criando uma classe que vai ser um controlado rest
* que vai responde ao endpoint categorias.
*/
@RestController
@RequestMapping(value ="/pedidos")
public class PedidoResource {
	/*
	 * requestmapping verbo http para uma requisição basica get. agora o metodo
	 * vai se chama find e vai ter 2 endpoint /categorias/id ResponseEntity
	 * encapsular requisicoes automaticamente para o serviço rest
	 * 
	 * @Autowired instacia automaticamente
	 */
	@Autowired
	private PedidoService service;

	@RequestMapping(value ="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pedido> find(@PathVariable Integer id) {

		Pedido obj = service.busca(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	/*
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Pedido obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<Pedido>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="instante") String orderBy, 
			@RequestParam(value="direction", defaultValue="DESC") String direction) {
		Page<Pedido> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}*/
}
