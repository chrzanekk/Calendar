package pl.com.konrad.calendar;

import java.time.LocalDate;

public class CalendarLogic {
    public static int getColIndexOfDate(LocalDate date) {
        return date.getDayOfWeek().getValue() - 1;
    }

    public static int getColIndexOfFirstDay(LocalDate date) {
        return getColIndexOfDate(getFirstDayOfCurrentMonth(date));
    }

    public static LocalDate getFirstDayOfCurrentMonth(LocalDate date) {
        return date.minusDays(date.getDayOfMonth() - 1);
    }

    public static LocalDate getBeginningDate(LocalDate date) {
        LocalDate beginningDate = getFirstDayOfCurrentMonth(date).minusDays(getColIndexOfFirstDay(date));
        return beginningDate;
    }
}
