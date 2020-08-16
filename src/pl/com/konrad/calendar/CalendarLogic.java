package pl.com.konrad.calendar;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CalendarLogic {
    //    to wyjebac z logiki do maina
    public static LocalDate getDate() {
        Scanner scanner = new Scanner(System.in);
        LocalDate date;

        System.out.println("Podaj datę w formacie (dd-mm-RRRR): ");
        String userDate = scanner.nextLine();
        try {
            date = LocalDate.parse(userDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        } catch (DateTimeParseException e) {
            System.out.println("Zły format daty.");
            date = getDate();
        }
        return date;
    }

    //prywatna
    public static int getColIndexOfDate(LocalDate date) {
        return date.getDayOfWeek().getValue() - 1;
    }

    //prywatna
    public static int getColIndexOfFirstDay(LocalDate date) {
        return getColIndexOfDate(getFirstDayOfCurrentMonth(date));
    }

    //prywatna
    public static LocalDate getFirstDayOfCurrentMonth(LocalDate date) {
        return date.minusDays(date.getDayOfMonth() - 1);
    }

    //publiczna
    public static LocalDate getBeginningDate(LocalDate date) {
        return getFirstDayOfCurrentMonth(date).minusDays(getColIndexOfFirstDay(date));
    }
}
