// uses jQuery and Bootstrap
const jQ = $.noConflict();

//set up memory
var memory = 0;

function outputNum() {
  try {
    var result = eval(jQ("#output").text());
    if (result == "NaN") {
      result = "ERROR";
    }
  } catch (e) {
    var result = "ERROR";
  } finally {
    return result;
  }
}
function memoryDisplay(numInMem) {
  if (numInMem == true) {
    jQ("#memoryStorage").text(memory);
  } else {
    jQ("#memoryStorage").text("N/A");
  }
}

jQ(document).ready(function(){
  memoryDisplay(false);

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
  //invert
  jQ("#invert").click(function(){
    jQ("#output").prepend("-(");
    jQ("#output").append(")");
  });
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
    memoryDisplay(false);
    memory = 0;
  });
  //M+
  jQ("#memoryAdd").click(function(){
    if (outputNum() != "ERROR") {
      memory = memory + outputNum();
      memoryDisplay(true);
      jQ("#output").text(0);
    }
  });
  //M-
  jQ("#memorySub").click(function(){
    if (outputNum() != "ERROR") {
      memory = memory - outputNum();
      memoryDisplay(true);
      jQ("#output").text(0);
    }
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

  //Other Functionalities ---------------------
  jQ(".col").mousedown(function(){
    jQ(this).css("border-style", "inset");
  });
  jQ(".col").mouseup(function(){
    jQ(this).css("border-style", "outset");
  });

});
