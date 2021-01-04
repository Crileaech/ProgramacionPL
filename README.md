# Lenguaje de Programación P

_P es un lenguaje de programación secuencial con asertos. La idea es usar asertos para verificar la corrección del programa. Si al
 ejecutar un programa, sus asertos son ciertos entonces el programa se considera correcto. El programa sería incorrecto en otro
 caso. El programa P se estructura en 3 secciones: una dedicada a la declaración de variables (sección VARIABLES), otra dedicada
 a la declaración de subprogramas (sección SUBPROGRAMAS) y otra dedicada al uso de variables y subprogramas (sección
 INSTRUCCIONES)._


### Instalación 🔧

_Una serie de ejemplos paso a paso que te dice lo que debes ejecutar para tener un entorno de desarrollo ejecutandose_

__

```
1.Arrancar IntelliJ IDE
2.Instalar Plugin ANTLR
```

## Ejecutando las pruebas ⚙️

_Explica como ejecutar las pruebas para este sistema_

### Analice las pruebas end-to-end 🔩

* 1.Creamos un proyecto
* 2.Creamos ficheros Anasint.g4 y Analex.g4 (estos ficheros cuelgan del directorio src)
* 3.Compilamos los ficheros ANTLR
    * PRIMERO Analex.g4 
    * SEGUNDO Anasint
* 4.Analizar Semántico
    * DEFINICIÓN DE DEISEÑO
        * OBJETIVO 1 (abstracto y declarativo): analizador semántico capaz de decidir si las
          asignaciones de un programa en un lenguaje llamado R están bien tipadas (suponemos que los
          programas P siempre usan variables declaradas)
        * OBJETIVO 2 (concreto y declarativo): analizador semántico capaz de decidir si las
         asignaciones de un programa en un lenguaje llamado R están bien tipadas (suponemos que los
         programas R siempre usan variables declaradas).
            * (a) Una asignación en el lenguaje de programación R está bien tipada si y sólo si el tipo de
         la variable a la que se asigna coincide con el tipo de la expresión asignada. Toda lista
         entera o booleana es también lista híbrida.
            * (b) Una expresión es de tipo entera si y sólo si es una constante entera, una variable entera
         o la suma, resta o producto de expresiones enteras.
            * (c) Una expresión es de tipo booleana si y sólo si es una constante booleana, una variable
         booleana o la conjunción, disyunción o negación de expresiones booleanas.
            * (d) Una expresión es de tipo lista entera si y sólo si es una lista dada por extensión (ej.
         […]) cuyos elementos son todos enteros (la lista vacía cumple esta restricción), una
         variable de tipo lista entera o la yuxtaposición (append) de dos expresiones de tipo
         lista de enteros.
            * (e) Una expresión es de tipo lista booleana si y sólo si es una lista dada por extensión
         cuyos elementos son todos booleanos (la lista vacía cumple esta restricción), una
         variable de tipo lista booleana o la yuxtaposición (append) de dos expresiones de tipo
         lista de booleanos.
            * (f) Una expresión es de tipo lista híbrida si y sólo si es una expresión de tipo lista de
         enteros o lista de booleanos, es una lista dada por extensión cuyos elementos son una
         mezcla de enteros y booleanos (la lista vacía cumple esta restricción), una variable de
         tipo lista híbrida o la yuxtaposición (append) de dos expresiones de tipo lista híbrida. 
    
* 5.Necesitamos Programa Main para ejecutar procesador pasando como argumento un txt

## Autores ✒️

_Menciona a todos aquellos que ayudaron a levantar el proyecto desde sus inicios_

* **Enrique Fernández Corrales** 
* **Cristina Leal Echevarría**
* **Antonio Prieto Tagua** 
* **Juan Toscano Fernández**
