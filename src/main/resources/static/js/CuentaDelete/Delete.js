function deleted(id) {
	$.get(
		'/deleted',
		{ id: id },
		function(data) {
			if (data == 'eliminado') {
				Swal.fire({
					icon: 'success',
					title: '<a style="justify-content: center;color:red;" href="#">Cuenta Eliminada</a>',
					padding: '1rem',
					toast: true,
					position: 'top-end',
					showConfirmButton: false,
					showCancelButton: false,
					timer: 2000,
					allowOutsideClick: false,
					allowEscapeKey: false,
					allowEnterKey: false
				})
				setTimeout(function() {
					window.location = '/login';
				}, 2000);
			} else {
				alert('algo esta mal')
			}
		}
	);
}

function updated(id) {
	$('#iduser').val(id);
	$('#exampleModal').modal('show');
}

$(function() {
	$('#exampleModal').modal(
		{
			backdrop: 'static',
			keyboard: false,
			focus: false,
			show: false
		}
	);
})
//funcion para editar datos generales
function editar() {
	var iduser = $('#iduser').val();
	var id_number = $('#data_number').val();
	var data_type = $('#data_type').val();
	var data_phone = $('#data_phone').val();
	var data_address = $('#data_address').val();

	$.get(
		'/saveDataGeneral',
		{
			iduser: iduser,
			id_number: id_number,
			data_type: data_type,
			data_phone: data_phone,
			data_address: data_address
		},
		function(data) {
			if (data != 'hay datos vacios') {

				if (data = 'update') {
					$('#dataaddress').html(data_address);
					$('#dataNumberid').html(id_number);
					$('#datatype').html(data_type);
					$('#dataphone').html(data_phone);
					Swal.fire({
						icon: 'success',
						title: '<a style="justify-content: center;color:rgb(114, 255, 0);" href="#">Información Actualizada</a>',
						padding: '1rem',
						toast: true,
						position: 'top-end',
						showConfirmButton: false,
						showCancelButton: false,
						timer: 2000,
						allowOutsideClick: false,
						allowEscapeKey: false,
						allowEnterKey: false
					})
				}
			} else {
				Swal.fire({
					icon: 'warning',
					title: '<a style="justify-content: center;color:red;" href="#">Hay campos vacios intenta otra vez</a>',
					padding: '1rem',
					toast: true,
					position: 'top-end',
					showConfirmButton: false,
					showCancelButton: false,
					timer: 2000,
					allowOutsideClick: false,
					allowEscapeKey: false,
					allowEnterKey: false
				})
			}

		}
	);

}


//SOLO NUMEROS
$(function() {
	$("#data_number").keydown(function(event) {
		//alert(event.keyCode);
		if ((event.keyCode < 48 || event.keyCode > 57) && (event.keyCode < 96 || event.keyCode > 105) && event.keyCode !== 190 && event.keyCode !== 110 && event.keyCode !== 8 && event.keyCode !== 9) {
			Swal.fire({
				icon: 'warning',
				title: '<p style="justify-content: center;color:red;">Solo se permiten numeros</p>',
				padding: '1rem',
				toast: true,
				position: 'top-end',
				showConfirmButton: false,
				showCancelButton: false,
				timer: 2000,
				allowOutsideClick: false,
				allowEscapeKey: false,
				allowEnterKey: false
			});
			return false;
		} else {
			var input = document.getElementById('data_number');
			input.addEventListener('input', function() {
				if (this.value.length > 10) {
					this.value = this.value.slice(0, 10);
					input.style.backgroundColor = "#72ff00";
				} else {

					if (this.value.length < 10) {
						this.value = this.value.slice(0, 10);
						input.style.backgroundColor = "white";
					}
				}

			});
		}
	});
	$("#data_phone").keydown(function(event) {
		//alert(event.keyCode);
		if ((event.keyCode < 48 || event.keyCode > 57) && (event.keyCode < 96 || event.keyCode > 105) && event.keyCode !== 190 && event.keyCode !== 110 && event.keyCode !== 8 && event.keyCode !== 9) {
			Swal.fire({
				icon: 'warning',
				title: '<p style="justify-content: center;color:red;" >Solo se permiten numeros</p>',
				padding: '1rem',
				toast: true,
				position: 'top-end',
				showConfirmButton: false,
				showCancelButton: false,
				timer: 2000,
				allowOutsideClick: false,
				allowEscapeKey: false,
				allowEnterKey: false
			});
			return false;
		} else {
			var input = document.getElementById('data_phone');
			input.addEventListener('input', function() {
				if (this.value.length > 10) {
					this.value = this.value.slice(0, 10);
					input.style.backgroundColor = "#72ff00";
				} else {

					if (this.value.length < 10) {
						this.value = this.value.slice(0, 10);
						input.style.backgroundColor = "white";
					}
				}

			});
		}
	});
});
//end solo number

//funcion vaciar campos
function vaciar(){
		 $('#iduser').val('');
	     $('#data_number').val('');
	     $('#data_type').val('');
	     $('#data_phone').val('');
	     $('#data_address').val('');
}



