
function logout(correo) {
	$.get(
		'/logout',
		{ correo: correo },
		function(envio) {
			if (envio) {
				Swal.fire({
					icon: 'error',
					footer: '<a style="color:red;" href="#">Cerrando sessión</a>',
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
				}, 3000);
			} else {
				alert("error de envio")
			}
		}
	)
}

