package com.pypl.kotlintraining

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.intellij.lang.annotations.Language

class CollectionActivity : AppCompatActivity() {

    private val TAG = "Collections"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collection)

        log("Activity started")
        pairs()
        triples()
        array()
        list()
        set()
        map()
        manipulation()
    }

    data class Language(var lang: String, var city: String = "")

    private fun manipulation() {
        val kotlin = Language("kotlin")
        val java = Language("java")
        java.city = "San Francisco"
        val php = Language("php")
        val scala = Language("scala")
        scala.city = "New York"
        val javascript = Language("javascript")
        val languageList = listOf(kotlin, java, php, scala, javascript)

        log(languageList.count())
        log(languageList.maxBy { it.lang.length })
        log(languageList.minBy { it.lang.length })
    }

    private fun map() {
        val dessert = hashMapOf("whipped cream" to "cake", "chocolate" to "cookie")
        log(dessert["chocolate"])
        if (dessert.isNotEmpty()) {
            log("dessert size is: ${dessert.size}")
        }

        log(dessert.containsKey("chocolate"))

        log(dessert.containsValue("cake"))

        log(dessert.contains("chocolate"))
        log("chocolate" in dessert)

        val inventory = mutableMapOf("pancake" to 1)
        inventory.put("cake", 3)
        inventory.remove("pancake")
        if (inventory.isNotEmpty()) {
            log("inventory size is ${inventory.size}")
        }
    }

    private fun set() {
        val color = setOf("red", "blue", "yellow", "white")
        val list = listOf("red", "blue")
        val result = color.containsAll(list)
        log(result)

        val mutableColor = mutableSetOf("red", "blue", "yellow")
        mutableColor.add("pink")
        val iterator = mutableColor.iterator()
        while (iterator.hasNext()) {
            log(iterator.next())
        }
    }

    private fun array() {
        val intArray = arrayOf(1, 2, 3, 4)
        val strArray = arrayOf("One", "Two", "Three")
        val charArray = arrayOf('a', 'b', 'c', 'd')

        val ids = IntArray(5)

        val numbers = intArrayOf(1, 2, 3, 4)
        val chrs = charArrayOf('a', 'b', 'c', 'd')
        val programmingLang = arrayOf("C", "Java", "Kotlin", "Python")
        log(programmingLang::class)
        log(programmingLang.javaClass)
        log("${programmingLang[0]} and ${programmingLang[1]}")
        log(programmingLang.get(3))
        log(programmingLang.size)

        for (element in strArray) {
            log(element)
        }

        ids[0] = 10
        ids[1] = 20
        ids.set(2, 30)
        ids.set(3, 40)
        for (element in ids) {
            log(element)
        }

        val array = arrayOf(1, "Hello", 'd', 9.99)
        for (el in array) {
            log(el)
        }

        log(array.contains(2))
        log(array.contains('d'))

        val nullArray = arrayOfNulls<String>(5)
        nullArray.set(0, "learn")
        nullArray.set(3, "kotlin")

        for (el in nullArray) {
            log(el)
        }
    }

    private fun list() {
        val numberList = listOf("one", "two", "three")
        val mutableNumberList = mutableListOf("one", "two", "three")

        mutableNumberList.add("five")

        log(listOf(1, 5, 4).sum())
        log(listOf("one", "two", "three").sumBy { it.length })

        val numberList2 = numberList + "four"
        log(numberList2)
        val numberList3 = numberList - "two"
        log(numberList3)

        log(numberList3::class)
        log(numberList3.javaClass)

        val nullList = listOfNotNull(32, null, "one", null, 'd')
        log(nullList.size)
        for (e in nullList) {
            log(e)
        }
    }

    private fun triples() {
        val kotlinVersions = Triple(1.1, 1.2, 1.3)
        val firstKotlinVersion = kotlinVersions.first
        val secondKotlinVersion = kotlinVersions.second
        val thirdKotlinVersion = kotlinVersions.third

        val book = Triple(1234, "Learn kotlin", 50)
        val (isbn, title, price) = book
        log("ISBN: ${book.first}, Title: ${book.second}, Price: ${book.third}")
    }

    private fun pairs() {
        val testName = "Kotlin Test"
        val grade = 10
        val resultTest = Pair(grade, testName)
        log(resultTest.toString())

        val book = Pair("Lear kotlin", 20)
        val (title, price) = book
        log("Title = ${book.first}, Price = ${book.second}")

        val yellowScarf = "yellow" to "Scarf"
        log(yellowScarf.first)
        log(yellowScarf.second)

        val clothes = ("yellow" to "Scarf") to ("blue" to "blouse")
        log(clothes.second.first)
    }


    private fun log(msg: Any?) {
        Logger.log(TAG, msg.toString())
    }


}
