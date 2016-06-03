package ase.ro.cts.testare;

import java.util.ArrayList;

import ase.ro.cts.proiect.Joc;
import junit.framework.TestCase;

public class TestAdaugaCampioni extends TestCase {
	
	Joc joc;
	ArrayList<String> listaCampioni;
	
	public static final String numeInitial = "Dota";
	public static final int numarActionariInitial = 10;

	public TestAdaugaCampioni(String name) {
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
	
	public void testAdaugareSirLungimeZero(){
		String sirGol = "";
		
		try{
			this.joc.adaugaCampioni(sirGol);
			fail("Lipsa exceptie cand se adauga o denumire de campion cu lungimea 0");   
		}
		catch(Exception e){
			
		}
	}
	public void testAdaugareCampionVid(){
		String denumireCapion = null;
		try{
			this.joc.adaugaCampioni(denumireCapion);
			fail("Lipsa exceptie cand se adauga o denumire vida de campion ");    
		}
		catch(Exception e){
			
		}
	}
	
	public void testAdaigareCampionExistent(){
		String denumireCapionExistent = "Ahri";
		try{
			this.joc.adaugaCampioni(denumireCapionExistent);
			fail("Lipsa exceptie cand se adauga un campion deja existent");    
		}
		catch(Exception e){
			
		}
	}

}
