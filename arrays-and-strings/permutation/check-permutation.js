#!/bin/node
 /* Given two strings s1,s2, write method to decide if one is a permutation of the other */
function sortString(s){ //N+NlogN time
  var ar = new Array(s.length);
  for(var i =0; i< s.length; i++){ // N time
    ar[i] = s.charAt(i);
  }
  ar = ar.sort(function(a,b){ return a.localeCompare(b) == 1 ; }); //NlogN
  s =  ar.join(''); //N time
  return s;
}
function isPermutationWithSorts(s1, s2) {//time: s1LOGs1 + s2LOGs2
  if(s1.length != s2.length ){
    return false;
  }
  var is = sortString(s1) == sortString(s2);
  return is;
}
function isPermutationASCIITwoPass(s1,s2){ // time: s1+s2
  var i;
  if( s1.length != s2.length ) return false;
  var letters = new Array(128); //number ASCII chars
  for( i =0; i<s1.length; i++ ) {
    if(!letters.hasOwnProperty(s1[i])) letters[s1[i]]=0;
    letters[s1[i]]++; //console.log(letters);
  }
  for( i=0; i<s2.length; i++ ){
    if(!letters.hasOwnProperty(s2[i])) letters[s2[i]]=0;
    letters[s2[i]]--; //console.log(letters);
    if( letters[s2[i]] < 0)  return false;
  }
  return true;
}
function runTests(qa,fn){
  var numOK=0, numTotal=Object.keys(qa).length;
  for (var i=0; i < qa.length; i++ ){
    var v = qa[i];
    var tr = fn(v.s1, v.s2);//console.log(tr,v); //tr for test result 
    if( tr==v.r ) {
      numOK++;
      console.log( "PASSED " + JSON.stringify(v) );
    }
    else {
      console.log( "FAILED " + JSON.stringify(v) );
    }
  }
  console.log(numOK+"/"+numTotal+" tests passed ok");
}
var qa=[ { s1 : 'asdf', s2: 'sdfa', r: true}, {s1: 'rob', s2: 'bro', r: true }, {s1: 'rob', s2: 'bror', r: false }, {s1: 'bbrroo', s2: 'fffaaa', r: false }];
runTests(qa,isPermutationWithSorts);
runTests(qa,isPermutationASCIITwoPass);
