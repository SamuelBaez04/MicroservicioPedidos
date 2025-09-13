package com.techstore.pedidos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techstore.pedidos.model.Pedido;
import com.techstore.pedidos.repositories.PedidoRepository;

@Service
public class PedidosService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Pedido guardarPedido(Pedido pedido) {
		return pedidoRepository.guardarPedido(pedido);
	}
	
	public Pedido buscarPorId(String id) {
		return pedidoRepository.buscarPorId(id);
	}
	
	public List<Pedido> getPedidos(){
		return pedidoRepository.getPedidos();
	}
	
	public Pedido actualizarPedido(Pedido pedido) {
		return pedidoRepository.actualizar(pedido);
	}
	
	public void eliminarPorId(String id) {
		pedidoRepository.eliminarPorId(id);
	}
	
}
