package pl.com.konrad.calendar;

import java.time.LocalDate;

public class Calendar {

    private LocalDate date;
    private LocalDate[][] calendar;

    public Calendar(LocalDate date) {
        this.date = date;
        CalendarLogic calendarLogic = new CalendarLogic(date);
        calendar = calendarLogic.setup();
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalDate[][] getCalendar() {
        return calendar;
    }
    public int getRowLength() {
        return calendar[0].length;
    }

    public int getColLength() {
        return calendar.length;
    }
}
