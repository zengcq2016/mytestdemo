package com.example.mytestdemo.txz;

import java.io.IOException;
import java.io.OutputStream;

import android.util.Log;

/**
 * @author Zengcq
 * @date 2016年12月12日
 * @version 1.0
 * @description
 */
public class SuUtil {
		  
	    private static Process process;  
	  
	    /** 
	     * 结束进程,执行操作调用即可 
	     */  
	    public static void kill(String packageName) {  
	        initProcess();  
	        killProcess(packageName);  
	        close();  
	    }  
	  
	    /** 
	     * 初始化进程 
	     */  
	    public static void initProcess() {  
	        if (process == null)  
	            try {  
	                process = Runtime.getRuntime().exec("su");  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	                Log.d("RituNavi", "su "+e.toString());
	            }  
	    }  
	  
	    /** 
	     * 结束进程 
	     */  
	    private static void killProcess(String packageName) {  
	        OutputStream out = process.getOutputStream();  
	        String cmd = "am force-stop " + packageName + " \n";  
	        try {  
	            out.write(cmd.getBytes());  
	            out.flush();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	            Log.d("RituNavi", "cmd "+e.toString());
	        }  
	    }  
	  
	    /** 
	     * 关闭输出流 
	     */  
	    private static void close() {  
	        if (process != null)  
	            try {  
	                process.getOutputStream().close();  
	                process = null;  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	                Log.d("RituNavi", "close "+e.toString());
	            }  
	    }  
}
