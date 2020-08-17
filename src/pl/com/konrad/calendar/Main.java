package pl.com.konrad.calendar;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LocalDate date = getDate();

        Calendar calendar = new Calendar(date);
        Printer printer = new Printer(date, calendar);

        printer.print();

    }

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
}
