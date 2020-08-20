package pl.com.konrad.calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Printer {
    private Calendar calendar;
    private Locale locale = new Locale("pl", "PL");

    public Printer(Calendar calendar) {
        this.calendar = calendar;
    }

    public void print() {
        printDate();
        System.out.println();
        printDayNames();
        System.out.println();
        printDaysOfMonth();
        printHorizontalLine();
    }

    private void printDaysOfMonth() {
        for (int row = 0; row < calendar.getRowLength(); row++) {
            printHorizontalLine();
            System.out.print("|");
            for (int col = 0; col < calendar.getColLength(); col++) {
                if (calendar.getCalendar()[col][row].getDayOfMonth() < 10 && !calendar.getCalendar()[col][row].equals(calendar.getDate()) && calendar.getCalendar()[col][row].getMonthValue() < calendar.getDate().getMonthValue()) {
                    System.out.print(" (" + calendar.getCalendar()[col][row].getDayOfMonth() + ")|");
                } else if (calendar.getCalendar()[col][row].getDayOfMonth() < 10 && !calendar.getCalendar()[col][row].equals(calendar.getDate()) && calendar.getCalendar()[col][row].getMonthValue() > calendar.getDate().getMonthValue()) {
                    System.out.print("[" + calendar.getCalendar()[col][row].getDayOfMonth() + "] |");
                } else if (calendar.getCalendar()[col][row].getDayOfMonth() >= 10 && !calendar.getCalendar()[col][row].equals(calendar.getDate()) && calendar.getCalendar()[col][row].getMonthValue() < calendar.getDate().getMonthValue()) {
                    System.out.print("(" + calendar.getCalendar()[col][row].getDayOfMonth() + ")|");
                } else if (calendar.getCalendar()[col][row].getDayOfMonth() >= 10 && !calendar.getCalendar()[col][row].equals(calendar.getDate()) && calendar.getCalendar()[col][row].getMonthValue() > calendar.getDate().getMonthValue()) {
                    System.out.print("[" + calendar.getCalendar()[col][row].getDayOfMonth() + "]|");
                } else if (calendar.getCalendar()[col][row].getDayOfMonth() >= 10 && !calendar.getCalendar()[col][row].equals(calendar.getDate()) && calendar.getCalendar()[col][row].getMonthValue() == calendar.getDate().getMonthValue()) {
                    System.out.print(" " + calendar.getCalendar()[col][row].getDayOfMonth() + " |");
                } else if (calendar.getCalendar()[col][row].getDayOfMonth() < 10 && calendar.getCalendar()[col][row].equals(calendar.getDate()) && calendar.getCalendar()[col][row].getMonthValue() == calendar.getDate().getMonthValue()) {
                    System.out.print(" " + calendar.getCalendar()[col][row].getDayOfMonth() + "* |");
                } else if (calendar.getCalendar()[col][row].getDayOfMonth() >= 10 && calendar.getCalendar()[col][row].equals(calendar.getDate()) && calendar.getCalendar()[col][row].getMonthValue() == calendar.getDate().getMonthValue()) {
                    System.out.print(" " + calendar.getCalendar()[col][row].getDayOfMonth() + "*|");
                } else {
                    System.out.print(" " + calendar.getCalendar()[col][row].getDayOfMonth() + "  |");
                }
            }
            System.out.println();
        }
    }

    private void printHorizontalLine() {
        char minus = '-';
        System.out.print(minus);
        for (int i = 0; i < calendar.getCalendar().length; i++) {
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
        LocalDate date = calendar.getDate();
        System.out.print(date.getDayOfWeek().getDisplayName(TextStyle.FULL, locale) + ", " + date.getDayOfMonth() + " " + date.getMonth().getDisplayName(TextStyle.FULL, locale) +
                " " + date.getYear());
    }
}


