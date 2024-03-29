//const loginObjectFromLocalStorage = localStorage.getItem('g_LoginObject');
//window.g_LoginObject = loginObjectFromLocalStorage ? JSON.parse(loginObjectFromLocalStorage) : null;

window.g_LoginObject = null;

var orderLinks = document.getElementsByClassName("orderLink");
for (var i = 0; i < orderLinks.length; i++) {
    orderLinks[i].addEventListener("click", function (event) {

        if (window.g_LoginObject === null) {
            event.preventDefault(); // Prevent the default action (redirecting to order.html)
            alert("You have to login first!");
        }
    });
}