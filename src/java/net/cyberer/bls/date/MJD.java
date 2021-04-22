package net.cyberer.bls.date;

import java.time.LocalDate;
import java.time.temporal.JulianFields;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MJD {
  public static void main(final String[] args) {
    System.out.println(getByLocalDate(2020, 4, 26));
  }

  public static long getByLocalDate(final int year, final int month, final int day) {
    // MJD = 0 -> 1858-11-17
    LocalDate date = LocalDate.of(year, month, day);
    return date.getLong(JulianFields.MODIFIED_JULIAN_DAY);
  }

  public static long getByCalendar(final int year, final int month, final int day) {
    Calendar cal = new GregorianCalendar(year, month, day);
    return 0;
  }

  // Epoch = 0 -> 1970-01-01
}
