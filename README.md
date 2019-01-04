# icmSolApp
A project for Mobile Computation

#### Funcionalidades:

1) Aceder à meteorologia de um qualquer distrito de Portugal, bastando para tal selecionar um de entre a lista de Distritos disponibilizada.

2) Manter sempre as cidades preferidas no slider para que se possa ter acesso mais rápido e eficiente.


#### Limitações: 
Por alguma razão que eu não consegui descobrir nas últimas duas horas de interação e tentativa de uso, a app ao ligar a primeira vez não funciona mas se for reiniciada funciona. Eu sei que isto é algo que está mal da minha parte mas não consegui resolver. Além disso, é necessário ter cuidado com o update no frag das settings.


#### Descrição do Fluxo de Interação com a Aplicação: 

Inicialmente, o utilizador, tem acesso a uma página onde encontra info acerca do tempo numa cidade. Ao andar para o lado direito encontra outras cidades e no último frag encontra uma lista com as cidades para poder escolher quais quer a funcionar na app.


#### Arquitetura Implementada:

Primeiro fomos buscar à api do IPMA:
* "Previsão Meteorológica Diária até 5 dias agregada por Local"
* "Lista de identificadores para as capitais distrito e ilhas"
* "Lista de identificadores do tempo significativo"
* "Lista de classes relativa à intensidade vento"

Os dados obtidos são usados para criar entidades, e depois armazenados na bd que é ROOM. 

As entidades são:
* "WeatherForecast" 
* "WeatherForecastData"
* "District" 
* "DistrictData"      
* "Weather"           
* "WeatherData"       
* "WindSpeed"           
* "WindSpeedData"       

Estes objetos quando criados são colocados nos repositórios correspondentes.

Para cada uma das entidades foi também criado um viewmodel para aceder diretamente
