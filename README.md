# 🏋️ Gymsys API

Backend de um sistema para gerenciamento de academias, desenvolvido com Java e Spring Boot.

---

## 📋 Sobre o Projeto

A Gymsys API é o backend de um sistema completo para gerenciamento de academias. Permite o cadastro e controle de alunos, instrutores, turmas, planos e contratações, com relacionamentos entre as entidades e regras de negócio aplicadas na camada de serviço.

---

## 🚀 Funcionalidades

- Cadastro, listagem, atualização e remoção de **Alunos**
- Cadastro, listagem, atualização e remoção de **Instrutores**
- Cadastro, listagem, atualização e remoção de **Turmas**
- Cadastro, listagem, atualização e remoção de **Planos**
- Cadastro e listagem de **Contratações** de planos por alunos
- Documentação interativa da API via **Swagger/OpenAPI**

---

## 🏗️ Arquitetura

O projeto segue a **Arquitetura em Camadas**:

```
Controller → Service → Repository → Banco de Dados
```

- **Controller** — recebe as requisições HTTP e retorna as respostas
- **Service** — contém as regras de negócio e validações
- **Repository** — gerencia a persistência dos dados via JPA
- **DTO** — controla o fluxo de dados entre as camadas e evita exposição das entidades
- **Mapper** — converte entidades em DTOs e vice-versa

---

## 🗃️ Modelagem de Domínio

```
Aluno ──────────── Contratacao ──────── Plano
  │                                      │
  └── Turma ──────────────── Instrutor   │
                                         │
                               TipoPlano (Enum)
                               MENSAL | TRIMESTRAL | ANUAL
```

### Relacionamentos

| Entidade A | Relacionamento | Entidade B |
|------------|---------------|------------|
| Turma      | Um para Muitos | Alunos    |
| Instrutor  | Um para Muitos | Turmas    |
| Aluno      | Um para Muitos | Contratações |
| Plano      | Um para Muitos | Contratações |

---

## 🛠️ Stack Utilizada

| Tecnologia | Descrição |
|-----------|-----------|
| Java 17 | Linguagem principal |
| Spring Boot | Framework principal |
| Spring Data JPA | Persistência de dados |
| Hibernate | ORM |
| H2 Database | Banco de dados (persistente em arquivo) |
| Lombok | Redução de boilerplate |
| Springdoc OpenAPI | Documentação da API (Swagger) |

---

## ▶️ Como Executar

### Pré-requisitos

- Java 17+
- Maven

### Passos

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/gymsys-backend.git

# Acesse a pasta do projeto
cd gymsys-backend/Gymsys

# Execute o projeto
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080`

---

## 📖 Documentação

Após subir a aplicação, acesse a documentação interativa:

```
http://localhost:8080/swagger-ui.html
```

---

## 🔗 Endpoints Principais

### Aluno
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/aluno/criar` | Cadastrar aluno |
| GET | `/aluno` | Listar todos os alunos |
| GET | `/aluno/{id}` | Buscar aluno por ID |
| PUT | `/aluno/alterar/{id}` | Atualizar aluno |
| DELETE | `/aluno/deletar/{id}` | Remover aluno |

### Instrutor
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/instrutor/criar` | Cadastrar instrutor |
| GET | `/instrutor` | Listar todos os instrutores |
| GET | `/instrutor/{id}` | Buscar instrutor por ID |
| PUT | `/instrutor/alterar/{id}` | Atualizar instrutor |
| DELETE | `/instrutor/deletar/{id}` | Remover instrutor |

### Turma
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/turma/criar` | Cadastrar turma |
| GET | `/turma` | Listar todas as turmas |
| GET | `/turma/{id}` | Buscar turma por ID |
| PUT | `/turma/alterar/{id}` | Atualizar turma |
| DELETE | `/turma/deletar/{id}` | Remover turma |

### Plano
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/plano/criar` | Cadastrar plano |
| GET | `/plano` | Listar todos os planos |
| GET | `/plano/{id}` | Buscar plano por ID |
| PUT | `/plano/alterar/{id}` | Atualizar plano |
| DELETE | `/plano/deletar/{id}` | Remover plano |

---

## 👨‍💻 Autor

Desenvolvido por **SavioQuixaba** — [LinkedIn](https://www.linkedin.com/in/savioquixaba/) · [GitHub](https://github.com/savioquixaba)
