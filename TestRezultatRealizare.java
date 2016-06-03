package ase.ro.cts.testare;

import Builder.BuilderMeci;
import Exceptii.ExceptieKilluriValoriNegative;
import Exceptii.ExceptieRezultatRealizareNegativ;
import Exceptii.ExceptieValoareNegativaInRealizare;
import ase.ro.cts.proiect.Meci;
import junit.framework.TestCase;

public class TestRezultatRealizare extends TestCase {

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
	
	public TestRezultatRealizare(String name) {
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

	public void testRezultatRealizareNegativ() throws ExceptieKilluriValoriNegative{
		this.meci.setNrKills(3);
		meci.setNrDeath(13);
		meci.setNrAssist(7);
		try{
			this.meci.rezultatRealizare();
			fail("Lipsa exceptie cand se returneaza o valoare a realizarii negativa");   
		}
		catch(Exception e){
			
		}
	}
	
	public void testValoareNegativa() throws ExceptieKilluriValoriNegative{
		this.meci.setNrKills(3);
		meci.setNrDeath(-13);
		meci.setNrAssist(7);
		try{
			this.meci.rezultatRealizare();
			fail("Lipsa exceptie cand una dintre valori(nrKills, NrDeath, NrAssist este negativa");   
		}
		catch(Exception e){
			
		}
	}
	
	public void testRetunrareZero() throws ExceptieRezultatRealizareNegativ,
	ExceptieValoareNegativaInRealizare, ExceptieKilluriValoriNegative{
		int valoareAsteptata = 0;
		this.meci.setNrKills(0);
		meci.setNrDeath(0);
		meci.setNrAssist(0);
		assertEquals(
				"Test rezultat 0 cand toate valorile sunt 0",
				valoareAsteptata,this.meci.rezultatRealizare());
	}
}
