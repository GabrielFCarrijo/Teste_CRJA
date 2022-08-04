# Crud-Spring-Boot

## Descrição do Projeto
* Crud que contem as 4 operações basicas Create, Read, Update, Delete
####

## Como Executar Este Projeto
* É necessário Java 17 para executar este projeto.
####
* É necessário Maven 3.6.3 ou acima para executar este projeto.
####
* É necessário Postman na sua versão 9.25.2 ou superior.
####
* Uma vez que atenda aos requisitos anteriores, pode clonar ou baixar o projeto.
####
* Após clonar ou baixar o projeto em sua máquina, é necessário compilá-lo com sua IDE de preferência (comando: mvn clean install). 
####
* Para que possam testar as 4 operações basta abrir postman com diretorio correto que passerei logo abaixo: 
  ####
  GET All People: http://localhost:8080/people
  ####
  GET People by id: http://localhost:8080/people/ 'Imporante frezar que aqui passamos ID'
  ####
  POST New People : http://localhost:8080/people
  ####
  PUT Update People : http://localhost:8080/people/ 'Imporante frezar que aqui passamos ID'
  ####
  DEL Delete People : http://localhost:8080/people/ 'Imporante frezar que aqui passamos ID'
 
####
* Para que possam acessar banco de dados entrar neste link: http://localhost:8080/h2-console
####
* Se todos os passos forem seguidos corretamente e o caminho do diretório for válido, existente e sem erros de escrita, então o projeto executará sem problemas.
