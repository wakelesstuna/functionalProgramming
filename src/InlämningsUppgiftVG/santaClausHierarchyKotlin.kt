package InlämningsUppgiftVG

import java.io.File

val listOfInput = File("src/InlämningsUppgiftVG/santaClausHierarchy.txt").readLines()
fun makeMap(): Map<String, List<String>> = listOfInput.map { e -> e.split(" ") }.associate { e -> e[0] to e.drop(1) }

val mapperino = makeMap()
fun addSubBosses(name: String): List<String> {
    val temp: MutableList<String> = mutableListOf()
    return when {
        mapperino.containsKey(name) -> {
            mapperino.getValue(name)
                    .forEach { e -> temp.add(e); addSubBosses(e).forEach { v -> temp.add(v) }; }
            temp
        }
        else -> temp
    }
}

fun main() {
   val temp = addSubBosses("Skumtomten")
    temp.forEach { s -> println(s) }
}