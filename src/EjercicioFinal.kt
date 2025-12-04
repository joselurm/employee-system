// Definimos la clase base como abstracta para que no se pueda instanciar directamente.
abstract class Employee(val name: String, salaryInput: Double) {

    // Declaramos salary aqui para poder controlar si mete salario negativo
    var salary: Double = salaryInput
        set(value) {
            // Setter personalizado: se ejecuta cada vez que intentamos cambiar el sueldo
            if (value < 0) {
                println("Error: El salario no puede ser negativo. Se establece a 0.0")
                field = 0.0 //guardamos 0.0
            } else {
                field = value
            }
        }
    //obligan a los hijos a implementarlos
    abstract fun work()
    abstract fun calculateAnnualBonus(): Double

    // funciona igual para todos
    fun details() {
        println("Empleado: $name - Salario: $salary€")
    }
}
// no todos los empleados seran evaluables
interface Evaluable {
    fun evaluatePerformance()
}
// Developer hereda de Employee e implementa Evaluable
class Developer(name: String, salary: Double) : Employee(name, salary), Evaluable {
    override fun work() {
        println("$name esta escribiendo y revisando codigo.")
    }

    override fun calculateAnnualBonus(): Double {
        return salary * 0.10 // 10%
    }

    override fun evaluatePerformance() {
        println("Evaluacion: Codigo limpio y eficiente")
    }
}

// Manager hereda de Employee e implementa Evaluable
class Manager(name: String, salary: Double) : Employee(name, salary), Evaluable {
    override fun work() {
        println("$name esta supervisando al equipo")
    }

    override fun calculateAnnualBonus(): Double {
        return salary * 0.20 // 20%
    }

    override fun evaluatePerformance() {
        println("Evaluacion: Objetivos del equipo cumplidos")
    }
}

// Designer hereda de Employee e implementa Evaluable
class Designer(name: String, salary: Double) : Employee(name, salary), Evaluable {
    override fun work() {
        println("$name esta creando diseños visuales.")
    }

    override fun calculateAnnualBonus(): Double {
        return salary * 0.15 // 15%
    }

    override fun evaluatePerformance() {
        println("Evaluacion: Diseños creativos y funcionales")
    }
}
fun main() {
    //Creo la lista de objetos de tipo Employee, aqui se demuestra el polimorfismo,
    //cuando creamos una lista de empleados y metemos developer, manager y designer
    val empleados = listOf(
        Developer("Ana", 30000.0),
        Manager("Carlos", 50000.0),
        Designer("Elena", 35000.0)
    )

    println("SISTEMA DE GESTION DE EMPLEADOS")

    //Recorro la lista de empleados
    for (empleado in empleados) {

        // llamo a los metodos comunes y abstractos donde muestro los detalles, el trabajo que hacen y el total de su bonus
        empleado.details()
        empleado.work()

        //añadimos a la variable bonus el resultado de la funcion que lo calcula con el salario
        val bonus = empleado.calculateAnnualBonus()
        println("Bonus anual: $bonus€")

        //vemos si el empleado que estamos mostrando implementa la interfaz
        if (empleado is Evaluable) {
            empleado.evaluatePerformance()
        }
    }
}