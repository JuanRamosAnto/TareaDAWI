<!DOCTYPE html>
<html lang="esS" >
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrapValidator.js"></script>
<script type="text/javascript" src="js/global.js"></script>

<link rel="stylesheet" href="css/bootstrap.css"/>
<link rel="stylesheet" href="css/bootstrapValidator.css"/>
<title>Ejemplos de CIBERTEC - Jorge Jacinto </title>
</head>
<body>
    
<div class="container">
<h1>Registra Medicamento</h1>

	<form id="id_form"> 
		
		<div class="row" style="margin-top:5%">
		     <div class="form-group col-sm-6">
				<div class="col-sm-4">
					<label class="control-label" for="id_nombre">Nombre</label>
				</div>
				<div class="col-sm-8">
					<input class="form-control" type="text" id="id_nombre" name="nombre" placeholder="Ingrese el nombre" maxlength="40">
				</div>
			</div>
			<div class="form-group  col-sm-6">
				<div class="col-sm-4">
					<label class="control-label" for="id_precio">Precio</label>
				</div>
				<div class="col-sm-6">
					<input class="form-control" type="text" id="id_precio" name="precio" placeholder="Ingrese el precio" maxlength="8">
		 		</div>
			</div>
		
		</div>
		
		<div class="row" style="margin-top: 0%">
			<div class="form-group col-sm-6">
				<div class="col-sm-4">
					<label class="control-label" for="id_stock">Stock</label>
				</div>
				<div class="col-sm-8">
					<input class="form-control" type="number" id="id_stock" name="stock" placeholder="Ingrese el stock" >
				</div>
			</div>
			<div class="form-group  col-sm-6">
				<div class="col-sm-4">
					<label class="control-label" for="id_laboratorio">Laboratorio</label>
				</div>
				<div class="col-sm-6">
					<input class="form-control" type="text" id="id_laboratorio" name="laboratorio" placeholder="Ingrese el laboratorio" >
		 		</div>
			</div>
		</div>
		
		<div class="row" style="margin-top: 2%" align="center"	>
				<button id="id_registrar" type="button" class="btn btn-primary" >Crear Medicamento</button>
		</div>	
		
		
		
	
	</form>
</div>
<script type="text/javascript">

$("#id_registrar").click(function (){ 
	//Lanza la validacion
	var validator = $('#id_form').data('bootstrapValidator');
    validator.validate();
    if(validator.isValid()){
    	console.log('Es Valido');
    	console.log($("#id_form").serialize());
    	$.ajax({
    		type: "POST",
            url: "registraMedicamento", 
            data: $('#id_form').serialize(),
            success: function(data){
            	limpiar();//limpia los datos
            	validator.resetForm();
            mostrarMensaje(data.MENSAJE);//muestra mensaje de confirmacion
            
            },
            error: function(){
            	
            	 mostrarMensaje(data.MSG_ERROR);
            }
    	});
    }

});


function limpiar(){
	$('#id_nombre').val('');
	$('#id_precio').val('');
	$('#id_stock').val('');
	$('#id_laboratorio').val('');
}

$(document).ready(function() {
    $('#id_form').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh' 
            
        },
        fields: {
        		nombre:{
                    selector: "#id_nombre",
                    validators:{
                        notEmpty: {
                             message: 'El nombre es obligatorio'
                        },
                        stringLength: {
                            min: 3,
                            max: 40,
                            message: 'El nombre es de 3 a 40 caracteres'
                        },
                    }
                },
                precio:{
                    selector: "#id_precio",
                    validators:{
                        notEmpty: {
                             message: 'El precio es obligatorio'
                        },
                     
                    }
                },
                stock:{
                    selector: "#id_stock",
                    validators:{
                        notEmpty: {
                             message: 'El stock es obligatorio'
                        },
                       
                    }
                },
                laboratorio:{
                    selector: "#id_laboratorio",
                    validators:{
                        notEmpty: {
                             message: 'La laboratorio es obligatorio'
                        }
                    }
                },
        }   
    });

    
});
</script>
</body>
</html>