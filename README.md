# Análisis de caso sistemas distribuidos (Entrega 1)

La arquitectura a realizar corresponde a la que se presenta a continuación, basada en la plataforma Comisaria Virtual.
![Blank Diagram](https://user-images.githubusercontent.com/44279550/85346217-c6c9f200-b4c2-11ea-879e-1c6ef6d6c8ef.png)

## Formulario de ingreso
La página principal presenta un formulario de ingreso, el cual al ser completado retorna el permiso con los datos ingresados, juntos con el id, la fecha de inicio y la fecha de término. 
![Captura de Pantalla 2020-06-22 a la(s) 20 07 41](https://user-images.githubusercontent.com/44279550/85346658-1c52ce80-b4c4-11ea-8530-f97c86d145f0.png)
![Captura de Pantalla 2020-06-22 a la(s) 20 11 37](https://user-images.githubusercontent.com/44279550/85346811-9c793400-b4c4-11ea-8139-d3eb05bcb53a.png)

## Análisis del sistema

Para que la arquitectura sea un sistema distribuido debe contar con una serie de características. La tabla que se presenta a continuación contiene 3 columnas, en donde la primera lista las características de un sistema distribuido, la segunda indica si la arquitectura descrita anteriormente la posee o no y finalmente una explicación.

| Características |¿Qué es?|¿La arquitectura lo posee? |
| ------------- | ------------- | ------------- |
| Poner recursos a disposición  |  Poner recursos a disposición es facilitar a los usuarios acceder a recursos remotos, de esta forma se puede disminuir el gasto económico, ya que los dispositivos personales no deben contar con una gran capacidad de procesamiento.  |  La arquitectura no cuenta con este punto, debido a que no se accede a ningún recurso remoto, ya que todo se encuentra localizado en un mismo equipo. |
| Transparencia de la distribución  |  La transparencia corresponde al hecho de hacer creer al usuario que los procesos y recursos se encuentran distribuidos en distintos equipos. Para lograr que un SD sea transparente este debe contar con: persistencia, acceso, concurrencia, réplicas, ubicación, falla, migración y re-localización.| La arquitectura no puede ser transparente en la distribución, debido a que los procesos no se encuentran distribuidos en distintos recursos, si no que en la misma red local.  |
| Apertura| Un sistema distribuido abierto es aquel en donde su funcionamiento se encuentra basado en reglas estándar, es decir, comparte con otros una semántica y sintaxis, de esta forma es fácil realizar cambios, debido a que las entradas y salidas son siempre las mismas. Un claro ejemplo de SD abiertos son aquellos que utilizan API's. | La arquitectura no lo posee, debido a que las salidas no se encuentran estandarizadas, por lo tanto, si se realiza un cambio es necesario modificar todo el desarrollo, por lo que no cumple con la portabilidad, interoperabilidad y fácil extensión (el sistema es monolítico).|
|Escalabilidad| La escalabilidad se puede definir como la capacidad que tiene un sistema para aumentar o disminuir su capacidad de respuesta. Existen distintos tipos de escalabilidad, por un lado la horizontal, en donde se aumenta la cantidad de recursos, aumentando también el throughput y la vertical,  que aumenta las capacidades de los recursos (agregar más memoria, etc). Entre las técnicas existentes para escalar se encuentra la partición, caché y la réplica.| La arquitectura actual no es escalable, ya que tanto la base de datos, como el backend y frontend no cuentan con réplicas, por lo que no es posible atender varias consultas a la vez. La base de datos tampoco se encuentra particionada, por lo que no es posible distribuir las consultas en diferentes equipos para no generar un cuello de botella. Tampoco se implementa caché, el cual permite acceder menos veces a la base de datos y aumentar el tiempo de respuesta. Por lo tanto, la arquitectura no se encuentra preparada para aumentar o disminuir su capacidad de respuesta.|


## Capacidad de respuesta del sistema
Para ser desarrollada fue utilizada la herramienta Artillery.io, que permite crear pruebas de cargas en las aplicaciones. Es importante destacar que las conexiones que crea Artillery son mediante el protocolo TCP, por lo que lo que se presentará no son errores en las solicitudes, si no que latencia. 
El primer caso de prueba realizada corresponde a un POST al backend. Para esto se utilizó el archivo que aparece en la siguiente imagen: 
![Captura de Pantalla 2020-06-26 a la(s) 23 59 00](https://user-images.githubusercontent.com/44279550/85914177-08330800-b809-11ea-8be2-dffdbadf659d.png)


Se varía la cantidad de usuarios generados por segundo entre 10 y 5000 y se obtiene la siguiente tabla:
![Captura de Pantalla 2020-06-28 a la(s) 21 38 42](https://user-images.githubusercontent.com/44279550/85964460-c54b6e80-b987-11ea-9858-306b0eb2fc11.png)

La tabla contiene el número de casos realizados, los casos que fueron completados con éxito, la cantidad de solicitudes promedio completadas por segundo, y el mínimo, máximo y media de las solicitudes (en milisegundos). Se puede notar que desde los 320 usuarios y solicitudes generadas comienza a aumentar el tiempo mínimo de respuesta, el máximo y el promedio, por lo tanto se puede determinar que desde esa cantidad de solicitudes el sistema se comienza a saturar. Otro dato importante es que con 5000 solicitudes el sistema demora demasiado en responder, por lo que el tiempo de espera de estas expira y no se completan con éxito el 23, 97% .

