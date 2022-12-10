/**
 *
 * signup.js
 *
 * @author: Abel Kifletsion
 *
 */
'use strict';

document.addEventListener('DOMContentLoaded', function () {
  document
    .getElementById('signupForm')
    .addEventListener('submit', function (evt) {
      evt.preventDefault();
      const username = document.getElementById('username').value;
      const password = document.getElementById('password').value;
      const email = document.getElementById('email').value;
      const data = {
        username: username,
        password: password,
        email: email,
      };
      fetch('localhost:8080/signup', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
      }).then((response) => {
        if (response.status === 200) {
          document.getElementById('message').innerHTML =
            'User created successfully';
          response.json().then((data) => {
            const token = data['authorization'];
            localStorage.setItem('token', token);
          });
        } else {
          document.getElementById('message').innerHTML = 'Invalid credentials';
        }
      });
    });
});
