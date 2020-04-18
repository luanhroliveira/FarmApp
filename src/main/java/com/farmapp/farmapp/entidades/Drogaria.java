package com.farmapp.farmapp.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_drogaria")
public class Drogaria implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDrogaria;
	private String razaoSocial;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "drogarias")
	private Set<Medicamento> medicamentos = new HashSet<>();
	
	public Drogaria() {
	}

	public Drogaria(Long idDrogaria, String razaoSocial) {
		this.idDrogaria = idDrogaria;
		this.razaoSocial = razaoSocial;
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
	

	public Set<Medicamento> getMedicamentos() {
		return medicamentos;
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