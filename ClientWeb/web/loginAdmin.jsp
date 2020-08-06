<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.3/css/bootstrap-select.min.css"></link>
        <link rel="stylesheet" type="text/css" href="https://account.genndi.com/assets/css/bootstrap.css"></link>
        <link rel="stylesheet" type="text/css" href="https://account.genndi.com/assets/css/base.css"></link>

       
        <style>
        input[type=text], select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type=password], select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type=submit] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }

        div {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 10px;
        }
        </style>
    </head>
    <body>
 
        <div class="row">
            <div class="col-sm-6 col-sm-offset-3 col-xs-12 col-xs-offset-0">
                <form name="login_form_admin" id="login_form_admin" method="post" action="loginConfAdmin.jsp" class="form_login">
                    <div class="white_block">
                    <article>
                    <header class="clearfix">
                        <h4 class="pull-left">Sign in</h4>
                    </header>
                    <div class="block-inner">
                        <div class="form-group">
                            <label>Username</label>
                            <input type="text" name="username" class="required form-control" value="" placeholder="Enter your username..."></input>
                        </div>
                        <div class="form-group w_margin">
                            <label>Password</label>
                            <input name="password" type="password" class="required form-control" style="" placeholder="Enter your password..."></input>
                        </div>
                        <button type="submit" class="btn btn-black_new btn-large btn-block btn-error text-uppercase "  id="submit_login">
                            <span class="btn-title" data-original-title="Sign in">Sign in</span>  
                        </button>
                    </div>
                    </article>
                    </div>
                </form>
            </div>
        </div>    
    </body>
</html>
