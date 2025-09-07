Cálculo de cuadrados con pool de hilos

Instrucciones:

Genere una lista de 20 números enteros del 1 al 20.
Cree un pool de hilos fijo de tamaño 4 usando Executors.newFixedThreadPool(4).
Para cada número de la lista, envíe una tarea al pool que calcule su cuadrado.
Cada tarea debe imprimir en consola:

* El número recibido,
* El resultado del cuadrado,
* El nombre del hilo que ejecutó la tarea.

Recolectar los resultados con Future.get() y guardarlos en una lista.
Al final del programa, mostrar en consola todos los resultados obtenidos en orden.
Cerrar correctamente el pool con shutdown().

Entregable: Repositorio con código.
