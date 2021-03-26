package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Factures implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFacture;
	
	private Date dateFacture;
	private double montantFacture;
	private boolean recu;
	
	@ManyToOne
	@JoinColumn(name="ID_Abonnement")
	private Abonnement abonnement;

	public Factures(Date dateFacture, double montantFacture, boolean recu, Abonnement abonnement) {
		super();
		this.dateFacture = dateFacture;
		this.montantFacture = montantFacture;
		this.recu = recu;
		this.abonnement = abonnement;
	}

	public Factures() {
		super();
	}

	public int getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(int idFacture) {
		this.idFacture = idFacture;
	}

	public Date getDateFacture() {
		return dateFacture;
	}

	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}

	public double getMontantFacture() {
		return montantFacture;
	}

	public void setMontantFacture(double montantFacture) {
		this.montantFacture = montantFacture;
	}

	public boolean isRecu() {
		return recu;
	}

	public void setRecu(boolean recu) {
		this.recu = recu;
	}

	public Abonnement getAbonnement() {
		return abonnement;
	}

	public void setAbonnement(Abonnement abonnement) {
		this.abonnement = abonnement;
	}

	@Override
	public String toString() {
		return "Factures [dateFacture=" + dateFacture + ", montantFacture=" + montantFacture + ", recu=" + recu
				+ ", abonnement=" + abonnement + "]";
	}
	
	
	
	
	
	

}
