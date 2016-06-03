package ase.ro.cts.testare;

import Builder.BuilderMeci;
import Exceptii.ExceptieValoareSubMinim;
import ase.ro.cts.proiect.Meci;
import junit.framework.TestCase;

public class TestSetDurata extends TestCase {

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
	
	public TestSetDurata(String name) {
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
	
	public void testValoareMaiMica(){
		int valoareMaiMica = 18;
		try{
			this.meci.setDurata(valoareMaiMica);;
			fail("Lipsa exceptie cand durata meciului este mai mica decat 20 minute");   
		}
		catch(Exception e){
			
		}
	}
	
	public void testValoareEgalaCuMinim() throws ExceptieValoareSubMinim{
		int valoareAsteptata = 20;
		int minimPermis = 20;
		this.meci.setDurata(minimPermis);
		assertEquals("Test rezultat cand se da o valoare egala cu minimul permis",
				valoareAsteptata, this.meci.getDurata());
	}
	
	public void testValoarePesteMinim() throws ExceptieValoareSubMinim{
		int valoareAsteptata = 34;
		int nouaValoare = 34;
		this.meci.setDurata(nouaValoare);
		assertEquals("Test rezultat cand se da o valoare egala cu minimul permis",
				valoareAsteptata, this.meci.getDurata());
	}

}
