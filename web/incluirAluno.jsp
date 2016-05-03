<%-- 
    Document   : CadResponsavel
    Created on : Apr 17, 2016, 9:28:59 AM
    Author     : Logan
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
        <nav class="navbar navbar-inverse" style="min-height: 135px">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#"><img  src="Imagens/logoresized.png" alt=""></a>
                </div>
                <div class="container" id="divMenu" style="padding-top: 1cm">
                    <ul class="nav navbar-nav">
                        <li><a href="#" style="color:#FFFFFF; font-size: x-large"">Sobre</a></li>
                        <li><a href="#" style="color:#FFFFFF; font-size: x-large">Serviços</a></li>
                        <li><a href="#" style="color:#FFFFFF; font-size: x-large">Contatos</a></li> 
                    </ul>
                </div>
                <ul class="nav navbar-nav navbar-right" style="padding-top: 0.5cm">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color:#FFFFFF; font-size:x-large">Responsável</a>
                    <ul class="dropdown-menu">
                        <li><a href="#"><span class="glyphicon glyphicon-user"></span>Perfil</a></li>  
                        <li><a href="Inicio.jsp"><span class="glyphicon glyphicon-log-out"></span>Sair</a></li>
                    </ul>   
                </ul>
            </div>
        </nav>
        <div class="jumbotron">
            <div class="container text-center">
            <p>Cadastrar Aluno</p>
            </div>
            <div class="container">
                <form action="ResponsavelController2" method="post">  
                    <div class="form-group row">
                        <label for="txtNomeAluno" class="col-sm-2 form-control-label">Nome do Aluno</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="txtNomeAluno" describedby="basic-addon2" placeholder="Nome do Aluno">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="txtMatriculaAluno" class="col-sm-2 form-control-label">Mátricula do Aluno</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="txtMatriculaAluno" placeholder="Mátricula do Aluno">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="txtTurma" class="col-sm-2 form-control-label">Turma do Aluno</label>
                        <div class="col-sm-4">
                            <input type="text"   class="form-control" name="txtTurma" placeholder="Turma do Aluno">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="txtTurno" class="col-sm-2 form-control-label">Turno do Aluno</label>
                        <div class="col-sm-4">
                            <select type="text" maxlength="9" class="form-control" name="txtTurno">
                                <option value="0">Escolha...</option>
                                <option value="matutino">Matutino</option>
                                <option value="vespertino">Vespertino</option>
                                <option value="diurno">Diurno</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="txtLoginAluno" class="col-sm-2 form-control-label">Login</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="txtLoginAluno" placeholder="Login do Aluno">
                        </div>
                    </div>
                     <div class="form-group row">
                        <label for="txtSenhaAluno" class="col-sm-2 form-control-label">Senha</label>
                        <div class="col-sm-4">
                            <input type="password" maxlength="6" class="form-control" name="txtSenhaAluno" placeholder="Senha do Aluno">
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
