
public class Commit {
	
	public Commit parent;
	public Commit pointer;
	private File pTree;
	private String summary;
	private String date;
	private String author;
	private String pValue;
	public Commit (String pTreeString, String changeLog,String authorName, Commit parentPointer)
	{
		parent=parentPointer;
		pointer=null;
		pTree=new File (new Path (pTreeString));
		author=authorName;
		summary=changeLog;
		pValue=pTreeString;
		date=new Date().toString();
		
		
		
	}
	
	 public static String getSHA1(File file) throws IOException {
	        

	        try {
	            MessageDigest md = MessageDigest.getInstance("SHA1");
	            FileInputStream fis = new FileInputStream(file);
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
	            return sb.toString();
	           

	        } catch (NoSuchAlgorithmException ex) {
	            throw new RuntimeException(ex);
	        }
	    }
	 public String getDate()
	 {
		 return date;
	 }
	 public void createFile ()
	 {
		 File file=new File ("objects/"+getSHA1(pTree));
		 FileWriter writer=new FileWriter(file);
		 writer.append (pValue +"\n"+parent+"\n"+pointer+"\n"+author+"\n"+date+"\n"+summary);
		 
	 }
	 
	 
	
}
