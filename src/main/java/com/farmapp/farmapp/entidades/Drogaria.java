package com.farmapp.farmapp.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Drogaria implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDrogaria;
	private String razaoSocial;
	
	@OneToMany(mappedBy = "drogaria")
	private List<Medicamento> listMedicamento = new ArrayList<>();
	
	public Drogaria() {
	}

	public Drogaria(Long idDrogaria, String razaoSocial, List<Medicamento> listMedicamento) {
		this.idDrogaria = idDrogaria;
		this.razaoSocial = razaoSocial;
		this.listMedicamento = listMedicamento;
	}

	public Long getIdDrogaria() {
		return idDrogaria;
	}

	public void setIdDrogaria(Long idDrogaria) {
		this.idDrogaria = idDrogaria;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	public void addMedicamento(Medicamento medicamento) {
		listMedicamento.add(medicamento);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDrogaria == null) ? 0 : idDrogaria.hashCode());
		result = prime * result + ((razaoSocial == null) ? 0 : razaoSocial.hashCode());
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
		Drogaria other = (Drogaria) obj;
		if (idDrogaria == null) {
			if (other.idDrogaria != null)
				return false;
		} else if (!idDrogaria.equals(other.idDrogaria))
			return false;
		if (razaoSocial == null) {
			if (other.razaoSocial != null)
				return false;
		} else if (!razaoSocial.equals(other.razaoSocial))
			return false;
		return true;
	}
	
	
	
}
