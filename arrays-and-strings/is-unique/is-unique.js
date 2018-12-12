#!/bin/node
function allUniqDS( s ){ /* Implemnt algo to determine if strng has all uniq chars.  Solve using data structures */
  var hm = {}; //js object implemented hashmap internally
  for(var i=0; i< s.length; i++){
    var c = s[i];
    if(!hm.hasOwnProperty(c)) hm[c]=1;
    else return false;
  }
  return true;
}
function allUniqArrayNtime( str ){ /* Implemnt algo to determine if str has all uniq chars.  Solve without using data structures */
  if( str.length > 128 ) return false;
  var charset=new Array(128);
  for( var i=0; i< str.length; i++){
    var val = str.charCodeAt( i );
    if( charset[val] ) return false;
    charset[val] = true;
  }
  return true;
}
function allUniqArrayNtimeSmallSpace( str ) { /* uses bit shifting to reduce space complexity */
  var checker =0;
  var cca='a'.charCodeAt(0);
  for (var i=0; i < str.length; i++){
    var v = str.charCodeAt(i) - cca;
    var oslv = (1 << v);
    var cao = checker & oslv;
    /*console.log(
      "c=c|(1<<v): " + zeropad(checker.toString(2),32)  + " " + str[i] + " v=" + v + " " + str +
    "\n1<<v:       " + zeropad(oslv.toString(2),32)     +
    "\nc&(1<<v):   " + zeropad(cao.toString(2),32));*/
    if( cao > 0 ) return false;
    checker |= (oslv);
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
runTests(qa,allUniqArrayNtime);
runTests(qa,allUniqArrayNtimeSmallSpace);
