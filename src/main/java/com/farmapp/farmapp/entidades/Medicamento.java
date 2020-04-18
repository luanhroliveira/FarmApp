package com.farmapp.farmapp.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_medicamento")
public class Medicamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMedicamento;

	private String nome;
	private String descricao;
	private Double preco;
	
	@ManyToMany
	@JoinTable(name = "tb_medicamento_drogaria", joinColumns = @JoinColumn(name = "medicamento_id"), inverseJoinColumns = @JoinColumn(name = "drogaria_id"))
	private Set<Drogaria> drogarias = new HashSet<>();

	@OneToMany(mappedBy = "id.medicamento")
	private Set<PedidoItem> itens = new HashSet<>();
	
	public Medicamento() {
	}

	public Medicamento(Long idMedicamento, String nome, String descricao, Double preco) {
		this.idMedicamento = idMedicamento;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

	public Long getIdMedicamento() {
		return idMedicamento;
	}

	public void setIdMedicamento(Long idMedicamento) {
		this.idMedicamento = idMedicamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Set<Drogaria> getDrogarias() {
		return drogarias;
	}

	@JsonIgnore
	public Set<Pedido> getPedidos(){
		Set<Pedido> set = new HashSet<>();
		for (PedidoItem x : itens) {
			set.add(x.getPedido());
		}
		return set;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMedicamento == null) ? 0 : idMedicamento.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Medicamento other = (Medicamento) obj;
		if (idMedicamento == null) {
			if (other.idMedicamento != null)
				return false;
		} else if (!idMedicamento.equals(other.idMedicamento))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}