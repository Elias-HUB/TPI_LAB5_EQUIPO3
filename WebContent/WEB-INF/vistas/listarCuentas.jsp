<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Cuentas</title>
        <jsp:include page="estilos.jsp"></jsp:include>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/estilo.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/jtable.css" />
    </head>

    <body>
        <jsp:include page="myNavbar.jsp"></jsp:include>


        <div class="m-5 p-5 rounded bg-white" id="">
            <h1>Cuentas</h1>
            <!-- <div class="container pb-3"> -->
            <form action="altaCuenta.html" method="get">
            <div class="justify-content-between mt-3">
                <button type="submit" class="btn btn-primary"><i class="bi bi-layout-text-window-reverse"></i></i> Nueva
                    Cuenta</button>
            </div>
            </form>
            <!-- </div> -->
            <br>
            <table id="example" class="table table-striped table-bordered dt-responsive nowrap pt-1 mt-5"
                cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th style="text-align: center">CBU</th>
                        <th style="text-align: center">Nro Cuenta</th>
                        <th style="text-align: center">Nombre y Apellido</th>
                        <th style="text-align: center">Tipo de Cuenta</th>
                        <th style="text-align: center">Saldo</th>
                        <th style="text-align: center">Estado</th>
                        <th style="text-align: center">Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>0170231820000000010500</td>
                        <td>20164</td>
                        <td>Valenzuela Elias</td>
                        <td>Caja de ahorro en pesos</td>
                        <td>$10299.5</td>
                        <td>Activo</td>
                        <td class="text-center" style="width: 190px">
<!--                             <button type="submit" id="" name="BtnVer" class="btn btn-info" onclick="location.href='detalleCuenta.html'"> -->
<!--                                 <i class="bi bi-file-person" data-toggle="tooltip" data-placement="bottom" -->
<!--                                     title="Ver Cuenta"></i> -->
<!--                             </button> -->
                            <button type="submit" id="" name="BtnModificar" class="btn btn-warning" onclick="location.href='modificarCuenta.html'">
                                <i class="bi bi-pencil-square" data-toggle="tooltip" data-placement="bottom"
                                    title="Modificar Cuenta"></i>
                            </button>
                            <button type="button" id="" onClick="modalEliminar(this)" name="BtnEliminar"
                                class="btn btn-danger">
                                <i class="bi bi-x-circle" data-toggle="tooltip" data-placement="bottom"
                                    title="Eliminar Cuenta"></i>
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
                    title: "�Desea dar de baja esta Cuenta?",
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
                                        title: 'El Cuenta se esta dando de baja...'
                                    }).then((result) => {
                                        location.replace('../Views/ListadoAgentes.php');
                                    })
                                } else if (AgenteID == "ExitosoUsuario") {
                                    Toast.fire({
                                        icon: 'success',
                                        title: 'El Cuenta y el Usuario se estan dando de baja...'
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