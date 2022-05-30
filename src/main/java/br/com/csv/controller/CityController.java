package br.com.csv.controller;

import br.com.csv.model.City;
import br.com.csv.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/cities")
public class CityController {

	private CityService cityService;

	public CityController(CityService cityService){
		this.cityService = cityService;
	}

	@PostMapping("/csv-import")
	public ResponseEntity<Void> importCsv() {
		cityService.importCsv();
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping("/capitals-ordered-by-name")
	public ResponseEntity<?> capitalCitiesOrderedByName() {
		try {
			return ResponseEntity.ok(cityService.capitalCitiesOrderedByName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@GetMapping("/state-with-highest-and-lowest-number-of-cities")
	public ResponseEntity<?> stateWithHighestAndLowestNumberOfCities() {
		try {
			return ResponseEntity.ok(cityService.stateWithHighestAndLowestNumberOfCities());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@GetMapping("/number-of-cities-by-state/{uf}")
	public ResponseEntity<?> numberOfCitiesByState(@PathVariable String uf) {
		try {
			return ResponseEntity.ok(cityService.numberOfCitiesByState(uf));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@GetMapping("/city-by-id-ibge/{idIbge}")
	public ResponseEntity<?> findCityByIbgeId(@PathVariable Long ibgeId) {
		try {
			return ResponseEntity.ok(cityService.findCityByIbgeId(ibgeId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@GetMapping("/cities-by-state/{uf}")
	public ResponseEntity<?> findCityByUf(@PathVariable String uf) {
		try {
			return ResponseEntity.ok(cityService.findCityByUf(uf));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@GetMapping("/find-by-filter/{column}/{filter}")
	public ResponseEntity<?> findByColumnAndFilter(@PathVariable String column, String filter) {
		try {
			return ResponseEntity.ok(cityService.findByColumnAndFilter(column, filter));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@GetMapping("/find-by-column/{column}")
	public ResponseEntity<?> findByColumn(@PathVariable String column) {
		try {
			return ResponseEntity.ok(cityService.findByColumn(column));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@GetMapping("/total-number-of-cities")
	public ResponseEntity<?> totalNumberOfCities() {
		try {
			return ResponseEntity.ok(cityService.totalNumberOfCities());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@PostMapping("/add-city")
	public ResponseEntity<City> save(@RequestBody City city) throws Exception{
		try {
			return new ResponseEntity<City>(cityService.save(city), HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	

	@PutMapping("/delete-city/{ibgeId}")
	public ResponseEntity<?> deleteCityByIbgeId(@PathVariable(value = "ibge_id") Long ibgeId) {
		try {
			cityService.deleteCityByIbgeId(ibgeId);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	// metodo para transformar o objeto em json
	//	@RequestMapping()
	//	public ResponseEntity<?> getModel() {
	//		City cityToJson = new City();
	//		return ResponseEntity.ok(cityToJson);
	//	}

}
