const reservationForm = document.getElementById('reservationForm');

reservationForm.addEventListener('submit', async (event) => {
event.preventDefault();
let username = document.getElementById('login-link').textContent
console.log(username) 
var email = document.getElementById('reservation-email').value
await fetch('http://localhost:8081/v1/users/' + username)
    .then(response => {
        if (!response.ok) {
            throw new Error('Failed to fetch user data');
        }
        return response.json();
    })
    .then(user => {
        // Check if user exists and password matches
        if (user && user.clientEmail === email) {
            // Handle successful login
            console.log('Login successful:', user);
          //var btn = document.getElementById('reservation-btn').textContent = "submited";
          var btn = document.getElementById('reservation-btn')
          btn.style.display = "none"
           // loginForm.style.display = 'none';
            // Redirect to another page or do whatever you need after successful login
        } else {
            // Handle invalid username or password
            console.error('Invalid username or password');
            alert('Invalid username or password. Please try again.');
        }
        return user;
    })
    .then(async (client) =>  {
        const time = document.getElementById('time').value
        const date = document.getElementById('date').value
        const reservation = {date,time,client};

            const response = await fetch('http://localhost:8081/v1/create/reservation', {
              method: 'POST',
              headers: { 'Content-Type': 'application/json' },
              body: JSON.stringify(reservation),
            });
             console.log("here from fetch: "+client.username)
             console.log("here is the response res from fetch: " + reservation)
            if (response.ok) {
              console.log("here is the response res: " + reservation) 
              var profileInfo = document.getElementById("profile-info");

              // Populate profile information
              profileInfo.innerHTML = "<p>Name: " + client.username + "</p>" +
                            "<p>Email: " + client.clientEmail + "</p>" +
                            "<p>date: "  + date + "</p>" +
                            "<p>time: "  + time + "</p>"
              // Handle successful registration (e.g., success message, redirect)
             // alert('Registration successful!');
             // window.location.href = '/login';
             //return response.json();
            } else {
              const errorData = response.json();
              // Display error message based on errorData (e.g., username taken)
            }
             
             return await response.json();
    })
    .then(async res => {        // add reservation

        const response = await fetch('http://localhost:8081/v1/book/' + username +'/' + res.bookingId, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(),
          });
           
          if (response.ok) {
              
            // Handle successful registration (e.g., success message, redirect)
           // alert('Registration successful!');
           // window.location.href = '/login';
           //return response.json();
          } else {
            const errorData = response.json();
            // Display error message based on errorData (e.g., username taken)
          }
        
           //return response.json();

    })
    .catch(error => {
      // Handle login error
      console.error('Login error:', error);
      alert('Login failed. Please try again.');
  });

});
