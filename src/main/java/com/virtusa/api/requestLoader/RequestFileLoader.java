package com.virtusa.api.requestLoader;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.virtusa.api.constants.Constants;

public class RequestFileLoader {
	final static Logger logger = Logger.getLogger(RequestFileLoader.class);

	public List<File> getDirectoryies(String dirName){
		logger.info("get directoryes from :"+dirName);
		File file = new File(dirName);
    	//String[] directories = file.listFiles();
    	File[] directories = file.listFiles(new FilenameFilter() {
    		  public boolean accept(File current, String name) {
    		    return new File(current, name).isDirectory();
    		  }
    		});
    	
		return Arrays.asList(directories);
		 
	}
	
	/**
	 * @param Dir
	 * @return
	 */
	public Map<String,String> getAllPropertyFiles(String Dir){
		Map<String,String> requestPropertyFile = new HashMap<String, String>();
		List<File> requestDirectoryies = getDirectoryies(Dir);
		for (File file : requestDirectoryies) {
			File f = new File(file.getAbsoluteFile()+File.separator+Constants.REQUEST_PPOPERTY_FILE);
			if(f.exists() && !f.isDirectory()) {
			requestPropertyFile.put(file.getName(),file.getAbsolutePath()+File.separator+Constants.REQUEST_PPOPERTY_FILE);
			}
		}
		return requestPropertyFile;
	}
}
