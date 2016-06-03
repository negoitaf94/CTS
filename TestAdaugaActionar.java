package ase.ro.cts.testare;

import java.util.ArrayList;

import Exceptii.ExceptieLipsaActionari;
import ase.ro.cts.proiect.Joc;
import junit.framework.TestCase;

public class TestAdaugaActionar extends TestCase {

	Joc joc;
	ArrayList<String> listaCampioni;
	
	public static final String numeInitial = "Dota";
	public static final int numarActionariInitial = 10;
	
	public TestAdaugaActionar(String name) {
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
	
	public void testNumarActionariValoriNormale() throws ExceptieLipsaActionari{
		
			int valoareActuala = this.joc.getNrActionari();
			int nrActionariValoareAsteptata =  valoareActuala + 1;
			assertEquals(
					"Test intrementare numar actionari",
					nrActionariValoareAsteptata,this.joc.adaugaActionar());
	
	}
	
	public void testNumarMinimActionari(){
		this.joc.setNrActionari(0);
		try{
			this.joc.adaugaActionar();
			fail("Lipsa exceptie cand incrementarea returneaza 1");    //inseamna ca initial jocul nu avea niciun actionar
		}
		catch(Exception e){
			
		}
	}
	
	
	
	

}
