package com.esprit.examen.services;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.CategorieFournisseur;
import com.esprit.examen.entities.Fournisseur;



@RunWith(SpringRunner.class)
@SpringBootTest
class FournisseurServiceImplTest {
	@Autowired
	IFournisseurService fournisseurService;

	@Test
	public void testAddFournisseur() {
	//	List<Fournisseur> fournisseur = fournisseurService.retrieveAllFournisseurs();
	//	int expected=fournisseur.size();
		
		List<Fournisseur> ftest = fournisseurService.retrieveAllFournisseurs();
		Fournisseur f = new Fournisseur((long)16,"Code 2 ajout","Libelle 2 ajout", CategorieFournisseur.CONVENTIONNE,null,null,null);
		Fournisseur savedFournisseur= fournisseurService.addFournisseur(f);
		
		assertNotNull(savedFournisseur.getIdFournisseur());
		assertNotNull(savedFournisseur.getCode());
		assertNotNull(savedFournisseur.getLibelle());
		fournisseurService.deleteFournisseur(savedFournisseur.getIdFournisseur());
		
		
	} 
	
	 @Test
	    public void testRetrieveAllFournisseurs() {
	        assertNotNull(fournisseurService.retrieveAllFournisseurs());
	        assertNotNull(fournisseurService,"c'est bon - les fournisseurs sont affiches");
	    }
	
	
/*	@Test
	public void testDeleteFournisseur() {
		Fournisseur f = new Fournisseur((long) 2,"Code 2 test","Libelle 2 test", CategorieFournisseur.CONVENTIONNE,null,null,null);
		Fournisseur savedFournisseur= fournisseurService.addFournisseur(f);
		fournisseurService.deleteFournisseur(savedFournisseur.getIdFournisseur());
		assertNull(fournisseurService.retrieveFournisseur(savedFournisseur.getIdFournisseur()));
	}
*/
	
	@Test
	 public void testRetrieveFournisseur() {
		 	assertNotNull(fournisseurService.retrieveFournisseur((long) 1));
	        assertNotNull(fournisseurService,"c'est bon - le fournisseur num 1 est affiche");

	    }
	
}
