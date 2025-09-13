package com.techstore.pedidos.model;

public class Pedido {

	private String nombreProducto;
	private int cantidadProducto;
	private String descripcion;
	private String id;
	private double total;
	private String nombreCliente;
	
	
	public Pedido() {

	}
	
	public Pedido(String nombreProducto, int cantidadProducto, String descripcion, String id, double total, String nombreCliente) {
		this.nombreProducto = nombreProducto;
		this.cantidadProducto = cantidadProducto;
		this.descripcion = descripcion;
		this.id = id;
		this.total = total;
		this.nombreCliente = nombreCliente;
	}
	
	public String getNombreProducto() {
		return nombreProducto;
	}
	
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	
	public int getCantidadProducto() {
		return cantidadProducto;
	}
	
	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNombreCliente() {
		return nombreCliente;
	}
	
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	
	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}

}
