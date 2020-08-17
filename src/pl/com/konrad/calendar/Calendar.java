package pl.com.konrad.calendar;

import java.time.LocalDate;

public class Calendar {
    private LocalDate[][] calendar = new LocalDate[7][6];

    public Calendar(LocalDate date) {
        this.date = date;
        CalendarLogic.setup(date, calendar);
    }

    private LocalDate date;

    public LocalDate[][] getCalendar() {
        return calendar;
    }

    public int getRowLength() {
        return calendar[0].length;
    }

    public  int getColLength() {
        return calendar.length;
    }

}
