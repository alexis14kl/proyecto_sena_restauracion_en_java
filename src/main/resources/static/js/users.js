function register() {
	validarData();
}

function validarData() {
	var name = $('#name').val();
	var email = $('#correo').val();
	var clave1 = $('#clave1').val();
	var clave2 = $('#clave2').val();
	var perfil = $('#perfil').val();
	if (name == '') {
		Swal.fire({
			icon: 'error',
			footer: '<a style="color:red;" href="#">Nombre Obligatorió</a>',
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
	} else {
		if (email == '') {
			Swal.fire({
				icon: 'error',
				footer: '<a style="color:red;" href="#">Correo Obligatorió</a>',
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
		} else {
			if (clave1 == '') {
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
			} else {
				if (clave2 == "") {
					Swal.fire({
						icon: 'error',
						footer: '<a style="color:red;" href="#">Repetición de la contraseña es Obligatorió</a>',
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
				} else {
					if (perfil == '') {
						Swal.fire({
							icon: 'error',
							footer: '<a style="color:red;" href="#">Seleccioné un perfil</a>',
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
					} else {
						if (clave1 != clave2) {
							Swal.fire({
								icon: 'error',
								footer: '<a style="color:red;" href="#">Verifica la contraseña</a>',
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
						} else {
							if (name != '' && email != '' && clave1 != '' && clave2 != '' && perfil != '') {
								$.get(
									'/validarEmailNewUser',
									{
										email: email,
										name: name,
										clave1: clave1,
										clave2: clave2,
										perfil: perfil
									},
									function(data) {
										if (data == 'el correo ya existe') {
											Swal.fire({
												icon: 'error',
												footer: '<a style="color:red;" href="#">El correo ya existe intenta con otro</a>',
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
										} else {
											if (data == 'correo registrado') {
												Swal.fire({
													icon: 'success',
													footer: '<a style="color:green;" href="#">Usuario registrado correctamente</a>',
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

									}
								)
							}
						}
					}
				}
			}
		}
	}
}



