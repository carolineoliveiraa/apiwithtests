# API de Gerenciamento de Usuários

Este README fornece informações sobre a API de Gerenciamento de Usuários, que permite realizar operações de CRUD (Criar, Ler, Atualizar e Excluir) sobre os recursos de usuários.

## Tecnologias Utilizadas

- Java 11
- Spring Boot
- Maven
- ModelMapper
- Banco H2 (ou MySQL, conforme configuração)

## Endpoints da API

### Usuário

#### Buscar Usuário por ID

- **URL:** `/user/{id}`
- **Método:** `GET`
- **Descrição:** Retorna os detalhes de um usuário específico.
- **Exemplo de Resposta:**
  ```json
  {
    "id": 1,
    "name": "João Silva",
    "email": "joao.silva@example.com"
  }
  ```
  ### Listar Todos os Usuários

- **URL:** `/user`
- **Método:** `GET`
- **Descrição:** Retorna uma lista de todos os usuários cadastrados.
- **Exemplo de Resposta:**
  ```json
  [
    {
      "id": 1,
      "name": "João Silva",
      "email": "joao.silva@example.com"
    },
    {
      "id": 2,
      "name": "Maria Souza",
      "email": "maria.souza@example.com"
    }
  ]
  ```
  ### Criar Novo Usuário

- **URL:** `/user`
- **Método:** `POST`
- **Descrição:** Cria um novo usuário.
- **Exemplo de Corpo da Requisição:**
  ```json
  {
    "name": "João Silva",
    "email": "joao.silva@example.com",
    "password": "senha123"
  }
  
### Atualizar Usuário

- **URL:** `/user/{id}`
- **Método:** `PUT`
- **Descrição:** Atualiza um usuário existente.
- **Exemplo de Corpo da Requisição:**
  ```json
  {
    "name": "João Silva Atualizado",
    "email": "joao.silva.atualizado@example.com"
  }
  
### Excluir Usuário

- **URL:** `/user/{id}`
- **Método:** `DELETE`
- **Descrição:** Remove um usuário existente.
- **Exemplo de Resposta:**
  - **Status:** `204 No Content`

## Testes da Classe `UserServiceImplTest`

A classe `UserServiceImplTest` realiza testes unitários para a implementação do serviço `UserServiceImpl`. Os testes utilizam JUnit e Mockito para verificar a funcionalidade do serviço de usuário. Abaixo está uma descrição dos testes implementados:

### Configuração Inicial

- **Classe:** `UserServiceImplTest`
- **Anotações:**
  - `@SpringBootTest`: Indica que o teste deve ser executado com o contexto do Spring Boot.
  - `@InjectMocks`: Injeta os mocks na instância do serviço a ser testado.
  - `@Mock`: Cria mocks dos componentes `UserRepository` e `ModelMapper`.
- **Método `setUp()`:** Inicializa os mocks e configura os dados de teste.

### Testes Implementados

#### `whenFindByIdThenReturnAnUserInstance`

- **Descrição:** Verifica se o método `findById` retorna uma instância de `User` com os valores esperados.
- **Setup do Mock:** `repository.findById(anyInt())` retorna um `Optional<User>`.
- **Asserções:** Verifica se o objeto retornado não é nulo e se suas propriedades correspondem aos valores esperados.

#### `whenFindByIdThenReturnAnObjectNotFoundException`

- **Descrição:** Verifica se o método `findById` lança uma exceção `ObjectNotFoundException` quando o usuário não é encontrado.
- **Setup do Mock:** `repository.findById(anyInt())` lança uma `ObjectNotFoundException`.
- **Asserções:** Verifica se a exceção lançada é do tipo `ObjectNotFoundException` e se a mensagem da exceção é a esperada.

#### `whenFindAllThenReturnAnListOfUsers`

- **Descrição:** Verifica se o método `findAll` retorna uma lista de usuários.
- **Setup do Mock:** `repository.findAll()` retorna uma lista contendo um `User`.
- **Asserções:** Verifica se a lista retornada não é nula, tem o tamanho correto e contém o `User` com as propriedades esperadas.

#### `whenCreateTheReturnSuccess`

- **Descrição:** Verifica se o método `create` retorna um `User` com os valores esperados quando a criação é bem-sucedida.
- **Setup do Mock:** `repository.save(any())` retorna o `User`.
- **Asserções:** Verifica se o objeto retornado não é nulo e se suas propriedades correspondem aos valores esperados.

#### `whenCreateTheReturnAnDataIntegrityViolationException`

- **Descrição:** Verifica se o método `create` lança uma exceção `DataIntegratyViolationException` quando o e-mail já está cadastrado.
- **Setup do Mock:** `repository.findByEmail(anyString())` retorna um `Optional<User>` com um e-mail existente.
- **Asserções:** Verifica se a exceção lançada é do tipo `DataIntegratyViolationException` e se a mensagem da exceção é a esperada.

#### `whenUpdatingTheReturnSuccess`

- **Descrição:** Verifica se o método `update` retorna um `User` com os valores esperados quando a atualização é bem-sucedida.
- **Setup do Mock:** `repository.save(any())` retorna o `User`.
- **Asserções:** Verifica se o objeto retornado não é nulo e se suas propriedades correspondem aos valores esperados.

#### `whenUpdateTheReturnAnDataIntegrityViolationException`

- **Descrição:** Verifica se o método `update` lança uma exceção `DataIntegratyViolationException` quando o e-mail já está cadastrado.
- **Setup do Mock:** `repository.findByEmail(anyString())` retorna um `Optional<User>` com um e-mail existente.
- **Asserções:** Verifica se a exceção lançada é do tipo `DataIntegratyViolationException` e se a mensagem da exceção é a esperada.

#### `deleteWithSuccess`

- **Descrição:** Verifica se o método `delete` remove um usuário com sucesso.
- **Setup do Mock:** `repository.findById(anyInt())` retorna um `Optional<User>`, e `repository.deleteById(anyInt())` não faz nada.
- **Asserções:** Verifica se o método `deleteById` foi chamado exatamente uma vez.

#### `deleteWithObjectNotFoundException`

- **Descrição:** Verifica se o método `delete` lança uma exceção `ObjectNotFoundException` quando o usuário não é encontrado.
- **Setup do Mock:** `repository.findById(anyInt())` lança uma `ObjectNotFoundException`.
- **Asserções:** Verifica se a exceção lançada é do tipo `ObjectNotFoundException` e se a mensagem da exceção é a esperada.

## Testes da Classe `UserResourceTest`

A classe `UserResourceTest` realiza testes unitários para a implementação do recurso `UserResource`. Os testes verificam o comportamento das APIs REST associadas ao gerenciamento de usuários. Abaixo está uma descrição dos testes implementados:

### Configuração Inicial

- **Classe:** `UserResourceTest`
- **Anotações:**
  - `@SpringBootTest`: Indica que o teste deve ser executado com o contexto do Spring Boot.
  - `@InjectMocks`: Injeta os mocks na instância do recurso a ser testado.
  - `@Mock`: Cria mocks dos componentes `UserServiceImpl` e `ModelMapper`.
- **Método `setUp()`:** Inicializa os mocks e configura os dados de teste.

### Testes Implementados

#### `whenFindByIdThenReturnSuccess`

- **Descrição:** Verifica se o método `findById` do `UserResource` retorna uma resposta bem-sucedida com os detalhes do `UserDTO`.
- **Setup do Mock:** `service.findById(anyInt())` retorna um `User`, e `mapper.map(any(), any())` retorna um `UserDTO`.
- **Asserções:** Verifica se a resposta não é nula, o corpo da resposta é um `UserDTO`, e as propriedades correspondem aos valores esperados.

#### `whenFindAllReturnAListOfUserDTO`

- **Descrição:** Verifica se o método `findAll` do `UserResource` retorna uma lista de `UserDTO`.
- **Setup do Mock:** `service.findAll()` retorna uma lista com um `User`, e `mapper.map(any(), any())` retorna um `UserDTO`.
- **Asserções:** Verifica se a resposta não é nula, o corpo da resposta é uma lista de `UserDTO`, e as propriedades correspondem aos valores esperados.

#### `whenCreateThenReturnCreated`

- **Descrição:** Verifica se o método `create` do `UserResource` retorna um status HTTP 201 Created.
- **Setup do Mock:** `service.create(any())` retorna um `User`.
- **Asserções:** Verifica se a resposta é um `ResponseEntity`, o status da resposta é `CREATED`, e o cabeçalho `Location` não é nulo.

#### `whenUpdateThenReturnSuccess`

- **Descrição:** Verifica se o método `update` do `UserResource` retorna uma resposta bem-sucedida com os detalhes do `UserDTO`.
- **Setup do Mock:** `service.update(userDTO)` retorna um `User`, e `mapper.map(any(), any())` retorna um `UserDTO`.
- **Asserções:** Verifica se a resposta não é nula, o corpo da resposta é um `UserDTO`, e as propriedades correspondem aos valores esperados.

#### `whenDeleteThenReturnSucess`

- **Descrição:** Verifica se o método `delete` do `UserResource` retorna uma resposta com status HTTP 204 No Content.
- **Setup do Mock:** `service.delete(anyInt())` não faz nada.
- **Asserções:** Verifica se a resposta é um `ResponseEntity`, o status da resposta é `NO_CONTENT`, e o método `delete` foi chamado uma vez.

---

## Testes da Classe `ResourceExceptionHandlerTest`

A classe `ResourceExceptionHandlerTest` realiza testes unitários para o manipulador de exceções `ResourceExceptionHandler`. Os testes verificam o comportamento do tratamento de exceções específicas. Abaixo está uma descrição dos testes implementados:

### Configuração Inicial

- **Classe:** `ResourceExceptionHandlerTest`
- **Anotações:**
  - `@SpringBootTest`: Indica que o teste deve ser executado com o contexto do Spring Boot.
  - `@InjectMocks`: Injeta os mocks na instância do manipulador de exceções a ser testado.
- **Método `setUp()`:** Inicializa os mocks.

### Testes Implementados

#### `whenObjectNotFoundExceptionThenReturnnAResponseEntity`

- **Descrição:** Verifica se o manipulador de exceções retorna uma resposta com status HTTP 404 Not Found quando ocorre uma `ObjectNotFoundException`.
- **Setup do Mock:** Cria uma `ObjectNotFoundException` com uma mensagem específica.
- **Asserções:** Verifica se a resposta não é nula, o corpo da resposta é um `StandardError`, o status é `NOT_FOUND`, e a mensagem de erro é a esperada.

#### `dataIntegratyViolationException`

- **Descrição:** Verifica se o manipulador de exceções retorna uma resposta com status HTTP 400 Bad Request quando ocorre uma `DataIntegratyViolationException`.
- **Setup do Mock:** Cria uma `DataIntegratyViolationException` com uma mensagem específica.
- **Asserções:** Verifica se a resposta não é nula, o corpo da resposta é um `StandardError`, o status é `BAD_REQUEST`, e a mensagem de erro é a esperada.


