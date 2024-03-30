window.g_LoginObject = JSON.parse(localStorage.getItem('g_LoginObject'));

// Replace the Login link with the dropdown
if (window.g_LoginObject !== null) {
    var loginLinkRect = document.getElementById('login-link').getBoundingClientRect();

    // Create the dropdown
    var dropdown = document.getElementById('dropdown').cloneNode(true);
    dropdown.style.display = 'block'; // Show the dropdown
    dropdown.style.position = 'absolute';
    dropdown.style.top = loginLinkRect.top + 'px';
    dropdown.style.left = loginLinkRect.left + 'px';

    // Append the dropdown to the document body
    document.body.appendChild(dropdown);

    // Add a click event listener to the Logout link
    document.addEventListener('click', function (event) {
        if (event.target && event.target.id === 'logout-link') {

            localStorage.removeItem('g_LoginObject');
            window.g_LoginObject = null;
            window.location.reload();
        }
    });
}

var orderLinks = document.getElementsByClassName("orderLink");
for (var i = 0; i < orderLinks.length; i++) {
    orderLinks[i].addEventListener("click", function (event) {

        if (window.g_LoginObject === null) {
            event.preventDefault(); // Prevent the default action (redirecting to order.html)
            alert("You have to login first!");
        }
    });
}

var orderLinks = document.getElementsByClassName("reservationLink");
for (var i = 0; i < orderLinks.length; i++) {
    orderLinks[i].addEventListener("click", function (event) {

        if (window.g_LoginObject === null) {
            event.preventDefault(); // Prevent the default action (redirecting to order.html)
            alert("You have to login first!");
        }
    });
}