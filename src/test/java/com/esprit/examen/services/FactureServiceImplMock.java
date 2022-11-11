package com.esprit.examen.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.esprit.examen.entities.Facture;
import com.esprit.examen.repositories.FactureRepository;
@ExtendWith(MockitoExtension.class)
public class FactureServiceImplMock {

	@Mock
	FactureRepository factureRepository;
	@InjectMocks
	FactureServiceImpl factureServiceImpl;
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date datefact = dateFormat.parse("30/09/2000");
	//initializer des objet
	Facture facture=new Facture (12.36,10.33,datefact,datefact,false,1);
	List<Facture> f = new ArrayList<Facture>() {
		
		{
			add(new Facture(12.36,10.33,datefact,datefact,false,1));
			add(new Facture(12.36,10.33,datefact,datefact,false,1));
			add(new Facture(12.36,10.33,datefact,datefact,false,1));
		}
	};

	@Test
	List<Facture> retrieveAllFactures(){
		Mockito.doReturn(f).when(factureRepository).findAll();
		List<Facture> fact = factureServiceImpl.retrieveAllFactures();
		Assertions.assertNotNull(fact);
		return f;
	}
	
	@Test
	List<Facture> getFacturesByFournisseur(Long idFournisseur){
		Mockito.doReturn(f).when(factureRepository).findAll();
		Facture fact = (Facture) factureServiceImpl.getFacturesByFournisseur(idFournisseur);
		Assertions.assertNotNull(fact);
		return (List<Facture>) fact;
	}
	
	@Test
	Facture addFacture(Facture f) {
	Facture fact= new Facture();
	Mockito.when(factureRepository.save(Mockito.any(Facture.class))).thenReturn(f);
	Facture facture = factureServiceImpl.addFacture(f);
	Assertions.assertNotNull(facture);
	return fact ;
	}
	
	/*@Test
	void cancelFacture(Long id) {
	//	Mockito.doReturn(id)
		
	}*/
	@Test
	Facture retrieveFacture(Long id) {
		Mockito.doReturn(f).when(factureRepository).findAll();
		Facture fact = factureServiceImpl.retrieveFacture(id);
		Assertions.assertNotNull(fact);
		return fact;
	}
	/*@Test
	void assignOperateurToFacture(Long idOperateur, Long idFacture) {
		Facture f=new Facture();
		Mockito.doReturn(f).when(factureRepository).findAll();
		Mockito.when(factureRepository.save(Mockito.any(Facture.class))).thenReturn(f);
		factureServiceImpl.assignOperateurToFacture(idOperateur,idFacture);
	}*/
	@Test
	float pourcentageRecouvrement(Date startDate, Date endDate) {
		Mockito.doReturn(f).when(factureRepository).findAll();
		return 0 ;
	}


}
