package com.curso.endpoint;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.endpoint.dto.PedidoDTO;
import com.curso.modelo.entidad.Pedido;
import com.curso.modelo.negocio.GestorPedidos;
import com.curso.modelo.persistencia.PedidoRepositorio;

@RestController
@RequestMapping("/pedidos")
public class PedidosRest {

	@Autowired private PedidoRepositorio pedidoRepo;
	@Autowired private GestorPedidos gestorPedidos;
	
	@PostMapping
	public ResponseEntity<PedidoDTO> insertar(@RequestBody() PedidoDTO pedidoDto) {
		Pedido pedidoInsertado = gestorPedidos.altaPedido(pedidoDto.asPedido());
		return new ResponseEntity<>(new PedidoDTO(pedidoInsertado), HttpStatus.CREATED);		
	}

	@GetMapping
	public List<PedidoDTO> listar() {
		return pedidoRepo.findAll().stream().map(p -> new PedidoDTO(p)).collect(Collectors.toList());
	}
	
	@GetMapping(path="/{id}",
				produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<PedidoDTO> buscar(@PathVariable("id") Integer id) {
		System.out.println("idPedido:"+id);
		return pedidoRepo
				.buscarPedidosConDetalles(id)
				.map(p -> {
					System.out.println(p.getDetalles());
					return new ResponseEntity<PedidoDTO>(new PedidoDTO(p), HttpStatus.OK);
				})				
				.orElse(new ResponseEntity<PedidoDTO>(HttpStatus.NOT_FOUND));
	}
	
}
