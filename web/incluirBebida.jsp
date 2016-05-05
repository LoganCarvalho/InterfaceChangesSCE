<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sistema Cantina Escola</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="js/bootstrap.min.js"></script>
        <link href="assets/css/custom.css" rel="stylesheet" />
        <style>
            /* Remove the navbar's default margin-bottom and rounded borders */ 
            .navbar {
                margin-bottom: 0;
                border-radius: 0;

            }
        </style>

        <title>Funcionários</title>
    </head>
   <body>
        <nav class="navbar navbar-inverse" style="min-height: 135px">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#"><img  src="Imagens/logoresized.png" alt=""> </a>
                </div>
                <div style="padding-top: 1cm">
                    <ul class="nav navbar-nav">
                        <li> <a href="Inicio.jsp" style="color:#FFFFFF; font-size: x-large">Sobre</a></li>
                        <li> <a href="servicos.jsp" style="color:#FFFFFF; font-size: x-large">Serviços</a></li>
                        <li> <a href="faleConosco.jsp" style="color:#FFFFFF; font-size: x-large">Contatos</a></li>
                    </ul>
                </div>
                <ul class="nav navbar-nav navbar-right" style="padding-top: 0.5cm">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color:#FFFFFF; font-size: x-large">Funcionário</a>
                    <ul class="dropdown-menu">
                        <li><a href="#"><span class="glyphicon glyphicon-user"></span>Perfil</a></li>  
                        <li><a href="Inicio.jsp"><span class="glyphicon glyphicon-log-out"></span>Sair</a></li>
                    </ul>   
                </ul>
            </div>
        </nav>
         <div class="jumbotron">
            <div class="container text-center">
            <p>Incluir Bebida</p>
            </div>
            <div class="container">
                <form action="ResponsavelController2" method="post">  
                    <div class="form-group row">
                        <label for="txtCodigoBebida" class="col-sm-2 form-control-label">Código da Bebida</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="txtCodigoBebida" describedby="basic-addon2">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="txtNomeBebida" class="col-sm-2 form-control-label">Nome da Bebida</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="txtNomeBebida">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="txtFornecedor" class="col-sm-2 form-control-label">Fornecedor</label>
                        <div class="col-sm-4">
                            <input type="text"  class="form-control" name="txtFornecedor">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="txtPrecoBebida" class="col-sm-2 form-control-label">Preço da Bebida</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="txtPrecoBebida" placeholder="R$ 00,00">
                        </div>
                    </div>
                    <button type="submit" class="btn btn-warning">Cadastrar</button>
                </form>
            </div>
        </div>
         <footer class="container-fluid text-center">
            <p>SCE- Sistema Cantina Escola, Copyright © 2016 </p>
        </footer>
    </body>
</html>
