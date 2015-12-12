<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Leave Application</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <style>
            /* Remove the navbar's default margin-bottom and rounded borders */ 
            .navbar {
                margin-bottom: 0;
                border-radius: 0;
                background: brown;
            }

            /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
            .row.content {height: 450px}

            /* Set gray background color and 100% height */
            .sidenav {
                padding-top: 20px;
                background-color: #f1f1f1;
                height: 100%;
            }
            @media screen and (max-width: 767px) {
                .sidenav {
                    height: auto;
                    padding: 15px;
                }
                .row.content {height:auto;} 
            }
        </style>
        <%if (session.getAttribute("Message") == "error") {
        %>
        <script>alert("User Name or password incorrect");</script>
        <%
                session.removeAttribute("Message");
            }
        %>
    </head>
    <body>

        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav navbar-left">
                        <li class="dropdown"><a class="mouse-change glyphicon  dropdown-toggle" data-toggle="dropdown" href="#">Login<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a id="ulog" >User</a></li>
                                <li><a id="adlog">Employer</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="modal fade" id="uModal" role="dialog">

            <div class="modal-dialog">

                
                <div class="modal-content">
                    <div class="modal-header" style="padding:35px 50px;">
                        <div class="row"><button type="button" class="close" data-dismiss="modal">&times;</button></div>
                        <h4 class="glyphicon ">Login</h4>
                    </div>
                    <div class="modal-body" style="padding:40px 50px;">
                        <form role="form" method="post" action="Log">
                            <div class="form-group">
                                <label for="usrname"><span class="glyphicon glyphicon-user"></span> Username</label>
                                <input type="text" class="form-control" name="usrname" placeholder="Enter email">
                            </div>
                            <div class="form-group">
                                <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
                                <input type="password" class="form-control" name="psw" placeholder="Enter password">
                                <input type="hidden" name="chec" value="user">
                            </div>
                            <div class="checkbox">
                                <label><input type="checkbox" value="" checked>Remember me</label>
                            </div>
                            <center>
                            <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-off"></span> Login</button>
                            </center>
                        </form>
                    </div>                    
                </div>
            </div>
        </div>
        <div class="modal fade" id="adModal" role="dialog">

            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header" style="padding:35px 50px;">
                        <div class="row"><button type="button" class="close" data-dismiss="modal">&times;</button></div>
                        <h4 class="glyphicon ">Login</h4>
                    </div>
                    <div class="modal-body" style="padding:40px 50px;">
                        <form role="form" method="post" action="Log">
                            <div class="form-group">
                                <label for="usrname"><span class="glyphicon glyphicon-user"></span> Employer</label>
                                <input type="text" class="form-control" name="usrname" placeholder="Enter email">
                            </div>
                            <div class="form-group">
                                <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
                                <input type="password" class="form-control" name="psw" placeholder="Enter password">
                                <input type="hidden" name="chec" value="admin">
                            </div>
                            <div class="checkbox">
                                <label><input type="checkbox" value="" checked>Remember me</label>
                            </div>
                            <center>
                            <button type="submit" class="btn btn-primary" ><span class="glyphicon glyphicon-off"></span> Login</button>
                            </center>
                        </form>
                    </div>                    
                </div>
            </div>
        </div>
        <script>
            $(document).ready(function () {
                $("#ulog").click(function () {
                    $("#uModal").modal();
                });
            });
            $(document).ready(function () {
                $("#adlog").click(function () {
                    $("#adModal").modal();
                });
            });
        </script>
    </body>
</html>
