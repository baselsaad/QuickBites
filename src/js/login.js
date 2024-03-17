$('.message a').click(function(){
    $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
 });


document.addEventListener('DOMContentLoaded', function() {
    var loginLink = document.getElementById('login-link');

    loginLink.addEventListener('click', function(event) {
        document.querySelector('.popup').style.display = 'flex';
        document.body.style.overflow = 'hidden'; // disable scrolling
    });
});

document.addEventListener('DOMContentLoaded', function() {
    var loginLink = document.getElementById('login-close');

    loginLink.addEventListener('click', function(event) {
        document.querySelector('.popup').style.display = 'none';
        document.body.style.overflow = 'auto'; // enable scrolling
    });
});




