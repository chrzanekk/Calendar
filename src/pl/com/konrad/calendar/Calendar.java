package pl.com.konrad.calendar;

import java.time.LocalDate;

public class Calendar {
    //    przerzucic do logiki
    private LocalDate[][] calendar = new LocalDate[7][6];
    private LocalDate date;

    public Calendar(LocalDate date) {
        this.date = date;
        CalendarLogic.setup(date, calendar);
    }


    public LocalDate[][] getCalendar() {
        return calendar;
    }
//    metoda getDate()

    public int getRowLength() {
        return calendar[0].length;
    }

    public int getColLength() {
        return calendar.length;
    }

}
