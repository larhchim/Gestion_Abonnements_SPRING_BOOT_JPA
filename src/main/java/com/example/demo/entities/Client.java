package com.example.demo.entities;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idClient;
	
	private String nomClient;
	private String emailClient;
	private String telephoneClient;
	private String villeClient;
	
	@OneToMany(mappedBy="client",fetch=FetchType.EAGER)
	private List<Abonnement> list ;

	public Client(String nomClient, String emailClient, String telephoneClient, String villeClient) {
		super();
		this.nomClient = nomClient;
		this.emailClient = emailClient;
		this.telephoneClient = telephoneClient;
		this.villeClient = villeClient;
	}

	public Client() {
		super();
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getEmailClient() {
		return emailClient;
	}

	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}

	public String getTelephoneClient() {
		return telephoneClient;
	}

	public void setTelephoneClient(String telephoneClient) {
		this.telephoneClient = telephoneClient;
	}

	public String getVilleClient() {
		return villeClient;
	}

	public void setVilleClient(String villeClient) {
		this.villeClient = villeClient;
	}

	public List<Abonnement> getListeab() {
	
		return list;
	}

	public void setListeab(List<Abonnement> listeab) {
		this.list = listeab;
	}

	@Override
	public String toString() {
		return "Client [nomClient=" + nomClient + ", emailClient=" + emailClient + ", telephoneClient="
				+ telephoneClient + ", villeClient=" + villeClient +"]\n";
	}
	
	
	
	
	
	

}
