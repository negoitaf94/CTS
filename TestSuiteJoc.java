package ase.ro.cts.testare;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestSuiteJoc extends TestCase {

		public static Test suite(){
			
			TestSuite testSuite = new TestSuite();
			testSuite.addTest(new TestSetDurata("testValoareMaiMica"));
			testSuite.addTestSuite(TestSetNrKills.class);
			testSuite.addTestSuite(TestSetNrMinioni.class);
			
			return testSuite;
			
		}

	}


