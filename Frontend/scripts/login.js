window.onload = function () {
    const apiBaseUrl = "http://localhost:8080/api/v1";

    const login = document.getElementById("login");

    login.onclick = () => {
        const username = document.getElementById("email").value;
        const password = document.getElementById("password").value;

        fetch(apiBaseUrl + "/authenticate", {
            headers: ({ "content-type": "application/json" }),
            method: "POST",
            body: JSON.stringify({
                email: username,
                password: password,
            }),
        })
            .then(response => response.json())
            .then(data => {
                localStorage.setItem("token", data.accessToken);
                window.location.href = "/index.html";

            }).catch(e => alert("Invalid Credentials"))
    };

}