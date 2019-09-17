import java.io.*;

public class FileIO {
	
	public <T> void writeToFile(T obj,String fileName) {
	      try {
	    	  
	         FileOutputStream fileOut = new FileOutputStream(fileName);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         
	         out.writeObject(obj);	// object being written here
	         out.close();
	         fileOut.close();
	         
	      } catch(IOException i) {
	         i.printStackTrace();
	      }
	}
	
	public <T> void readFromFile(T obj,String fileName) {
		try {
			
	         FileInputStream fileIn = new FileInputStream(fileName);
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         
	         obj = (T)in.readObject(); // object being read here
	         in.close();
	         fileIn.close();
	         
	      } catch (IOException i) {
	         i.printStackTrace();
	         return;
	      } catch (ClassNotFoundException c) {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	         return;
	      }
	}
	
}
