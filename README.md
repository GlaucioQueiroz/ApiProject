# API PROJECT
## Swagger
    http://.../swagger-ui.html
## Docker
For the project, the configuration of containers was created
```sh
DB
MySql
```
```sh
API
Rest Api - JAVA
```

Docker compose orchestrated
```sh
docker-compose up -d --build --force-recreate
```

## Postman
Postman Configuration Files

-- The requests use "pre-script" to get and send the TOKEN

| Plugin | README |
| ------ | ------ |
| Collection | https://github.com/GlaucioQueiroz/ApiProject/blob/main/ApiProject.postman_collection.json |
| Environment Config | https://github.com/GlaucioQueiroz/ApiProject/blob/main/ConfigApiProject.postman_environment.json |