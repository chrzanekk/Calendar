package pl.com.konrad.calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Calendar {
    private LocalDate[][] calendar = new LocalDate[7][6];

    public Calendar(LocalDate date) {
        this.date = date;
    }

    private LocalDate date;

    public LocalDate[][] getCalendar() {
        return calendar;
    }

    public void setup() {
        for (int row = 0; row < calendar[0].length; row++) {
            for (int col = 0; col < calendar.length; col++) {

            }
        }
    }


//    określić dzień tygodnia
//    określić kolumne pierwszego dnia miesiaca oraz najwcześniejszy dzień poprzedniego miesiąca (lewy górny róg)
//    wypełnić tablice
}
