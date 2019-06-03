
var flag=0;


function changeData(id){
	var cont = document.getElementById(id);
	for(let x=1;x<4;x++){
		if(id==flag&&cont.value!=""){
			
			$.post("/ChangeUserData",
					  {
					    value: cont.value,
					    id: id
					  },
					  function(data, status){
						  if(data=="name changed") window.location.href = '/UserAccount';
					   
					  });
			
			
			
			
			break;
		}else{
			document.getElementById(x).classList.add("input_unvisible");	
		}
	}
	
	flag=id;
	cont.classList.remove("input_unvisible");
}





function deleteAccount(){
	let result = confirm("Are you sure?!"); 
	if(result==true){
		window.location.href = '/DeleteUser';
	}
	
	
}