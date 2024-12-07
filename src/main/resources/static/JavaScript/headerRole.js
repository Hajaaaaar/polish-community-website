function handleRoleChange() {
    const role = document.getElementById("roleSelect").value;

    const moderatorLink = document.getElementById("moderatorLink");
    const adminLink = document.getElementById("adminLink");

    moderatorLink.style.display = "none";
    adminLink.style.display = "none";

    if (role === "moderator") {
        moderatorLink.style.display = "block";
    } else if (role === "admin") {
        adminLink.style.display = "block";
    }
}