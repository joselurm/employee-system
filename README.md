# employee-system
Ejercicio final
Tecnologias Utilizadas
-Lenguaje: Kotlin 
-Entorno de Desarrollo: IntelliJ
-Control de Versiones: Git y GitHub 
-Modelado UML: draw.io

Explicacion del Diagrama de Clases:
-Employee (Clase Abstracta): Es la clase base del sistema. Define los atributos comunes y declara los metodos abstractos, obligando a las clases hijas a definir el comportamiento y controla que no se metan salarios negativos.
-Developer, Manager, Designer (Clases Derivadas): Heredan de Employee e implementan la interfaz evaluable. Cada una implementa su propia forma de trabajar y el calculo de bonus.
-Evaluable (Interfaz): Define evaluatePerformance() que cada clase que la implementa la utiliza a su manera.

Instrucciones de Ejecución
Pasos
Clonar el repositorio
Abrir el proyecto
Localizar el codigo
Ejecutar, esta todo en el mismo archivo para solo entregarte un archivo al github
