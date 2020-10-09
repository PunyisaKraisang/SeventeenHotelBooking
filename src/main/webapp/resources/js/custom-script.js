window.onload = (event) => {

	let cartSession = sessionStorage.cartMap;
	let cartMap;
	
	if (typeof cartSession == 'undefined') {
		cartMap = new Map();
		
	} else {
		cartMap = new Map(JSON.parse(cartSession));
	}
	
	populateCart(cartMap);
};


function addCart(id, name, price) {
	let cartSession = sessionStorage.cartMap;
	let cartMap;
	
	if (typeof cartSession == 'undefined') {
		cartMap = new Map();
		
	} else {
		cartMap = new Map(JSON.parse(cartSession));
	}
	
	if (cartMap.get(id) != null && (typeof cartMap.get(id) !== 'undefined')){
		let menu = cartMap.get(id);
		menu.qtt = menu.qtt + 1;
		cartMap.set(id, menu);
		
	} else {
		cartMap.set(id, {id: id, name: name, price: price, qtt: 1});
	}
	
	sessionStorage.setItem("cartMap", JSON.stringify(Array.from(cartMap.entries())));
	
	populateCart(cartMap);
}

function populateCart(cartMap) {

	let html = "";
	
	if (cartMap.size == 0) {
		html = html 
			+ "<div class='row'>"
				+ "<div class='col-11'>No item in cart</div>"
			+ "</div>";
			
		document.querySelector("#cart-result").innerHTML = html;
		return;
	}
	
	
	let total = 0;
	for (let [id, menu] of cartMap) {
		let price = (Math.round(menu.qtt * menu.price * 100) / 100);
		total += price;
		html = html 
			+ "<div class='row'>"
				+ "<div class='col-7'>" + menu.name + "</div>"
				+ "<div class='col-2'>x " + menu.qtt + "</div>" 
				+ "<div class='col-2'>$" + price.toFixed(2) + "</div>" 
				+ "<div class='col-1'><a onClick='deleteCart(" + id + ")'><span class='icon-delete'></span></a></div>" 
			+ "</div>";
	}
	
	html = html 
		+ "<hr>"
		+ "<div class='row'>"
			+ "<div class='col-7'></div>"
			+ "<div class='col-2'>Total</div>" 
			+ "<div class='col-3'>$" + total.toFixed(2) + "</div>" 
		+ "</div>";
	
	document.querySelector("#cart-result").innerHTML = html;
}

function deleteCart(id) {

	alert(id);
}



