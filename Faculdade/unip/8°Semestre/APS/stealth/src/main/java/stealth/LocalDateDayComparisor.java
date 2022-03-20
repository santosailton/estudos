package stealth;

import java.time.LocalDate;

public class LocalDateDayComparisor {
	public static boolean isToday(LocalDate date) {
		LocalDate today = LocalDate.now();
		if(today.getDayOfMonth() == date.getDayOfMonth() &&
				today.getMonthValue() == date.getMonthValue() &&
				today.getYear() == date.getYear())
			return true;
		return false;
	}
}
