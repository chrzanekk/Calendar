package pl.com.konrad.calendar;


import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate date = CalendarLogic.getDate();
        Calendar calendar = new Calendar(date);

        Printer printer = new Printer(date, calendar.getCalendar());
        printer.print();
    }
}
