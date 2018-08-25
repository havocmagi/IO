import java.util.*;
import java.io.*;

public class IOLab
{
	private double[][] data; 
	boolean tryAgain;
	Scanner tokens= null;
	
	public static void main(String[] args) throws IOException 
	{
		IOLab fileTest = new IOLab();
		fileTest.readData();
		System.out.println();
		System.out.println(fileTest.toString());
		fileTest.writeData();
	}

	public String toString()
	{
		String a="";
		for(int r=0; r<data.length; r++)
		{
			for(int c=0; c<data[r].length; c++)
			{
				a+=String.format("%10.4f", data[r][c]);
			}
			a+="\n";
		}
		return a;
	}
	
	public void readData()
	{
		do
		{
			Scanner console = new Scanner(System.in);
			System.out.printf("Please enter a file name to read: ");
			String inFile = console.next();
			tryAgain=false;
			try
			{
				File file = new File(inFile); // connect to the file
				tokens = new Scanner(file); // buffer the data
				int nrows = tokens.nextInt(); // get the number of rows.
				int ncols = tokens.nextInt(); // 1. get the number of cols.		
				data=new double[nrows][ncols];// 2. allocate space for the 2-d data array instance field:
				// 3. write a nested loop to read the data into the data array.
				for(int i=0; i<nrows; i++)
				{
					for(int j=0; j<ncols; j++)
					{
						data[i][j] = tokens.nextDouble();
						System.out.printf("%10.4f", data[i][j]);
					}
					System.out.println();
				}
			}
			catch(FileNotFoundException err)
			{
				System.out.printf("Error opening file %s,%s\n",inFile,err);
				tryAgain=true;
			}
			catch(Exception err)
			{
				System.out.printf("Unrecoverable exception, exiting program %s\n", err);
				err.printStackTrace();
			}
			// 4. close the file:
			finally
			{
				if(tokens!=null)
					tokens.close();
			}
		}while(tryAgain);
	} // end readData()

	public void writeData()
	{
		Scanner console = new Scanner(System.in);
		System.out.printf("Enter a file name for writing data: ");// 1. prompt the user for a file name to write.
		String outFile=console.next();
		int nrows = data.length;
		int ncols = data[0].length;
		try
		{
			// 2. Allocate the file and allow buffering with printf
			FileWriter writeIt=new FileWriter(outFile);
			PrintWriter out=new PrintWriter(writeIt);
			// 3. write the number of rows into the file
			// 4. write the number of cols into the file
			out.printf("%d\n",nrows);
			out.printf("%d\n",ncols);
			// 5. Format the output using format-elements, numbers should be
			// aligned on the decimal point and rounded to 4 digits to the
			// right of the decimal.
			// 6. use a nested loop to write data stored in the data array.
			// 7. Write your name into the file.
			// 8. close the file.
			for(int i=0; i<nrows; i++)
			{
				for(int j=0; j<ncols; j++)
				{
					out.printf("%10.4f", data[i][j]);
				}
				out.printf("\n");
			}
			out.printf("Trushan");
			out.close();
		}
		catch(IOException err)
		{
			System.out.printf("IOException error %s\n", err);
		}
	} // end of writeData
} // end class