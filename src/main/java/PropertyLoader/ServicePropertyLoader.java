package PropertyLoader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.virtusa.api.constants.Constants;



public class ServicePropertyLoader implements PropertyLoader {
	
static String lock="lock";
private static ServicePropertyLoader instance =null;

// variable List
/**
 * 
 */
String url;







/**
 * @return
 */
public String getUrl() {
	return url;
}



private ServicePropertyLoader(){
	
	init();
}
public static ServicePropertyLoader getInstanse(){
synchronized (lock) {
	if(instance==null){
		instance = new ServicePropertyLoader();
		return instance;
	}else{
		return instance;
	}
}
}
private void init(){
	//load propertyes
	Properties prop = new Properties();
	InputStream input = null;
	try {
		input = new FileInputStream(Constants.PROPERTY_FILE);
		try {
			prop.load(input);
			//get property values
			url=prop.getProperty(Constants.URL);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
	
		e.printStackTrace();
	}finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	
}
}
}

