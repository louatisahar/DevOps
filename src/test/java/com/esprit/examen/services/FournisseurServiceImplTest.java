package com.esprit.examen.services;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.esprit.examen.entities.CategorieFournisseur;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.FournisseurRepository;


@ExtendWith(MockitoExtension.class)

class FournisseurServiceImplTest {

	@Mock
	FournisseurRepository fournisseurRepository;
	@InjectMocks
	FournisseurServiceImpl fournisseurService;
	//on a initialiser un objet sa pour tester avec
	Fournisseur f = new Fournisseur((long)0,"Code 2 ajout","Libelle 2 ajout", CategorieFournisseur.CONVENTIONNE,null,null,null);
	List<Fournisseur> fournisseurInit = new ArrayList<Fournisseur>() {
		{
		add (new Fournisseur((long)3,"Code 3 ajout","Libelle 3 ajout", CategorieFournisseur.ORDINAIRE,null,null,null));
		add (new Fournisseur((long)4,"Code 4 ajout","Libelle 4 ajout", CategorieFournisseur.CONVENTIONNE,null,null,null));
		add (new Fournisseur((long)5,"Code 5 ajout","Libelle 5 ajout", CategorieFournisseur.ORDINAIRE,null,null,null));

		}
	};
	
	
	@Test
	void testRetrieveAllFournisseurs() {

		
		Mockito.doReturn(fournisseurInit).when(fournisseurRepository).findAll();
        List<Fournisseur> fournisseur = fournisseurService.retrieveAllFournisseurs();
		Assertions.assertNotNull(fournisseur);	


		
	}	

	@Test
	void testAddFournisseur() {
		
		Fournisseur f = new Fournisseur();
		Mockito.when(fournisseurRepository.save(Mockito.any(Fournisseur.class))).thenReturn(f);
		Fournisseur fou=fournisseurService.addFournisseur(f);
		Assertions.assertNotNull(fou);	
	}
	
	@Test
	void testDeleteFournisseur() {

		fournisseurService.deleteFournisseur((long)2);
		Mockito.verify(fournisseurRepository).deleteById((long)2);

		
	}
	

	/*@Test
	void testUpdateFournisseur() {
		
		
		Mockito.when(fournisseurRepository.save(Mockito.any(Fournisseur.class))).thenReturn(f);
		f.setLibelle("Libelle 3 updated");
		Fournisseur fou=fournisseurService.updateFournisseur(f);
		assertNotNull(fou);
		assertEquals("Libelle 3 updated", f.getLibelle());

	}*/

	@Test
	void testRetrieveFournisseur() {
		
		Mockito.when(fournisseurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(f));
		Fournisseur saa = fournisseurService.retrieveFournisseur((long)2);
		Assertions.assertNotNull(saa);	
		}

}


/*
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

	
	@Test
	 public void testRetrieveFournisseur() {
		 	assertNotNull(fournisseurService.retrieveFournisseur((long) 1));
	        assertNotNull(fournisseurService,"c'est bon - le fournisseur num 1 est affiche");

	    }
	
}
*/