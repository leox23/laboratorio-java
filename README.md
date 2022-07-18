# laboratorio-java
### Participantes
1. Leonel Elias Mira Lunar
2. Jhonatan Alexader Castillo Perez

### Video explicativo:

Es una lista de reproduccion para tener un solo link, youtube solo permite subir 10min.

https://www.youtube.com/watch?v=iWHZ1S1HjLY&list=PLrwNRvISkjhGIMLQTouPxR44nLQV3tkBk&index=1

Se desarrolla la actividad de crear un juego de Quien quiere ser millonario en Java. Creando un proyecto maven con una conexion a una base de datos almacenada haciendo uso de MySql.

## Instructivo de ejecución
1. Bajar el repositorio de GitHub usando el boton "Download ZIP".

![downloadZip](https://user-images.githubusercontent.com/51030335/179426787-e6952620-bdb2-46b3-a453-3e00f4803083.png)

2. Descomprimir el archivo .zip y abrir con el editor o IDE  de su preferencia.

3. Iniciar MySQL WorkBench y correr el script llamado questionBank.sql que se encuentra en la carpeta "SQL" del repositorio. Este creara la base de datos.

![164646357-82a64133-1c30-408a-b409-5ded7d5422af](https://user-images.githubusercontent.com/51030335/179426834-5d71a3d2-964a-42d2-9429-61b183138c22.png)

4. Relizar el paso anterior con el archovo llamado "questionchallenge_answer.sql" que se encuentra en la carpeta "SQL" del repositorio para dar datos iniciales a la tabla answer.

5. Realizar el paso anterior para los archivos "questionchallenge_question.sql" y "questionchallenge_player.sql".

6. NOTA:Si tu conexion a MySQL tiene una configuracion diferente , dirigete al archivo Preferences.properties en la carpeta resource y cambia los valores para:

```java
DRIVER=com.mysql.cj.jdbc.Driver
USUARIO   ="root";
PASSWORD  ="Admin1234";
URL ="jdbc:mysql://localhost:3306/questionchallenge?useUnicode=true&characterEncoding=UTF-8";
```
