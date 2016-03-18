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
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <style>
            /* Remove the navbar's default margin-bottom and rounded borders */ 
            .navbar {
                margin-bottom: 0;
                border-radius: 0;
            }

            /* Add a gray background color and some padding to the footer */
            footer {
                background-color: #f2f2f2;
                padding: 25px;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-default navbar-inverse" role="navigation">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">SCE</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Home</a></li>
                        <li><a href="#">Escolas Parceiras</a></li>
                    </ul>
                    <form class="navbar-form navbar-right" role="search">
                        <div class="form-group" method="post" action="login" accept-charset="UTF-8">
                            <input type="text" class="form-control" placeholder="Email">
                             <input type="text" class="form-control" placeholder="Senha">
                        </div>
                        <button type="submit" class="btn btn-default">Entrar</button>
                    </form>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>


        <div class="jumbotron">
            <div class="container text-center">
                <div class="col-sm-3">      
                    <img src="Imagens/logo.png" class="img-responsive" style="width:100%" alt="Image">
                </div>
                <p>Inovação. Esta é a palavra-chave para garantir a sobrevivência, o crescimento e o fortalecimento de qualquer negócio. Informatizar sua instituição de ensino é essencial para mantê-la organizada, atualizada e competitiva. Melhorar a qualidade dos serviços prestados também é fundamental para criar diferenciais e assim alcançar o sucesso. Pensando nisso foi que surgiu o SCE. O Sistema Cantina Escolas é uma solução específica para instituições que vão desde a Educação Básica até o ensino médio, oferecendo diversas ferramentas de forma modular, ou seja, permitindo que cada instituição componha uma solução adequada ao seu perfil e às suas necessidades.</p>
            </div>
        </div>
        <footer class="container-fluid text-center">
            <p>SCE- Sistema Cantina Escola, Copyright</p>
        </footer>

    </body>
</html>

