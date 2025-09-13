package com.techstore.pedidos.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.techstore.pedidos.model.Pedido;

@Repository
public class PedidoRepository {

	private final List<Pedido> baseDeDatos = new ArrayList<>();
	
	public Pedido guardarPedido(Pedido pedido) {
		baseDeDatos.add(pedido);
		return pedido;
	}
	
	public Pedido buscarPorId(String id) {
		for (Pedido pedido : baseDeDatos) {
			if(pedido.getId().equals(id)) {
				return pedido;
			}
		}
		return null;
	}
	
	public List<Pedido> getPedidos(){
		return new ArrayList<>(baseDeDatos);
	}
	
	public Pedido actualizar(Pedido pedido) {
		for(int i = 0; i < baseDeDatos.size(); i++) {
			if(baseDeDatos.get(i).getId().equals(pedido.getId())) {
				baseDeDatos.set(i, pedido);
				return pedido;
			}
		}
		return null;
	}
	
	public void eliminarPorId(String id) {
		for(int i = 0; i < baseDeDatos.size(); i++) {
			if(baseDeDatos.get(i).getId().equals(id)) {
				baseDeDatos.remove(i);
				return;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
}
