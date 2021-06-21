<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Movimientos</title>
        <jsp:include page="estilos.jsp"></jsp:include>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/estilo.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/jtable.css" />
    </head>

    <body>
        <jsp:include page="myNavbar.jsp"></jsp:include>


        <div class="m-5 p-5 rounded bg-white" id="">
            <h1>Movimientos</h1>
            <div class="container pb-3">
                <div class="row d-flex justify-content-center mt-3">
                    <div class="form-group col-md-3">
                        <label Class="control-label">Cuenta</label>
                        <select class="form-select">
                            <option value="1" selected>20164</option>
                            <option value="2">24567</option>
                            <option value="3">32654</option>
                        </select>
                    </div>


                    <div class="form-group col-md-3">
                        <label Class="control-label">CBU</label>
                        <input id="TboxCBUCuenta" name="TboxCBUCuenta" Class="form-control"
                            value="0170231820000000010500" readonly>
                    </div>

                    <div class="form-group col-md-3">
                        <label Class="control-label">Nombre</label>
                        <input id="TboxNombreCuenta" name="TboxNombreCuenta" Class="form-control"
                            value="Valenzuela Elias" readonly>
                    </div>

                    <div class="form-group col-md-3">
                        <label Class="control-label">Tipo de cuenta</label>
                        <input id="TboxTipoCuenta" name="TboxTipoCuenta" Class="form-control"
                            value="Caja de ahorro en pesos" readonly>
                    </div>

                    <div class="form-group col-md-2">
                        <label Class="control-label">Saldo</label>
                        <input id="TboxSaldoCuenta" name="TboxSaldoCuenta" Class="form-control" value="$10299.5"
                            readonly>
                    </div>

                    <div class="form-group col-md-1">
                        <label Class="control-label">Estado</label>
                        <input id="TboxEstadoCuenta" name="TboxEstadoCuenta" Class="form-control" value="Alta" readonly>
                    </div>
                </div>
            </div>

            <table id="example" class="table table-striped table-bordered dt-responsive nowrap pt-1" cellspacing="0"
                width="100%" style="font-size: small;">
                <thead>
                    <tr>
                        <th style="text-align: center">Nro</th>
                        <th style="text-align: center">Tipo Movimiento</th>
                        <th style="text-align: center">Detalle</th>
                        <th style="text-align: center">Importe</th>
                        <th style="text-align: center">Estado</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>Alta Cuenta</td>
                        <td>1</td>
                        <td>$10.000</td>
                        <td>Alta</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>Transferencia</td>
                        <td>1</td>
                        <td>$-1550.5</td>
                        <td>Transferido</td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>Transferencia</td>
                        <td>5</td>
                        <td>$1850</td>
                        <td>Transferido</td>
                    </tr>
                </tbody>
            </table>
        </div>


        <jsp:include page="myFooter.jsp"></jsp:include>
        <script src="${pageContext.request.contextPath}/resources/Js/DataTableMovimientos.js"></script>
    </body>

    </html>