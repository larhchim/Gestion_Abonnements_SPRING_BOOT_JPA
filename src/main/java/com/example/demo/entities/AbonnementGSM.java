package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="idAb")
public class AbonnementGSM extends Abonnement {

	private static final long serialVersionUID = 1L;
	
	
	int fidelio;


	public AbonnementGSM(String nomAb, Date dateAb, double solde, int fidelio) {
		super(nomAb, dateAb, solde);
		this.fidelio = fidelio;
	}

	

	public AbonnementGSM() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getFidelio() {
		return fidelio;
	}


	public void setFidelio(int fidelio) {
		this.fidelio = fidelio;
	}



	@Override
	public String toString() {
		return "AbonnementGSM [fidelio=" + fidelio + "]";
	}



	
	
	

}
