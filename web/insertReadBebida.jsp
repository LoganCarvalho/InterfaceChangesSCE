<%-- 
    Document   : ManterProdutoIndex
    Created on : 22/03/2016, 15:55:11
    Author     : jcarvalho
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
                    <a class="navbar-brand" href="#"><img  src="Imagens/logoresized.png" alt=""> </a>
                </div>
                <div class="container" id="divMenu" style="padding-top: 1cm">
                    <ul class="nav navbar-nav">
                        <li> <a href="Inicio.jsp" style="color:#FFFFFF; font-size: x-large">Sobre</a></li>
                        <li> <a href="servicos.jsp" style="color:#FFFFFF; font-size: x-large">Serviços</a></li>
                        <li> <a href="faleConosco.jsp" style="color:#FFFFFF; font-size: x-large">Contatos</a></li>
                    </ul>
                </div>
                <ul class="nav navbar-nav navbar-right" style="padding-top: 0.5cm">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color:#FFFFFF; font-size: x-large">Nome do Aluno</a>
                    <ul class="dropdown-menu">
                        <li><a href="#"><span class="glyphicon glyphicon-user"></span>Perfil</a></li>  
                        <li><a href="Inicio.jsp"><span class="glyphicon glyphicon-log-out"></span>Sair</a></li>
                    </ul>   
                </ul>
            </div>
        </nav>
        <div class="jumbotron">
            <div class="container text-center">
                <div class="row">
                    <div class="col-md-7">
                        <img class="img-circle" src="Imagens/adicionarbebida.png" alt="Generic placeholder image" width="140" height="140">
                        <h2>Incluir Bebida</h2>
                        <p><a class="btn btn-warning waves-effect waves-light" href="incluirBebida.jsp" data-toggle="tooltip" data-placement="bottom" title="Clique aqui para realizar o cadastro de uma bebida" role="button">Entrar &raquo;</a></p>
                    </div>
                    <div class="col-md-4">
                        <img class="img-circle" src="Imagens/consultarbebida.png" alt="Generic placeholder image" width="140" height="140">
                        <h2>Consultar Bebida</h2>
                        <p><a class="btn btn-warning waves-effect waves-light" data-toggle="tooltip" data-placement="bottom" title="Clique aqui para consultar os dados de uma bebida." href="consultarBebida.jsp" role="button">Entrar &raquo;</a></p>
                    </div>
                </div>             
            </div>
        </div>
        <!-- Inicializando os ToolTips -->
        <script>
            $(document).ready(function () {
                $('[data-toggle="tooltip"]').tooltip();
            });
        </script>

        <footer class="container-fluid text-center">
            <p>SCE- Sistema Cantina Escola, Copyright © 2016 </p>
        </footer>
    </body>
</html>
