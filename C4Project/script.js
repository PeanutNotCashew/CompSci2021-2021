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
    //creates day
    const container = document.createElement("td");
    const dayDiv = document.createElement("div");
    const text = document.createTextNode(i + 1);
    const element = document.getElementsByTagName("TR")[tableRow];
    dayDiv.appendChild(text);
    container.appendChild(dayDiv);
    element.appendChild(container);
  }
  //creates blank days
  let lastDay = new Date(year, month, daysInMonth).getDay();
  for (var i = 7; i > lastDay; i--) {
    const listItem = document.createElement("td");
    const element = document.getElementsByTagName("TR")[5];
    element.appendChild(listItem);
    element.lastChild.setAttribute("class", "blank");
  }
  //note to self: 8-4
}
