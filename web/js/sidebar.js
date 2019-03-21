function w3_open() {
    if (document.getElementById("mySidebar").style.width === "150px")
    {
        document.getElementById("main").style.marginLeft = "50px";
        document.getElementById("mySidebar").style.width = "50px";
        document.getElementById("sidebar-menu").style.display = "none";
        document.getElementById("sidebar-home").style.display = "none";
        document.getElementById("sidebar-database").style.display = "none";
        document.getElementById("sidebar-playground").style.display = "none";
    }
    else
    {
        document.getElementById("main").style.marginLeft = "150px";
        document.getElementById("mySidebar").style.width = "150px";
        document.getElementById("sidebar-menu").style.display = "block";
        document.getElementById("sidebar-home").style.display = "block";
        document.getElementById("sidebar-database").style.display = "block";
        document.getElementById("sidebar-playground").style.display = "block";
    }
}