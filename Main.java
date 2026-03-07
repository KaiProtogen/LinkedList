/*
Steven Stack
3/6/26
Purpose: Reads from a csv file, then outputs the maximal ACE and year into command prompt and a file.
*/

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
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
		DoublyLinkedSortedList base = new DoublyLinkedSortedList();
		
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
			base.insert(temp);
		}
		
		Node maxYearNode = base.getFirst();
		HurricaneRowData dat = maxYearNode.getValue();
		int maxYear = dat.getYear();
		
		String header1 = String.format("Year of max ace: %d", maxYear);
		String header2 = String.format("All data in order of ACE:");
		System.out.printf("%s\n%s\n", header1, header2);
		System.out.println(base);
		fileOutput.write(String.format("%s\n%s\n", header1, header2));
		fileOutput.write(base.toString());
		
		fileOutput.close();
		dataRead.close();
	}
}