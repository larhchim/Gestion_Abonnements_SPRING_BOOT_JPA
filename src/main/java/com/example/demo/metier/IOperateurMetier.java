package com.example.demo.metier;

import java.util.List;

import com.example.demo.entities.Abonnement;
import com.example.demo.entities.Client;
import com.example.demo.entities.Factures;

public interface IOperateurMetier {
	
	public void addClient(Client c);
	
	public void addAbonnement(Abonnement ab);
	
	public void addFacture(Factures f);
	
	public Abonnement abonnementInfo(int id);
	
	public List<Client> listeClients(String mc);
	
	public Client clientById(int id);
	
	public List<Abonnement> ls(int id );

}
