const reservationForm = document.getElementById('bookTableButton');

reservationForm.addEventListener('click', async (event) => {

  let username = document.getElementById('userNameInput').value;
  var email = document.getElementById('emailInput').value;


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
      } else {
        // Handle invalid username or password
        console.error('Invalid username or password');
        alert('Invalid username or email. Please try again.');
      }
      return user;
    })
    .then(async (client) => {
      const time = document.getElementById('time').value
      const date = document.getElementById('date').value

      if (time === '' || date === '') {
        alert('Please fill out all fields.');
        return;
      }

      const reservation = { date, time, client };

      const response = await fetch('http://localhost:8081/v1/create/reservation', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(reservation),
      });

      console.log("here from fetch: " + client.username)
      console.log("here is the response res from fetch: " + reservation)

      if (response.ok) {
        console.log("here is the response res: " , reservation);
        alert('Reservation successful!');
      } else {
        const errorData = response.json();
        console.log("here is the response res: " + errorData);
      }

      return await response.json();
    })
    .then(async res => {   // add reservation

      const response = await fetch('http://localhost:8081/v1/book/' + username + '/' + res.bookingId, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(),
      });

      if (response.ok) {
        // Handle successful registration (e.g., success message, redirect)
        alert('Reservation sent via email!');
        // window.location.href = '/login';
        //return response.json();
      } else {
        const errorData = response.json();
        // Display error message based on errorData (e.g., username taken)
      }
    })
    .catch(error => {
      // Handle login error
      console.error('Login error:', error);
      alert('Login failed. Please try again.');
    });

});
