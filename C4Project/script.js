//value references
const monthList = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
const weekList = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
const timeList = ["8:00 AM", "8:30 AM", "9:00 AM", "9:30 AM","10:00 AM","10:30 AM", "11:00 AM", "11:30 AM", "12:00 PM", "12:30 PM", "1:00 PM", "1:30 PM", "2:00 PM", "2:30 PM", "3:00 PM", "3:30 PM", "4:00 PM"]
//set variables
const today = new Date().getDate();
const thisMonth = new Date().getMonth();
const thisYear = new Date().getFullYear();
let month = thisMonth;
let year = thisYear;
var appointmentDay = "";

//creates calendar
function createCalendar() {
  const daysInMonth = new Date(year, month, 0).getDate() + 1;
  document.getElementById("calendar").innerHTML = "";
  //displays month and year
  document.getElementById("calendarHead").innerHTML = monthList[month] + " " + year;
  //creates table
  let firstDay = new Date(year, month, 1). getDay();
  //week days
  const listItem = document.createElement("tr");
  const element = document.getElementById("calendar");
  element.appendChild(listItem);
  for (var i = 0; i < weekList.length; i++) {
    const listItem = document.createElement("th");
    const node = document.createTextNode(weekList[i]);
    listItem.appendChild(node);
    const element = document.getElementsByTagName("TR")[0];
    element.appendChild(listItem);
    element.getElementsByTagName("th")[i].setAttribute("class", "weekday")
  }
  //creates blank rows at beginning
  if (firstDay != 0) {
    const listItem = document.createElement("tr");
    const element = document.getElementById("calendar");
    element.appendChild(listItem);
  }
  for (var i = 1; i < firstDay; i++) {
    const listItem = document.createElement("td");
    const element = document.getElementsByTagName("TR")[1];
    element.appendChild(listItem);
    element.getElementsByTagName("td")[i-1].setAttribute("class", "blank");
  }
  //creates days
  for (var i = 0; i < daysInMonth; i++) {
    let day = new Date(year, month, i);
    let weekday = day.getDay();
    let tableRow = (i + firstDay - weekday - 1)/7 + 1;
    //creates row if sunday
    if (day.getDay() == 0) {
      const listItem = document.createElement("tr");
      const element = document.getElementById("calendar");
      element.appendChild(listItem);
    }
    //creates day, with id of day
    let date = i + 1;
    const container = document.createElement("td");
    const dayDiv = document.createElement("div");
    const text = document.createTextNode(date);
    const element = document.getElementsByTagName("TR")[tableRow];
    dayDiv.setAttribute("class", "date");
    dayDiv.appendChild(text);
    container.setAttribute("id", date);
    container.setAttribute("onclick", "createForm(" + date + ")")
    container.appendChild(dayDiv);
    element.appendChild(container);
  }
  //creates blank days
  let lastDay = new Date(year, month, daysInMonth).getDay();
  let tableRow = (daysInMonth + firstDay - lastDay - 1)/7 + 1;
  for (var i = 7; i > lastDay; i--) {
    const listItem = document.createElement("td");
    const element = document.getElementsByTagName("TR")[tableRow];
    element.appendChild(listItem);
    element.lastChild.setAttribute("class", "blank");
  }
  //signifies today
  if (month == thisMonth && year == thisYear) {
    document.getElementById(today + 1).childNodes[0].style.backgroundColor = "steelBlue";
    document.getElementById(today + 1).childNodes[0].style.color = "white";
  }
  //note to self: 8-4
}
//goes back a month
function lastMonth() {
  if (month == 0) {
    month = 11;
    year --;
  }
  else {
    month --;
  }
  createCalendar();
}
//goes forwards a month
function nextMonth() {
  if (month == 11) {
    month = 0;
    year ++;
  }
  else {
    month ++;
  }
  createCalendar();
}
//goes to this month
function goToThisMonth() {
  month = thisMonth;
  year = thisYear;
  createCalendar();
}
//when day clicked on, displays form
function createForm(day) {
  document.getElementById("modal").style.display = "block";
  appointmentDay = day;
  showTab(0);
  document.getElementById("displayDay").innerHTML = monthList[month] + " " + day + " " + year;
}
//switches between tabs
function showTab(tab) {
  for (var i = 0; i < document.getElementsByClassName("tab").length; i++) {
    document.getElementsByClassName("tab")[i].style.display = "none";
  }
  document.getElementsByClassName("tab")[tab].style.display = "block";
}
//switches to add tab and displays all times
function showAdd() {
  showTab(1);
  document.getElementsByClassName('appointmentTime')[0].innerHTML = "";
  for (var i = 0; i < timeList.length; i++) {
    const listItem = document.createElement("option");
    const node = document.createTextNode(timeList[i]);
    listItem.appendChild(node);
    listItem.setAttribute("value", i+1);
    const element = document.getElementsByClassName('appointmentTime')[0];
    element.appendChild(listItem);
  }
}
//switches to modify tab and displays existing time slots
function showModify() {
  document.getElementsByClassName('appointmentTime')[1].innerHTML = "";
  let appointmentNum = document.getElementById(appointmentDay).childNodes;
  if (appointmentNum.length == 1) {
    showTab(4);
  }else {
    showTab(2);
  }
  for (var i = 1; i < appointmentNum.length; i++) {
    const listItem = document.createElement("option");
    const node = document.createTextNode(appointmentNum[i].innerHTML);
    listItem.appendChild(node);
    listItem.setAttribute("value", i);
    const element = document.getElementsByClassName('appointmentTime')[1];
    element.appendChild(listItem);
  }
}
//switches to delete tab and displays existing time slots
function showDelete() {
  document.getElementsByClassName('appointmentTime')[2].innerHTML = "";
  let appointmentNum = document.getElementById(appointmentDay).childNodes;
  if (appointmentNum.length == 1) {
    showTab(4);
  }else {
    showTab(3);
  }
  for (var i = 1; i < appointmentNum.length; i++) {
    const listItem = document.createElement("option");
    const node = document.createTextNode(appointmentNum[i].innerHTML);
    listItem.appendChild(node);
    listItem.setAttribute("value", i);
    const element = document.getElementsByClassName('appointmentTime')[2];
    element.appendChild(listItem);
  }
}
//hides form
function hideForm(){
  document.getElementById("modal").style.display = "none";
}
//creates event with text and time slot (order)
function add() {
  let time = document.getElementsByClassName("appointmentTime")[0].value;
  let description = document.getElementById("appointmentTextAdd").value;
  let divText = timeList[time-1] + ": " + description;

  const listItem = document.createElement("div");
  const node = document.createTextNode(divText);
  listItem.appendChild(node);
  listItem.setAttribute("style", "order: " + time);
  listItem.setAttribute("class", "appointment")
  const element = document.getElementById(appointmentDay);
  element.appendChild(listItem);

  hideForm();
}
//gets event div and modifies inner text
function modify() {
  let slot = document.getElementsByClassName("appointmentTime")[1].value;
  let description = document.getElementById("appointmentTextModify").value;
  let appointmentNum = document.getElementById(appointmentDay).childNodes;
  let time = Number(appointmentNum[slot].style.order);
  let divText = timeList[time-1] + ": " + description;

  appointmentNum[slot].innerHTML = divText;

  hideForm();
}
//gets event div and deletes
function deleteFinal(){
  let time = document.getElementsByClassName("appointmentTime")[2].value;
  let appointmentNum = document.getElementById(appointmentDay);

  appointmentNum.removeChild(appointmentNum.childNodes[time]);

  hideForm();
}

// font, headerFont, cellWidth, cellHeight, backgroundColor
let styles = ["arial", "georgia", "100", "75", "green"];
//changes item in style array
function changeStyle(styleNum, inputName) {
  styles[styleNum] = document.getElementById(inputName).value;
  applyStyles();
}
//saves defaults
function defaultStyles() {
  styles = ["arial", "georgia", "100", "75", "green"];
  applyStyles();
}
//inputs styles
function applyStyles() {
  let regularFont = "* {font-family: " + styles[0] + ", sans-serif}"
  let headerFont = "h1 {font-family: " + styles[1] + ", sans-serif}"
  let tableHead = "th {width: " + styles[2] + "px}"
  let tableCell = "td {width: " + styles[2] + "px;" + " height:" + styles[3] + "px}"
  let webpageColor = "body {background-color: " + styles[4] + "}"
  document.getElementsByTagName("style")[0].innerHTML = webpageColor + " " + regularFont + " " + headerFont + " " + tableHead + " " + tableCell;
}
