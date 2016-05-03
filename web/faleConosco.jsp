<%-- 
    Document   : Inicio
    Created on : Mar 17, 2016, 11:46:05 PM
    Author     : Logan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Sistema Cantina Escola</title>
        <meta charset="utf-8">
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
    </head>
    <body>
        <nav class="navbar navbar-default navbar-inverse" style="min-height: 130px" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <h1 class="navbar-header" style="color:#FFFF00" href="#">SCE</h1>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="padding-top: 0.5cm">
                    <ul class="nav navbar-nav">
                     <!--<li class=""><a href="#" style="color:#FFFFFF">Escolas Parceiras</a></li>-->
                        <li class=""><a href="faleConosco.jsp" style="color:#FFFFFF">Fale Conosco</a></li>
                        <li class=""><a href="Inicio.jsp" style="color:#FFFFFF">Sobre o SCE</a></li>
                    </ul>
                    <form class="navbar-form navbar-right" role="search">
                        <div class="form-group" method="post" action="login" accept-charset="UTF-8">
                            <input type="text" class="form-control" placeholder="Email">
                            <input type="password"  class="form-control" placeholder="Senha">
                        </div>
                        <button type="submit" class="btn btn-warning waves-effect waves-light"><i class="fa fa-arrow-right right"></i>Entrar</button>
                    </form>
                </div>
            </div>
        </nav>

        <div class="jumbotron">
            <div class="container text-center">
                <div class="col-sm-3">      
                    <img src="Imagens/logo.png" class="img-responsive" style="width:100%" alt="Image">
                </div>
                <p>Para maiores esclarecimentos de como funciona nosso sistema ou como adquirir outras ofertas, entre em contato conosco pelos seguintes caminhos:</p><br>
                <p>sce@sce.org.br</p><br>
                <p>(071) 3324-4545 / 6768</p>
            </div>
        </div>

        <footer class="container-fluid text-center">
            <p>SCE- Sistema Cantina Escola, Copyright © 2016 </p>
        </footer>

    </body>
</html>

