package com.spamalot.latexyearcalendar;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;

/**
 * Util functions.
 * 
 * @author johannsg
 *
 */
public final class DateUtil {
  /** Nothing. */
  private DateUtil() {
  }

  /**
   * Return a DateTime of the Sunday before the DateTime handed in, or of in if it
   * is a Sunday.
   * 
   * @param in A date
   * @return a DateTime of the Sunday
   */
  public static DateTime getPreviousSunday(final DateTime in) {

    DateTime result = in.minusDays(in.getDayOfWeek() % 7);

    return result;
  }

  /**
   * Return a DateTime of the Saturday after the DateTime handed in.
   * 
   * @param in A Date
   * @return a DateTime of the Saturday
   */
  public static DateTime getFollowingSaturday(final DateTime in) {

    DateTime result = in.plusDays(DateTimeConstants.SATURDAY - getDayOfWeekZeroSunday(in));

    return result;
  }

  /**
   * Return the number (0 .. 6) for a day of the week, 0 is Sunday.
   * 
   * @param in A Date
   * @return Numerical day of the week with Sunday as 0.
   */
  private static int getDayOfWeekZeroSunday(final DateTime in) {
    return in.getDayOfWeek() % 7;
  }
}
