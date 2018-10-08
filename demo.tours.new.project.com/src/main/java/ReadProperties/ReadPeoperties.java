package ReadProperties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class ReadPeoperties {
	
	private Properties p = null;
	private FileInputStream fis = null;
	private String path = null;
	private File file = null;
	private String value = null;
	
	public ReadPeoperties(String path) {
		
		this.path  = path;
		
	}
	public String data(String path, String Key) {
		
		p = new Properties();
		
		file = new File(path);
		
		try {
			fis = new FileInputStream(file);
			
			p.load(fis);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		
		}
		
		value = p.getProperty(Key);
		
		return value;
	}

}
