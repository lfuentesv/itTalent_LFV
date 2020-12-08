# itHunt_LFV
_Evaluación JAVA IT-Hunt (GlobalLogic)_

### Pre-requisitos 📋

 * git
 * gradle

## Comenzando 🚀

_Clonar el proyecto utilizando git_
```
git clone https://github.com/lfuentesv/itHunt_LFV.git
```

## Pruebas ⚙️

_En la raiz del directorio donde se realizó la descarga del proyecto (ej: /home/lfuentes/itHuntLFV) ejecutar el comando:_
```
gradle clean test
```

## Ejecución 📦

_En la raiz del directorio donde se realizó la descarga del proyecto (ej: /home/lfuentes/itHuntLFV) ejecutar el comando:_
```
gradle clean bootrun
```

### Uso ⌨️

#### Registrar Usuario
 * Post
 * localhost:8080
 * Body
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


## Construido con 🛠️

_Utilicé las siguientes herramientas durante el desarrollo_

* [Eclipse 2020-09](https://www.eclipse.org/) - IDE
* [Spring Boot](https://spring.io/projects/spring-boot#overview) 
* [Gradle](https://gradle.org/) - Manejador de dependencias
* [Dozer](http://dozer.sourceforge.net/documentation/about.html) - Mapeador de objetos
* [Git Flow](https://nvie.com/posts/a-successful-git-branching-model/) - Metodología para organizar repositorio git


