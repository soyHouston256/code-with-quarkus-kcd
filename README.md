# code-with-quarkus-kcd

## Deploy

- Option 01:

```shell
mvn clean package -Dnative
```

```shell
./target/code-with-quarkus-kcd-1.0.0-runner
```

- Option 02:

```shell
podman build -f src/main/docker/Dockerfile.multistage -t code-with-quarkus-kcd:1.0.0 .
```

```shell
podman run --rm --name code-with-quarkus-kcd -p 8080:8080 code-with-quarkus-kcd:1.0.0
```

## Test

```shell
curl -v http://localhost:8080/person | jq
```

```shell
curl -v -X POST http://localhost:8080/person \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Juan Perez",
    "email": "jperez@gmail.com"
}' | jq
```

```shell
curl -v -X PUT http://localhost:8080/person/664f4bf9c70dd20036c229cb \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Juan Perez",
    "email": "jperez@gmail.com"
}' | jq
```

```shell
curl -v -X DELETE http://localhost:8080/person/664f4bf9c70dd20036c229cb
```