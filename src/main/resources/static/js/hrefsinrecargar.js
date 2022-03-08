function abrirUrl(url, contenedor){
	
 $.get(url,{},function(data){
 	if(data){
		  var datas = $('#container1').html($('#'+ contenedor ).html(data))
	}else{

	}
 })

}


//contenido del html
//<!-- paginas href -->
//	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
//	<script type="text/javascript" src="js/hrefsinrecargar.js" async="async"></script>
//	<div id="contenedor_principal"></div>
//<!-- end paginas -->

//onclick en button onclick="abrirUrl('/gallery','contenedor_principal');"