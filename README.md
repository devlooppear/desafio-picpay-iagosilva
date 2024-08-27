# Get Started

Para iniciar o projeto, siga as etapas abaixo:

1. **Executar Docker Compose**: Certifique-se de que todos os serviços necessários estejam em execução. Para fazer isso, execute o seguinte comando:

```bash
docker compose up
Isso irá iniciar os contêineres necessários para a aplicação.
```

2. **Limpar e Instalar Dependências: Execute o seguinte comando para limpar e instalar todas as dependências do projeto**:

```bash
mvn clean install
```

3. **Executar a Aplicação: Para iniciar a aplicação Spring Boot, use o comando**:

```bash
./mvnw spring-boot:run
```

4. **Executar Migrações do Flyway: Para executar as migrações do Flyway, utilize o seguinte comando, certificando-se de que o arquivo de configuração esteja no caminho correto**:

```bash
mvn -Dflyway.configFiles=src/main/resources/flyway.conf flyway:migrate
```

5. **Migrar e Semear: Para migrar fresh e semear o banco de dados, execute**:

```bash
./mvnw spring-boot:run -Dspring-boot.run.arguments="migrate-fresh-and-seed"
```
