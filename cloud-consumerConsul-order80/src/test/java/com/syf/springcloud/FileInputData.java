package com.syf.springcloud;


import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @ProjectName: cloud
 * @Package: com.syf.springcloud
 * @Author: syf
 * @Date: 2020/5/26 16:41
 * @Description:
 * @Version:
 */
public class FileInputData {
    public static void main(String[] args) throws Exception{
        //读数据
        File file =  new File("data.txt");
        InputStream inputStream = new FileInputStream(file);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));




        String s = bufferedReader.readLine();
        StringBuffer sb = new StringBuffer();

        while (s != null){
            sb.append(""+s);
            s = bufferedReader.readLine();
        }
        String[] temp = sb.toString().replaceFirst(" ", "").split("\\s+");
        double[] doubles = new double[temp.length];
        for (int i = 0 ; i < temp.length ; i ++){
            doubles[i] = Double.parseDouble(temp[i]);
        }
        bufferedReader.close();
        /*//写数据
        FileOutputStream out = new FileOutputStream("data.txt");
        BufferedOutputStream bos = new BufferedOutputStream(out);
        String content = new String();
        double sum = 0;
        for(int i = 0 , j = doubles.length/2 ; i < doubles.length/2 && j <doubles.length ; i++,j++){
            content = content+(doubles[i]+"\t\n"+doubles[j]+"\t\n");
        }
        bos.write(content.getBytes(),0,content.getBytes().length);
        bos.flush();
        bos.close();*/
        double sum = 0;
        for(int i = 0 , j = 1 ; i < doubles.length && j < doubles.length;){
            sum += doubles[i] * doubles[j];
            System.out.println("sum="+doubles[i]+"*"+doubles[j]);
            i = i + 2 ;
            j = j + 2 ;
        }
        System.out.println("sum = " + sum);
    }
}
