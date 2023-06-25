# Gatito café: uma aplicação desenvolvida baseada nos cat cafés 🐱 ☕
Um cat café é um estabelecimento que une amor ao café e afeição pelos gatos. Os frequentadores podem interagir com os felinos enquanto consomem a bebida. O conceito já existe há pelo menos 20 anos e o primeiro estabelecimento do tipo surgiu em Taiwan, no ano de 1998. Além de ser um espaço para provar um bom café na companhia de um lindo gatinho, os espaços ainda podem unir os animais aos seus futuros donos, por meio da adoção. No Brasil, os cat cafés começaram a ser implementados apenas nos últimos anos, pois a ANVISA possui algumas restrições sanitárias que impedem que os gatos circulem no mesmo local em que a comida é servida ou produzida, e por esse motivo nos cat cafés brasileiros os gatos ficam num cômodo separado onde os clientes podem reservar uma visita para interagir com os felinos.

## Plano de testes
Como a aplicação *não possui front-end desenvolvido nesse primeiro momento*, os seguintes requisitos do projeto final da disciplina foram implementados:
- [x] Escrever um **plano de teste**, ou seja, um documento que descreva cada teste juntamente com as entradas e saídas esperadas. 
- [x] Implementar uma **verificação estática** no projeto (**PMD** e/ou **SonarClould**, instalei a extensão de ambos no meu projeto)
- [ ] Implementar um **conjunto de testes unitários**
- [ ] Implementar **testes de componentes (API)** <s>e/ou testes de sistema (Selenium ou Cypress)</s>
- [x] Configure um ambiente de integração contínua de sua escolha, por exemplo, **Github Actions**, Jekins, Travis, Circle-CI, GitLab, entre outros.

### Verificação estática
A verificação estática foi feita através da adição do plugin e da extensão do PMD juntamente com a adição da extenção do Sonarlint ao projeto no VS Code. Além disso, foi seguido o passo-a-passo para a implementação do Github Actions com o SonarClould.

### Testes Unitários

### Testes de Componente

### Github Actions CI/CD
Foram implementadas actions referentes a análise estática do código via SonarCloud, Java CI com Maven, Revisão de dependências e PMD (este último não consegui configurar corretamente).
