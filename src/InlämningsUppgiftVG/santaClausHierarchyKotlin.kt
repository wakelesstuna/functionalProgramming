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
                    .forEach { e -> temp.add(e); addSubBosses(e).forEach { temp.add(it) }; }
            temp
        }
        else -> temp
    }
}

fun addBosses(name: String): List<String> {
    val temp: MutableList<String> = mutableListOf()
    mapperino.forEach { (k, v) -> v.forEach { n -> if (n == name) { temp.add(k); addBosses(k).forEach{temp.add(it)}}}}
    return temp
}

fun main() {
    println("---Subbosses---")
    val subBosses = addSubBosses("Tomten")
    subBosses.forEach { println(it) }

    println("\n---Bosses---")
    val bosses = addBosses("Bladlusen").reversed()
    bosses.forEach { println(it) }
}

