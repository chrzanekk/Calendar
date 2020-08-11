package pl.com.konrad.calendar;

import java.time.LocalDate;

public class Calendar {
    private LocalDate[][] calendar = new LocalDate[7][6];

    public Calendar(LocalDate date) {
        this.date = date;
    }

    private LocalDate date;

    public LocalDate[][] getCalendar() {
        return calendar;
    }

    public void setup() {
        LocalDate beginningDate = CalendarLogic.getBeginningDate(date).minusDays(1);
        for (int row = 0; row < calendar[0].length; row++) {
            for (int col = 0; col < calendar.length; col++) {
                beginningDate = beginningDate.plusDays(1);
                calendar[col][row] = beginningDate;
                }
        }
    }
}
