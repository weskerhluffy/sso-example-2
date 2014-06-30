<html>
    <head>
        <title>SSO Example 2</title>
    </head>
    <body>
        Hello <sec:loggedInUserInfo field="username"/> to SSO Example 2!<br>
        En el panteon de dolores <sec:loggedInUserInfo field="authorities"/> tengo michante!<br>
        <g:link controller='logout' action='index'>Logout</g:link>
    </body>
</html>