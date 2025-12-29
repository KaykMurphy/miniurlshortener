# 🔗 Mini URL Shortener

Uma aplicação moderna e eficiente para encurtamento de URLs, desenvolvida com Spring Boot e arquitetura RESTful.

## 📋 Sobre o Projeto

O Mini URL Shortener é um serviço web que permite transformar URLs longas em links curtos e fáceis de compartilhar. A aplicação gera códigos únicos de 6 caracteres e gerencia o redirecionamento automático para as URLs originais.

### ✨ Funcionalidades

- **Encurtamento de URLs**: Converte URLs longas em códigos curtos de 6 caracteres
- **Redirecionamento Automático**: Redireciona usuários da URL curta para a URL original
- **Validação Robusta**: Garante que apenas URLs válidas (http:// ou https://) sejam processadas
- **Códigos Únicos**: Geração segura de códigos usando caracteres alfanuméricos
- **Persistência de Dados**: Armazenamento em banco de dados H2

## 🛠️ Tecnologias Utilizadas

- **Java 17+**
  - Javadoc 
- **Spring Boot 3.x**
  - Spring Web
  - Spring Data JPA
  - Spring Validation
  - Spring OpenAPI
- **H2 Database** (em memória)
- **Lombok** (redução de boilerplate)
- **Maven** (gerenciamento de dependências)

## 🏗️ Arquitetura

O projeto segue uma arquitetura em camadas bem definida:

```
├── controller/     # Camada de apresentação (REST endpoints)
├── service/        # Camada de negócio
├── repository/     # Camada de acesso a dados
├── model/          # Entidades JPA
├── dto/            # Objetos de transferência de dados
├── doc/            # Documentação da API
└── exception/      # Tratamento de exceções customizadas
```

## 📡 Endpoints da API

### Criar URL Curta

```http
POST /api/shorten
Content-Type: application/json

{
  "originalUrl": "https://www.exemplo.com.br/pagina-muito-longa"
}
```

**Resposta:**
```json
{
  "shortUrl": "http://localhost:8080/aB3xY9"
}
```

### Redirecionar para URL Original

```http
GET /{shortCode}
```

**Resposta:** HTTP 301 (Moved Permanently) com redirecionamento para a URL original

## 🚀 Como Executar

### Pré-requisitos

- Java 17 ou superior
- Maven 3.6+

### Passos

1. Clone o repositório
```bash
git clone https://github.com/seu-usuario/mini-url-shortener.git
cd mini-url-shortener
```

2. Execute a aplicação
```bash
mvn spring-boot:run
```

3. A aplicação estará disponível em `http://localhost:8080`

4. Acesse o console H2 em `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:testdb`
   - Username: `sa`
   - Password: *(deixe em branco)*

## 🧪 Testando a API

### Usando cURL

**Criar URL curta:**
```bash
curl -X POST http://localhost:8080/api/shorten \
  -H "Content-Type: application/json" \
  -d '{"originalUrl": "https://www.google.com"}'
```

**Acessar URL curta:**
```bash
curl -L http://localhost:8080/{shortCode}
```

### Usando Postman ou Insomnia

Importe a coleção de requisições ou crie manualmente os endpoints conforme documentado acima.

## 📦 Estrutura do Banco de Dados

### Tabela: urls

| Campo | Tipo | Descrição |
|-------|------|-----------|
| id | BIGINT | Identificador único (auto-incremento) |
| original_url | VARCHAR | URL original completa |
| short_code | VARCHAR | Código único de 6 caracteres (único) |
| created_at | TIMESTAMP | Data/hora de criação |

## 🔒 Segurança

- Geração de códigos usando `SecureRandom` para maior aleatoriedade
- Validação de entrada com Bean Validation
- Constraint de unicidade no código curto

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 👨‍💻 Autor

**Kayk Edmar**

Desenvolvido com ☕ e 💙

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/kayk-edmar/)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/KaykMurphy)

---

⭐ Se este projeto foi útil para você, considere dar uma estrela no repositório!
