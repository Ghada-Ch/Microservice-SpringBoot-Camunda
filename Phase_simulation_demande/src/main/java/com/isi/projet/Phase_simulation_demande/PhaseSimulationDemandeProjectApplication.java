package com.isi.projet.Phase_simulation_demande;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PhaseSimulationDemandeProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhaseSimulationDemandeProjectApplication.class, args);
	}
	/*
	@Bean
	CommandLineRunner start(BaremeRepository baremeRepository){
		return args -> {
			baremeRepository.save(new Bareme(null, 1.5F,5,7,950, 2000));
			baremeRepository.save(new Bareme(null,4,3,3,5220, 7000));
			baremeRepository.save(new Bareme(null,2.5F,10,12,120, 400));
			baremeRepository.save(new Bareme(null,0.8F,2,4,500, 1000));
			baremeRepository.save(new Bareme(null,7.0F,1,5,7000, 2500));
			baremeRepository.save(new Bareme(null,7.0F,1,5,7000, 2500));
			baremeRepository.save(new Bareme(null,7.0F,1,5,7000, 2500));


		};
	}*/
}
