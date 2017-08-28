package com.metacube.main;

import com.metacube.facade.CounselingFacade;
/**
 * The main class responsible for calling start counseling
 * @author Udit Saxena
 *
 */
public class Main {

	public static void main(String[] args) {
		CounselingFacade councelingFacade = CounselingFacade.getInstance();
		councelingFacade.startCounseling();
	}
}
