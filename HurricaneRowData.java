/*
Steven Stack
3/6/26
Purpose: Creates various methods and constructors for use in Main.java.
*/

public class HurricaneRowData{
	private int year;
	private int ace;
	private int stormsTotal;
	private int hurricanesTotal;
	private int hurricanesMajor;
	
	public HurricaneRowData(int year, int ace, int stormsTotal, int hurricanesTotal, int hurricanesMajor){
		// Constructor containing all data used in the csv file.
		this.year = year;
		this.ace = ace;
		this.stormsTotal = stormsTotal;
		this.hurricanesTotal = hurricanesTotal;
		this.hurricanesMajor = hurricanesMajor;
	}
	
	public HurricaneRowData(){}
	
	public String toString(){
		return String.format("\nYear: %d\nACE Index: %d\nTropical Storms: %d\nHurricanes Cat. 1-5: %d\nHurricanes Cat. 3-5: %d\n", year, ace, stormsTotal, hurricanesTotal, hurricanesMajor);
	}
	
	public int getYear(){
		return year;
	}
	
	public void setYear(int year){
		this.year = year;
	}
	
	public int getACE(){
		return ace;
	}
	
	public void setACE(int ace){
		this.ace = ace;
	}
	
	public int getStormsTotal(){
		return stormsTotal;
	}
	
	public void setStormsTotal(int stormsTotal){
		this.stormsTotal = stormsTotal;
	}
	
	public int getHurricanesTotal(){
		return hurricanesTotal;
	}
	
	public void setHurricanesTotal(int hurricanesTotal){
		this.hurricanesTotal = hurricanesTotal;
	}
	
	public int getHurricanesMajor(){
		return hurricanesMajor;
	}
	
	public void setHurricanesMajor(int hurricanesMajor){
		this.hurricanesMajor = hurricanesMajor;
	}
}