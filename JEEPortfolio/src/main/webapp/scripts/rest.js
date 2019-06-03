	var offersContainer = document.getElementById("offers");
	var carsTable;
	var sortedTable;
	
	



function getCarsFromEndpoint(endpointAdres){
	
	
	fetch(endpointAdres)
		.then(response => {
			return response.json()
		})
		.then(data => {
			console.log("data arrived");
			console.log(data);
			carsTable = data;
			getFilter();
			printCarTable(carsTable);
		})
		.catch(err => {
			console.log(err);
		})
}

function printCarTable(table){
	 offersContainer.innerHTML=`${table.map(function(car){
		 return`
		 <div class="offer_item" onclick="getItem(${car.id})">
		 <div class="offer_item_img">
			<img src="${car.pictureAdres}" alt="car" >
		</div>
			 <div class="offer_item_data_cont" id="${car.id}">
			 	<p><strong>Brand: </strong>${car.mark}</p>
			 	<p><strong>Model: </strong>${car.model}</p>
			 	<p><strong>year: </strong>${car.year}</p>
			 </div>
			 <div class="offer_item_data_price">
			 ${car.price+" zl"}
			 </div>
		 </div>`
		 }).join("")}`;
}

function getFilter(){
	let filter = document.getElementById("filter");
	let filterValue = filter.options[filter.selectedIndex].value;
	switch (filterValue) {
	case "price":
		sortedTable = carsTable.sort((a, b) => Number(b.price) - Number(a.price));
		printCarTable(sortedTable);
		break;
	case "year":
		sortedTable = carsTable.sort((a, b) => Number(b.year) - Number(a.year));
		printCarTable(sortedTable);
			break;
	default:
		break;
	}
}

function getItem(itemAdres){
	let adres = '/api/car/'+itemAdres;
	window.location.href = adres;
	
}

function getCarsListByString(){
	console.log("test");
	let query = document.getElementById("searchForm").value;
	
	getCarsFromEndpoint('/api/car/search/'+query);
}   
