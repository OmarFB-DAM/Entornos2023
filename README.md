# Ejercicio Calculadora de Propinas

En la ruta del proyecto "ProyectoEntornos1/src/propinas/TipMaster.java"se encuentra el código de la clase TipMaster.java.
(El proyecto también contiene el paquete donde está CanaryExchange.java, nuestra aplicación de cambio de divisas).

![image](https://github.com/OmarFB-DAM/Entornos2023/assets/153750217/0eeadfe1-061d-492b-bad0-b2a2697874ea)
Esta clase con la ayuda del editor WindowBuilder
![image](https://github.com/OmarFB-DAM/Entornos2023/assets/153750217/12a63cad-c240-49ef-b7d5-3bf987e928ac)
Como podemos ver el programa consta de una ventana que contiene:
 - 4 etiquetas de texto plano que utilizo como titulo de los cuadros de texto o desplegable.
 - 1 botón que limpia el contenido de los cuadros de texto y devuelve a la opción por defecto en el desplegable.
 - Los 3 cuadros de texto; 2 de ellos solo devuelven resultado y no permiten al usuario que introduzca ningún dato;
  el cuadro de texto bajo la etiqueta que indica el input del usuario, donde se debe introducir un valor ya sea entero o
  con coma(la coma puede ser escrita en con la coma española local ',' o la coma extranjera '.').
 - Por último un selector desplegable con las opciones de la propina que quieras seleccionar; actualmente son 4 opciones.
![image](https://github.com/OmarFB-DAM/Entornos2023/assets/153750217/4408cf8a-75fc-4a29-bf42-f0279e21486e)

Los textos planos son JLabels  estáticos sin ninguna funcionalidad.
Los cuadros de texto de salida muestran cada uno el contenido que indica la JLabel que tienen encima indicando.

Pasamos a explicar los elementos que tienen más desarrollo y funcionalidades detrás:
  - Mostraremos primero el desplegable sin inputs en la entrada de texto.
    ![image](https://github.com/OmarFB-DAM/Entornos2023/assets/153750217/c27b2a13-096f-4bb4-8b74-756a8e15e9d7)
  - Podemos elegir una opcion del desplegable y luego escribir texto en el cuadro de la izquierda. O podemos directamente
    escribir una cantidad por pantalla y después escoger el porcentaje deseado.

![image](https://github.com/OmarFB-DAM/Entornos2023/assets/153750217/67c9a404-6a42-4141-8e0c-a3bbdda3e55b)
![image](https://github.com/OmarFB-DAM/Entornos2023/assets/153750217/5b39931b-eabe-48d8-9555-d65a83e7ef54)

Esta diversidad de opciones la conseguimos primero utilizando el listener propio de los *JComboBox*, que es el elemento que usa Java swing para generar desplegables.
   ![image](https://github.com/OmarFB-DAM/Entornos2023/assets/153750217/61f8f86c-405f-4068-a7fd-cee2546a4d4c)
    Podemos ver la segunda razón por la cuál disponemos y manejamos diferentes funcionalidades y se trata de la función *gestionarAccionDesplegable(JComboBox desplegablePorcentajes);*.
![image](https://github.com/OmarFB-DAM/Entornos2023/assets/153750217/57957507-8901-4116-bdc7-e64960e1de33)

En esta se tratan tanto las opciones posibles seleccionadas en el desplegable como posibles errores de entrada.

![image](https://github.com/OmarFB-DAM/Entornos2023/assets/153750217/d8297ab1-cd93-4137-b577-c6c84b447f07) ![image](https://github.com/OmarFB-DAM/Entornos2023/assets/153750217/3ecde67f-8ccf-4a5f-ba59-b82668ab8391)
    ![image](https://github.com/OmarFB-DAM/Entornos2023/assets/153750217/11618140-3e03-4103-bb8f-7ea690ea79ad)
    ![image](https://github.com/OmarFB-DAM/Entornos2023/assets/153750217/94fb766e-2603-4f1b-9271-2bd469090674)
  - Otra funcionalidad importante se consigue con el *CaretListener*
    ![image](https://github.com/OmarFB-DAM/Entornos2023/assets/153750217/2c966d47-ed1e-4e46-890a-2d8a8d2d286f)

Se puede apreciar en los comentarios del código pero en resumen, sería una escucha de cambio en el cuadro de texto.
    Para que se actualice la salida en cuanto cambiamos la entrada, lo que nos habilita primero escoger el porcentaje y luego escribir la cuantía.
  - El boton *Clear* es un JButton que tiene un *MouseListener* para realizar la acción una vez sea pulsado.
     ![image](https://github.com/OmarFB-DAM/Entornos2023/assets/153750217/d1735cd5-4cfb-4cde-9b13-fe81e6c07e7b) ![image](https://github.com/OmarFB-DAM/Entornos2023/assets/153750217/883406d6-5c8c-4847-9886-a0dc4e3fc22b) ![image](https://github.com/OmarFB-DAM/Entornos2023/assets/153750217/6590645d-f88e-49b4-8986-a679877ae673)
  - La última entrada con funcionalidades es la entrada de texto *JTextField*.
      En el caso del input debe gestionarse la diferenciación entre números y otro tipo de input que se pase por teclado. Para ello utilizo la función *public boolean esUnDouble(String input);*.
![image](https://github.com/OmarFB-DAM/Entornos2023/assets/153750217/a1b9f688-8c5f-45ed-a424-89d21546b4ce)

Esta me permite comprobar si los imputs son valores enteros o contienen decimales con ambas comas en cada instancia del código que sea llamada.
      Se puede ver por ejemplo usándose en la función *gestionarAccionDesplegable(JComboBox desplegablePorcentajes);* explicada en más arriba en profundidad.
      Los *JTextField* de salida simplemente muestran el output calculado con cada opción seleccionada en el desplegable.
    Los *try-catch* colocados en las funciones de input controlan si se produce una excepcion por incorrecto tipo de input, o también posibles problemas de condición
    de carrera, al esperar con el *CaretListener* de manera concurrente a las demas acciones de la aplicación.

- En cuánto a los detalles no funcionales, como por ejemplo la elección de colores. Decidi utilizar un diseño simple y claro.
Ya que se trata de una aplicación de uso cotidiano, decidí usar colores claros de ventana de Windows.
Las formas, tamaño y espaciado entre elementos es abierto y claro para diferenciar claramente cada uno de ellos.
- El icono de la aplicación se encuentra en el paquete "ProyectoEntornos1/src/propinas/Imagenes" donde también hay otras posibles opciones válidas.
![north-store-icons-03](https://github.com/OmarFB-DAM/Entornos2023/assets/153750217/39dfcc38-80a2-485a-8221-dfca847a252e)

 

    



 
   
