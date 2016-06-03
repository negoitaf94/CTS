package ase.ro.cts.testare;

import Builder.BuilderMeci;
import Exceptii.ExceptieKilluriValoriNegative;
import Exceptii.ExceptieValoareSubMinim;
import ase.ro.cts.proiect.Meci;
import junit.framework.TestCase;

public class TestSetNrKills extends TestCase {

	BuilderMeci builderMeci; 
	Meci meci;
	
	public static final String numeInitial = "Flory";
	public static final String campionInitial = "Ahri";
	public static final String tipRealizare = "vitorie";
	public static final String tipMeci = "Ranked";
	public static final int nrKills = 14;
	public static final int nrDeath = 4;
	public static final int nrAsist = 10;
	public static final int durataMeci = 52;
	public static final int nrMinioni = 179;
	public static final int valoareRealizare = 86;
	
	public TestSetNrKills(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		this.builderMeci = new BuilderMeci(campionInitial, numeInitial, tipRealizare);
		this.meci = builderMeci.setNrKillsBuilder(nrKills).
				setNrDeathBuilder(nrDeath).setNrAssistBuilder(nrAsist).
				setNrMinioniBuilder(nrMinioni).setDurataBuilder(durataMeci).
				setRealizareBuilder(valoareRealizare).setTipMeciBuilder(tipMeci).build();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		this.meci = null;
		this.builderMeci =  null;
	}
	
	public void testValoariNegative(){
		int valoareNegativa = -4;
		try{
			this.meci.setNrKills(valoareNegativa);;
			fail("Lipsa exceptie cand valoarea pentru numarul de kill-uri este negativa");   
		}
		catch(Exception e){
			
		}
	}
	
	public void testValoariNormale() throws ExceptieValoareSubMinim, ExceptieKilluriValoriNegative{
		int valoareAsteptata = 17;
		this.meci.setNrKills(valoareAsteptata);
		assertEquals("Test rezultat cand se da o valoare normala",
				valoareAsteptata, this.meci.getNrKills());
	}
   
}
