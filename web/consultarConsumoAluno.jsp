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
        <nav class="navbar navbar-inverse" style="min-height: 135px">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#"><img  src="Imagens/logoresized.png" alt=""></a>
                </div>
                <div class="container" id="divMenu" style="padding-top: 1cm">
                    <ul class="nav navbar-nav">
                        <li> <a href="Inicio.jsp" style="color:#FFFFFF; font-size: x-large">Sobre</a></li>
                        <li> <a href="servicos.jsp" style="color:#FFFFFF; font-size: x-large">Serviços</a></li>
                        <li> <a href="faleConosco.jsp" style="color:#FFFFFF; font-size: x-large">Contatos</a></li>
                    </ul>
                </div>
                <ul class="nav navbar-nav navbar-right" style="padding-top: 0.5cm">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color:#FFFFFF; font-size:x-large">Funcionário</a>
                    <ul class="dropdown-menu">
                        <li><a href="#"><span class="glyphicon glyphicon-user"></span>Perfil</a></li>  
                        <li><a href="Inicio.jsp"><span class="glyphicon glyphicon-log-out"></span>Sair</a></li>
                    </ul>   
                </ul>
            </div>
        </nav>
        <div class="jumbotron">
            <div class="container text-center">
                <p>Consultar Consumo</p>
            </div>
            <div class="container">
                <form action="ConsultarConsumoAluno" method="post">  
                    <div class="form-group row">
                        <label for="txtMatricula" class="col-sm-2 form-control-label">Mátricula do Aluno</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" name="txtMatricula" describedby="basic-addon2">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="txtDataInicial" class="col-sm-2 form-control-label">Data Inicial</label>
                        <div class="col-sm-2">
                            <input type="date" class="form-control" name="txtDataInicial" placeholder="00/00/0000">
                        </div>
                    </div>   
                    <div class="form-group row">
                        <label for="txtDataFinal" class="col-sm-2 form-control-label">Data Final</label>
                        <div class="col-sm-2">
                            <input type="date" class="form-control" name="txtDataInicial" placeholder="00/00/0000">
                        </div>
                    </div> 
                    <button type="submit" class="btn btn-warning">Consultar Consumo</button>                                                      
                    <div class="row">
                        <div class="col-md-12">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>Nome do Produto</th>
                                        <th>Data do Consumo</th>                                        
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>John</td>
                                        <td>Doe</td>                                        
                                    </tr>
                                    <tr>
                                        <td>Mary</td>
                                        <td>Moe</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>    
                    </div>    
                </form>
            </div>
        </div>
        <footer class="container-fluid text-center">
            <p>SCE- Sistema Cantina Escola, Copyright © 2016 </p>
        </footer>
    </body>
</html>
