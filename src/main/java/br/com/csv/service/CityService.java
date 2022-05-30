package br.com.csv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.csv.model.City;
import br.com.csv.repository.CityRepository;
import br.com.csv.repository.ColumnsRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class CityService {

	private CityRepository cityRepository;

	public CityService(CityRepository cityRepository){
		this.cityRepository = cityRepository;
	}

	private ColumnsRepository columnsRepository;

	String line = null;

	//1 - Importar o arquivo CSV das cidades para a base de dados;
	public String importCsv() {
		try {
			BufferedReader bfrd = new BufferedReader(new FileReader("src/main/resources/cities.csv"));
			line = bfrd.readLine();
			while (line != null) {
				String[] data = line.split(",");
				City c = new City(
						null,
						Long.parseLong(data[1]),
						data[2],
						data[3],
						data[4],
						data[5],
						data[6],
						data[7],
						data[8],
						data[9],
						data[10]
				);

				cityRepository.save(c);
			}
			bfrd.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Arquivo CSV importado com sucesso!";
	}

	//2 - Exibir as cidades que são capitais ordenadas por nome;
	public List<City> capitalCitiesOrderedByName() {
		return cityRepository.capitalCitiesOrderedByName();
	}
	
	//3 - Exibir o nome do estado com a maior e menor quantidade de cidades e a quantidade de cidades;
	public Object stateWithHighestAndLowestNumberOfCities() {
		// TODO Auto-generated method stub
		return cityRepository.stateWithHighestAndLowestNumberOfCities();
	}

	//4 - Exibir a quantidade de cidades por estado;
	public Integer numberOfCitiesByState(String uf) {
		return cityRepository.numberOfCitiesByState(uf);
	}

	//5 - Exibir os dados da cidade informando o id do IBGE;
	public City findCityByIbgeId(Long ibgeId) {
		return cityRepository.findCityByIbgeId(ibgeId);
	}

	//6 - Exibir o nome das cidades de um estado selecionado;
	public List<City> findCityByUf(String uf) {
		return cityRepository.findCityByUf(uf);
	}
	
	//7 - Adicionar uma nova Cidade;
	public City save(City city) {
		if (!isPersist(city)) {
			buildCity(city);
			cityRepository.save(city);
		}
		return city;
	}

	private void buildCity(City city) {
		city.setIbgeId(city.getIbgeId());
		city.setUf(city.getUf());
		city.setName(city.getName());
		city.setCapital(city.getCapital());
		city.setLon(city.getLon());
		city.setLat(city.getLat());
		city.setNoAccents(city.getNoAccents());
		city.setAlternativeNames(city.getAlternativeNames());
		city.setMicroRegion(city.getMicroRegion());
		city.setMacroRegion(city.getMacroRegion());
	}

	private boolean isPersist(City city) {
		if (city.getIbgeId() != null) {
			return true;
		}
		return false;
	}

	//8 - Deletar uma cidade;
	public void deleteCityByIbgeId(Long ibgeId) {
		cityRepository.deleteCityByIbgeId(ibgeId);
	}

	//9 - Selecionar uma coluna e entrar com uma string para filtrar todos os objetos que contenham tal string;
	public List<City> findByColumnAndFilter(String column, String filter) {
		return cityRepository.findByColumnAndFilter(column, filter);
	}
	
	//10 - Exibir a quantidade de registro baseado em uma coluna. Não exibir itens iguais;
	public Integer findByColumn(String column) {
		return cityRepository.findByColumn(column);
	}
	
	//11 - Exibir a quantidade de registros total;
	public Integer totalNumberOfCities() {
		return cityRepository.totalNumberOfCities();
	}
	
	//12 - Dentre todas as cidades, obter as duas cidades mais distantes uma da outra com base na localização (distância em KM em linha reta);

}
