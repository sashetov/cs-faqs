import java.util.*;
class oneAway {
  static boolean oneEditAway( String s1, String s2 ){
    if(s1.length() == s2.length()) return oneEditReplace(s1,s2);
    else if ( s1.length() + 1 == s2.length() ) return oneEditInsert(s1,s2);
    else if ( s1.length() - 1 == s2.length() ) return oneEditInsert(s2,s1);
    return false;
  }
  static boolean oneEditReplace( String s1, String s2 ){
    boolean fd = false; //found diff
    for ( int i =0; i< s1.length(); i++){
      if( s1.charAt(i) != s2.charAt(i) ){
        if( fd ) return false;
        fd=true;
      }
    }
    return true;
  }
  static boolean oneEditInsert( String s1, String s2 ){
    int ix1=0;
    int ix2=0;
    while( ix2 < s2.length() && ix1 < s1.length() ){
      if( s1.charAt(ix1) != s2.charAt(ix2)  ) {
        if( ix1 != ix2 ) return false;
        ix2++;
      }
      else {
        ix1++;
        ix2++;
      }
    }
    return true;
  }
  public static void main(String ... args){
    String[] s1 = {"pale","pales","pale","pale"};
    String[] s2 = {"ple" ,"pale" ,"bale","bae"};
    Boolean[] r = {true  ,true   ,true  ,false};
    for( int i =0; i< s1.length; i++){
      if(oneEditAway(s1[i],s2[i]) == r[i]) System.out.print("PASSED ");
      else System.out.print("FAILED ");
      System.out.println(s1[i]+","+s2[i]+","+Boolean.toString(oneEditAway(s1[i],s2[i]))+","+Boolean.toString(r[i]));
    }
  }
}
