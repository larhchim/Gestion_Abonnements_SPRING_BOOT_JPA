package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="idAb")
public class AbonnementFixe extends Abonnement{
	
	private static final long serialVersionUID = 1L;
	
	int debit;

	public AbonnementFixe(String nomAb, Date dateAb, double solde, int debit) {
		super(nomAb, dateAb, solde);
		this.debit = debit;
	}

	public AbonnementFixe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getDebit() {
		return debit;
	}

	public void setDebit(int debit) {
		this.debit = debit;
	}

	@Override
	public String toString() {
		return "AbonnementFixe [debit=" + debit + "]";
	}


	

}
