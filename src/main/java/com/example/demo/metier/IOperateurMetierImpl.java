package com.example.demo.metier;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.IOperateurDAO;
import com.example.demo.entities.Abonnement;
import com.example.demo.entities.Client;
import com.example.demo.entities.Factures;


@Service
public class IOperateurMetierImpl implements IOperateurMetier{
	
	@Autowired
	IOperateurDAO opera;

	
	

	public void setOpera(IOperateurDAO opera) {
		this.opera = opera;
	}
	

	@Override
	public void addClient(Client c) {
		
		opera.addClient(c);

		
	}

	@Override
	public void addAbonnement(Abonnement ab) {
		
		opera.addAbonnement(ab);
		
	}

	@Override
	public void addFacture(Factures f) {
		
		opera.addFacture(f);
		
	}

	@Override
	public Abonnement abonnementInfo(int id) {

		return opera.abonnementInfo(id);
		
	}

	@Override
	public List<Client> listeClients(String mc) {
		
		return opera.listeClients(mc);
		
	}

	@Override
	public Client clientById(int id) {
		
		return opera.clientById(id);
		
	}

	@Override
	public List<Abonnement> ls(int id) {
		
		return opera.ls(id);
		
	}

}
