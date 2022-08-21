package Ox03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 알파벳개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String s = br.readLine();

        //문자별 개수
        Map<Character, Long> charByCount = Stream.of(s)
                .flatMap(a -> a.chars().mapToObj(c -> (char) c))
                .collect(Collectors.groupingByConcurrent(Function.identity(), Collectors.counting()));


        for(char c='a';c<='z';c++){
            System.out.print(charByCount.getOrDefault(c,0L)+" ");
        }

        br.close();
    }
}
