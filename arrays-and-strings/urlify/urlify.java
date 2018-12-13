import java.util.*;
public class urlify {
  public static void main( String... args ) {
    int len  = 13;                  // length of string to urlize
    String l = "Mr John Smith    "; // extra space padding included so no dynamic string resize
    char[] a = l.toCharArray();
    urlize( a , len );
    for (char c: a) { System.out.print(c); } System.out.print("\n");
  }
  static void urlize(char[] str, int len) {
    int spaceCount =0, index, i=0; //for (char c: str) { System.out.print(c); } System.out.print(":"+Integer.toString(len)+"\n");
    for( i = 0; i < len; i++ ){
      if( str[i] == ' ' ){
        spaceCount++;
      }
    }
    index = len + spaceCount * 2;
    if ( len < str.length ) str[len] = '\0'; //end array
    for ( i = len-1; i>=0; i-- ) {
      if( str[i] == ' '){
        str[index-1] = '0';
        str[index-2] = '2';
        str[index-3] = '%';
        index = index - 3;
      } else { //System.out.println("index - 1:"+Integer.toString(index-1) ); //System.out.println( "i:" + Integer.toString(i) );
        str[index-1] = str[i];
        index--;
      }
    }
  }
}
