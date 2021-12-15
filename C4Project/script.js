const monthList = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
const weekList = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
const timeList = ["8:00 AM", "8:30 AM", "9:00 AM", "9:30 AM","10:00 AM","10:30 AM", "11:00 AM", "11:30 AM", "12:00 PM", "12:30 PM", "1:00 PM", "1:30 PM", "2:00 PM", "2:30 PM", "3:00 PM", "3:30 PM", "4:00 PM"]
let today = new Date().getDate();
const thisMonth = new Date().getMonth();
const thisYear = new Date().getFullYear();
let month = thisMonth;
let year = thisYear;
var appointmentDay = "";

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

function createForm(day) {
  document.getElementById("modal").style.display = "block";
  appointmentDay = day;
  showTab(0);
  document.getElementById("displayDay").innerHTML = monthList[month] + " " + day + " " + year;
}

function showTab(tab) {
  for (var i = 0; i < document.getElementsByClassName("tab").length; i++) {
    document.getElementsByClassName("tab")[i].style.display = "none";
  }
  document.getElementsByClassName("tab")[tab].style.display = "block";
}

function showAdd() {
  showTab(1);
  for (var i = 0; i < timeList.length; i++) {
    const listItem = document.createElement("option");
    const node = document.createTextNode(timeList[i]);
    listItem.appendChild(node);
    listItem.setAttribute("value", i+1);
    const element = document.getElementById("appointmentTime");
    element.appendChild(listItem);
  }
}

function hideForm(){
  document.getElementById("modal").style.display = "none";
}

function add() {
  let time = document.getElementById("appointmentTime").value;
  let description = document.getElementById("appointmentTextAdd").value
  let divText = timeList[time-1] + " " + description;

  const listItem = document.createElement("div");
  const node = document.createTextNode(divText);
  listItem.appendChild(node);
  listItem.setAttribute("style", "order: " + time);
  const element = document.getElementById(appointmentDay);
  element.appendChild(listItem);

  hideForm();
}
