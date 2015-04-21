import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MadhuString{
   public static void main (String[] args) 
   {
      File file = new File ("/Users/Madhumita/Desktop/genelist.txt");
      StringBuilder line = new StringBuilder();
      BufferedReader reader = null;

try {
    reader = new BufferedReader (new FileReader(file));
    String text = null;

    while ((text = reader.readLine()) !=null) {
    	
    	//line.append(text)
        //.append(System.getProperty ("line.separator"));
line.append(text);
line.append(", ");
    }
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    finally 
   {
    try {
        if (reader !=null){
            reader.close();
    }
    }
    catch (IOException e) 
    {
      e.printStackTrace();
    }
    }

    System.out.println(line.toString());
    
    
    }
    }