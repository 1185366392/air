package com.example.sunshineairlines;

import android.os.Handler;
import android.os.Message;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by admin on 2020/2/18.
 */

public class Http {
    static public  void get(final String urlStr, final Handler handler, final int what){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    URL url=new URL(urlStr);
                    HttpURLConnection connection=(HttpURLConnection)url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    connection.connect();
                    int response=connection.getResponseCode();
                    if(response==HttpURLConnection.HTTP_OK){
                        InputStream inputStream=connection.getInputStream();
                        String result=is2String(inputStream);
                        inputStream.close();
                        if(handler!=null){
                            Message message=new Message();
                            message.what=what;
                            message.obj=result;
                            handler.sendMessage(message);
                        }
                    }
                }
                catch (Exception ex){
                    int i=0;
                }
            }
        }).start();
    }
    static public  void post(final String urlStr, final Handler handler, final int what){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    URL url=new URL(urlStr);
                    HttpURLConnection connection=(HttpURLConnection)url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setConnectTimeout(5000);
                    connection.connect();
                    int response=connection.getResponseCode();
                    if(response==HttpURLConnection.HTTP_OK){
                        InputStream inputStream=connection.getInputStream();
                        String result=is2String(inputStream);
                        inputStream.close();
                        if(handler!=null){
                            Message message=new Message();
                            message.what=what;
                            message.obj=result;
                            handler.sendMessage(message);
                        }
                    }
                }catch (Exception ex){
                    int i=0;
                }
            }
        }).start();
    }
    private static String is2String(InputStream inputStream) throws IOException {
        StringBuffer out=new StringBuffer();
        InputStreamReader inread=new InputStreamReader(inputStream,"UTF-8");
        char[] b=new char[4096];
        for(int n;(n=inread.read(b))!=-1;){
            out.append(new String(b,0,n));
        }
        return  out.toString();
    }
}
