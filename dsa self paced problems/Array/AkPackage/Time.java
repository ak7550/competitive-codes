package AkPackage;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.Period;

public class Time {
    public Period timeDifference(LocalDate datefrom, LocalDate dateto) {
        return Period.between(datefrom, dateto);
    }

    public String timeDifferenceString(LocalDate datefrom, LocalDate dateto) {
        Period intervalPeriod = timeDifference(datefrom, dateto);
        return "Difference of: " + intervalPeriod.getDays() + " day" + (intervalPeriod.getDays() != 1 ? "s " : " ")
                + intervalPeriod.getMonths() + " month" + ((intervalPeriod.getMonths() != 1) ? "s " : " ")
                + intervalPeriod.getYears() + " year" + ((intervalPeriod.getYears() != 1) ? "s." : ".");
    }

    public int yearsBetween(LocalDate from, LocalDate to) {
        return (int) ChronoUnit.YEARS.between(from, to); // an example of lossy conversation
    }

    public long monthsBetween(LocalDate from, LocalDate to) {
        return ChronoUnit.MONTHS.between(from, to);
    }

    public long daysBetween(LocalDate from, LocalDate to) {
        return ChronoUnit.DAYS.between(from, to);
    }

}