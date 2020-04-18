package com.farmapp.farmapp.entidades;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.farmapp.farmapp.entidades.pk.PedidoItemPK;

@Entity
@Table(name = "tb_pedido_item")
public class PedidoItem implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PedidoItemPK id;
	
	private Integer quantidade;
	private Double preco;
	
	public PedidoItem() {
	}

	public PedidoItem(Pedido pedido, Medicamento medicamento, Integer quantidade, Double preco) {
		super();
		id.setPedido(pedido);
		id.setMedicamento(medicamento);
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}
	
	public Medicamento getMedicamento(){
		return id.getMedicamento();
	}

	public void setMedicamento(Medicamento medicamento) {
		id.setMedicamento(medicamento);;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoItem other = (PedidoItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
