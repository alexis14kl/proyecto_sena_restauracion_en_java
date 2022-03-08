	function deleted(id){
			$.get(
			   '/deleted',
			   {id:id},
			   function(data){
				   if(data == 'eliminado'){
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
				   }else{
					   alert('algo esta mal')
				   }
			   }
			);
		}
		
		function updated(){
			$('#exampleModal').modal('show');
		}