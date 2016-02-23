package com.spamalot.LaTeXYearCalendar;

import org.joda.time.DateTime;

import java.util.Locale;

/**
 * Hello world.
 *
 */
public final class App {
  /**
   * Construct nothing.
   */
  private App() {
  }

  /**
   * Do all the things.
   * 
   * @param args
   *          The arguments to the program
   */
  public static void main(final String[] args) {
    System.out.println("Hello World!");

    DateTime dt = new DateTime();
    String monthName = dt.monthOfYear().getAsText();
    String frenchShortName = dt.monthOfYear().getAsShortText(Locale.FRENCH);
    boolean isLeapYear = dt.year().isLeap();
    DateTime rounded = dt.dayOfMonth().roundFloorCopy();

    int year = dt.year().get();

    System.out.println(year);
    System.out.println("Month name is " + monthName + " (or shortened in French " + frenchShortName + ")");
    System.out.println("It is " + isLeapYear + " that this is a leap year.");
    System.out.println("Day of Month is " + rounded);

    System.out.println("Previous Sunday is " + DateUtil.getPreviousSunday(rounded));
    System.out.println("Following Saturday is " + DateUtil.getFollowingSaturday(DateUtil.getPreviousSunday(rounded)));

  }

}
