/*
Steven Stack
3/6/26
Purpose: Reads from a csv file, then outputs the maximal ACE and year into command prompt and a file.
*/

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;

public class Main{
	public static void main (String[] args) throws IOException{
		Path data;
		Scanner dataRead;
		FileWriter fileOutput;
		// Tests that all necessary imports are functioning.
		try{
			data = Paths.get("ace.csv");
			dataRead = new Scanner(data);
			fileOutput = new FileWriter("Output.txt");
		}
		catch (IOException e){
			System.out.println("IO Exception " + e.toString());
			return;
		}
		
		dataRead.nextLine();
		String currentLine;
		String[] rowData = new String[5];
		ArrayList<HurricaneRowData> base = new ArrayList<HurricaneRowData>();
		
		// Adds each line of the csv file to a temporary variable, which is then added to an ArrayList.
		while(dataRead.hasNextLine()){
			currentLine = dataRead.nextLine();
			rowData = currentLine.split(",");
			
			HurricaneRowData temp = new HurricaneRowData();
			temp.setYear(Integer.parseInt(rowData[0]));
			temp.setACE(Integer.parseInt(rowData[1]));
			temp.setStormsTotal(Integer.parseInt(rowData[2]));
			temp.setHurricanesTotal(Integer.parseInt(rowData[3]));
			temp.setHurricanesMajor(Integer.parseInt(rowData[4]));
			base.add(temp);
		}
		
		int maxYear = findYear(base);
		int maxACE = findACE(base, maxYear);
		
		System.out.printf("The maximal ACE was %d in %d", maxACE, maxYear);
		String output = String.format("The maximal ACE was %d in %d", maxACE, maxYear);
		fileOutput.write(output);
		
		fileOutput.close();
		dataRead.close();
	}
	
	public static int findYear(ArrayList<HurricaneRowData> base){
		int maxACE = 0;
		int yearResult = 0;
		// Searches each row of the ArrayList and compares to find the highest ACE in the full array.
		// When the highest ACE is found, it returns the year from the same row as the max ACE.
		for (HurricaneRowData currentRow : base){
			if (currentRow.getACE() > maxACE){
				maxACE = currentRow.getACE();
				yearResult = currentRow.getYear();
			}
		}
		return yearResult;
	}
	
	public static int findACE(ArrayList<HurricaneRowData> base, int year){
		// Compares the years to find and return the max ACE.
		for (HurricaneRowData currentRow : base){
			if (currentRow.getYear() == year){
				return currentRow.getACE();
			}
		}
		return 0;
	}
}