# itTalent_LFV
_Evaluación JAVA IT-Hunt (GlobalLogic)_

### Pre-requisitos 📋

 * git
 * gradle

## Comenzando 🚀

_Clonar el proyecto utilizando git_
```
git clone https://github.com/lfuentesv/itTalent_LFV.git
```

## Pruebas ⚙️

_En la raiz del directorio donde se realizó la descarga del proyecto (ej: /home/lfuentes/itTalent_LFV/glogic/) ejecutar el comando:_
```
./gradlew clean test
```

## Ejecución 📦

_En la raiz del directorio donde se realizó la descarga del proyecto (ej: /home/lfuentes/itTalent_LFV/glogic) ejecutar el comando:_
```
./gradlew clean bootrun
```

### Uso ⌨️

#### Registrar Usuario
 * Método http: Post
 * URL: localhost:8080/usuario
 * Body:
```
{
    "name": "pedro Rodrigue",
    "email": "pedrft@rodrigue.cl",
    "password": "Hunter22",
    "phones": [{
                "number": "12345670",
                "citycode": "1",
                "contrycode": "10"
                }]
}
```
 * Notas: 
 * * El email debe tener mínimo 1 caracter y maxímo 7, debe ser ".cl".
 * * El password debe empezar con UNA mayúscula,seguido de letras minúsculas y terminar en DOS números.

#### Buscar Usuario por Id
 * Método http: Get
 * URL: localhost:8080/usuario/{id}
 * Notas: 
 * * {id} corresponde al id del usuario, por ejemplo: 767b21a4-c76c-4dcd-9792-1e2f8962db65, este se obtiene dentro de la respuesta del registro del usuario.

#### Buscar todos los usuario

 * Método http: Get
 * URL: localhost:8080/usuario
 * Notas: 
 * * Retorna un listado con todos los usuarios registrados, ordenados por fecha de registro de forma descendente.

## Construido con 🛠️

_Utilicé las siguientes herramientas durante el desarrollo_

* [Eclipse 2020-09](https://www.eclipse.org/) - IDE
* [Spring Boot](https://spring.io/projects/spring-boot#overview) 
* [Gradle](https://gradle.org/) - Manejador de dependencias
* [Dozer](http://dozer.sourceforge.net/documentation/about.html) - Mapeador de objetos
* [Git Flow](https://nvie.com/posts/a-successful-git-branching-model/) - Metodología para organizar repositorio git

## Documentación 📖
_En el directorio /diagramas se encuentran los siguientes diagramas:_
 * Diagrama de secuencia "Registro"
 * Diagrama de componentes

