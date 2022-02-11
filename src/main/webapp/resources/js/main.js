function addComment(productId, event) {
	event.preventDefault();
	fetch("/Springmvc1/api/add-comment", {
		method: "post",
		body: JSON.stringify({
			"content": document.getElementById("commentId").value,
			"productId": productId,
		}),
		headers: {
			"Content-Type": "application/json"
		}
	}).then(function(res) {
		console.info(res);
		return res.json();
	})
		.then(function(data) {
			console.info(data);
			let area = document.getElementById("commentArea");
			area.innerHTML =

				`<div class="row" >
			<div class="col-md-2" style="padding: 10px">
				<img class="rounded-circle img-fluid"
					style="width: 50px; height: 50px" alt=""
					src="/Springmvc1/resource/img/ava.png">
					<!--<c:url value='/resource/img/ava.png'/> de link nay thi js se khong hieu dc tai vi no khong load lai trang
					do do ta can hardcode source cua link trong javascript-->
			</div>
			<div class="col-md-10">
				<p>${data.noidung}</p>
				<i>${data.createdDate}</i>
			</div>
		
		</div>` + area.innerHTML

		});

}

function addToCart(id, name, price) {
	event.preventDefault();
	fetch("/Springmvc1/api/cart", {
		method: "post",
		body: JSON.stringify({
			"productId": id,
			"productName": name,
			"price": price,
			"quanlity": 1,
		}),
		headers: {
			"Content-Type": "application/json",
		},
	})
		.then(function(res) {
			return res.json();
		})
		.then(function(data) {
			let counter = document.getElementById("cartCounter");
			counter.innerText = data;
		});
}

function updateQuanlity(cnt, productId) {
	fetch("/Springmvc1/api/cart", {
		method: "put",
		body: JSON.stringify({
			"productId":  productId,
			"productName":  "",
			"price": 0,
			"quanlity": cnt

		}),
		headers: {
			"Content-Type":  "application/json",
		}

	}).then(function(res) {
		return res.json()
	}).then(function(data) {
		let counter = document.getElementById("cartCounter");
		counter.innerText = data;
	})

}

function deleteCartItem(productId) {
	/*neu khong dung dau packtid thi ta phai cong chuoi*/
	fetch(`/Springmvc1/api/cart/${productId}`, {
		method: "delete",
	})
		.then(function(res) {
			return res.json();
		})
		.then(function(data) {
			counter = document.getElementById("cartCounter");
			counter.innerText = data;
			/* location.reload()*/
			let row = document.getElementById(`product${productId}`);
			row.style.display =  "none"

		});
}



