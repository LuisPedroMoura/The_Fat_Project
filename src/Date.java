import java.io.Serializable;

public class Date implements Serializable{
	

	private static final long serialVersionUID = -4120075515157658738L;
	private int day;
	private int month;
	private int year;
	
	public Date(int d, int m, int a) throws Exception{
		day = d;
		month = m;
		year = a;
		if (!validDate()) {
			throw new Exception();
		}
	}

	public int getDay() {
		return day;
	}

	public void setDay(int dia) {
		this.day = dia;
	}

	public int getMonth() {
		return month;
	}

	public void setMes(int mes) {
		this.month = mes;
	}

	public int getYear() {
		return year;
	}

	public void setAno(int ano) {
		this.year = ano;
	}
	
	public boolean validDate() {
			
		// Ano bissexto
		boolean bis = false;
		if ((this.year%400==0) || (this.year%100!=0 && this.year%4==0)) {
			bis = true;
		}
		
		// Dias nao positivos & Meses fora do seu dominio
		if (this.day<=0||this.month<=0||this.month>12) {return false;}
		
		// Dias fora do seu domínio
		int [] months31 = {1, 3, 5, 7, 8, 10, 12};
		int [] months30 = {4, 6, 9, 11};
		
		int diasMes=0;
		
		for (int i=0; i<months31.length; i++) {
			if (months31[i] == this.month) {
				diasMes=31;
				break;
			}
		}
		
		if (diasMes==0) {
			for (int i=0; i<months30.length; i++) {
				if (months30[i] == this.month) {
					diasMes=30;
					break;
				}
			}
		}
		
		if (diasMes==0) {
			if (bis) {diasMes=29;}
			else {diasMes=28;}
		}
		
		if (this.day>diasMes) {return false;}
		
		return true;
	}
		

	@Override
	public String toString() {
		return day + "-" + month + "-" + year;
	}
	
}
