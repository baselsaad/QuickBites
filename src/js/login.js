/* eslint-disable linebreak-style */
/* eslint-disable spaced-comment */
/* eslint-disable linebreak-style */
/* eslint-disable eol-last */
/* eslint-disable quotes */
/* eslint-disable linebreak-style */
/* eslint-disable no-undef */
/* eslint-disable linebreak-style */
/* eslint-disable no-unused-vars */
// eslint-disable-next-line no-undef
$('.message a').click(() => {
  $('form').animate({ height: 'toggle', opacity: 'toggle' }, 'slow');
});

document.addEventListener('DOMContentLoaded', () => {
  const loginLink = document.getElementById('login-link');

  loginLink.addEventListener('click', (event) => {
    document.querySelector('.popup').style.display = 'flex';
    document.body.style.overflow = 'hidden'; // disable scrolling
  });
});

document.addEventListener('DOMContentLoaded', () => {
  const loginLink = document.getElementById('login-close');

  loginLink.addEventListener('click', (event) => {
    document.querySelector('.popup').style.display = 'none';
    document.body.style.overflow = 'auto'; // enable scrolling
  });

});

//-----------------------register -----------------
const registerForm = document.getElementById('registerForm');

registerForm.addEventListener('submit', async (event) => {
  event.preventDefault();
  const username = document.getElementById('username').value;
  const clientEmail = document.getElementById('email').value;
  const userPassword = document.getElementById('password').value;

  const user = { clientEmail,username, userPassword };

  try {
    const response = await fetch('http://localhost:8081/v1/signin', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(user),
    });

    if (response.ok) {
      // Handle successful registration (e.g., success message, redirect)
     // alert('Registration successful!');
      window.location.href = '/login';
    } else {
      const errorData = await response.json();
      // Display error message based on errorData (e.g., username taken)
    }
  } catch (error) {
    console.error(error);
    // Handle other errors (e.g., network issues)
  }
});

//------------------------login------------------------------------



