package app;
import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Products {
	
	public static int row =0; 
	public static void SelectBouquet(WebDriver driver,Workbook w) {
		// TODO Auto-generated method stub
		
		try
		{
				try
				{
					
					int col = 0 ; 
					Sheet sheet;
					sheet= w.getSheet(0);
					String Bouquet= sheet.getCell(col,row).getContents();
					driver.findElement(By.xpath(Bouquet)).click();
					row++;
				
				}
				catch(org.openqa.selenium.TimeoutException TOE)
				{
					TOE.getMessage();
				}
				 
				
		}
		catch(Exception ex)
		{
			System.out.printf( ex.getMessage().toString());
		}
		
	}
}
