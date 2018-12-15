#!/bin/node
/* Given a string, write a funciton to tcheck if its a permutation of a plindrome.  A palindrome is a word or phrase that is the same forwards and backwards.  A permutation is a rearrangement of letters.  The palindrome does not need ot be limited to just dictionary words.  EX: "tact coa" => true ( permutations: "taco cat", "atco cta", ... ). */
function palindromePermut(s){ // time complexity: s
  var charCounts={},i, oddCount=0;
  for( i=0; i<s.length; i++){
    var c = s[i], cc = s[i].charCodeAt(0), a = "a".charCodeAt(0), z = "z".charCodeAt(0);
    if( cc >= a && cc <= z) { // is [a-z] char
      if ( !charCounts.hasOwnProperty( c ) )
        charCounts[c]=1;
      else  charCounts[c]++;
    }
  }
  for ( i in charCounts ){
    if( charCounts[i] % 2 == 1 ){
      oddCount++;
      if(oddCount > 1)
        return false;
    }
  }
  return true;
}
function zeropad(s,l){
  var pad='';
  if(s.length<l){
    var d=l-s.length;
    for(var i=0; i<d; i++){
      pad+='0';
    }
  }
  s = pad+s;
  return s;
}
function makeBinary( n ){
  return zeropad( n.toString(2), 32);
}
function getCharNum(c) {
  var a = "a".charCodeAt(0),
      z = "z".charCodeAt(0),
      v = c.charCodeAt(0);
  if ( a <=v && v <=z ) return v-a;
  return -1
}
function checkExactlyOneBitSet( v ){ //console.log("     v-1: "+makeBinary(v - 1)+"\n"+" v&(v-1): "+makeBinary(v & (v - 1)));
  return ( v & ( v - 1 ) ) == 0;
}
function toggle( v, ix) {
  if( ix < 0 ) return v;
  var m = 1 << ix;
  if( (v & m)==0) v |= m;
  else v &= ~m;
  return v;
}
function createBitVector(s){
  var v=0,i,c,x;
  for(i in s){
    c=s[i];
    x = getCharNum(c);
    v = toggle(v,x); //console.log("       v: "+makeBinary(v)+" '"+c+"' "+" x:"+x );
  }
  return v;
}
function palindromePermutBitShift(s){ //time complexity s, space complexity 1
  var v = createBitVector(s);//bit vector
  return ( v == 0 || checkExactlyOneBitSet(v));
}
function runTests(answers,fn){
  var numOK=0, numTotal=Object.keys(answers).length;
  for (var k in answers ) {
    var v = answers[k];
    var tr = fn(k); //tr for test result
    if( tr==v ) {
      numOK++; 
      console.log("PASSED "+k);
    }
    else {
      console.log("FAILED "+k);
    }
  }
  console.log(numOK +"/"+numTotal+" tests passed ok");
}
var qa = { "sssseeh":true, "seshs es":true, "atco cta":true,"taco cat":true, "mthing else":false };
runTests( qa,palindromePermut );
runTests( qa,palindromePermutBitShift );
