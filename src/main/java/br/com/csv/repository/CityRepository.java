package br.com.csv.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.csv.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

	// 2 - Exibir as cidades que são capitais ordenadas por nome;
	@Query(nativeQuery = true, value = "SELECT name FROM tb_cities WHERE capital = 'TRUE' ORDER BY name")
	List<City> capitalCitiesOrderedByName();
	
	//3 - Exibir o nome do estado com a maior e menor quantidade de cidades e a quantidade de cidades;
	@Query(nativeQuery = true, value = "SELECT MIN(uf), MAX(uf) FROM tb_cities WHERE uf = '?'")
	Integer stateWithHighestAndLowestNumberOfCities();

	// 4 - Exibir a quantidade de cidades por estado;
	@Query(nativeQuery = true, value = "SELECT COUNT(uf) FROM tb_cities WHERE uf = '?'")
	Integer numberOfCitiesByState(String uf);

	// 5 - Exibir os dados da cidade informando o id do IBGE;
	@Query(nativeQuery = true, value = "SELECT * FROM tb_cities WHERE ibge_id = ?")
	City findCityByIbgeId(Long ibgeId);

	// 6 - Exibir o nome das cidades de um estado selecionado;
	@Query(nativeQuery = true, value = "SELECT no_accents FROM tb_cities WHERE uf = ?")
	List<City> findCityByUf(String uf);

	// 7 - Adicionar uma nova Cidade;
	City save(City city);

	//8 - Deletar uma cidade informando o id do IBGE;
	@Query(nativeQuery = true, value = "DELETE FROM cities WHERE ibge_id = ?")
	City deleteCityByIbgeId(Long ibgeId);

	// 9 - Selecionar uma coluna e entrar com uma string para filtrar todos os
	// objetos que contenham tal string;
	@Query(nativeQuery = true, value = "SELECT * FROM tb_cities WHERE ?1 LIKE '%?2%'")
	List<City> findByColumnAndFilter(String column, String filter);

	// 10 - Exibir a quantidade de registro baseado em uma coluna. Não exibir itens
	// iguais;
	@Query(nativeQuery = true, value = "SELECT COUNT(DISTINCT ?) FROM tb_cities")
	Integer findByColumn(String column);

	// 11 - Exibir a quantidade de registros total;
	@Query(nativeQuery = true, value = "SELECT COUNT(*) FROM tb_cities")
	Integer totalNumberOfCities();

	// 12 - Dentre todas as cidades, obter as duas cidades mais distantes uma da
	// outra com base na localização (distância em KM em linha reta);
}
