# icmSolApp
A project for Mobile Computation

#### Funcionalidades:

1) Aceder � meteorologia de um qualquer distrito de Portugal, bastando para tal selecionar um de entre a lista de Distritos disponibilizada.

2) Manter sempre as cidades preferidas no slider para que se possa ter acesso mais r�pido e eficiente.


#### Limita��es: 
Por alguma raz�o que eu n�o consegui descobrir nas �ltimas duas horas de intera��o e tentativa de uso, a app ao ligar a primeira vez n�o funciona mas se for reiniciada funciona. Eu sei que isto � algo que est� mal da minha parte mas n�o consegui resolver. Al�m disso, � necess�rio ter cuidado com o update no frag das settings.


#### Descri��o do Fluxo de Intera��o com a Aplica��o: 

Inicialmente, o utilizador, tem acesso a uma p�gina onde encontra info acerca do tempo numa cidade. Ao andar para o lado direito encontra outras cidades e no �ltimo frag encontra uma lista com as cidades para poder escolher quais quer a funcionar na app.


#### Arquitetura Implementada:

Primeiro fomos buscar � api do IPMA:
* "Previs�o Meteorol�gica Di�ria at� 5 dias agregada por Local"
* "Lista de identificadores para as capitais distrito e ilhas"
* "Lista de identificadores do tempo significativo"
* "Lista de classes relativa � intensidade vento"

Os dados obtidos s�o usados para criar entidades, e depois armazenados na bd que � ROOM. 

As entidades s�o:
* "WeatherForecast" 
* "WeatherForecastData"
* "District" 
* "DistrictData"      
* "Weather"           
* "WeatherData"       
* "WindSpeed"           
* "WindSpeedData"       

Estes objetos quando criados s�o colocados nos reposit�rios correspondentes.

Para cada uma das entidades foi tamb�m criado um viewmodel para aceder diretamente
