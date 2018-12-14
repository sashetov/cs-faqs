import java.util.*;
public class palindromePermut {
  public static void main(String... args) {
    String[] strs= { "seshs es", "atco cta", "mthing else" };
    for ( int i = 0; i < strs.length; i++ ){
      System.out.println( strs[i]+": "+ Boolean.toString(isPermutationOfPalindrome( strs[i])) );
    }
  }
  static boolean isPermutationOfPalindrome( String phrase ) {
    int[] table = buildCharFrequencyTable( phrase );
    return checkMaxOneOdd( table );
  }
  static boolean checkMaxOneOdd( int[] table ) {
    boolean foundOdd = false;
    for ( int count : table ) {
      if(count %2 == 1) {
        if(foundOdd) {
          return false;
        }
        foundOdd = true;
      }
    }
    return true;
  }
  static int getCharNumber(Character c){
    int a = Character.getNumericValue('a');
    int z = Character.getNumericValue('z');
    int val = Character.getNumericValue(c);
    if( a <= val && val <= z ){
      return val - a;
    }
    return -1;
  }
  static int[] buildCharFrequencyTable(String phrase) {
    int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
    for( char c : phrase.toCharArray()){
      int x = getCharNumber(c);
      if( x != -1 ){
        table[x]++;
      }
    }
    return table;
  }
}
