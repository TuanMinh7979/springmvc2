

function addToCart(productId) {
	fetch(`/StaticRsWeb/api/cart/${productId}`).then(res => res.json()).then(data =>{
		var d=document.getElementById("cartCounter");
		if(d!=null){
			d.innerText=data;
		}	
	})
}