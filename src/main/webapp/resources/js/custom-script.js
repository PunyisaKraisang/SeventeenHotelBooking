window.onload = (event) => {

	let cartMap = getCartMapInSession();
	populateCart(cartMap);
};


function getCartMapInSession() {
	let cartSession = sessionStorage.cartMap;
	let cartMap;
	
	if (typeof cartSession == 'undefined') {
		cartMap = new Map();
		
	} else {
		cartMap = new Map(JSON.parse(cartSession));
	}
	
	return cartMap;
}


function addToCart(id, name, price) {
	let cartMap = getCartMapInSession();
	
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
		document.querySelector("#checkout-btn").disabled = true;
		document.querySelector("#checkout-btn").classList.add('disabled');
		return;
	}
	
	
	let total = 0;
	let index = 0;
	for (let [id, menu] of cartMap) {
		let price = (Math.round(menu.qtt * menu.price * 100) / 100);
		total += price;
		html = html 
			+ "<div class='row'>"
				+ "<div class='col-7'>" + menu.name + "</div>"
				+ "<div class='col-2'>x " + menu.qtt + "</div>" 
				+ "<div class='col-2'>$<span class='text-right'>" + price.toFixed(2) + "</span></div>" 
				+ "<div class='col-1'><a onClick='deleteFromCart(" + id + ")' title='Delete'><span class='icon-delete'></span></a></div>" 
			+ "</div>";
			
		html = html 
			+ "<div class='row'>"
				+ "<input name='items["+ index +"].id' value='" + id + "' type='hidden' />"
				+ "<input name='items["+ index +"].name' value='" + menu.name + "' type='hidden'/>"
				+ "<input name='items["+ index +"].qtt' value='" + menu.qtt + "' type='hidden'/>" 
				+ "<input name='items["+ index +"].price' value='" + price + "' type='hidden'/>" 
			+ "</div>";
			
		index = index + 1;
	}
	
	html = html 
		+ "<hr>"
		+ "<div class='row'>"
			+ "<div class='col-7'></div>"
			+ "<div class='col-2'>Total</div>" 
			+ "<div class='col-2'>$<span class='text-right'>" + total.toFixed(2) + "</span></div>" 
			+ "<div class='col-1'></div>"
		+ "</div>";
		
	html = html + "<input name='totalPrice' value='" + total + "' type='hidden'/>"
	
	
	document.querySelector("#cart-result").innerHTML = html;
	
	document.querySelector("#checkout-btn").disabled = false;
	document.querySelector("#checkout-btn").classList.remove('disabled');
}

function deleteFromCart(id) {
	let cartMap = getCartMapInSession();
	cartMap.delete(id);
	
	sessionStorage.setItem("cartMap", JSON.stringify(Array.from(cartMap.entries())));
	
	populateCart(cartMap);
}




$(document).ready(function () {

	$('.deliver-date').datepicker({
		'autoclose': true
	});

    $('#search-form').validate({
        rules: {
            name: {
                alphanumeric: true,
                required: false
            }
        }
    });

});
