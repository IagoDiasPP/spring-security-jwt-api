# Spring Security JWT API

API REST desenvolvida com **Spring Boot** com foco em autenticação e autorização utilizando **Spring Security e JWT**.

O projeto implementa um fluxo completo de autenticação, permitindo cadastro de usuários, login, geração de token JWT e controle de acesso baseado em roles.

## 🚀 Tecnologias utilizadas

* Java 23
* Spring Boot
* Spring Security
* JWT (JSON Web Token)
* Spring Data JPA / Hibernate
* MySQL
* Docker e Docker Compose
* Maven
* MapStruct
* Lombok
* Bean Validation

## 📌 Funcionalidades

* Cadastro de usuários
* Login com autenticação via JWT
* Geração e validação de tokens
* Proteção de endpoints utilizando Spring Security
* Controle de permissões por roles

    * ALUNO
    * ADMIN
* Criptografia de senha utilizando BCrypt
* DTOs para entrada e saída de dados
* Validações com Bean Validation
* Tratamento global de exceções
* Mapeamento de entidades utilizando MapStruct

## 🔐 Fluxo de autenticação

1. O usuário realiza o cadastro através do endpoint de registro.
2. A senha é criptografada utilizando BCrypt.
3. O usuário realiza login informando suas credenciais.
4. A API retorna um token JWT.
5. O token deve ser enviado nas próximas requisições protegidas através do header:

```
Authorization: Bearer {token}
```

## ⚙️ Configuração do projeto

O projeto utiliza variáveis de ambiente para configurações sensíveis, como banco de dados e chave JWT.

Atualmente o projeto **não utiliza um arquivo `.env` diretamente**. As variáveis abaixo devem ser configuradas no ambiente onde a aplicação será executada (IDE, sistema operacional ou container Docker).

Exemplo de variáveis necessárias:

```env
# =========================
# Banco de Dados
# =========================

DATABASE_URL=jdbc:mysql://localhost:3308/analise_dados
DATABASE_USERNAME=appuser
DATABASE_PASSWORD=123

# =========================
# JWT
# =========================

# Gere uma chave forte para produção.
# Para desenvolvimento pode usar qualquer texto longo.
JWT_KEY=sua-chave-secreta-jwt

# Tempo em milissegundos
JWT_EXPIRATION=90000
```

> O arquivo `.env` não é obrigatório para o funcionamento da aplicação. Ele é apenas uma forma comum de armazenar variáveis de ambiente. Em ambientes profissionais, essas informações normalmente são configuradas diretamente no servidor, pipeline de deploy ou container.

## 🐳 Executando com Docker

O projeto possui configuração Docker para execução do banco de dados MySQL.

Suba o container:

```bash
docker compose up -d
```

Depois execute a aplicação Spring Boot:

```bash
./mvnw spring-boot:run
```

No Windows:

```bash
mvnw.cmd spring-boot:run
```

## 📂 Estrutura do projeto

```
src/main/java
│
├── Controller
├── Dto
├── Exception
├── Handler
├── Mapper
├── Model
├── Repository
├── Service
├── config
└── enums
```

## 📚 Objetivo

Projeto desenvolvido com objetivo de praticar conceitos de backend Java moderno, principalmente autenticação, segurança de APIs REST e boas práticas utilizando Spring Boot.

## 👨‍💻 Autor

Iago Dias Prudencio Pereira

GitHub:
https://github.com/IagoDiasPP
