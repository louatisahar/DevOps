package com.esprit.examen.services;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.esprit.examen.entities.Facture;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.Reglement;
import com.esprit.examen.repositories.CategorieProduitRepository;
import com.esprit.examen.repositories.FactureRepository;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.ReglementRepository;

@ExtendWith(MockitoExtension.class)
class ProduitTest {

	@Mock
	ProduitRepository produitRepository;
	@InjectMocks
	ProduitServiceImpl produitServiceImpl;
	
	//initializer des objet
	Produit produit= new Produit ((long)1,"Prod 1 ","Prod 1 ",(float)3.252,new Date(),new Date(),null,null, null);

	List<Produit> r = new ArrayList<Produit>() {
		
		{
			add(new Produit((long)1,"Prod 1 ","Prod 1 ",(float)3.252,new Date(),new Date(),null,null, null));
			add(new Produit((long)1,"Prod 1 ","Prod 1 ",(float)3.252,new Date(),new Date(),null,null, null));
			add(new Produit((long)1,"Prod 1 ","Prod 1 ",(float)3.252,new Date(),new Date(),null,null, null));
		}
	};
	
	
	@Test
	void retrieveAllReglements() {
		Mockito.doReturn(r).when(produitRepository).findAll();
		List<Produit> prods = produitServiceImpl.retrieveAllProduits();
		Assertions.assertNotNull(prods);
	}

	@Test
	void addReglement() {
		Produit prod=new Produit();
		Mockito.when(produitRepository.save(Mockito.any(Produit.class))).thenReturn(produit);
		Produit produit = produitServiceImpl.addProduit(prod);
		Assertions.assertNotNull(produit);
	}

	@Test
	void retrieveReglement() {
		Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
		Produit prod1=produitServiceImpl.retrieveProduit((long)2);
		Assertions.assertNotNull(prod1);
	}

	@Test
	void retrieveReglementByFacture() {
		Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
		Produit prod1=produitServiceImpl.retrieveProduit((long)2);
		Assertions.assertNotNull(prod1);

	}

	/*@Test
	void getChiffreAffaireEntreDeuxDate() {
		Mockito.doReturn(r).when(reglementRepository).findAll();
		float reg = reglementServiceImpl.getChiffreAffaireEntreDeuxDate(new Date(),new Date());
		Assertions.assertNotNull(reg);
	}*/
}