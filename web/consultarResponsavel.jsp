<%@page import="Model.Bean.Responsavel"%>
<%@page import="Model.Dao.ResponsavelDAO"%>
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

        <title>Funcionário</title>
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
                <p>Consultar Responsável</p>
            </div>
            <div class="container">
                <form action="ConsultarResponsavel" method="post">  
                    <div class="form-group row">
                        <label for="txtNomeResponsavel" class="col-sm-2 form-control-label">Nome do Responsável</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" name="txtNomeResponsavel">
                        </div>
                    </div>                    
                    <button type="submit" class="btn btn-warning">Consultar</button>                                                      
                    <div class="row">
                        <div class="col-md-12">
                            <table class="table table-hover">
                                <% Responsavel respons = (Responsavel) request.getAttribute("responsavel");%>
                                <thead>
                                    <tr>
                                        <th>Nome do Responsável</th>
                                        <th>CPF</th>
                                        <th>Telefone</th>
                                        <th>Email</th>
                                        <th>Editar</th>
                                        <th>Excluir</th>
                                    </tr>
                                </thead>                            
                                <tbody>
                                    <%if (respons != null) {%>
                                    <tr>
                                        <td><%=respons.getNome()%></td> 
                                        <td><%=respons.getCpf()%></td>
                                        <td><%=respons.getTelefone()%></td>
                                        <th><%=respons.getEmail()%></th>
                                        <td><a href="alterarResponsavel.jsp?cpf=<%=respons.getCpf()%>&nome=<%=respons.getNome()%>&telefone=<%=respons.getTelefone()%>&email=<%=respons.getEmail()%>"><span class="glyphicon glyphicon-edit"></span></a></td>                                        
                                        <td><a href="ExcluirResponsavel.jsp?cpf=<%=respons.getCpf()%>"><span class="glyphicon glyphicon-remove"></span></a></td>       
                                    </tr>     
                                    <%} %>
                                </tbody>
                            </table>
                        </div>    
                    </div>    
                </form>
            </div>
        </div>
        <div class="modal fade" id="confirmar-delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">     
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="modelConfirmarExclusao">Confirmar Exclusão</h4>
                    </div>

                    <div class="modal-body">
                        <p>Você está prestes a apagar um responsável, o procedimento é irreversivel.</p>
                        <p>Você quer continuar?</p>
                        <p class="debug-url"></p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                        <button class="btn btn-danger btn-ok">Apagar</button>
                    </div>
                </div>
            </div>
        </div>
        <script>
            $('#confirmar-delete').on('show.bs.modal', function (e) {
                $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
                //data-toggle="modal" data-target="#confirmar-delete" colocar no Href
                $('.debug-url').html('Apagar: <strong>' + $(this).find('.btn-ok').attr('href') + '</strong>');
            });
        </script>
        <footer class="container-fluid text-center">
            <p>SCE- Sistema Cantina Escola, Copyright © 2016 </p>
        </footer>
    </body>
</html>
