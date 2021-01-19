package InlämningsUppgiftVG

import java.io.File

val listOfInput = File("src/InlämningsUppgiftVG/santaClausHierarchy.txt").readLines()
fun makeMap(): Map<String, List<String>> = listOfInput.map { e -> e.split(" ") }.associate { e -> e[0] to e.drop(1) }

val mapperino = makeMap()

fun addSubBosses(name: String): List<String> = if (mapperino.containsKey(name)) mapperino.getValue(name).map { e -> (addSubBosses(e) + e).map { it } }.flatten() else emptyList()

fun addBosses(name: String): List<String> = mapperino.map { (k, v) -> if (v.contains(name)) { (addBosses(k) + k).map { it } } else emptyList()}.flatten()

fun main() {
    println("---Subbosses---")
    addSubBosses("Tomten").forEach { println(it) }

    println("\n---Bosses---")
    addBosses("Bladlusen").forEach { println(it) }
}

