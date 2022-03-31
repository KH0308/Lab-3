package lab03;
import java.io.DataInputStream;
import java.io.FileInputStream;

public class Readdailyrainfall
{
	public static void main(String[] args)
	{
		String sourceFile = "dailyrainfallOutput.txt";
		System.out.println("Reading data from " + sourceFile + "\n");
		
		try {

			// 2. Create stream to read data
			DataInputStream DIS = new DataInputStream(new FileInputStream
					(sourceFile));

			// Variables for processing byte-based data
			double dailyrainfall = 0;
			double totaldailyrainfall = 0;
			int noOfRecords = 0;
			String date = "";
			
			// 3. Process data until end-of-file
			while(DIS.available() > 0) {
				
				// Read data
				date = DIS.readUTF();
				dailyrainfall = DIS.readDouble();
				System.out.println( date + "\t" + dailyrainfall);
				
				totaldailyrainfall += dailyrainfall;
				noOfRecords ++;
			}
			
			// 4. Close stream
			DIS.close();
			
			// Calculate average dailyrainfall
			double averagedailyrainfall = totaldailyrainfall / noOfRecords;
			String formattedAverage = String.format("%.1f", averagedailyrainfall);
			System.out.print("\nAverage Rainfall for " + noOfRecords + 
					" station Cheng(Taman Merdeka): " + formattedAverage + "%");
			}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		// Indicate end of program - Could be successful
		System.out.println("\nEnd of program.");
	}
}
