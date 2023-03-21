package ExampleExcelRead;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelClass {
	public static void main(String[] args)   
	{  
		ExcelClass rc=new ExcelClass();   //object of the class  
	//reading the value of 2nd row and 2nd column  
//		String username1=rc.ReadCellData(1, 0);
//		String username2=rc.ReadCellData(2, 0);
//	String password1=rc.ReadCellData(1, 1);
//	String password2=rc.ReadCellData(2, 1);
//	
//	System.out.println(username1+" "+password1 +" "+username2+" "+password2+" ");  
	
	//as objects
	Object[][] data= new Object[2][2];
	for(int i=0;i<2;i++)
	{
		for(int j=0;j<2;j++)
		{
			data[i][0]=rc.ReadCellData(i+1, 0);
			data[i][1]=rc.ReadCellData(i+1, 1);
		}
	}
	
	for(int i=0;i<2;i++)
	{
		for(int j=0;j<2;j++)
		{
			System.out.println(data[i][j]);
		}
	}
	}

	private String ReadCellData(int vRow, int vColumn) {
		String value=null;          //variable for storing the cell value  
		Workbook wb=null;   //initialize Workbook null  
		try  
		{  
		//reading data from a file in the form of bytes  
		FileInputStream fis=new FileInputStream("C:\\Users\\HP\\Desktop\\testNGWorkspace\\DataProviderExample\\users.xlsx");  
		//constructs an XSSFWorkbook object, by buffering the whole stream into the memory  
		wb=new XSSFWorkbook(fis);  
		}  
		catch(FileNotFoundException e)  
		{  
		e.printStackTrace();  
		}  
		catch(IOException e1)  
		{  
		e1.printStackTrace();  
		}  
		Sheet sheet=wb.getSheetAt(0);   //getting the XSSFSheet object at given index  
		Row row=sheet.getRow(vRow); //returns the logical row  
		Cell cell=row.getCell(vColumn); //getting the cell representing the given column  
		value=cell.getStringCellValue();    //getting cell value  
		return value;               //returns the cell value  
		}  
}
