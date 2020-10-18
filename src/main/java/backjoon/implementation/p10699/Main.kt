package backjoon.implementation.p10699

import java.io.*
import java.time.LocalDate
import java.util.*

fun main(args: Array<String>) {
    printDate();
}

fun printDate() {
    print(LocalDate.now());
}

internal class InputReader {
    private var br: BufferedReader? = null

    constructor() {
        br = BufferedReader(InputStreamReader(System.`in`))
    }

    constructor(filepath: String?) {
        try {
            br = BufferedReader(FileReader(filepath))
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
    }

    @Throws(IOException::class)
    fun readLineIntoCharList(): List<Char> {
        val l: MutableList<Char> = ArrayList()
        while (true) {
            val readVal = br!!.read()
            if (readVal == '\n'.toInt() || readVal == -1) break
            l.add(readVal.toChar())
        }
        return l
    }

    @Throws(IOException::class)
    fun ready(): Boolean {
        return br!!.ready()
    }

    @Throws(IOException::class)
    fun readLine(): String {
        return br!!.readLine()
    }

    @Throws(IOException::class)
    fun readInt(): Int {
        return readLine().toInt()
    }

    @Throws(IOException::class)
    fun readLong(): Long {
        return readLine().toLong()
    }
}