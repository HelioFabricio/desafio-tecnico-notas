# Desafio Técnico - API de Notas

## 📌 Sobre o projeto

Esta aplicação é uma API desenvolvida em Spring Boot com containerização via Docker e banco Oracle.

---

## 🚀 Como executar com Docker

Na raiz do projeto, execute:

```bash
docker compose up --build
```

A aplicação subirá junto com o banco Oracle via Docker Compose.

---

## 🌐 Endpoints disponíveis

### ➕ Criar nota
```
POST /nota
```

#### Exemplo de request:
```json
{
  "valor": 300.00,
  "numero": "12300",
  "dataHora": "2026-06-18T01:53:00-03:00"
}
```

---

### ❌ Deletar nota
```
DELETE /nota
```

---

### 📊 Estatísticas
```
GET /estatistica
```

---

### ❤️ Health check
```
GET /actuator/health
```

---

## ⚙️ Configuração da aplicação

A aplicação possui configuração customizável no `application.yml`:

```yaml
spring:
  application:
    search-time-span-seconds: 300
```

Essa variável define o tempo de busca (em segundos) utilizado pela regra de negócio.

---

## 🔐 Variáveis de ambiente (.env)

Para execução via Docker Compose, recomenda-se criar um arquivo `.env` na raiz do projeto:

```env
SPRING_DATASOURCE_URL=jdbc:oracle:thin:@oracle:1521/FREEPDB1
SPRING_DATASOURCE_USERNAME=app
SPRING_DATASOURCE_PASSWORD=app

ORACLE_PASSWORD=oracle
APP_USER=app
APP_USER_PASSWORD=app
```

---

## 🧱 Arquitetura

- Spring Boot API
- Oracle Database (via Docker)
- Docker Compose para orquestração
- Configuração via application.yml + environment variables
