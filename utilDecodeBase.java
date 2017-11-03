/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apache.commons.codec.binary;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
//import java.util.Base64;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
//import com.sun.org.apache.xml.internal.security.utils.Base64;

public class utilDecodeBase {
    public utilDecodeBase() {
        super();
    }

    public static void main(String[] a) throws Exception {
        
        // Enter the filename as input
       
       String Filname =   "I:\\SOAPfiles\\GlInterface.zip";
       
        
        File br = new File(Filname);
        // Convert the file into Byte 
        byte[] bytes = loadFile(br);

        // Call the api for Base64 encoding
        String encoded = Base64.encode(bytes);
        String encStr = new String(encoded);
        // Print the file
        System.out.println(encStr);
        
    }

    private static byte[] getByteArray(String fileName) {
        File file = new File(fileName);
        FileInputStream is = null;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[16384];
        try {
            is = new FileInputStream(file);
            while ((nRead = is.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            buffer.flush();
        } catch (IOException e) {
            System.out.println("In getByteArray:IO Exception");
            e.printStackTrace();
        }
        return buffer.toByteArray();
    }


    private static byte[] loadFile(File file) throws IOException {
        InputStream is = new FileInputStream(file);

        long length = file.length();
        if (length > Integer.MAX_VALUE) {
            // File is too large
        }
        byte[] bytes = new byte[(int)length];

        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length &&
               (numRead = is.read(bytes, offset, bytes.length - offset)) >=
               0) {
            offset += numRead;
        }

        if (offset < bytes.length) {
            throw new IOException("Could not completely read file " +
                                  file.getName());
        }

        is.close();
        return bytes;
    }

}

