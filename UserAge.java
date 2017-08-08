// My UserAge library is dependent on my DateConverter library.
import java.util.Date;
import java.util.Calendar;
public class UserAge {
    public boolean appropriateAge;

    public UserAge(int birthMonth, int birthDay, int birthYear) {

        int ageMonth = birthMonth;
        int ageDay = birthDay;
        int ageYear = birthYear;

    }

    public int getUserAge(int ageMonth, int ageDay, int ageYear) {

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int userInYearsEstimate = (year - ageYear) - 1;
        int userInDaysEstimate = userInYearsEstimate * 365;
        int approxDays = userInDaysEstimate + ageDay;

        // Call this to get the number of days in their birth month.
        DateConverter getMonthDays = new DateConverter(ageMonth);
        int monthDays = getMonthDays.getDaysInMonth(ageMonth);
        int usersLifeInDays = approxDays + monthDays;
        boolean isUser18 = checkIfEighteen(usersLifeInDays);
        return usersLifeInDays;

    }

    public boolean checkIfEighteen(int usersLifeInDays) {

        int eighteenYearsInDays = 365 * 18;
        if(usersLifeInDays - eighteenYearsInDays >= 0) {
            appropriateAge = true;
        } else {
            appropriateAge = false;
        }
        return appropriateAge;
    }
}



