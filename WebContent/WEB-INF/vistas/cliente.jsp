<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Clientes</title>
        <jsp:include page="estilos.jsp"></jsp:include>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/estilo.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/jtable.css" />
    </head>

    <body>
        <jsp:include page="myNavbar.jsp"></jsp:include>


        <div class="m-5 p-5 rounded bg-white" id="">
            <h1>Clientes</h1>
            <!-- <div class="container pb-3"> -->
            <div class="justify-content-between mt-3">
                <button type="button" class="btn btn-primary"><i class="bi bi-person-plus"></i> Nuevo Cliente</button>
            </div>
            <!-- </div> -->
            <br>
            <table id="example" class="table table-striped table-bordered dt-responsive nowrap pt-1 mt-5"
                cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th style="text-align: center">Usuario</th>
                        <th style="text-align: center">Nombre y Apellido</th>
                        <th style="text-align: center">Dni</th>
                        <th style="text-align: center">Domicilio</th>
                        <th style="text-align: center">Estado</th>
                        <th style="text-align: center">Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Eze@gmail.com.ar</td>
                        <td>Ezequiel Cordoba</td>
                        <td>12976154</td>
                        <td>Avenida Falsa 1234</td>
                        <td>Activo</td>
                        <td class="text-center" style="width: 190px">
                            <button type="button" id="" onClick="modalCliente(this)" name="BtnVer" class="btn btn-info">
                                <i class="bi bi-file-person" data-toggle="tooltip" data-placement="bottom"
                                    title="Ver Cliente"></i>
                            </button>
                            <button type="button" id="" name="BtnModificar" class="btn btn-warning">
                                <i class="bi bi-pencil-square" data-toggle="tooltip" data-placement="bottom"
                                    title="Modificar Cliente"></i>
                            </button>
                            <button type="button" id="" onClick="modalEliminar(this)" name="BtnEliminar"
                                class="btn btn-danger">
                                <i class="bi bi-x-circle" data-toggle="tooltip" data-placement="bottom"
                                    title="Eliminar Cliente"></i>
                            </button>

                        </td>
                    </tr>
                </tbody>
            </table>
        </div>


        <jsp:include page="myFooter.jsp"></jsp:include>
        <script src="${pageContext.request.contextPath}/resources/Js/dataTableClientes.js"></script>
        <script>
            function modalEliminar(btn) {
                const Toast = Swal.mixin({
                    toast: true,
                    position: 'top',
                    showConfirmButton: false,
                    timer: 6000,
                    timerProgressBar: true,
                    onOpen: (toast) => {
                        toast.addEventListener('mouseenter', Swal.stopTimer)
                        toast.addEventListener('mouseleave', Swal.resumeTimer)
                    }
                });
                var AgenteID = btn.id;
                Swal.fire({
                    icon: 'warning',
                    title: "¿Desea dar de baja este Cliente?",
                    showCancelButton: true,
                    confirmButtonColor: "#c82333",
                    cancelButtonText: "Cancelar",
                    confirmButtonText: "Dar de baja",
                    reverseButtons: true
                }).then((result) => {
                    if (result.value) {
                        $.ajax({
                            url: '../Services/ServicesAgente.php',
                            type: 'POST',
                            dataType: "json",
                            data: {
                                AgenteID: AgenteID
                            },
                            success: function (AgenteID) {
                                if (AgenteID == "Exitoso") {
                                    Toast.fire({
                                        icon: 'success',
                                        title: 'El Cliente se esta dando de baja...'
                                    }).then((result) => {
                                        location.replace('../Views/ListadoAgentes.php');
                                    })
                                } else if (AgenteID == "ExitosoUsuario") {
                                    Toast.fire({
                                        icon: 'success',
                                        title: 'El Agente y el Usuario se estan dando de baja...'
                                    }).then((result) => {
                                        location.replace('../Views/ListadoAgentes.php');
                                    })
                                } else {
                                    Toast.fire({
                                        icon: 'error',
                                        title: 'Hubo un problema. Comunicarse con el Area tecnica.'
                                    })
                                };
                            }
                        });
                    }
                })
            }
        </script>
    </body>

    </html>