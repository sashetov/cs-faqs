import java.util.*;
class oneAway {
  static boolean oneEditAway( String s1, String s2 ){ // time complexity: o(min(s1,s2)), space complexity: 
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
  static boolean oneEditInsert( String s1, String s2 ){ //assumes s1.length()<s2.length() for proper function
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
  static boolean oneEditAwayMerged( String s1, String s2 ){
    if( Math.abs( s1.length() - s2.length() ) > 1 ) return false;
    String ss1 = s1.length() < s2.length() ? s1: s2;
    String ss2 = s1.length() < s2.length() ? s2: s1;
    int ix1 = 0;
    int ix2 = 0;
    boolean fd= false;
    while( ix2 < ss2.length() && ix1 < ss1.length()  ) {
      if( ss1.charAt(ix1) != ss2.charAt(ix2) ) {
        if(fd) return false;
        fd=true;
        if(ss1.length() == ss2.length()) ix1++;
      }
      else ix1++;
      ix2++;
    }
    return true;
  }
  public static void main(String ... args){
    String[] s1 = {"pale","pales","pale","pale"};
    String[] s2 = {"ple" ,"pale" ,"bale","bae"};
    Boolean[] r = {true  ,true   ,true  ,false};
    for( int i =0; i< s1.length; i++){
      if(oneEditAway(s1[i],s2[i]) == r[i]) System.out.print( "PASSED oneEditAway ");
      else System.out.print("FAILED oneEditAway ");
      System.out.println(s1[i]+","+s2[i]+","+Boolean.toString(oneEditAway(s1[i],s2[i]))+","+Boolean.toString(r[i]));
      if(oneEditAwayMerged(s1[i],s2[i]) == r[i]) System.out.print( "PASSED oneEditAwayMerged ");
      else System.out.print("FAILED oneEditAwayMerged ");
      System.out.println(s1[i]+","+s2[i]+","+Boolean.toString(oneEditAwayMerged(s1[i],s2[i]))+","+Boolean.toString(r[i]));
    }
  }
}
