# Kafka Microservices

Este projeto é uma aplicação de microserviços utilizando Kafka como sistema de mensageria. A aplicação é desenvolvida com Spring Boot 3.3.3 e utiliza Docker Compose para facilitar a configuração e execução do Kafka e Zookeeper.

## Tecnologias

- **Spring Boot**: 3.3.3
- **Apache Kafka**: Utilizado para a comunicação entre os microserviços.
- **Docker Compose**: Facilita a configuração e gerenciamento dos containers Kafka e Zookeeper.

## Estrutura do Projeto

- **Producer**: Envia mensagens para o tópico Kafka.
- **Consumer**: Consome mensagens do tópico Kafka.
- **Docker Compose**: Configuração para executar Kafka e Zookeeper em containers Docker.

## Configuração

### Docker Compose

O arquivo `docker-compose.yml` configura os serviços Kafka e Zookeeper. Certifique-se de que o Docker e o Docker Compose estão instalados em sua máquina.

### Docker Compose File

```yaml
version: '3.8'
services:
  kafka:
    image: wurstmeister/kafka:latest
    container_name: kafka
    ports:
      - "9094:9094"
    environment:
      KAFKA_ADVERTISED_LISTENERS: INSIDE://kafka:9094,OUTSIDE://localhost:9094
      KAFKA_LISTENER_NAME_PLAINTEXT: INSIDE
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: INSIDE:PLAINTEXT,OUTSIDE:PLAINTEXT
      KAFKA_LISTENERS: INSIDE://0.0.0.0:9094,OUTSIDE://0.0.0.0:9094
      KAFKA_LISTENER_NAME: INSIDE
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
      KAFKA_AUTO_CREATE_TOPICS_ENABLE: 'true'
    depends_on:
      - zookeeper

  zookeeper:
    image: wurstmeister/zookeeper:latest
    container_name: zookeeper
    ports:
      - "2181:2181"
