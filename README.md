# Camunda WebModeler Client

This library aims to provide a REST client for accessing the Camunda 8 Web Modeler REST APIs from a java
application.

## Getting Started

### Install Dependency

First import the dependency:

```xml

<dependency>
    <groupId>io.holunda</groupId>
    <artifactId>camunda-web-modeler-rest-client</artifactId>
    <version>${camunda-web-modeler-rest-client.version}</version>
</dependency>
```

### Usage

```
CamundaWebModelerClient camundaWebModelerClient = CamundaWebModelerClientBuilder.builder()
    .clientId("clientId")
    .clientSecret("clientSecret")
    .build();
```

## Limitations:

Currently this Version only supports the SaaS Rest-Api

