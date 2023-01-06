<html>
   <head>
      <title>Main Page</title>
   </head>
   
   <body>
      <h1>Main Page</h1>
      <ul>
         <li><p><b>User Name:</b>
            <%= request.getParameter("user_name")%>
         </p></li>
         <li><p><b>Password:</b>
            <%= request.getParameter("password")%>
         </p></li>
         <% if (request.getParameter("password").equals("admin") && request.getParameter("user_name").equals("admin")) { %>
         <p> kaki </p>
         <% } else { %>
         <p> Gosh! Today is a Work-day.. </p>
         <% } %>
      </ul>
   
   </body>
</html>
