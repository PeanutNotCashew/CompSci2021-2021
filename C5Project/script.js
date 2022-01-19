// uses jQuery and Bootstrap
const jQ = $.noConflict();

//set up memory
var memory = 0;

function outputNum() {
  return Number(jQ("#output").text());
}

jQ(document).ready(function(){
  //MR
  jQ("#memoryReturn").click(function(){
    jQ("#output").text(memory);
  });
  //MC
  jQ("#memoryClear").click(function(){
    memory = 0;
  });
  //M+
  jQ("#memoryAdd").click(function(){
    memory = memory + outputNum();
  });
  //M-
  jQ("#memorySub").click(function(){
    memory = memory - outputNum();
  });
  //CE
  jQ("#clear").click(function(){
    jQ("#output").text(0);
  });
  //numbers (0-9)
  jQ(".numbers").click(function(){
    let buttonValue = jQ(this).text();
    buttonValue = Number(buttonValue);
    if (jQ("#output").text() == "0") {
      jQ("#output").text(buttonValue);
    } else {
      jQ("#output").append(buttonValue);
    }
  });
  //percent (divide value in field by 100)
  jQ("#percent").click(function(){
    jQ("#output").text(outputNum()/100);
  });
  //divide one by value in field
  jQ("#oneDivide").click(function(){
    jQ("#output").text(1/outputNum());
  });
  //get square root
  jQ("#squareRoot").click(function(){
    let squareRoot = Math.sqrt(outputNum());
    jQ("#output").text(squareRoot);
  });

});
