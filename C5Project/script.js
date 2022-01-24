// uses jQuery
const jQ = $.noConflict();

//set up memory
var memory = 0;
var ridNumber = true;

//evaluates equation and checks for errors
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
//decides whether to display memory
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
    //or statement
    if (jQ("#output").text() == "0" || jQ("#output").text() == "ERROR" || ridNumber == true) {
      jQ("#output").text(buttonValue);
    } else {
      jQ("#output").append(buttonValue);
    }
    ridNumber = false;
  });
  //signs (+ - / *)
  jQ(".sign").click(function(){
    var getSign = jQ(this).text();
    jQ("#output").append(getSign);
    ridNumber = false;
  });
  //decimal
  jQ("#decimal").click(function(){
    jQ("#output").append(".");
    ridNumber = false;
  })
  //invert
  jQ("#invert").click(function(){
    jQ("#output").prepend("-(");
    jQ("#output").append(")");
    ridNumber = false;
  });
  //equals
  jQ("#equals").click(function(){
    jQ("#output").text(outputNum());
    ridNumber = true;
    //for troubleshooting
    //console.log(outputNum());
  });

  //Special Functions -------------------------
  //displays memory in output field
  jQ("#memoryReturn").click(function(){
    if (jQ("#memoryStorage").text() == "N/A") {
      jQ("#output").text("ERROR");
    } else {
      jQ("#output").text(memory);
      ridNumber = false;
    }
  });
  //clears memory
  jQ("#memoryClear").click(function(){
    memoryDisplay(false);
    memory = 0;
  });
  //adds value in field to memory
  jQ("#memoryAdd").click(function(){
    if (outputNum() != "ERROR") {
      memory = memory + outputNum();
      memoryDisplay(true);
      jQ("#output").text(0);
    }
  });
  //subtracts value in field from memory
  jQ("#memorySub").click(function(){
    if (outputNum() != "ERROR") {
      memory = memory - outputNum();
      memoryDisplay(true);
      jQ("#output").text(0);
    }
  });
  //clears output field
  jQ("#clear").click(function(){
    jQ("#output").text(0);
  });
  //percent (divide value in field by 100)
  jQ("#percent").click(function(){
    jQ("#output").text(outputNum()/100);
    ridNumber = false;
  });
  //divide one by value in field
  jQ("#oneDivide").click(function(){
    jQ("#output").text(1/outputNum());
    ridNumber = false;
  });
  //get square root
  jQ("#squareRoot").click(function(){
    let squareRoot = Math.sqrt(outputNum());
    jQ("#output").text(squareRoot);
    ridNumber = false;
  });

  //Key presses (#s, signs, and =) ------------
  jQ(document).keydown(function(event){
    switch (event.which) {
      case 8:
        jQ("#clear").click();
        break;
      case 13:
        jQ("#equals").click();
        break;
      case 48:
        jQ("#zero").click();
        break;
      case 49:
        jQ("#one").click();
        break;
      case 50:
        jQ("#two").click();
        break;
      case 51:
        jQ("#three").click();
        break;
      case 52:
        jQ("#four").click();
        break;
      case 53:
        jQ("#five").click();
        break;
      case 54:
        jQ("#six").click();
        break;
      case 55:
        jQ("#seven").click();
        break;
      case 56:
        jQ("#eight").click();
        break;
      case 57:
        jQ("#nine").click();
        break;
      case 88:
        jQ("#times").click();
        break;
      case 187:
        jQ("#plus").click();
        break;
      case 189:
        jQ("#minus").click();
        break;
      case 190:
        jQ("#decimal").click();
        break;
      case 191:
        jQ("#divide").click();
        break;
      default:

    }
  });

  //Button looks ------------------------------
  jQ(".col").mousedown(function(){
    jQ(this).css("border-style", "inset");
  });
  jQ(".col").mouseup(function(){
    jQ(this).css("border-style", "outset");
  });

});
