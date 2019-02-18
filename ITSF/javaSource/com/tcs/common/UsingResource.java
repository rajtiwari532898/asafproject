package com.tcs.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.icesoft.faces.context.Resource;

public class UsingResource implements Resource {
	private String resourceName;
    private InputStream inputStream;
    private final Date dtlastModified;
    private  ExternalContext extContext;
    FacesContext fc = FacesContext.getCurrentInstance();
	
    public UsingResource(String resourceNam) {
        this.resourceName = resourceNam;
        this.dtlastModified = new Date();
        extContext=fc.getExternalContext();
    }
    
    public byte[] toByteArray(InputStream input) throws IOException{
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		byte[] buf = new byte[4096];
		int len =0;
		if(input!=null){
			while((len = input.read(buf)) > -1){
				output.write(buf,0,len);
			}
			return output.toByteArray();	
		}
		return buf;
	}
    
    public InputStream open() throws IOException {
    	InputStream stream=null;
    	if (inputStream == null) {
        	try{
        		stream = new FileInputStream(new File(resourceName));
        		byte[] byteArray = toByteArray(stream);
                inputStream = new ByteArrayInputStream(byteArray);
                stream.close();
        	}catch(FileNotFoundException e){
        		try{
        		
        		inputStream=extContext.getResourceAsStream(resourceName);
        		}catch(Exception e1){
        			try {
						throw e1;
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						stream.close();
						//e2.printStackTrace();
					}
        		}
        		
        	}finally{
        		if(stream!=null){
				 stream.close();
        		}
			}
    	}else{
    		byte[] byteArray=new byte[0];
    		inputStream=new ByteArrayInputStream(byteArray);
    	}
        return inputStream;
    }
    
    public String calculateDigest() {
        return resourceName;
    }
    public Date lastModified() {
        return new Date (dtlastModified.getTime());
    }

    
    public void withOptions(Options arg0) throws IOException {
    	
    }



}
