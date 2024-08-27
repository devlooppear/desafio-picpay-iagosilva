# Get Started

Para iniciar o projeto, siga as etapas abaixo:

1. **Limpar e Instalar Dependências**:

   Execute o seguinte comando para limpar e instalar todas as dependências do projeto:

```bash
mvn clean install
```

2. **Executar a Aplicação**: Para iniciar a aplicação Spring Boot, use o comando:

```bash
./mvnw spring-boot:run
```

3. **Executar Migrações do Flyway**: Para executar as migrações do Flyway, utilize o seguinte comando, certificando-se de que o arquivo de configuração esteja no caminho correto:

```bash
mvn -Dflyway.configFiles=src/main/resources/flyway.conf flyway:migrate
```

To migrate fresh and seed:

./mvnw spring-boot:run -Dspring-boot.run.arguments="migrate-fresh-and-seed"
