function getCookie(cname) {
  var cook = cname + "=";
  var decodedCookie = decodeURIComponent(document.cookie);
  var ca = decodedCookie.split(";");
  for (var i = 0; i < ca.length; i++) {
    var c = ca[i];
    while (c.charAt(0) == " ") {
      c = c.substring(1);
    }
    if (c.indexOf(cook) == 0) {
      return c.substring(cook.length, c.length);
    }
  }
  return "";
}

function checkAdminStatus() {
  var admin = getCookie("admin");
  if (admin == true || admin == "true") {
    let adminLink = document.getElementById("navbarAdmin");
    adminLink.classList.remove("hidden");
    console.log("hello");
  } else {
    return;
  }
}

function checkUser() {
  try {
    var user = getCookie("username");
    if (user != null && user != "" && user != undefined) {
      checkAdminStatus();
    } else if ((user = null || user == "" || user == undefined)) {
      window.location.href = "redirect.html";
    } else {
      return;
    }
  } catch (TypeError) {
    window.location.href = "redirect.html";
  }
}