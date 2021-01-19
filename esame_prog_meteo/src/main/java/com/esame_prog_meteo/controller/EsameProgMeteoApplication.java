/**
 * Package che contiene le classi necessarie all'esecuzione dell'applicazione e alle REST delle chiamate
 */
package com.esame_prog_meteo.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe che permette l'avviamento e l'esecuzione dell'applicazione tramite il
 * framework SpringBoot
 * 
 * @author Joshua Ciccolini
 * @author Michele Di Renzo
 */
@SpringBootApplication
public class EsameProgMeteoApplication {
	/**
	 * Metodo di BootStrap dell'applicazione
	 * 
	 * @param args Eventuali parametri da passare al metodo di BootStrap
	 */
	public static void main(String[] args) {
		SpringApplication.run(EsameProgMeteoApplication.class, args);
	}

}

