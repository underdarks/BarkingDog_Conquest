package Ox02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최댓값 {

    /**
     *  첫번째 방법
     */
    public static void getMaxNumAndIndex(int []list){
        int max=list[0];    //최대값
        int idx=1;          //최대값의 위치

        for (int i = 1; i < list.length; i++) {
            if(max < list[i]){
                max=list[i];
                idx=i+1;
           }
        }

        System.out.println(max);
        System.out.println(idx);
    }

    /**
     * 2번째 방법
     */
    public static void getMaxNumAndIndex2(int []list){
        int max = Arrays.stream(list)
                .max()
                .orElse(0);

        Map<Integer,Integer> map=new HashMap<>();   //값, 인덱스 저장 구조

        int seq=1;
        for (int i : list)
            map.put(i,seq++);


        System.out.println(max);
        System.out.println(map.get(max));
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int size=9;
        int []list=new int[size];

        for(int i=0;i<size;i++) {
            String s = br.readLine();
            list[i]= Integer.parseInt(s);
        }

        getMaxNumAndIndex2(list);

        br.close();
    }
}
