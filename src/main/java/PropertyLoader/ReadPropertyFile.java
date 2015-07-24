package PropertyLoader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.virtusa.api.constants.Constants;

/**
 * @author camarathunga
 *
 */
public class ReadPropertyFile {
	
public Set<Object> getAllkeys(String propertyFileName){
	
	Properties prop = new Properties();
	InputStream input = null;
	try {
		input = new FileInputStream(propertyFileName);
		try {
			prop.load(input);
			
			
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
	return prop.keySet();
}

public Map<String,String> getAllPropertyValues(String propertyFileName){
	Set<Object> keySet = getAllkeys(propertyFileName);
	if(keySet.size()==0){
		return null;
	}
	Map<String,String> propValues = new HashMap<String, String>();
	//load propertyes
		Properties prop = new Properties();
		InputStream input = null;
	try {
		input = new FileInputStream(propertyFileName);
		try {
			prop.load(input);
			
		
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
	for (Object key : keySet) {
		propValues.put((String) key,prop.getProperty((String)key));
	}
	return propValues;
}


public Map<String, String> getPriopertyValue(String[] keys,String PropertyFile){
	if(keys.length==0){
		return null;
	}
	Map<String,String> propValues = new HashMap<String, String>();
	//load propertyes
		Properties prop = new Properties();
		InputStream input = null;
	try {
		input = new FileInputStream(PropertyFile);
		try {
			prop.load(input);
			
		
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
	for (String key : keys) {
		propValues.put(key,prop.getProperty(key));
	}
	return propValues;
}

}
