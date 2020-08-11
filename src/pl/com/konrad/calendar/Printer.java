package pl.com.konrad.calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Printer {
//    WYDRUK:
//    1. data uzytkownika
//    2. dni tygodnia poza tablica
//    3. rysowanie tablicy

    private LocalDate date;
    private LocalDate[][] datesOfMonth;
    private Locale locale = new Locale("pl", "PL");

    public Printer(LocalDate date, LocalDate[][] datesOfMonth) {
        this.date = date;
        this.datesOfMonth = datesOfMonth;
    }

    public void print() {
        printDate();
        System.out.println();
//        printMonthYear();
//        System.out.println();
        printDayNames();
        System.out.println();
        for (int row = 0; row < datesOfMonth[0].length; row++) {
            printHorizontalLine();
            System.out.print("|");
            for (LocalDate[] localDates : datesOfMonth) {
                if (localDates[row].getDayOfMonth() < 10 && !localDates[row].equals(date) && localDates[row].getMonthValue() < date.getMonthValue()) {
                    System.out.print(" (" + localDates[row].getDayOfMonth() + ")|");
                } else if (localDates[row].getDayOfMonth() < 10 && !localDates[row].equals(date) && localDates[row].getMonthValue() > date.getMonthValue()) {
                    System.out.print("[" + localDates[row].getDayOfMonth() + "] |");
                } else if (localDates[row].getDayOfMonth() >= 10 && !localDates[row].equals(date) && localDates[row].getMonthValue() < date.getMonthValue()) {
                    System.out.print("(" + localDates[row].getDayOfMonth() + ")|");
                } else if (localDates[row].getDayOfMonth() >= 10 && !localDates[row].equals(date) && localDates[row].getMonthValue() > date.getMonthValue()) {
                    System.out.print("[" + localDates[row].getDayOfMonth() + "]|");
                } else if (localDates[row].getDayOfMonth() >= 10 && !localDates[row].equals(date) && localDates[row].getMonthValue() == date.getMonthValue()) {
                    System.out.print(" " + localDates[row].getDayOfMonth() + " |");
                } else if (localDates[row].getDayOfMonth() < 10 && localDates[row].equals(date) && localDates[row].getMonthValue() == date.getMonthValue()) {
                    System.out.print(" " + localDates[row].getDayOfMonth() + "* |");
                } else if (localDates[row].getDayOfMonth() >= 10 && localDates[row].equals(date) && localDates[row].getMonthValue() == date.getMonthValue()) {
                    System.out.print(" " + localDates[row].getDayOfMonth() + "*|");
                } else {
                    System.out.print(" " + localDates[row].getDayOfMonth() + "  |");
                }
            }
            System.out.println();
        }
        printHorizontalLine();
    }

    private void printHorizontalLine() {
        char minus = '-';
        System.out.print(minus);
        for (int i = 0; i < datesOfMonth.length; i++) {
            for (int j = 0; j <= 4; j++)
                System.out.print(minus);
        }
        System.out.println();
    }

    private void printDayNames() {
        System.out.print("|");
        for (int i = 1; i <= 7; i++) {
            System.out.print(DayOfWeek.of(i).getDisplayName(TextStyle.FULL, locale).substring(0, 3) + ".|");
        }
    }

    private void printDate() {
        System.out.print(date.getDayOfWeek().getDisplayName(TextStyle.FULL, locale) + ", " + date.getDayOfMonth() + " " + date.getMonth().getDisplayName(TextStyle.FULL, locale) +
                " " + date.getYear());
    }

    private void printMonthYear() {
        System.out.print(date.getMonth().getDisplayName(TextStyle.FULL,locale) + " "+ date.getYear());
    }
}


