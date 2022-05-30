package br.com.csv;

import br.com.csv.controller.CityController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class CsvServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsvServiceApplication.class, args);
	}

	@Autowired
	private CityController cityController;

	@EventListener(ApplicationReadyEvent.class)
	public void importCsv() {
		cityController.importCsv();
	}
}

