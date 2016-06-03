package ase.ro.cts.testare;

import java.util.ArrayList;

import Exceptii.ExceptieStergereCampionCareNuExista;
import Exceptii.ExceptieStergereCampionNull;
import ase.ro.cts.proiect.Joc;
import junit.framework.TestCase;

public class TestStergeCampion extends TestCase {

	Joc joc;
	ArrayList<String> listaCampioni;
	
	public static final String numeInitial = "Dota";
	public static final int numarActionariInitial = 10;
	
	public TestStergeCampion(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		listaCampioni = new ArrayList<String>();
		listaCampioni.add("Zed");
		listaCampioni.add("Caitlyn");
		listaCampioni.add("Ahri");
		listaCampioni.add("Tresh");
		listaCampioni.add("Kindred");
		this.joc = Joc.creareJoc(numeInitial,numarActionariInitial,listaCampioni);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		this.joc = null;
	}

	public void testValoriNormale() throws ExceptieStergereCampionCareNuExista,
	ExceptieStergereCampionNull{
		String valoareDeSters = "Tresh";
		ArrayList<String> listaAsteptata = new ArrayList<String>();
		listaAsteptata.add("Zed");
		listaAsteptata.add("Caitlyn");
		listaAsteptata.add("Ahri");
		listaAsteptata.add("Kindred");
		assertEquals(
				"Test rezultat pentru valori normale",
				listaAsteptata,joc.stergeCampion(valoareDeSters));
	}
	
	public void testStergereElementInexistent(){
		String campionInexistent = "Syndra";
		try{
			this.joc.stergeCampion(campionInexistent);
			fail("Lipsa exceptie cand se doreste stergerea unui campion inexistent in lista");   
		}
		catch(Exception e){
			
		}
	}
	public void testStergereElementNull(){
		String campionVid = null;
		try{
			this.joc.stergeCampion(campionVid);
			fail("Lipsa exceptie cand se doreste stergerea unui campion vid");   
		}
		catch(Exception e){
			
		}
	}
}
