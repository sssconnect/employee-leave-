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

            /* Set black background color, white text and some padding */
            footer {
                background-color: #555;
                color: white;
                padding: 15px;
            }

            /* On small screens, set height to 'auto' for sidenav and grid */
            @media screen and (max-width: 767px) {
                .sidenav {
                    height: auto;
                    padding: 15px;
                }
                .row.content {height:auto;} 
            }
        </style>
        <%
            if (session.getAttribute("Message") == "user") {
        %>
            <script>alert("Successively LogedIn.,.");</script>
        <%
                session.removeAttribute("Message");
        }%>
        <%
            if (session.getAttribute("Message") == "error") {
        %>
            <script>alert("Some error Occured while Data Saving");</script>
        <%
                session.removeAttribute("Message");
        }%>
        <%
            if (session.getAttribute("Message") == "Successfully Saved") {
        %>
            <script>alert("<%=session.getAttribute("Message")%>");</script>
        <%
                session.removeAttribute("Message");
        }%>
        
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav navbar-left">
                        <li><a onclick="logout()" href="index.jsp"><span class="mouse-change glyphicon glyphicon-log-in"></span> Logout </a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="box">
            <hr>
            <h2 class="intro-text text-center">
                <strong>Request for Leave</strong>
            </h2>
            <hr>
            <div class="container-fluid text-center">
                <div class="row content">
                    <div class="col-sm-2 sidenav">

                    </div>
                    <div class="col-sm-8 text-left">
                        <div class="container-fluid" style="margin-top:5%">     
                            <form method="post" action="Leaves" class="form-inline">
                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <div class="row" >
                                            <div class="col-lg-6">
                                                <label for="uname" > User Name </label>
                                            </div>

                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" name="uname" value="<%=session.getAttribute("Users")%>" style="width: 200px;" placeholder="Mr. John">
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <div class="row" >
                                            <div class="col-lg-6">
                                                <label for="email"> Email-ID </label>
                                            </div>

                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" name="email" style="width: 200px;" placeholder="xyz@gmail.com">
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <div class="row" >
                                            <div class="col-lg-6">
                                                <label for="sdate"> Start Date </label>
                                            </div>

                                            <div class="col-lg-6">
                                                <input type="date" class="form-control" style="width: 200px;margin-top: 3%" name="sdate" >
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <div class="row" >
                                            <div class="col-lg-6">
                                                <label for="edate"> End Date </label>
                                            </div>

                                            <div class="col-lg-6">
                                                <input type="date" class="form-control" style="width: 200px;margin-top: 3%" name="edate" >
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <div class="row" >
                                            <div class="col-lg-6">
                                                <label for="edate"> Reason </label>
                                            </div>

                                            <div class="col-lg-6">
                                                <textarea name="resn" row="4" cols="20" class="form-control" style="width: 200px;margin-top: 3%"></textarea>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-6">

                                </div>
                                <button type="submit" class="btn btn-success" style="width: 100px;margin-top: 2%">Submit</button>
                                <button type="reset" class="btn btn-primary" style="width:  100px;margin-top: 2%">Clear</button>

                            </form>     
                        </div>
                    </div>
                    <div class="col-sm-2 sidenav">

                    </div>
                </div>
            </div>
        </div>

        <script>
            function logout() {
                alert("You have Successfully Logout!");
            }
        </script>
    </body>
</html>
