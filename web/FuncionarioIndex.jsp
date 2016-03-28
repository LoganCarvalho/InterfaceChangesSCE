<%-- 
    Document   : FuncionarioIndex
    Created on : 21/03/2016, 12:53:43
    Author     : jcarvalho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sistema Cantina Escola</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <nav class="navbar navbar-inverse" style="min-height: 135px" role="navigation">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">
                        <img  src="Imagens/logoresized.png" alt="">
                    </a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="container" id="bs-example-navbar-collapse-1" style="padding-top: 1cm">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="#" style="color:#FFFFFF; font-size: x-large"">Sobre</a>
                        </li>
                        <li>
                            <a href="#" style="color:#FFFFFF; font-size: x-large">Serviços</a>
                        </li>
                        <li>
                            <a href="#" style="color:#FFFFFF; font-size: x-large">Contatos</a>
                        </li>
                    </ul>
                    <div class="container col-sm-5" id="bs-example-navbar-collapse-1" style="padding-top: 0.4cm">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color:#FFFFFF; font-size:large" role="button" >Funcionário</a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Perfil</a></li>  
                                <li role="separator" class="divider"></li>
                                <li><a href="inicio.jsp">Sair</a></li>
                            </ul>
                        </li>
                    </div>
                </div>
            </div>

        </nav>
        <div class="jumbotron">
            <div class="container text-center">
                <div class="row">
                    <div class="col-lg-4">
                        <img class="img-circle" src="Imagens/ManterProdutos.png" alt="Generic placeholder image" width="140" height="140">
                        <h2>Manter Produto</h2>
                        <p><a class="btn btn-warning waves-effect waves-light" href="#" data-toggle="tooltip" data-placement="bottom" title="Incluir, Alterar, Consultar e Desbloquear Comidas e Bebidas do Sistema." role="button">Entrar &raquo;</a></p>
                    </div><!-- /.col-lg-4 -->
                    <div class="col-lg-4">
                        <img class="img-circle" src="Imagens/cadastro.png" alt="Generic placeholder image" width="140" height="140">
                        <h2>Cadastrar Pais</h2>
                        <p><a class="btn btn-warning waves-effect waves-light" data-toggle="tooltip" data-placement="bottom" title="Cadastrar responsável atribuindo além de seus dados um login e uma senha de acesso." href="#" role="button">Entrar &raquo;</a></p>
                    </div><!-- /.col-lg-4 -->
                    <div class="col-lg-4">
                        <img class="img-circle" src="Imagens/saldo.png" alt=Generic placeholder image" width="140" height="140">
                             <h2>Consultar Saldo</h2>
                        <p><a class="btn btn-warning waves-effect waves-light" data-toggle="tooltip" data-placement="bottom" title="Consultar saldo do aluno através da matricula." href="#" role="button">Entrar &raquo;</a></p>
                    </div><!-- /.col-lg-4 -->
                </div><!-- /.row -->
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
