const monthList = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
const weekList = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];

function createCalendar() {
  //gets month and year
  let month = new Date().getMonth();
  let year = new Date().getFullYear();
  document.getElementById("displayMonth").innerHTML = monthList[month] + " " + year;
  //creates table

  //note to self: 8-4
}
