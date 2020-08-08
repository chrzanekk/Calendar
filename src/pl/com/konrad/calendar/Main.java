package pl.com.konrad.calendar;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calendar calendar = new Calendar();
        LocalDate date = getDate();

        Printer printer = new Printer(date,calendar.getCalendar());
        printer.print();
        System.out.println("Index of column of user input date");
        System.out.println(getColIndexOfUserInput(date));
        System.out.println("Index of column of first day of month");
        System.out.println(getColIndexOfFirstDay(date));

    }
    public static LocalDate getDate() {
        Scanner scanner = new Scanner(System.in);
        LocalDate date = null;

            System.out.println("Podaj datę w formacie (dd-mm-RRRR): ");
            String userDate = scanner.nextLine();
            try {
                date = LocalDate.parse(userDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            } catch (DateTimeParseException e) {
                System.out.println("Zły format daty.");

            }

        return date;
    }
    public static int getColIndexOfUserInput(LocalDate date) {
        return date.getDayOfWeek().getValue()-1;
    }

    public static int getColIndexOfFirstDay (LocalDate date) {
        return getColIndexOfUserInput(date)-1;
    }







}
