///
function reqListener() {

	if (this.readyState == 4 && this.status == 200) {

		//console.log(this.responseText);
		const data = JSON.parse(this.response)
		document.getElementById("app").innerHTML = `<table>
		 <thead>
		   <tr>
		     <th>nombre</th>
		   </tr>
		 </thead>
		 
		 <tbody>
		   <tr>
		     <td>${data.nombre_completo}</td>
		   </tr>
		 </tbody>
		</table>`;
		//document.querySelector("#app").innerHTML = JSON.stringify(`<p style=color:red;>${data.nombre_completo}</p>`)
	}
}

var oReq = new XMLHttpRequest();
oReq.addEventListener("load", reqListener);
oReq.open("GET", "http://localhost:9090/user");
oReq.send();


//codigo 2 funcional appi rest
const API_URL = "http://localhost:9090";
const HTMLResponse = document.querySelector("#app");
fetch(`${API_URL}/user1`)
.then((response) => response.json())
.then((users) => {
	const tpl = users.map((user) => `<table>
	           <thead>
	             <tr>
	               <th>nombre</th>
	             </tr>
	           </thead>
	           <tbody>
	             <tr>
	               <td>${user.username}, ${user.nombre_completo}<td>
	             </tr>
	           </tbody>
	</table>`);
	//HTMLResponse.innerHTML = ``
	document.getElementById("app").innerHTML = `<ul> ${tpl}</ul>`;
	//alert(tpl)
})

//condigo final obtener js por objecto individual
$.get('/user',
              {},
              function(data) {
             	if(data){    
						console.log(data.nombre_completo);
						var nombre1 = data.nombre_completo;
						//alert(nombre1)
						//code funcional 1 var nombre = $('#appjquery').append(data.nombre_completo)    
						 $('#appjquery').html(nombre1)  
						 alert(data.nombre_completo)
				}else{
					alert("error")
				}
             });	
             
 //obtener lista js muestra un solo registro
 $.get(
	'/user1',
	{},
	 function(data){
	   if(data){
		$.each(data, function(index, obj){
			alert(obj.username)
			$('#appeach').html(obj.username)
			console.log(obj)
		})
			
	}else{
		alert("no hay objecto")
		
	}
	}
)            
             