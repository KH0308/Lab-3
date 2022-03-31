package lab03;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class dailyrainfall{
	
	public static void main(String[] args) 
	{
	
		String outFile = "dailyrainfallOutput.txt";
		
		
		String date[] = {"18/03/22", "19/03/22","20/03/22","21/03/22","22/03/22"
				,"23/03/22"};
		double datarain[] = {7.0, 0.0, 0.0, 8.0, 0.0, 0.0};
		
		try
		{
			DataOutputStream DOS = new DataOutputStream(new FileOutputStream
					(outFile));
			
			for (int index = 0; index < date.length; index++)
			{
				
				// 3. Write data into data stream
				DOS.writeUTF(date[index]);
				DOS.writeDouble(datarain[index]);
				
				// 4. Flush for each writing
				DOS.flush();
			}
			
			DOS.close();
		}
			
		catch (Exception ex)
		{
				
			ex.printStackTrace();
		}
			
		System.out.println("End of program. Check out " + outFile);
	}

}
