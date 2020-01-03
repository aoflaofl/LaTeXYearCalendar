package com.spamalot.latexyearcalendar;

import java.util.Locale;

import org.joda.time.DateTime;

/**
 * Make a calendar.
 *
 */
public final class App {

  /** Construct nothing. */
  private App() {
  }

  /**
   * Do all the things.
   * 
   * @param args The arguments to the program
   */
  public static void main(final String[] args) {
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

    for (int month = 1; month <= 12; month++) {
      DateTime da = new DateTime().withDayOfMonth(1).withMonthOfYear(month);
      outputMonth(da);
      if (month % 3 == 0) {
        System.out.println("\\vfill%");
      } else {
        System.out.println("\\hfill%");
      }
    }
  }

  private static void outputMonth(final DateTime in) {
    // System.out.println("Previous Sunday is " +
    // DateUtil.getPreviousSunday(in));
    // System.out.println("Following Saturday is " +
    // DateUtil.getFollowingSaturday(in));
    //
    // System.out.println(in.monthOfYear().getAsText());

    printTableHeader();
    printMonthName(in.monthOfYear().getAsText());
    printDayHeader();
    DateTime da = in;

    // int monthNum = in.getMonthOfYear();
    // int yearNum = in.getYear();
    for (int week = 0; week < 6; week++) {
      // if (DateUtil.getPreviousSunday(da).getMonthOfYear() == monthNum
      // || DateUtil.getPreviousSunday(da).getYear() != yearNum) {
      System.out.print("\\tiny " + da.getWeekOfWeekyear() + " ");
      // } else {
      // System.out.print(" ");
      // }
      outputWeek(DateUtil.getPreviousSunday(da), in.getMonthOfYear(), in.getYear());
      da = da.plusDays(7);
    }
    printTableFooter();
  }

  private static void outputWeek(final DateTime in, final int month, final int year) {
    DateTime da = in;
    for (int day = 0; day < 7; day++) {
      if (da.getMonthOfYear() == month || da.getYear() != year) {
        System.out.print("& " + da.getDayOfMonth() + " ");
      } else {
        System.out.print("& ");
      }
      da = da.plusDays(1);
    }
    System.out.println("\\\\ \\cline{2-8}");
  }

  private static void printTableHeader() {
    System.out.println("\\begin{tabular}{r@{\\hskip1pt} | c | c | c | c | c | c | c |} \\cline{2-8}");
  }

  private static void printTableFooter() {
    System.out.println("\\end{tabular}%");
  }

  private static void printMonthName(final String month) {
    System.out.print("& \\multicolumn{7}{c|}{\\large ");
    System.out.print(month);
    System.out.println(" } \\\\[-1pt] \\cline{2-8}");
  }

  private static void printDayHeader() {
    System.out
        .println("& S & \\textbf{M} & \\textbf{T} & \\textbf{W} & \\textbf{T} & \\textbf{F} & S \\\\ \\cline{2-8}");
  }
}
