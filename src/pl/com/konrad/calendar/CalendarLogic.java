package pl.com.konrad.calendar;

import java.time.LocalDate;

public class CalendarLogic {
    private final LocalDate date;
    private LocalDate[][] calendar = new LocalDate[7][6];

    public CalendarLogic(LocalDate date) {
        this.date = date;
    }



    public LocalDate[][] setup() {
        LocalDate beginningDate = CalendarLogic.getBeginningDate(date).minusDays(1);
        for (int row = 0; row < calendar[0].length; row++) {
            for (int col = 0; col < calendar.length; col++) {
                beginningDate = beginningDate.plusDays(1);
                calendar[col][row] = beginningDate;
            }
        }
        return calendar;
    }

    private static LocalDate getBeginningDate(LocalDate date) {
        return getFirstDayOfCurrentMonth(date).minusDays(getColIndexOfFirstDay(date));
    }

    private static int getColIndexOfDate(LocalDate date) {
        return date.getDayOfWeek().getValue() - 1;
    }

    private static int getColIndexOfFirstDay(LocalDate date) {
        return getColIndexOfDate(getFirstDayOfCurrentMonth(date));
    }

    private static LocalDate getFirstDayOfCurrentMonth(LocalDate date) {
        return date.minusDays(date.getDayOfMonth() - 1);
    }


}
