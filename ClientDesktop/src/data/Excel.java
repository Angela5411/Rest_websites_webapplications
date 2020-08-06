
package data;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import static org.apache.poi.ss.usermodel.CellType.STRING;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.json.JSONException;

public class Excel {
    
    private List<Question> questions;

    public List<Question> getQuestions() {
        return questions;
    }
    public Excel(String name) throws MalformedURLException, JSONException, URISyntaxException, IOException 
    {
        //Blank workbook
            InputStream ExcelFileToRead = new FileInputStream(name);
            XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
            XSSFSheet sheet = wb.getSheet("Φύλλο1");
            
            XSSFRow row;
            XSSFCell cell;
            questions=new ArrayList<Question>();
            int i=0;
            row=sheet.getRow(i);
            try{
            for(i=1;i<sheet.getLastRowNum();i++)
            {
                    row=(XSSFRow)sheet.getRow(i);
                    
                    cell=(XSSFCell)row.getCell(0);String question=""; 
                    if (cell.getCellTypeEnum() ==STRING)
                        question=cell.getStringCellValue();
                    else if(cell.getCellTypeEnum() == NUMERIC)
			question=((int)cell.getNumericCellValue())+"";
                                        
                    cell=row.getCell(1); String a1="";
                    if (cell.getCellTypeEnum() ==STRING)
                        a1=cell.getStringCellValue();
                    else if(cell.getCellTypeEnum() == NUMERIC)
			a1=((int)cell.getNumericCellValue())+"";
                    
                    cell=row.getCell(2); String a2="";                  
                    if (cell.getCellTypeEnum() ==STRING)
                        a2=cell.getStringCellValue();
                    else if(cell.getCellTypeEnum() == NUMERIC)
			a2=((int)cell.getNumericCellValue())+"";
                                        
                    cell=row.getCell(3); String a3="";
                    if (cell.getCellTypeEnum() ==STRING)
                        a3=cell.getStringCellValue();
                    else if(cell.getCellTypeEnum() == NUMERIC)
			a3=((int)cell.getNumericCellValue())+"";
                                        
                    cell=row.getCell(4); String a4="";
                    if (cell.getCellTypeEnum() ==STRING)
                        a4=cell.getStringCellValue();
                    else if(cell.getCellTypeEnum() == NUMERIC)
			a4=((int)cell.getNumericCellValue())+"";
                                        
                    cell=row.getCell(5); Integer correct=(int)cell.getNumericCellValue();
                    Question temp=new Question(question,a1,a2,a3,a4,correct);
                    temp.terminate();
            } 
            
            }catch( java.lang.NullPointerException e)
            {;}
	
        
    }
}
