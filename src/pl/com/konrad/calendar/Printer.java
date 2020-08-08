package pl.com.konrad.calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Printer {
//    WYDRUK:
//    1. data uzytkownika
//    2. dni tygodnia poza tablica
//    3. rysowanie tablicy

    private LocalDate date;
    private LocalDate[][] datesOfMonth;

    public Printer(LocalDate date, LocalDate[][] datesOfMonth) {
        this.date = date;
        this.datesOfMonth = datesOfMonth;
    }

    public void print() {
        printDayNames();
        System.out.println();
        for (int row = 0; row < datesOfMonth[0].length; row++) {
            printHorizontalLine();
            System.out.print("|");
            for (int col = 0; col < datesOfMonth.length; col++) {
                System.out.print(" " +"x" +" |");
            }
            System.out.println();
        }
        printHorizontalLine();
    }

    private void printHorizontalLine() {
        char minus = '-';
        System.out.print(minus);
        for (int i = 0; i < datesOfMonth.length; i++) {
            for (int j = 0; j <= 3; j++)
                System.out.print(minus);
        }
        System.out.println();
    }

    private void printDayNames() {
        System.out.print("|");
        for (int i = 1; i<=7; i++) {
            System.out.print(DayOfWeek.of(i).toString().substring(0,3) + "|");
        }
    }
}


