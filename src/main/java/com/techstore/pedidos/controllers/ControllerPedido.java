package com.techstore.pedidos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.techstore.pedidos.model.Pedido;
import com.techstore.pedidos.services.PedidoService;


@RestController
@RequestMapping("/techstore/pedidos")
@Tag(name = "Microservicio Pedidos de TechStore", description = "Gestion completa de los pedidos de los usuarios")
public class ControllerPedido {

	private final PedidoService pedidoService;
	
	@Autowired
	public ControllerPedido(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}
	
	@PostMapping
	@Operation(summary = "Crear pedido", description = "Registrar un nuevo pedido")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "201", description = "Pedido creado exitosamente"),
			@ApiResponse(responseCode = "400", description = "Datos inválidos en la solicitud") 
			})
	public ResponseEntity<Pedido> guardarPedido(@Parameter (description = "Datos necesarios para crear el pedido") @RequestBody Pedido pedido) {
		Pedido nuevoPedido = pedidoService.guardarPedido(pedido);
		return new ResponseEntity<>(nuevoPedido, HttpStatus.CREATED);
	}
	
	@GetMapping
	@Operation(summary = "Listar pedidos", description = "Obtener todos los pedidos registrados")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista de pedidos obtenida exitosamente") })
	public ResponseEntity<List<Pedido>> obtenerPedidos() {
		List<Pedido> lista = pedidoService.getPedidos();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	

	@GetMapping("/{id}")
	@Operation(summary = "Consulta Pedido por id", description = "Retorna un pedido en especifico, basado en su id.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Pedido encontrado exitosamente"),
			@ApiResponse(responseCode = "404", description = "Pedido con ese id no encontrado")
	})
	public ResponseEntity<Pedido> buscarPorId(@PathVariable @Parameter(description = "Id del pedido") String id){
		Pedido pedido = pedidoService.buscarPorId(id);
		if(pedido != null) {
			return new ResponseEntity<>(pedido, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{id}")
	@Operation (summary = "Actualización de un Pedido", description = "Actualiza completamente el pedido encontrado")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Pedido actualizado correctamente"),
			@ApiResponse(responseCode = "404", description = "Pedido no encontrado")
	})
	public ResponseEntity<Pedido> actualizarPedido(@PathVariable @Parameter(description = "Id del Pedido") String id, 
			@RequestBody @Parameter(description = "datos necesarios para actualizar") Pedido pedido){
		Pedido pedidoExistente = pedidoService.buscarPorId(id);
		if(pedidoExistente != null) {
			pedidoExistente.setId(id);
			Pedido pedidoActualizado = pedidoService.actualizarPedido(pedido);
			return new ResponseEntity<>(pedidoActualizado, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	@Operation (summary = "Eliminar Pedido", description = "Elimina el pedido basado en su id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Pedido eliminado exitosamente"),
			@ApiResponse(responseCode = "404", description = "Pedido no encontrado para su eliminacion")
	})
	public ResponseEntity<Void> eliminarPorId(@PathVariable @Parameter(description = "Id del Pedido") String id){
		Pedido pedidoExistente = pedidoService.buscarPorId(id);
		if(pedidoExistente != null) {
			pedidoService.eliminarPorId(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
