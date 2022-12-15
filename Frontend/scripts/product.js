"use strict"

let products = [];

const apiBaseUrl = "http://localhost:8080/api/v1";
const productUrl = apiBaseUrl + "/products";


let myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");
myHeaders.append("Authorization", `Bearer ${localStorage.getItem("token")}`);

let selectedProductId = null;

loadProducts();

function loadProducts() {
    let url = productUrl;
    fetch(url, {
        method: "GET",
        headers: myHeaders
    })
        .then((res) => res.json())
        .then((data) => {
            products = data;
            let productListContent = "";

            products.forEach(product => (productListContent += writeProductRow(product)));

            const productTableBody = document.getElementById("product-table-body");
            productTableBody.innerHTML = productListContent;
        })
        .catch(function (err) {
            console.log(err);
            console.log("Error fetching Products");
        });
}

function loadProductDetails(productId) {
    document.getElementById("submitButton").innerHTML = "Update";

    let url = productUrl + "/" + productId;
    fetch(url, {
        method: "GET",
        headers: myHeaders
    })
        .then((res) => res.json())
        .then((data) => {
            document.getElementById('name').value = data.name;
            document.getElementById('price').value = data.price;
            document.getElementById('rating').value = data.rating;
        
            var categoryOptions = document.getElementById('category');
        
            for (var i = 0; i < categoryOptions.length; i++) {
                if (categoryOptions[i].value == data.category.name) {
                    categoryOptions[i].selected = true;
                    break;
                }
            }

            selectedProductId = data.id;
        })
        .catch(function (err) {
            console.log(err);
            console.log("Error fetching Courses");
        });
}

function writeProductRow(product) {
    //const product = encodeURIComponent(JSON.stringify(stu));
    return `
        <tr id="row-stu-${product.id}">
            <td>${product.id}</td>
            <td>${product.category.name}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.rating}</td>
            <td class="w-20">
                <button class="btn btn-sm btn-outline-primary py-0" 
                        style="font-size: 0.95em;" 
                        data-bs-toggle="modal" 
                        data-bs-target="#productDetailsModal"
                        onclick="loadProductDetails('${product.id}')">
                        <i class="fa fa-edit"> Edit</i>
                </button>
                <button class="btn btn-sm btn-outline-primary py-0" 
                        style="font-size: 0.95em;" 
                        data-bs-toggle="modal"
                        data-bs-target="#confirmDeleteModal"
                        onclick="confirmDeleteProduct('${product.id}')">
                        <i class="fa fa-trash"> Delete</i>
                </button>
            </td>
        </tr>
    `;
}

function submitForm() {
    if (!selectedProductId) addProduct();
    else updateProduct();
}

function closeProductDetailsModal() {
    const productModalElement = document.getElementById("productDetailsModal");
    const modal = bootstrap.Modal.getInstance(productModalElement);
    modal.hide();

    document.getElementById('name').value = "";
    document.getElementById('price').value = "";
    document.getElementById('rating').value = "";
    document.getElementById('category').value = "";

    document.getElementById("submitButton").innerHTML = "Save";
    selectedProductId = null;
}

function confirmDeleteProduct(productId) {
    selectedProductId = productId;
}

function closeConfirmDeleteModal() {
    const deleteConfirmModal = document.getElementById("confirmDeleteModal");
    const modal = bootstrap.Modal.getInstance(deleteConfirmModal);
    modal.hide();

    selectedProductId = null;
}

function addProduct() {
    var name = document.getElementById('name').value;
    var price = document.getElementById('price').value;
    var rating = document.getElementById('rating').value;
    const category = document.getElementById('category').value;

    const product = { id: 0, name, price, rating, category };
    const data = JSON.stringify(product);

    let url = productUrl;
    fetch(url, {
        method: "POST",
        headers: myHeaders,
        body: data,
        redirect: "follow",
    })
        .then((res) => {
            console.log(res.text());
        })
        .then((res) => {
            closeProductDetailsModal();
            loadProducts();
        })
        .catch((error) => console.log("error", error));
}

function updateProduct() {
    const name = document.getElementById('name').value;
    const price = document.getElementById('price').value;
    const rating = document.getElementById('rating').value;
    const category = document.getElementById('category').value;

    const data = JSON.stringify({ id: selectedProductId, name, price, rating, category })
    
    let url = productUrl + "/" + selectedProductId;
    fetch(url, {
        method: "PUT",
        headers: myHeaders,
        body: data,
        redirect: "follow",
    })
        .then((res) => {
            console.log(res.text());
        })
        .then((res) => {
            closeProductDetailsModal();
            loadProducts();
        })
        .catch((error) => console.log("error", error));
}

function deleteProduct() {
    let url = productUrl + "/" + selectedProductId;
    fetch(url, {
        method: "DELETE",
        headers: myHeaders
    })
        .then((res) => {
            closeConfirmDeleteModal();
            loadProducts();
        })
        .catch(function (err) {
            console.log(err);
            console.log("Error deleting Product " + id);
        });
}