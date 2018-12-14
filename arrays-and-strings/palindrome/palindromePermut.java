import java.util.*;
public class palindromePermut {
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
  static boolean isPermutationOfPalindrome( String phrase ) { // o(n) time, no optimizations ( two pass ), s space complexity for table
    int[] table = buildCharFrequencyTable( phrase );
    return checkMaxOneOdd( table );
  }
  static boolean isPermutationOfPalindromeOnePass( String phrase ) { // o(n) time, alternate ( single pass ), s space complexity for table
    int countOdd = 0;
    int a = Character.getNumericValue('a');
    int z = Character.getNumericValue('z');
    int[] table = new int[z-a+1];
    for( char c : phrase.toCharArray()){
      int x = getCharNumber(c);
      if( x!=-1){
        table[x]++;
        if( table[x] %2 ==1 ){
          countOdd++;
        }
        else countOdd--;
      }
    }
    return countOdd <=1;
  }
  static int toggle( int bitVector, int index) {
    if( index < 0 ) return bitVector;
    int mask = 1<<index;
    if( ( bitVector & mask )==0){
      bitVector |=mask;
    }
    else{
      bitVector &= ~mask;
    }
    return bitVector;
  }
  static int createBitVector( String phrase ){
    int bitVector=0;
    for (char c: phrase.toCharArray()){
      int x = getCharNumber(c);
      bitVector = toggle( bitVector, x );
    }
    return bitVector;
  }
  static boolean checkExactlyOneBitSet( int bitVector){
    return ( bitVector & ( bitVector -1 )) == 0;
  }
  static boolean isPermutationOfPalindromeBitShift( String phrase ){ //o(n) time complexity, 1 space complexity for int
    int bitVector = createBitVector( phrase );
    return bitVector == 0 || checkExactlyOneBitSet( bitVector );
  }
  public static void main(String... args) {
    String[] strs= { "sssseeh", "seshs es", "atco cta","taco cat", "mthing else" };
    for ( int i = 0; i < strs.length; i++ ){
      System.out.println( "isPermutationOfPalindrome " + strs[i]+": "+ Boolean.toString(isPermutationOfPalindrome( strs[i])) );
      System.out.println( "isPermutationOfPalindromeOnePass " + strs[i]+": "+ Boolean.toString(isPermutationOfPalindromeOnePass( strs[i])) );
      System.out.println( "isPermutationOfPalindromeBitShift" + strs[i]+": "+ Boolean.toString(isPermutationOfPalindromeBitShift( strs[i])) );
    }
  }
}
