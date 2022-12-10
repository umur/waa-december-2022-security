/**
 * home.js
 */
'use strict';

document.addEventListener('DOMContentLoaded', function () {
  fetch('http://localhost:8080/products', {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json',
      authorization: 'Bearer ' + localStorage.getItem('token'),
    },
  })
    .then((response) => {
      if (response.ok) {
        response.json().then((data) => {
          for (let i = 0; i < data.length; i++) {
            document.getElementById('content').innerHTML +=
              '<div class="card" style="width: 18rem;">' +
              '<div class="card-body">' +
              '<h5 class="card-title">' +
              'Id: ' +
              data[i].id +
              '</h5>' +
              '<p class="card-text">' +
              'Product Name: ' +
              data[i].name +
              '</p>' +
              '<p class="card-text">' +
              'Product Price: ' +
              data[i].price +
              '</p>' +
              '</div>' +
              '</div>';
            //   document.getElementById('content').innerHTML = data;
          }
        });
      } else {
        document.location.href =
          'http://localhost:5500/src/main/resources/static/loginForm.html';
      }
    })
    .catch((error) => {
      document.location.href =
        'http://localhost:5500/src/main/resources/static/loginForm.html';
    });

  const button = document.getElementById('getProduct');
  button.addEventListener('click', function () {
    const field = document.getElementById('productId');
    const productId = field.value;
    fetch('http://localhost:8080/products/' + productId, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
        authorization: 'Bearer ' + localStorage.getItem('token'),
      },
    }).then((response) => {
      if (response.ok) {
        response.json().then((data) => {
          document.getElementById('content').innerHTML = '';
          document.getElementById('content').innerHTML +=
            '<div class="card" style="width: 18rem;">' +
            '<div class="card-body">' +
            '<h5 class="card-title">' +
            'Id: ' +
            data.id +
            '</h5>' +
            '<p class="card-text">' +
            'Product Name: ' +
            data.name +
            '</p>' +
            '<p class="card-text">' +
            'Product Price: ' +
            data.price +
            '</p>' +
            '</div>' +
            '</div>';
        });
      } else {
        document.location.href =
          'http://localhost:5500/src/main/resources/static/loginForm.html';
      }
    });
  });
});
