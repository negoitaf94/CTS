package ase.ro.cts.testare;

import java.util.ArrayList;

import ase.ro.cts.proiect.Utilizator;
import junit.framework.TestCase;

public class TestGetPozitieMain extends TestCase {

	Utilizator utilizator;
	ArrayList<Integer> listaRealizari;
	
	public static final String numeInitial = "Flory";
	public static  String pozitieMainInitial = "adc";
	public static final String tipUtilizatorInitial = "premium";
	
	public TestGetPozitieMain(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		listaRealizari = new ArrayList<Integer>();
		listaRealizari.add(54);
		listaRealizari.add(64);
		listaRealizari.add(20);
		listaRealizari.add(96);
		listaRealizari.add(98);
		listaRealizari.add(102);
		listaRealizari.add(52);
		listaRealizari.add(80);
		utilizator = new Utilizator(numeInitial,
				listaRealizari, pozitieMainInitial, tipUtilizatorInitial );
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		this.utilizator = null;
	}

	public void testGetPozitieMain() {
		String valoareAsteptata="mid";
		
		utilizator.setPozitieMain(valoareAsteptata);
		
		assertEquals("Verificare getPozitieMain",valoareAsteptata,utilizator.getPozitieMain());
	}

}
