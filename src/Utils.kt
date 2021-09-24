import java.text.SimpleDateFormat
import java.util.*

fun getCurrentDate(): String {
    val cal = Calendar.getInstance()
    cal.add(Calendar.DATE, 0)
    val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return simpleDateFormat.format(cal.time)
}


fun formatDate(inputDate: String, inputFormat: String, outputFormat: String): String {
    val outputDateFormat = SimpleDateFormat(outputFormat, Locale.getDefault())
    val inputDateFormat = SimpleDateFormat(inputFormat, Locale.getDefault())
    val date = inputDateFormat.parse(inputDate)
    return outputDateFormat.format(date)
}

fun getFirstDateOfMonth(calendar: Calendar): String {
    calendar.add(Calendar.DATE, 0)
    val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return simpleDateFormat.format(calendar.time)
}

fun getCurrentDate(cal: Calendar): String {
    cal.add(Calendar.DATE, 0)
    val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return simpleDateFormat.format(cal.time)
}
