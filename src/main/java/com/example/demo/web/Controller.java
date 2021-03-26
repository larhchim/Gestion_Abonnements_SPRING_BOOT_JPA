package com.example.demo.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Abonnement;
import com.example.demo.entities.AbonnementFixe;
import com.example.demo.entities.AbonnementGSM;
import com.example.demo.entities.Client;
import com.example.demo.entities.Factures;
import com.example.demo.metier.IOperateurMetier;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	IOperateurMetier op;
	

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String requestMethodName(HttpServletRequest req,Model mode,String enrg) {

		mode.addAttribute("p",new Client());
		
		mode.addAttribute("Abfixe",new ArrayList<AbonnementFixe>());
		
		mode.addAttribute("Abgsm", new ArrayList<AbonnementGSM>());
		
		mode.addAttribute("lsab", new ArrayList<Abonnement>());
		
		mode.addAttribute("factf",new ArrayList<Factures>());
		
		mode.addAttribute("factg",new ArrayList<Factures>());
		
		mode.addAttribute("isactive","nonact");


	
		return "index";
	}
	
	
	@RequestMapping(value = "calcul", method = RequestMethod.POST)
	public String requestMethodName(String enrg,Model mode) {
		
	
		
				try {
					
					Client liste = op.clientById(Integer.valueOf(enrg)) ;
					
					
					System.out.println(liste.toString());
					mode.addAttribute("p",liste);
					
					
					List<Abonnement> ab =liste.getListeab();
					
					List<AbonnementFixe> fix=new ArrayList<AbonnementFixe>();
					List<AbonnementGSM> gsm=new ArrayList<AbonnementGSM>();
					


					
					for (int i = 0; i < ab.size(); i++) {
						
						if(ab.get(i) instanceof  AbonnementFixe) {
							
							fix.add((AbonnementFixe) ab.get(i));
						
							
						}else {
							
							gsm.add((AbonnementGSM) ab.get(i));


						}
						
					}
					List<Factures> factfix =  new ArrayList<Factures>();
					List<Factures> factgsm = new ArrayList<Factures>();
					
					for (int i=0;i<fix.size();i++) {
	
		               for(int j=0;j<fix.get(i).getListeF().size();j++) {
		            	   
		            	   factfix.add(fix.get(i).getListeF().get(j));
		            	   
		               }
						
					}

					for (int i=0;i<gsm.size();i++) {
						
						for(int j=0;j<gsm.get(i).getListeF().size();j++) {
							
							factgsm.add(gsm.get(i).getListeF().get(j));
							
						}
						
					}

					
					
					mode.addAttribute("lsab", ab);
					
					mode.addAttribute("Abfixe",fix);
					
					mode.addAttribute("Abgsm", gsm);
					
					mode.addAttribute("factf",factfix);
					
					mode.addAttribute("factg",factgsm);
					
					
					mode.addAttribute("isactive","act");

					
					
					/*System.out.println("******************Abonnements fixe***************");
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
						
					}*/
					
					
				}catch(Exception e) {
					
					mode.addAttribute("isactive","nonact");
					mode.addAttribute("p",new Client());
					mode.addAttribute("Abfixe",new ArrayList<AbonnementFixe>());
					mode.addAttribute("Abgsm", new ArrayList<AbonnementGSM>());
					mode.addAttribute("lsab", new ArrayList<Abonnement>());
					mode.addAttribute("factf",new ArrayList<Factures>());
					mode.addAttribute("factg",new ArrayList<Factures>());
					e.printStackTrace();
					mode.addAttribute("error","Invalid Number Try again");
					return "index";

					
				}
			
		

						
		return "index";
	}




}
	
