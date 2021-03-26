package com.example.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Abonnement;
import com.example.demo.entities.AbonnementFixe;
import com.example.demo.entities.AbonnementGSM;
import com.example.demo.entities.Client;
import com.example.demo.entities.Factures;
import com.example.demo.metier.IOperateurMetier;

@SpringBootApplication
public class ExamJava2020Application {
	
	@Autowired
	IOperateurMetier operation;

	public static void main(String[] args) {
		SpringApplication.run(ExamJava2020Application.class, args);
	}
	
	@PostConstruct
	public void LoadOneFinished() {
		System.out.println("*****************************hello World***********************************");
		/*Client c = new Client();
		c.setEmailClient("Balouki@gmail.Com");
		c.setNomClient("BALOUKI");
		c.setTelephoneClient("0670138099");
		c.setVilleClient("RABAT");
		operation.addClient(c);*/
		
		/*AbonnementFixe fx = new AbonnementFixe();
		fx.setClient(operation.clientById(4));
		fx.setDateAb(new Date());
		fx.setDebit(2);
		fx.setNomAb("FIXE houria");
		fx.setSolde(1500000.0);
		operation.addAbonnement(fx);
		
		AbonnementGSM gs = new AbonnementGSM();
		gs.setClient(operation.clientById(4));
		gs.setDateAb(new Date());
		gs.setFidelio(44000000);
		gs.setNomAb("GSM houria");
		gs.setSolde(2500000.0);
		operation.addAbonnement(gs);*/
		/*for(int i=9;i<=10;i++) {
			
			Factures f = new Factures();
			f.setAbonnement(operation.abonnementInfo(i));
			f.setDateFacture(new Date());
			f.setMontantFacture(operation.abonnementInfo(i).getSolde());
			f.setRecu(true);
			operation.addFacture(f);
			
		}*/
		
		 //9
       Client cli=operation.clientById(4);
		List<Abonnement> ab =cli.getListeab();
		
		List<AbonnementFixe> fix=new ArrayList<AbonnementFixe>();
		List<Factures> ffix=new ArrayList<Factures>();
		List<AbonnementGSM> gsm=new ArrayList<AbonnementGSM>();
		List<Factures> fgsm=new ArrayList<Factures>();

		
		for (int i = 0; i < ab.size(); i++) {
			
			if(ab.get(i) instanceof  AbonnementFixe) {
				
				fix.add((AbonnementFixe) ab.get(i));
				
			}else {
				
				gsm.add((AbonnementGSM) ab.get(i));

			}
			
		}
		
		System.out.println("******************Abonnements fixe***************");
		System.out.println(fix.toString());
		System.out.println("******************Factures Abonnements fixe***************");

		for (int i=0;i<fix.size();i++) {
			
			System.out.println(fix.get(i).getListeF().toString());
			
		}
		
		
		System.out.println("******************Abonnements gsm***************");

		System.out.println(gsm.toString());

		System.out.println("******************factures Abonnements gsm***************");

		
		for (int i=0;i<gsm.size();i++) {
			
			System.out.println(gsm.get(i).getListeF().toString());
			
		}
		
		
		
		
		
		
		
		
		//System.out.println(cli.getListeab().size());
		
		//System.out.println(operation.ls(1).toString());
			//System.out.println(ab.toString());


		//System.out.println(operation.listeClients("A").toString());
	
		
		//System.out.println(operation.listeClients("r").toString());
		System.out.println("*****************************hello World***********************************");

	}

}
