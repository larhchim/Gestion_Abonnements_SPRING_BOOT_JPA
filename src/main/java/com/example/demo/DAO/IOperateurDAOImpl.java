package com.example.demo.DAO;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Abonnement;
import com.example.demo.entities.Client;
import com.example.demo.entities.Factures;


@Component
public class IOperateurDAOImpl implements IOperateurDAO{
	
	@Autowired
	EntityManager entity;

	@Override
	@Transactional
	public void addClient(Client c) {
		
		entity.persist(c);
		
	}

	@Override
	@Transactional
	public void addAbonnement(Abonnement ab) {
		
		entity.persist(ab);
		
	}

	@Override
	@Transactional
	public void addFacture(Factures f) {
		
		entity.persist(f);
		
	}

	@Override
	@Transactional
	public Abonnement abonnementInfo(int id) {
		
		Abonnement ab = entity.find(Abonnement.class, id);
		
		return ab;
		
	}

	@Override
	@Transactional
	public List<Client> listeClients(String mc) {
		
		List<Client> climc = new ArrayList<>();
		List<Client> clients =entity.createQuery("FROM Client").getResultList();
		
		for(int i=0;i<clients.size();i++) {
			if(clients.get(i).getNomClient().toLowerCase().contains(mc.toLowerCase())) {
				climc.add(clients.get(i));
			}
		}
		
		return climc;
		
	}

	@Override
	@Transactional
	public Client clientById(int id) {
		Client cl=entity.find(Client.class, id);
		return cl;
	}
	
	
	
	@Override
	@Transactional
	public List<Abonnement> ls(int id) {
		Client cl=clientById(id);
		List<Abonnement> ab = cl.getListeab();
		return ab;
	}
	
	
	

	

}
