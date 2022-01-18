package Inlämningsuppgift2

import java.io.File


/*
Tomtarna på Nordpolen har en strikt chefs-hierarki
Högsta chefen för allt är "Tomten"
Under "Tomten" jobbar "Glader" och "Butter"
Under "Glader" jobbar "Tröger", "Trötter"och "Blyger"
Under "Butter" jobbar "Rådjuret", "Nyckelpigan", "Haren" och "Räven"
Under "Trötter" jobbar "Skumtomten"
Under "Skumtomten" jobbar "Dammråttan"
Under "Räven" jobbar "Gråsuggan" och "Myran"
Under "Myran" jobbar "Bladlusen"
Er uppgift är att illustrera tomtens arbetshierarki i en lämplig datastruktur.
(Det finns flera tänkbara datastrukturer här)
Skriv sedan en funktion där man anger ett namn på tomten eller någon av hens underhuggare som
inparameter.
Funktionen listar sedan namnen på alla underlydandesom en given person har
Expempel: Du anger "Trötter" och får som svar ["Skumtomten", "Dammråttan"]"
För att bli godkänd på uppgiften måste du använda rekursion.
 */

class Tomteland {

    var listOfUnderlings: HashMap<String, List<String>> = HashMap()

    init {
        initiateHashMap()
        println(listOfUnderlings)
    }

    fun initiateHashMap() {
        File("Tomt.txt").forEachLine { s ->
            run {
                var ess = s.split(" ")
                listOfUnderlings[ess[0]] = ess.subList(1, ess.size)
            }
        }
    }

    //TODO: skapa en datastruktur för att lagra tomtarna och deras relationer i

    // current namn är den tomte vars underlydande ni vill ta fram
    //res är listan som håller alla underlydande
    fun getUnderlings(currentName: String, res: MutableList<String>): List<String> {
        //TODO, skriv denna metod, glöm inte att den ska vara rekursiv!


        if (listOfUnderlings.containsKey(currentName)) {
            for (i in listOfUnderlings.get(currentName)!!) {
                res.add(i)
                res += getUnderlings(i, arrayListOf())
            }
        }
        return res
    }

}

fun main() {

    //Exempel på anrop till den rekursiva funktionen getUnderlings,
    // här är tanken att hitta Gladers underlydande
    //listan fylls på successivt när vi rekurserar

    var list: MutableList<String> = mutableListOf()

    val tomtLand = Tomteland()
    println(tomtLand.getUnderlings("Tomten", list))

}