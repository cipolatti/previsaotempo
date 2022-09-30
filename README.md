# previsaotempo
Previsao do tempo com API do Open Weather Map

### Utilizado o postman para realização dos teste, abaixo os end-points:

- Consulta a previsão do tempo para os próximos 5 dias a cada 3 horas para uma determinada cidade e salva na base de dados.

localhost:8080/previsao/{cidade} -> Exemplo: localhost:8080/previsao/Rio Grande

- Traz a lista de registros de todas consultas realizadas

localhost:8080/previsao/listar-previsoes

### Utilizado as dependencias abaixo:

- spring-boot-starter-web
- lombok
- spring-boot-starter-data-jpa
- postgresql
- spring-boot-starter-webflux

