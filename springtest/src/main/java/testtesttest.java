import java.util.*;
import java.io.*;

public class testtesttest {

	public static void main(String[] args) {
		String s = "banana" ;
		// �ڸ��� �ְ�
        String[] a_char_arr = s.split("");
        
        for (int i = 0; i < s.length(); i++){
            // ���� ����� ���� 
        	System.out.println("��Ƽ���� ���� ������");
            for(int j = 0; j < s.length(); j++){
                a_char_arr[i] = a_char_arr[j];
                System.out.println("��Ƽ���� �� ��° ������ ������");
                if(a_char_arr[i] == a_char_arr[j]){
                    
                }
                if(i == j){
                	System.out.println("���⼭ ��Ƽ��");
                    continue;
                }
            }
        }
        int[] answer = {};
	}
}
