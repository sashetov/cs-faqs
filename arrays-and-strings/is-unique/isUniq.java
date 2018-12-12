import java.util.*;
public class isUniq {
  public static void main(String... args) {
    Scanner sc = new Scanner(System.in);
    while(sc.hasNextLine()) {
      char line[] = sc.nextLine().toCharArray();
      String sline = new String(line);
      //System.out.println("check unique presort " + checkUniqueNLogN(line));
      System.out.println("check unique ascii N time, 1 space is " + checkUniqueAsciiN(sline));
      System.out.println("check unique a-z N time 1/8 space is " + checkUniqueAZBitShiftN(sline));
    }
  }
  static boolean checkUniqueAsciiN(String str) { // time complexity is n, space is 1
    if ( str.length() > 128 ) return false;
    boolean[] char_set = new boolean[128];
    for( int i=0; i < str.length(); i++ ) {
      int val = str.charAt(i);
      if(char_set[val]) return false; // alread found this char
      char_set[val] = true;
    }
    return true;
  }
  static boolean checkUniqueAZBitShiftN(String str) { // space usage reduced to 1/8 of checkUniqueAsciiN, supports only ascii letters A-Z
    int checker=0;
    for(int i =0; i<str.length(); i++){
      int val=str.charAt(i)-'a';
      if( ( checker & ( 1 << val ) ) > 0 ){
        return false;
      }
      checker |= (1 << val);
    }
    return true;
  }
  static boolean checkUniqueNLogN(char arr[]) {
    quicksort(arr, 0, arr.length - 1); 
    for(int i = 0; i < arr.length - 1; ++i) if(arr[i] == arr[i + 1]) return false;
    return true;
  }
  static void quicksort(char arr[], int a, int b) {
    if(b - a < 1) return;
    int p = a;
    int i = a + 1;
    int j = b;
    while(i < j) {
      while(arr[i] < arr[p] && i < b) i++;
      while(arr[j] > arr[p] && j > a) j--;
      if(i < j) interchange(arr, i, j);
    }
    interchange(arr, p, j);
    quicksort(arr, a, j - 1);
    quicksort(arr, j + 1, b);
  }
  static void interchange(char arr[], int a, int b) {
    char temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }
}
