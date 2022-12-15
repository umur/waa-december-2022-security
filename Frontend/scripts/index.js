(function() {
    if (!localStorage.getItem("token")) {
        window.location.href = "/login.html";
    }

    const logout = document.getElementById("signout");
    signout.onclick = () => {
        localStorage.removeItem("token");
        window.location.href = "login.html";
    };

})();