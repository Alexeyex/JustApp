import java.util.*

val sc = Scanner(System.`in`)
val seconds = sc.nextInt()
var endingMinutes: String = ""

fun main() {
    agoToText()
}

private fun agoToText() {
    when (seconds) {
        in 0..60 -> print("был(а) только что")
        in 61..60 * 60 -> choiceOfEndingMinutes()
        in (60 * 60) + 1..24 * 60 * 60 -> choiceOfEndingHours()
        in (24 * 60 * 60) + 1..48 * 60 * 60 -> print("был(а) сегодня")
        in (48 * 60 * 60) + 1..72 * 60 * 60 -> print("был(а) вчера")
        else -> print("был(а) давно")
    }
}

private fun choiceOfEndingMinutes() {
    val m = (seconds / 60).toString().split("")

    when (true) {
        (m[m.size - 2] == "2" || m[m.size - 2] == "3" || m[m.size - 2] == "4" || m[m.size - 2] == "1") && m[m.size - 3] == "1" -> endingMinutes =
            "был(а) ${seconds / 60} минут назад"
        m[m.size - 2] == "1" -> endingMinutes = "был(а) ${seconds / 60} минуту назад"
        m[m.size - 2] == "2" || m[m.size - 2] == "3" || m[m.size - 2] == "4" -> endingMinutes =
            "был(а) ${seconds / 60} минуты назад"
        (m[m.size - 2] == "2" || m[m.size - 2] == "3" || m[m.size - 2] == "4") && (m[m.size - 3] == "1") -> endingMinutes =
            "был(а) ${seconds / 60} минуты назад"
        else -> endingMinutes = "был(а) ${seconds / 60} минут назад"
    }
    print(endingMinutes)
}

private fun choiceOfEndingHours() {
    val m = (seconds / 3600).toString().split("")

    when (true) {
        m[m.size - 2] == "1" && m[m.size - 3] == "1" -> endingMinutes = "был(а) ${seconds / 3600} часов назад"
        m[m.size - 2] == "1" -> endingMinutes = "был(а) ${seconds / 3600} час назад"
        m[m.size - 2] == "2" || m[m.size - 2] == "3" || m[m.size - 2] == "4" -> endingMinutes =
            "был(а) ${seconds / 3600} часа назад"
        else -> endingMinutes = "был(а) ${seconds / 3600} часов назад"
    }
    print(endingMinutes)
}