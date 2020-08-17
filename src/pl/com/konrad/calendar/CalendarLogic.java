package pl.com.konrad.calendar;

import java.time.LocalDate;

public class CalendarLogic {

    public static void setup(LocalDate date,LocalDate[][] calendar) {
        LocalDate beginningDate = CalendarLogic.getBeginningDate(date).minusDays(1);
        for (int row = 0; row < calendar[0].length; row++) {
            for (int col = 0; col < calendar.length; col++) {
                beginningDate = beginningDate.plusDays(1);
                calendar[col][row] = beginningDate;
            }
        }
    }

    public static LocalDate getBeginningDate(LocalDate date) {
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
