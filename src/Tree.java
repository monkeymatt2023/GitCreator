import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Tree {
	private FileWriter output;
	
	public Tree (ArrayList<String> list) throws Exception
	{
		FileWriter writer = new FileWriter("output.txt"); 
		for(String str: list) {
		  writer.write(str + System.lineSeparator());
		}
		writer.close();
		
		String sha = ""; 
		try {
            MessageDigest md = MessageDigest.getInstance("SHA1");
            FileInputStream fis = new FileInputStream("output.txt");
            byte[] dataBytes = new byte[1024];

            int nread = 0;

            while ((nread = fis.read(dataBytes)) != -1) {
                md.update(dataBytes, 0, nread);
            }
            ;

            byte[] mdbytes = md.digest();

            //convert the byte to hex format
            StringBuffer sb = new StringBuffer("");
            for (int i = 0; i < mdbytes.length; i++) {
                sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16)
                        .substring(1));
            }
            sha = sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
		
		File pairs = new File("objects/" + sha);
        pairs.createNewFile();
        InputStream input = new FileInputStream("output.txt");
        OutputStream output = new FileOutputStream(pairs);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = input.read(buffer)) > 0) {
               output.write(buffer, 0, length);
               
        }
        output.close();
        input.close();
		
    }
}
