 - Este programa funciona como una tabla la cual nos va a mostrar una serie de alumnos según la base de datos (archivo.txt) que escojamos.

   Lleva implementadas las funcionalidades de poder agregar, eliminar y filtrar los alumnos de dicha base de datos. La función agregar está 
   correctamente implementada, la de eliminar da fallos a la hora de sustituir un archivo temporal por el original que estemos viendo y el de
   filtrar no tiene nada implmentado por el momento.

   Tenemos arriba a la izquierda dos pestañas, la primera de "Abrir..." nos mostrará un sola opción, "Archivo...", la cual nos abrirá un menú
   en el que elegiremos la base de datos de alumno.

   La otra pestaña, "Edición...", nos deja escoger entre dos opciones, "Limpiar", que nos dejará la base de datos vacía, y "Actualizar" que servirá
   a la hora de hacer cambios manuales en el archivo base de datos.


 - Consta de 4 archivos java, la clase Persona.java simplemente nos sirve como objeto para agregar elementos a la tabla, consta de 4 variables
   con sus getter y setter, un constructor con los parámetros necesarios y otro sin ellos, un método toString() para  agregar los objetos al archivo 
   correspondiente y un último método getColumn() para agregar las diferentes variables a sus correspondientes columnas.

   La clase TableModel.java extiende de AbstractTableModel y servirá para que el componente jTable de la clase que nos aporta el JFrame utilice 
   nuestro objeto TableModel, dentro de esta clase se le indica el número de columnas, filas y de dónde debe de sacar los datos.

   La tercera clase es ManejoDeDatos.java que se encargará de hacer todo el manejo y gestión de la base de datos en uso, consta de varios 
   métodos, el primero nos pasa un archivo txt a un ArrayList para alimentar al TableModel, otro es compararPersonas() que nos devuelve un
   booleano, siendo true cuando las personas a comparar sean iguales. Este método compara el nombre, primer apellido, segundo y edad de 
   dos personas, este método identifica un "*" (o un 0 para la edad) para saltarse la comparación de una variable en específico y hacerla 
   pasar como igual. Otro método es deletePerson() que recibe un objeto Persona por parámetro, y todas las Personas con las que coincidan
   las variables serán eliminados de la tabla, aquí es cuando podremos hacer usos de los "*" y el "0", addPerson() simplemente  nos añade una
   persona a la base, vaciarArchivo() es el método utilizado en la opción "Limpiar" de la pestaña "Edición...", como se puede ver, se utiliza el 
   método deletePerson() pero pasando por parámetro una Persona con valores "+" y "0", y por último el método comprobarSiVacío(), utilizado
   para borrar un "\n" que se añade al principio de línea a la hora de agregar una persona al archivo.

   Por último tenemos la clase FRAME_Table que será la que se nos va a mostrar a la hora de utilizar el programa, en el tenemos la tabla que
   visualizará los datos, varios campos de texto en los que añadir la información de la persona, un botón que nos servirá bien sea para agregar,
   eliminar o filtrar personas, y un checkbox en cual nos vaciará los campos o no a la hora de pulsar el botón de agregar/eliminar/filtrar. De
   manera interna también lleva sus propios métodos, como vaciarCampos(), comprobarCampoVacío(), comprobarCampos(), botonPersona(),
   cambiarTextoBoton(), escogerArchivo(), y los dos últimos, introducirPersona() y eliminarPersona(), que hacen uso de todos los métodos 
   anteriores para hacer comprobaciones de campos correctos, etc y realmente funcionan haciendo uso de los métodos de la clase ManjeDeDatos
   pasándole un objeto Persona. El resto es almacenar datos en variables con FocusListener, etc.

   