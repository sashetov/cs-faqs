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

runTests(qa,palindromePermut);
