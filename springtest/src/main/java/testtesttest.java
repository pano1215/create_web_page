import java.util.*;
import java.io.*;

public class testtesttest {

	public static void main(String[] args) {
		String s = "banana" ;
		// 자르고 넣고
        String[] a_char_arr = s.split("");
        
        for (int i = 0; i < s.length(); i++){
            // 넣은 값들과 비교함 
        	System.out.println("컨티뉴가 어디로 찍히나");
            for(int j = 0; j < s.length(); j++){
                a_char_arr[i] = a_char_arr[j];
                System.out.println("컨티뉴가 두 번째 포문에 찍히나");
                if(a_char_arr[i] == a_char_arr[j]){
                    
                }
                if(i == j){
                	System.out.println("여기서 컨티뉴");
                    continue;
                }
            }
        }
        int[] answer = {};
	}
}
