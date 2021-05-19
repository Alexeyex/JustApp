import java.util.*

val sc = Scanner(System.`in`)
val seconds = sc.nextInt()
val min = seconds/60
val hour = seconds/3600
val m = min.toString().split("")
val i:String = m[m.size - 2]
val j:String = m[m.size - 3]

fun main() {
    agoToText()
}

private fun agoToText() {
    when (seconds) {
        in 0..60 -> print("был(а) только что")
        in 61..60 * 60 -> print("был(а) ${choiceOfEndingMinutes()} назад")
        in (60 * 60) + 1..24 * 60 * 60 -> print("был(а) ${choiceOfEndingHours()} назад")
        in (24 * 60 * 60) + 1..48 * 60 * 60 -> print("был(а) сегодня")
        in (48 * 60 * 60) + 1..72 * 60 * 60 -> print("был(а) вчера")
        else -> print("был(а) давно")
    }
}

private fun choiceOfEndingMinutes(): String {

    return when {
        (i == "2" || i == "3" || i == "4" || i == "1") && j == "1" -> "$min минут"
        i == "1" -> "$min минуту"
        i == "2" || i == "3" || i == "4" -> "$min минуты"
        (i == "2" || i == "3" || i == "4") && (j == "1") -> "$min минуты"
        else -> "$min минут"
    }
}

private fun choiceOfEndingHours(): String {

    return when {
        i == "1" && j == "1" -> "$hour часов"
        i == "1" -> "$hour час"
        i == "2" || i == "3" || j == "4" -> "$hour часа"
        else -> "$hour часов"
    }
}