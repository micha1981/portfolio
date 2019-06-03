var buttonStatus="hamburger";
function toogleMenu(){
	
	
	var menu = document.getElementById("navMenu");
	menu.classList.toggle("nav-open");
	var buttonImg = document.getElementById("navButton");
	if(buttonStatus=="hamburger")
	{buttonImg.style.backgroundImage = 'url("img/nav-x-button.png")';
	 buttonStatus="X";
	
	}
	else{
	buttonImg.style.backgroundImage = 'url("img/button-icon.png")';	
	buttonStatus="hamburger";
	
	}
	

}

function signIn(){
	let login = document.getElementById("login").innerText;	
		if(login==="Log in") window.location.href = "/Login";
		else window.location.href = "/UserAccount";
	}
function logOut(){
	window.location.href = "/Logout";
}

document.addEventListener("DOMContentLoaded", function(event) {	
	
	window.addEventListener('scroll', function(e) {
    slide();
	});
});


function slide(){
	
	var nodesArrayL = [].slice.call(document.querySelectorAll(".anim-left"));
	var nodesArrayR = [].slice.call(document.querySelectorAll(".anim-right"));   
	 let index = 0;
	   while (index < nodesArrayL.length) { 
		   let imgYPosition = nodesArrayL[index].getBoundingClientRect().top;
		   
		    if (imgYPosition<=600) {
		    	nodesArrayL[index].classList.add("animationL");
			}
		    index++; 
		} 
	   index = 0;
	   while (index < nodesArrayR.length) { 
		   let imgYPosition = nodesArrayR[index].getBoundingClientRect().top;
		   
		    if (imgYPosition<=500) {
		    	nodesArrayR[index].classList.add("animationR");
			}
		    index++; 
		}	
	
}

