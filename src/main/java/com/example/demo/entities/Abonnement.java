package com.example.demo.entities;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Abonnement implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAb;
	
	private String nomAb;
	private Date dateAb;
	private double solde;
	
	@ManyToOne
	@JoinColumn(name="ID_Client")
	Client client;

	@OneToMany(mappedBy="abonnement",fetch=FetchType.EAGER)
	List<Factures> listeF = new ArrayList<>();

	public Abonnement(String nomAb, Date dateAb, double solde) {
		super();
		this.nomAb = nomAb;
		this.dateAb = dateAb;
		this.solde = solde;
	}

	public Abonnement() {
		super();

	}

	public int getIdAb() {
		return idAb;
	}

	public void setIdAb(int idAb) {
		this.idAb = idAb;
	}

	public String getNomAb() {
		return nomAb;
	}

	public void setNomAb(String nomAb) {
		this.nomAb = nomAb;
	}

	public Date getDateAb() {
		return dateAb;
	}

	public void setDateAb(Date dateAb) {
		this.dateAb = dateAb;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Factures> getListeF() {
		return listeF;
	}

	public void setListeF(List<Factures> listeF) {
		this.listeF = listeF;
	}

	@Override
	public String toString() {
		return "Abonnement [nomAb=" + nomAb + ", dateAb=" + dateAb + ", solde=" + solde + "]\n";
	}
	
	
	
	
	
	
	
	
	

}
