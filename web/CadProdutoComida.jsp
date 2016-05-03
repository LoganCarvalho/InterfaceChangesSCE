<%-- 
    Document   : CadProdutoComida
    Created on : Apr 11, 2016, 10:38:38 PM
    Author     : Logan
--%>

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
                    <a class="navbar-brand" href="#"><img src="Imagens/logoresized.png" alt=""> </a>
                </div>
                <div style="padding-top: 1cm">
                    <ul class="nav navbar-nav">
                        <li> <a href="Inicio.jsp" style="color:#FFFFFF; font-size: x-large">Sobre</a></li>
                        <li> <a href="#" style="color:#FFFFFF; font-size: x-large">Serviços</a></li>
                        <li> <a href="faleConosco.jsp" style="color:#FFFFFF; font-size: x-large">Contatos</a></li>
                    </ul>
                </div>
                <ul class="nav navbar-nav navbar-right" style="padding-top: 1.5cm">
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
                <h1>CAD</h1>      
                <p>Consultar, Alterar e Desbloquear</p>   
                <div class="row">
                    <div class="col-md-12">
                        <img class="img-circle" src="Imagens/ManterProdutos.png" alt="Generic placeholder image" width="140" height="140">
                        <p><button type="button" class="btn btn-warning" href="#" data-toggle="modal" data-target="exemploModal" data-placement="bottom" title="Aqui você pode cadastrar um novo produto." role="button"><span class="glyphicon glyphicon-plus"></span>Novo &raquo;</button></p>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-4">
                        <input type="text" placeholder="Buscar Produto" class="form-control" id="txtBuscarProduto">
                    </div>
                    <button type="submit" class="btn btn-warning">Buscar</button>
                </div>
            </div>
        </div>
        
        
        <footer class="container-fluid text-center">
            <p>SCE- Sistema Cantina Escola, Copyright © 2016</p>
        </footer>
    </body>
</html>
