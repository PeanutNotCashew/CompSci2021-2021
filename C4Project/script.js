const monthList = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
const weekList = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];

function createCalendar() {
  //gets month and year
  let month = new Date().getMonth();
  let year = new Date().getFullYear();
  document.getElementById("displayMonth").innerHTML = monthList[month] + " " + year;
  //creates table
  const daysInMonth = new Date(year, month, 0).getDate() + 1;
  let firstDay = new Date(year, month, 1). getDay();
  //week days
  const listItem = document.createElement("tr");
  const element = document.getElementById("calendar");
  element.appendChild(listItem);
  for (var i = 0; i < weekList.length; i++) {
    const listItem = document.createElement("td");
    const node = document.createTextNode(weekList[i]);
    listItem.appendChild(node);
    const element = document.getElementsByTagName("TR")[0];
    element.appendChild(listItem);
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
  }
  //creates days
  for (var i = 0; i < daysInMonth; i++) {
    let day = new Date(year, month, i);
    let weekday = day.getDay();
    let tableRow = (i + firstDay - weekday - 1)/7 + 1;
    console.log(tableRow);
    if (day.getDay() == 0) {
      const listItem = document.createElement("tr");
      const element = document.getElementById("calendar");
      element.appendChild(listItem);
    }
    const listItem = document.createElement("td");
    const node = document.createTextNode(i + 1);
    listItem.appendChild(node);
    const element = document.getElementsByTagName("TR")[tableRow];
    element.appendChild(listItem);
  }
  //note to self: 8-4
}
