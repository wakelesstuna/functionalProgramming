package InlämningsUppgiftVG

import java.io.File

fun makeStringList (fileName: String) = File(fileName).readLines()

fun makeMap(): MutableMap<String, MutableList<String>> {
    val listOfInput = makeStringList("src/InlämningsUppgiftVG/santaClausHierarchy.txt")

    val mapperino: MutableMap<String, MutableList<String>> = mutableMapOf()

    for (i in listOfInput){
        var splitLine = i.split(" ")
        val key = splitLine[0]
        splitLine = splitLine.drop(1)
        mapperino[key] = splitLine as MutableList<String>
    }
    return mapperino
}

val mapperino = makeMap()
fun addSubBossToList(name: String): List<String> {
    val temp: MutableList<String> = mutableListOf()
    return when {
        mapperino.containsKey(name) -> {
            for (i in mapperino.getValue(name).toCollection(mutableListOf())){
                temp.add(i)
                addSubBossToList(i).forEach { e -> temp.add(e) }
            }
            temp
        }
        else -> {
            temp
        }
    }
}

fun main() {
    val temp = addSubBossToList("Glader")
    temp.forEach { s -> println(s) }
}