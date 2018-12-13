#!/bin/node
// Write method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end ot hold the additional chars, and that you are given the true lenght of the string. ( java solution should use real char array for in place operation) EX: "Mr John Smith",13 -> "Mr%20John%20Smith"
function urlify( s, tl ){ // time: s
  var sc=0,ix,i=0;
  for(i=0;i<tl;i++){
    if(s[i]==' '){
      sc++;
    }
  }
  ix=tl+sc*2;
  for(i=tl-1;i>=0;i--){
    if(s[i]==' '){
      s[ix-1]='0';
      s[ix-2]='2';
      s[ix-3]='%';
      ix = ix -3;
    }
    else {
      s[ix-1]=s[i];
      ix--;
    }
  }
}

var s = "Mr John Smith    ";
var a = new Array(17);
a = s.split('');
urlify(a,13);
console.log(a.join(''));
