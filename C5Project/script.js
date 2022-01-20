// uses jQuery and Bootstrap
const jQ = $.noConflict();

//set up memory
var memory = 0;

function outputNum() {
  try {
    var result = eval(jQ("#output").text());
  } catch (e) {
    var result = "ERROR";
  } finally {
    return result;
  }
}

jQ(document).ready(function(){
  //numbers (0-9)
  jQ(".numbers").click(function(){
    let buttonValue = jQ(this).text();
    buttonValue = Number(buttonValue);
    if (jQ("#output").text() == "0") {
      jQ("#output").text(buttonValue);
    }
    else if (jQ("#output").text() == "ERROR") {
      jQ("#output").text(buttonValue);
    } else {
      jQ("#output").append(buttonValue);
    }
  });
  //signs (+ - / *)
  jQ(".sign").click(function(){
    var getSign = jQ(this).text();
    jQ("#output").append(getSign);
  });
  //decimal
  jQ("#decimal").click(function(){
    jQ("#output").append(".");
  })
  //equals
  jQ("#equals").click(function(){
    jQ("#output").text(outputNum());
    console.log(outputNum());
  });

  //Special Functions -------------------------
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
