package com.syf.springcloud;

import java.io.*;
import java.util.Scanner;

/**
 * @ProjectName: cloud
 * @Package: com.syf.springcloud
 * @Author: syf
 * @Date: 2020/5/26 15:44
 * @Description:
 * @Version:
 */
public class Main {
    public static void main(String[] args) throws Exception{
        File file = new File("jijin.txt");
        Scanner scanner = new Scanner(System.in);
        System.out.println(" 请输入N:" );
        int n = scanner.nextInt();
        double[] a = new double[n];
        double[] b = new double[n];
        int sum = 0 ;
        System.out.println("输入金额：" );
        for(int i = 0 ; i < n ; i ++){
            a[i] = scanner.nextDouble();
        }
        System.out.println("输入涨幅：" );
        for(int i = 0 ; i < n ; i ++){
            b[i] = scanner.nextDouble();
        }
        for(int i = 0 ; i < n ; i ++){
            sum += a[i]*b[i];
        }
        System.out.println("sum = " + sum);


    }
}
