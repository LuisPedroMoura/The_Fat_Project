import java.io.Serializable;
import java.util.Calendar;

public class Date implements Serializable, Comparable<Date> {
	
	
	private static final long serialVersionUID = -1995075525118834439L;
	private int day, month, year;

	
	//--- CONSTRUTORES --------------------------------------------
		public Date(int day, int month , int year) {
			this.day = day;
			this.month = month;
			this.year = year;
		}
		public Date (Date date) {
			this.day = date.getDay();
			this.month = date.getMonth();
			this.year = date.getYear();
		}
		public Date() {
			Calendar cal = Calendar.getInstance();
			this.year = cal.get(Calendar.YEAR);
			this.month = cal.get(Calendar.MONTH) + 1;
			this.day = cal.get(Calendar.DAY_OF_MONTH);
		}

	//--- METODOS ------------------------------------------------
		public void printData() {
			System.out.printf("%02d-%02d-%04d\n",day, month, year);
		}
		
		
			public int getDay() {
				return day;
			}
			public int getMonth() {
				return month;
			}
			public int getYear() {
				return year;
			}
		
		public String monthName() {
			String[] monthes = {"Jan", "Feb", "Mar", "Apr", "May",
							  "Jun", "Jul", "Aug", "Sep", "Oct",
							  "Nov", "Dec"};			 
			return monthes[month - 1];
		}
		
		public Date tomorrow() {
			int day = this.day;
			int month = this.month;
			int year = this.year;
			if (day < daysInMonth(month, year)) {
				day++;
			} else {
				day = 1;
				if (month == 12) {
					month = 1;
					year++;
				} else {
					month++;
				}
			}
			return new Date(day, month, year);
		}
		public Date yesterday() {
			int day = this.day;
			int month = this.month;
			int year = this.year;
			if (day > 1) {
				day--;
			} else {
				if (month == 1) {
					month = 12;
					year--;
				} else {
					month--;
				}
				day = daysInMonth(month, year);
			}
			return new Date(day, month, year);
		}
		
	//--- METODODOS DA CLASSE ------------------------------------
		public static boolean leapYear(int year) {
			return ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
		}

		public static int daysInMonth(int month, int year) {
				switch (month) {
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					return 31;
				case 4:
				case 6:
				case 9:
				case 11:
					return 30;
				default: //Fevereiro
					return (leapYear(year)) ? 28 : 29;
			}
		}
		
		public static boolean validarData(int day, int month, int year) {
			return((day <= daysInMonth(month, year)) && (month > 0 && month < 13));
		}
	
	
	public Date subtractDays(int days) {
		
		Date newDate = new Date(this);
		
		for (int i = 0; i < days; i++) {
			newDate = yesterday();
		}
		
		return newDate;
	}

	@Override
	public String toString() {
		return day + "-" + month + "-" + year;
	}
	public String writeOutDate() {
		return getDay() + " - " + monthName() + " - " + getYear();
	}

	@Override
	public int compareTo(Date other) {
		if(this.year < other.getYear()) { return -1; }
		else if (this.year > other.getYear()) { return 1; }
		else {
			if (this.month < other.getMonth()) { return -1; }
			else if (this.month > other.getMonth()) { return 1; }
			else {
				if (this.day < other.getDay()) { return -1; }
				else if (this.day > other.getDay()) { return 1; }
				else { return 0; }
			}
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + month;
		result = prime * result + year;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
	
	
}
