/**
 * login.js
 *
 */
'use strict';

document.addEventListener('DOMContentLoaded', function () {
  document
    .getElementById('loginForm')
    .addEventListener('submit', function (evt) {
      evt.preventDefault();
      const username = document.getElementById('username').value;
      const password = document.getElementById('password').value;
      const data = {
        email: username,
        password: password,
      };
      fetch('http://localhost:8080/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
      })
        .then((response) => {
          if (response.status === 200) {
            document.getElementById('message').innerHTML =
              'User logged in successfully';
            response.json().then((data) => {
              localStorage.setItem('token', data['token']);
              localStorage.setItem('refreshToken', data['refreshToken']);
              setTimeout(function () {
                document.location.href =
                  'http://localhost:5500/src/main/resources/static/index.html';
              }, 2000);
            });
          } else {
            document.getElementById('message').innerHTML =
              'Invalid credentials';
           
          }
        })
        .catch((error) => {
          document.getElementById('message').innerHTML = 'Invalid credentials';
        });
    });
});
