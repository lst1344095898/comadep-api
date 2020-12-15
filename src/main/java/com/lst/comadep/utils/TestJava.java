package com.lst.comadep.utils;

import com.lst.comadep.utils.RandomData.AccessInformation;

import java.util.Random;

public class TestJava {

    public static void main(String[] args) {

//        getNUmber();
//            getColor();
//        getRandom();
        AccessInformation accessInformation=new AccessInformation();
       accessInformation.getOtherOutTime(2);
       accessInformation.getOtherInTime(2);
    }
    public static void getRandom(){
        Random random=new Random();
        for (int i=0;i<20;i++){
            System.out.println(random.nextInt(3));
        }
    }

        public static void getNUmber(){
        Random random=new Random();

        int x = random.nextInt(10);
        int y= random.nextInt(10);
        for (int j=0;j<10;j++){
            for (int i=0;i<10;i++){
                if (random.nextInt(4)==1)
                    System.out.print("["+j+","+i+","+ random.nextInt(100)+"],");
                else
                    System.out.print("["+j+","+i+","+ 0+"],");

            }
            System.out.println();
        }
    }
    public static void getColor(){
        String[] arr= {"#313695", "#4575b4", "#74add1", "#abd9e9", "#e0f3f8", "#ffffbf", "#fee090", "#fdae61", "#f46d43", "#d73027", "#a50026"};
        System.out.print("[");
        for (int i=10;i>=0;i--){
            System.out.print("'"+arr[i]+"',");
        }
        System.out.print("]");

    }
}
