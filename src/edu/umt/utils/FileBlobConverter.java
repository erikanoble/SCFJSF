package edu.umt.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created with IntelliJ IDEA.
 * User: erikanoble
 * Date: 8/23/13
 * Time: 3:46 PM
 * To change this template use File | Settings | File Templates.
 */



public class FileBlobConverter {

    public static void setFileBytes(byte[] data) throws Exception{

    }

    public static void setFileBytes(byte[] data, String filename) throws Exception{
        File tempScan = new File(filename);
        FileOutputStream fos = new FileOutputStream(tempScan);
        fos.write(data);
        fos.close();
        fos.close();
    }

    public static byte[] getFileAsBytes(String file) throws Exception{
        FileInputStream fis = new FileInputStream(file);
        FileChannel fc = fis.getChannel();
        byte[] data = new byte[new Long(fc.size()).intValue()];
        ByteBuffer bb = ByteBuffer.wrap(data);
        fc.read(bb);
        System.out.println(data.length);
        return data;
    }

}
