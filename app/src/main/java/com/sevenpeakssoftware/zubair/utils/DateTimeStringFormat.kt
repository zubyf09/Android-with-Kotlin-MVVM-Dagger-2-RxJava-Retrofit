//package prog
//
//import java.text.SimpleDateFormat
//import java.util.Calendar
//
//
//
//
//fun datetimeStringFormat() {
//
//    val today = Calendar.getInstance()
//
//    println(SimpleDateFormat().format( today.time ))
//    println(SimpleDateFormat("MMMM d, Y").format( today.time )) // month name  day, year
//    println(SimpleDateFormat("M / d / Y").format( today.time )) // month / day / year
//    println()
//    println(SimpleDateFormat("EEE").format( today.time )) // week day name abbreviated
//    println(SimpleDateFormat("EEEE").format( today.time )) // week day name
//    println()
//    println(SimpleDateFormat("H").format( today.time )) // Hour (24 hour clock)
//    println(SimpleDateFormat("h").format( today.time )) // Hour (12 hour clock)
//    println(SimpleDateFormat("a").format( today.time )) // AM or PM
//    println(SimpleDateFormat("H:m:s:SSS").format( today.time )) // Hour:Minute:Second:Microsecond
//}