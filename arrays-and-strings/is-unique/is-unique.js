#!/bin/node 
function allUniqDS( s){ /* Implemnt algo to determine if strng has all uniq chars.  Solve using data structures */
  var hm = {}; //js object implemented hashmap internally
  for(var i=0; i< s.length; i++){
    var c = s[i];
    if(!hm.hasOwnProperty(c)) hm[c]=1;
    else return false;
  }
  return true;
}
function allUniqNoDSN2( s ){ /* Implemnt algo to determine if strng has all uniq chars.  Solve without using data structures */
  for(var i =0; i<s.length; i++){
    for(var j =i+1; j<s.length; j++){
      if( s[i] == s[j]){
        return false;
      }
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

var qa={ 'abcdefg'  : true, 'abcdafg'  : false, 'qwervasdf': true, 'success'  : false };
runTests(qa,allUniqDS);
runTests(qa,allUniqNoDSN2);
