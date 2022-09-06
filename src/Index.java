import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

public class Index {
	private HashMap<String, String> blobs;
	private File index;
	public Index()
	{
		 index=new File("index");
		new File("/objects").mkdirs();
		
	}
	public void addBlobs(String fileName) throws Exception
	{
		Blob x=new Blob (fileName);
		addToFile(fileName, x.getSHA());
		
	}
	public void addToFile (String fileName, String shaString) throws IOException
	{
        FileWriter output = new FileWriter(index);
        output.write(fileName+", "+shaString);
        blobs.put (fileName,shaString);
        output.close();
	}
	public boolean removeBlob(String fileName) throws IOException
	{
		if (blobs.containsKey(fileName))
		{
			File inputFile=new File(fileName);
			
			File tempFile= new File (fileName);
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
			String lineToRemove =fileName+", "+blobs.get(fileName);
			String currentLine;
			
			while((currentLine = reader.readLine()) != null) {
			    // trim newline when comparing with lineToRemove
			    String trimmedLine = currentLine.trim();
			    if(trimmedLine.equals(lineToRemove)) continue;
			    writer.write(currentLine + System.getProperty("line.separator"));
			}
			writer.close(); 
			reader.close(); 
			boolean successful = tempFile.renameTo(inputFile);
			File toDelete=new File (blobs.get(fileName)+".txt");
			toDelete.delete();
			blobs.remove(fileName);
			
			return true;
		}
		return false;
	}
}
