package com.syf.springcloud;

import com.google.gson.internal.$Gson$Preconditions;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

/**
 * @ProjectName: cloud
 * @Package: com.syf.springcloud
 * @Author: syf
 * @Date: 2020/5/26 16:53
 * @Description:
 * @Version:
 */
public class FileOutputData {
    public static void main(String[] args) throws Exception {
        FileOutputStream file = new FileOutputStream("data.txt");
        BufferedOutputStream bos = new BufferedOutputStream(file);
        String content = new String();
        System.out.println("输入数量：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[] num = new double[n];

        System.out.println("输入金额和涨幅：");
        for (int i = 0 ; i < n ; i ++){
            num[i] = scanner.nextDouble();
            content += Double.toString(num[i])+"\t\n";
        }
        bos.write(content.getBytes(),0,content.getBytes().length);
        bos.flush();
        bos.close();
    }
}
