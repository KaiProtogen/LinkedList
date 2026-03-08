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
		
		// Adds each line of the csv file to a temporary variable, which is then inserted into a node.
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
		
		System.out.println("List Length: " + base.length());
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
	
	/*
	// Tests removing an item and seeing if the contains method returns false for the item.
	// Also inserts another item afterwards and tests for the length, if another item is included, and if the value of a third item is correct.
	public static boolean testingOne(){
		DoublyLinkedSortedList baseTest = new DoublyLinkedSortedList();
		baseTest.insert(new HurricaneRowData(2017, 225, 17, 10, 6));
		baseTest.insert(new HurricaneRowData(2018, 133, 15, 8, 2));
		baseTest.insert(new HurricaneRowData(2019, 132, 18, 6, 3));
		baseTest.insert(new HurricaneRowData(2020, 180, 30, 14, 7));
		
		if(baseTest.length() == 4){
			baseTest.remove(new HurricaneRowData(2020, 180, 30, 14, 7));
			baseTest.contains(new HurricaneRowData(2020, 180, 30, 14, 7));
			baseTest.insert(new HurricaneRowData(2021, 146, 21, 7, 4));
			return baseTest.length() == 4 && baseTest.contains(new HurricaneRowData(2019, 132, 18, 6, 3)) && baseTest.getByValue(new HurricaneRowData(2018, 133, 15, 8, 2)).getValue().equals(new HurricaneRowData(2018, 133, 15, 8, 2));
		}
		return false;
	}
	
	// Tests if the last item in the list is 2019 (with the lowest ACE value).
	public static boolean testingTwo(){
		DoublyLinkedSortedList baseTestTwo = new DoublyLinkedSortedList();
		baseTestTwo.insert(new HurricaneRowData(2017, 225, 17, 10, 6));
		baseTestTwo.insert(new HurricaneRowData(2018, 133, 15, 8, 2));
		baseTestTwo.insert(new HurricaneRowData(2019, 132, 18, 6, 3));
		baseTestTwo.insert(new HurricaneRowData(2020, 180, 30, 14, 7));
		
		return baseTestTwo.getLast().getValue().equals(new HurricaneRowData(2019, 132, 18, 6, 3));
	}
	*/
}