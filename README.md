# Gatito café: uma aplicação desenvolvida baseada nos cat cafés 🐱 ☕
Um cat café é um estabelecimento que une amor ao café e afeição pelos gatos. Os frequentadores podem interagir com os felinos enquanto consomem a bebida. O conceito já existe há pelo menos 20 anos e o primeiro estabelecimento do tipo surgiu em Taiwan, no ano de 1998. Além de ser um espaço para provar um bom café na companhia de um lindo gatinho, os espaços ainda podem unir os animais aos seus futuros donos, por meio da adoção. No Brasil, os cat cafés começaram a ser implementados apenas nos últimos anos, pois a ANVISA possui algumas restrições sanitárias que impedem que os gatos circulem no mesmo local em que a comida é servida ou produzida, e por esse motivo nos cat cafés brasileiros os gatos ficam num cômodo separado onde os clientes podem reservar uma visita para interagir com os felinos.

*Esse trabalho tem como objetivo simular um site de um cat café. Nesse site, espera-se que mostre os cafés disponíveis na cafeteria e os gatinhos que estão disponíveis na cafeteria. Espera-se implementar também no futuro um sistema de booking para usuários, para que eles possam *.

## Plano de testes
Como a aplicação *não possui front-end desenvolvido nesse primeiro momento*, os seguintes requisitos do projeto final da disciplina foram implementados:
- [x] Escrever um **plano de teste**, ou seja, um documento que descreva cada teste juntamente com as entradas e saídas esperadas. 
- [x] Implementar uma **verificação estática** no projeto (**PMD** e/ou **SonarClould**, instalei a extensão de ambos no meu projeto)
- [x] Implementar um **conjunto de testes unitários**
- [x] Implementar **testes de componentes (API)** <s>e/ou testes de sistema (Selenium ou Cypress)</s>
- [x] Configure um ambiente de integração contínua de sua escolha, por exemplo, **Github Actions**, Jekins, Travis, Circle-CI, GitLab, entre outros.

### Verificação estática
A verificação estática foi feita através da extensão do PMD juntamente com a adição da extensão do Sonarlint ao projeto no VS Code. Além disso, adicionou-se também o plugin do PMD ao arquivo `pom.xml`. A verificação com o PMD pelo VS Code é feita com o comando `Ctrl+Shift+P" e pesquisa por Apex  A verificação estática através das Github actions do SonarClould não foi possível de serem implementadas, visto que para isso seria necessário dividir o projeto em dois (caf-auth e cafe-gato) para a Action poder fazer a build e análise e não tinha essa opção no site do SonarClould, já que ele ouxava diretamente o repositório do Github.

### Testes Unitários
Testes unitários foram implementados nas classes Cat, Coffee e User (respectivamente através das classes BookingTest, CatTest, CoffeeTest e UserTest). A descrição do que cada teste faz encontra-se 

### Testes de Componente
Testes de componente foram implementados nas classes CatWS, CoffeeWS, UserWS e (respectivamente através das classes CatWSTest, CoffeeWSTest e UserWSTest). 
### Github Actions CI/CD
Foram implementadas actions referentes a Java CI com Maven (para cada um dos diretórios cafe-auth e cafe-gato) e revisão de dependências.
