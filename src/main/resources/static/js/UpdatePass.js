function cambiarp(id) {
	$('#id').val(id);
	$('#modalPass').modal('show');

}
function salirp() {
	$('#modalPass').modal('hide');
}
function actualizarp() {
	var id = $('#id').val();
	var passanterior = $('#passanterior').val();
	var newpass = $('#newpass').val();
	if (id != '' && passanterior != '' && newpass != '') {
		if (newpass == passanterior) {
			$.get(
				'/updatePassword',
				{
					id: id,
					newpass: newpass
				},
				function(data) {
					$.get(
						'/endPassword',
						{
							id: id,
							newpass: newpass
						},
						function(data2) {
							if (data2) {
								Swal.fire({
									icon: 'success',
									footer: '<a style="color:green;" href="#">Contraseña Actualizada</a>',
									padding: '1rem',
									toast: true,
									position: 'top-end',
									showConfirmButton: false,
									timer: 5000,
									timerProgressBar: true,
									allowOutsideClick: false,
									allowEscapeKey: false,
									allowEnterKey: false
								})
								setTimeout(function() {
									window.location = '/login';
								}, 4000);
							} else {
								alert("error")
							}
						}
					);
				}
			)
		} else {
			Swal.fire({
				icon: 'error',
				footer: '<a style="color:red;" href="#">Contraseña No coiciden</a>',
				padding: '1rem',
				toast: true,
				position: 'top-end',
				showConfirmButton: false,
				timer: 5000,
				timerProgressBar: true,
				allowOutsideClick: false,
				allowEscapeKey: false,
				allowEnterKey: false
			})
		}
	} else {
		Swal.fire({
			icon: 'error',
			footer: '<a style="color:red;" href="#">asegurate de que todos los campos están diligenciados</a>',
			padding: '1rem',
			toast: true,
			position: 'top-end',
			showConfirmButton: false,
			timer: 5000,
			timerProgressBar: true,
			allowOutsideClick: false,
			allowEscapeKey: false,
			allowEnterKey: false
		})
	}
}