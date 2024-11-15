# H2_T1_PSP_IVAN_ROLDAN
Hito2 del 1ºTrimestre de Psp CampusFp Humanes 2ºDAM

Descripción
Este proyecto es una aplicación distribuida cliente/servidor que permite a los usuarios buscar información sobre libros disponibles en una librería virtual. La arquitectura está dividida en tres capas:
Capa de Acceso a Datos: Encargada de gestionar la información de los libros.
Capa Servidor: Maneja las solicitudes de los clientes y utiliza la capa de acceso a datos para recuperar información.
Capa Cliente: Se comunica con el servidor para enviar solicitudes de búsqueda.

Tecnologías Utilizadas
Java: Lenguaje de programación principal.
Socket API: Para la comunicación en red entre cliente y servidor.
Java IO: Para la entrada y salida de datos.
Java Collections Framework: Para manejar listas y mapas de libros.

Cómo Ejecutar el Proyecto
Clona este repositorio:
git clone <URL_DEL_REPOSITORIO>

Navega al directorio del proyecto:
cd <NOMBRE_DEL_DIRECTORIO>

Compila las clases:
javac psp/*.java

Inicia el servidor:
java psp.Servidor

En otra terminal, ejecuta el cliente:
java psp.Cliente

Contribuciones
Las contribuciones son bienvenidas. Si deseas mejorar o agregar nuevas funcionalidades, siéntete libre de abrir un pull request.

Licencia
Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles. Este README proporciona una visión general clara del proyecto, instrucciones sobre cómo ejecutarlo y detalles sobre su estructura y funcionamiento.
