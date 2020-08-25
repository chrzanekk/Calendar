package pl.com.konrad.calendar;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calendar calendar = new Calendar(getDate());
        Printer printer = new Printer(calendar);
        printer.print();

    }

    public static LocalDate getDate() {
        Scanner scanner = new Scanner(System.in);
        LocalDate date = null;
        boolean isDateCorrect = false;
        while (!isDateCorrect) {
            System.out.println("Podaj datę w formacie (dd-mm-RRRR): ");
            String userDate = scanner.nextLine();
            try {
                date = LocalDate.parse(userDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                isDateCorrect = true;
            } catch (DateTimeParseException e) {
                System.out.println("Zły format daty.");
            }
        }
        return date;
    }
}
