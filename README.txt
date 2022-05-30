API para leitura e manutenção de uma lista de cidades do Brasil em um arquivo CSV.

1 - Importar o arquivo CSV das cidades para a base de dados;
http://localhost:8080/cities/csvImport

2 - Exibir as cidades que são capitais ordenadas por nome;
http://localhost:8080/cities/capitalsOrderedByName

3 - Exibir o nome do estado com a maior e menor quantidade de cidades e a quantidade de cidades;
http://localhost:8080/cities/stateWithHighestAndLowestNumberOfCities

4 - Exibir a quantidade de cidades por estado;
http://localhost:8080/cities/numberOfCitiesByState/{uf}

5 - Exibir os dados da cidade informando o id do IBGE;
http://localhost:8080/cities/cityByIdIbge/{idIbge}

6 - Exibir o nome das cidades de um estado selecionado;
http://localhost:8080/cities/citiesByState/{uf}

7 - Adicionar uma nova Cidade;
http://localhost:8080/cities/addCity
{
	"ibge_id":"1200089",
	"uf":"MS",
	"name":"Ladario",
	"capital":"false",
	"lon":-19.00,
	"lat":-57.00,
	"no_accents":"Ladario",
	"alternative_names":null,
	"microregion":"Corumba",
	"mesoregion":"Centro Oeste"
}

8 - Deletar uma cidade;
http://localhost:8080/cities/deleteCity/{idIbge}

9 - Selecionar uma coluna e entrar com uma string para filtrar todos os objetos que contenham tal string;
http://localhost:8080/cities/findByFilter/{column}/{filter}

10 - Exibir a quantidade de registro baseado em uma coluna. Não exibir itens iguais;
http://localhost:8080/cities/findByColumn/{column}

11 - Exibir a quantidade de registros total;
http://localhost:8080/cities/totalNumberOfCities

12 - Dentre todas as cidades, obter as duas cidades mais distantes uma da outra com base na localização (distância em KM em linha reta);
* em desenvolvimento
