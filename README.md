# Qr Coder

## Características del proyecto

### Publicación

En este informe se presenta el proyecto **[Qr Coder](https://github.com/AlbertoVf/qr-coder)** que se encuentra disponible en GitHub bajo la licencia **[Mit](https://choosealicense.com/licenses/mit)**. La fecha de publicación en GitHub fue el **22/10/2020**.

### Descripción del proyecto

El proyecto tiene la función de la codificación y decodificación de códigos QR. Los códigos qr son imágenes en blanco y negro con un formato especifico, solo contienen texto.

## Codificación

### Lenguajes y Frameworks

- **Java** es un [lenguaje de programación](https://es.wikipedia.org/wiki/Lenguaje_de_programaciรณn) y una [plataforma informática](https://es.wikipedia.org/wiki/Plataforma_informรกtica) que fue comercializada por primera vez en 1995 por [Sun Microsystems](https://es.wikipedia.org/wiki/Sun_Microsystems). Java es rápido, seguro y fiable. Si es ejecutado en una plataforma no tiene que ser [recompilado](https://es.wikipedia.org/wiki/Compilaciรณn_en_tiempo_de_ejecuciรณn) para correr en otra. Java es, a partir de 2012, uno de los lenguajes de programación más populares en uso, particularmente para aplicaciones de [cliente-servidor](https://es.wikipedia.org/wiki/Cliente-servidor) de [web](https://es.wikipedia.org/wiki/Web). Se ha utilizado la librería de java OpenJDK. Las librerías core-3.3.0 y javase-3.3.0 se utilizaron para la realización de los códigos Qr. Para la ejecución de los test s ha utilizado Junit(v.5.4)

### Entorno de programación

- **IntelliJ IDEA** es un [entorno de desarrollo integrado](https://es.wikipedia.org/wiki/Entorno_de_desarrollo_integrado) (IDE) para el desarrollo de programas informáticos. Es desarrollado por JetBrains (anteriormente conocido como IntelliJ), y están disponible en dos ediciones: edición para la comunidad y edición comercial.

### Control de versiones

- **[Git](https://git-scm.com/):** Sistema de control de versiones utilizado para llevar un registro de los cambios en el proyecto y evitar posibles errores a lo largo del proceso. Servidor externo donde se alojara una copia del proyecto. **Git** es un software de [control de versiones](https://es.wikipedia.org/wiki/Control_de_versiones) diseñado por [Linus Torvalds](https://es.wikipedia.org/wiki/Linus_Torvalds), pensando en la eficiencia, la confiabilidad y compatibilidad del mantenimiento de versiones de aplicaciones cuando estas tienen un gran número de archivos de [código fuente](https://es.wikipedia.org/wiki/C%C3%B3digo_fuente). Su propósito es llevar registrode los cambios en archivos de computadora incluyendo coordinar el trabajo que varias personas realizan sobre archivos compartidos en un repositorio de código.

    **[Github](https://github.com/AlbertoVf)** es una [forja](https://es.wikipedia.org/wiki/Forja_(software)) (plataforma de desarrollo colaborativo) para alojar proyectos utilizando el sistema de [control de versiones](https://es.wikipedia.org/wiki/Control_de_versiones) [Git](https://es.wikipedia.org/wiki/Git). Se utiliza principalmente para la creación de [código fuente](https://es.wikipedia.org/wiki/C%C3%B3digo_fuente) de [programas](https://es.wikipedia.org/wiki/Programa_inform%C3%A1tico) de [ordenador](https://es.wikipedia.org/wiki/Ordenador "Ordenador"). El [software](https://es.wikipedia.org/wiki/Software) que opera GitHub fue escrito en [Ruby on Rails](https://es.wikipedia.org/wiki/Ruby_on_Rails "Ruby on Rails"). El código de los proyectos alojados en GitHub se almacena generalmente de forma [pública](https://es.wikipedia.org/wiki/C%C3%B3digo_abierto).

    **[Gitlab](https://gitlab.com/AlbertoVf1)** es un [servicio web](https://es.wikipedia.org/wiki/Servicio_web) de [forja](https://es.wikipedia.org/wiki/Forja_(software)), [control de versiones](https://es.wikipedia.org/wiki/Control_de_versiones) y [DevOps](https://es.wikipedia.org/wiki/DevOps) basado en [Git](https://es.wikipedia.org/wiki/Git). Además de gestor de repositorios, el servicioofrece también alojamiento de [wikis](https://es.wikipedia.org/wiki/Wiki) y un [sistema de seguimiento de errores](https://es.wikipedia.org/wiki/Sistema_de_seguimiento_de_incidentes), todo ello publicado bajo una [licencia de código abierto](https://es.wikipedia.org/wiki/Licencia_de_c%C3%B3digo_abierto), principalmente.

### Organización de proyecto

- **[Diagrams](https://en.wikipedia.org/wiki/Diagrams.net):** Draw.io es una herramienta muy útil para diseñar los diagramas del proyecto y representar gráficamente el funcionamiento y la estructura de tu proyecto. Es una aplicación de diagramación muy completa que te permite crear distintos tipos de diagramas, como diagramas de flujo, diagramas de clases o diagramas de red.

## Diagramas

![Esquema relacional](docs/qr-coder_1.svg)

> Esquema relacional del proyecto

## Manual de uso

La aplicación de escritorio permite la creación de un código qr que se guarda en formato imagen.

El código qr esta compuesto por un texto que se codifica y el nombre del fichero resultante, ambos se pueden personalizar. En la aplicación se podrá seleccionar entre codificar o decodificar una imagen.

En el proceso de codificación el usuario podrá codificar el texto que quiera, ademas de modificar el nombre del fichero y sus dimensiones. El resultado es una imagen en formato **.png**

En el proceso de decodificación el usuario podrá seleccionar una imagen con formato **.png** para decodificar, el texto resultante se visualizara en una ventana independiente.
