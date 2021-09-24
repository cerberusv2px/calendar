import java.text.SimpleDateFormat
import java.util.*
import java.util.Calendar

// fun main() {
//    val calendar = Calendar.getInstance()
//    calendar.set(Calendar.MONTH, 3)
//    calendar.set(Calendar.DAY_OF_MONTH, 3)
//    val maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
//    //val df = SimpleDateFormat("yyyy-MM-dd EEE")
//    val df = SimpleDateFormat("MMM yyyy")
//    println(df.format(calendar.time))
//    for (i in 1..maxDay) {
//        calendar.set(Calendar.DAY_OF_MONTH, i)
//        println(df.format(calendar.time))
//    }
// }

fun main() {
    val calendar = Calendar.getInstance()
    val currentDate = getCurrentDate()
    val currentMonth = formatDate(currentDate, "yyyy-MM-dd", "MMMM")
    val currentMonthIndex = calendar.get(Calendar.MONTH)

    // print("$currentMonth\t Index:\t$currentMonthIndex")
    // getNextMonth(calendar, currentMonthIndex)
    // getPreviousMonth(calendar, currentMonthIndex)
    // getAllDateOfCurrentMonth(calendar)

    // print(getCurrentYear())
    // checkNextYear(calendar)
    // checkPreviousYear(calendar)


    getAllBetweenDates("2019-07-04","2019-07-06")
}

private fun getNextMonth(calendar: Calendar, currentMonthIndex: Int) {
    calendar.apply {
        set(Calendar.MONTH, (currentMonthIndex + 1))
        set(Calendar.DAY_OF_MONTH, 1)
    }
    val currentDate = getFirstDateOfMonth(calendar)
    val currentMonth = formatDate(currentDate, "yyyy-MM-dd", "MMMM")
    val nextMonthIndex = calendar.get(Calendar.MONTH)
    print("$currentMonth\t Index:\t$nextMonthIndex \tCurrent Date: $currentDate")
}

private fun getPreviousMonth(calendar: Calendar, currentMonthIndex: Int) {
    calendar.apply {
        set(Calendar.MONTH, (currentMonthIndex - 1))
        set(Calendar.DAY_OF_MONTH, 1)
    }
    val currentDate = getFirstDateOfMonth(calendar)
    val currentMonth = formatDate(currentDate, "yyyy-MM-dd", "MMMM")
    val prevMonthIndex = calendar.get(Calendar.MONTH)
    print("$currentMonth\t Index:\t$prevMonthIndex \tCurrent Date: $currentDate")
}

private fun getAllDateOfCurrentMonth(calendar: Calendar) {
    val maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
    val df = SimpleDateFormat("dd E")
    for (i in 0 until maxDay) {
        calendar.set(Calendar.DAY_OF_MONTH, i + 1)
        println(df.format(calendar.time))
    }
}

private fun getCurrentYear(): String {
    val currentDate = getCurrentDate()
    val currentYear = formatDate(currentDate, "yyyy-MM-dd", "yyyy")
    return currentYear
}

/**
 * used to check if current month is 12 and handle usecase when user presses next
 * eg. current month is Dec,2019..so when user press next,, get Jan.2020
 */

private fun checkNextYear(calendar: Calendar) {
    calendar.apply {
        set(Calendar.MONTH, 11)
        set(Calendar.DAY_OF_MONTH, 1)
    }
    val currentYear = getCurrentYear().toInt()
    val currentMonthIndex = calendar.get(Calendar.MONTH)
    println(currentMonthIndex)
    if (currentMonthIndex == 11) {
        calendar.apply {
            set(Calendar.MONTH, 0)
            set(Calendar.DAY_OF_MONTH, 1)
            set(Calendar.YEAR, currentYear + 1)
        }
        println(formatDate(getCurrentDate(calendar), "yyyy-MM-dd", "yyyy-MM-dd"))
    }
}

private fun checkPreviousYear(calendar: Calendar) {
    calendar.apply {
        set(Calendar.MONTH, 0)
        set(Calendar.DAY_OF_MONTH, 1)
    }
    val currentYear = getCurrentYear().toInt()
    val currentMonthIndex = calendar.get(Calendar.MONTH)
    println(currentMonthIndex)
    if (currentMonthIndex == 0) {
        calendar.apply {
            set(Calendar.MONTH, 11)
            set(Calendar.DAY_OF_MONTH, 1)
            set(Calendar.YEAR, currentYear - 1)
        }
        println(formatDate(getCurrentDate(calendar), "yyyy-MM-dd", "yyyy-MM-dd"))
    }
}


private fun getAllBetweenDates(startDate: String, endDate: String) {
    val startCalendar = Calendar.getInstance()
    startCalendar.time = SimpleDateFormat("yyyy-MM-dd").parse(startDate)

    val endCalendar = Calendar.getInstance()
    endCalendar.time = SimpleDateFormat("yyyy-MM-dd").parse(endDate)

    val df = SimpleDateFormat("yyyy-MM-dd",Locale.US)
    val betweenDates = mutableListOf<String>()
    while(startCalendar.before(endCalendar)) {
        val result = startCalendar.time
        startCalendar.add(Calendar.DATE,1)
        betweenDates.add(df.format(result))
        // println(df.format(result))

    }
    betweenDates.add(endDate)

    //betweenDates.removeAt(0)
    //betweenDates.removeAt(betweenDates.size - 1)
    println(betweenDates)


}

//date day event: bool type: string? startdate: String enddate: String
