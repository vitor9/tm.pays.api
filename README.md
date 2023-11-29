# tm.pays.api
Repositório dedicado a API do projeto de agendamento de transações financeiras da Tokyo Marine

## Tecnologias utilizadas
Utilizado Spring Initializr gerar um projeto com as dependências necessárias, como o Spring Web, o Spring Data JPA, o H2 Database e o Lombok. A versão utilizada do Java é a 17

### Como fazer build e rodar aplicação localmente
1. Rodar o comando `mvn clean install` na pasta raiz da API
2. Rodar a classe TmPaysApplication para subir o back-end junto com a base em memória da aplicação

#### Qual arquitetura foi utilizada?
A arquitetura segue comumente conhecido como arquitetura em camadas ou arquitetura em três camadas. Essa abordagem organiza o sistema em camadas distintas, cada uma com uma responsabilidade específica. Os benefícios incluem a separação de preocupações, facilitando a manutenção, escalabilidade e testabilidade do sistema. Aqui estão as camadas principais que podemos identificar na API:

Camada de Controle (Controller): Responsável por receber as requisições HTTP, interpretar parâmetros e chamar os métodos apropriados na camada de serviço. No nosso caso, isso é representado pelo TransferenciaController.

Camada de Serviço (Service): Responsável pela lógica de negócios e manipulação de dados. Nossa classe TransferenciaService está localizada nesta camada. Aqui, a lógica de taxa de transferência é calculada e as operações de persistência são realizadas.

Camada de Persistência (Repository): Responsável por interagir com o banco de dados. A classe TransferenciaRepository é um exemplo disso. Ela utiliza o Spring Data JPA para simplificar as operações de persistência.

Além disso, a arquitetura segue o padrão MVC (Model-View-Controller), que é uma forma de organizar o código de uma aplicação. Nesse padrão:

- O Model (modelo) representa a estrutura de dados e a lógica de negócios. Em nosso caso, a classe Transferencia atua como o modelo.

- A View (visualização) é responsável pela apresentação dos dados ao usuário. Neste contexto, a visão seria o frontend Vue.js, que não foi detalhado na implementação.

- O Controller (controlador) gerencia as requisições do usuário, interage com o modelo para obter os dados necessários e seleciona a visão apropriada para apresentar os resultados. O TransferenciaController desempenha esse papel.

--

##### Por que essa arquitetura?

Separação de Preocupações: Cada camada tem uma responsabilidade clara e separada, o que facilita a compreensão do código e a manutenção.

Reusabilidade: As camadas podem ser reutilizadas em diferentes partes do sistema ou até mesmo em outros projetos.

Escalabilidade: A separação permite escalar cada camada independentemente, facilitando a escalabilidade horizontal.

Testabilidade: Cada camada pode ser testada de forma isolada, facilitando a implementação de testes unitários e de integração.

Flexibilidade: Mudanças em uma camada não devem afetar diretamente as outras, proporcionando flexibilidade para evolução e manutenção.