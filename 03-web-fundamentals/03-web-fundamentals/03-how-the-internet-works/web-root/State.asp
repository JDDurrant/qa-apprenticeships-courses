<html>
<head>
<title>Enter your details</title>
</head>
<body>

<form method="POST" action="State.asp">

<% If Request.ServerVariables("Request_Method") = "GET" Then %>

   <!-- *** Write the HTML form *** -->
   Enter some text: <input type="text" name="data"> <br />
   <input type="submit" name="Submit" value="submit">
   
<% ElseIf Request.ServerVariables("Request_Method") = "POST" Then %>

   <!-- *** Write out a thank you message *** -->
   <p>Thank you for your data</p>
   
   <!-- *** Write back the HTML form *** -->
   Enter some text: <input type="text" name="data"> <br />
   <input type="submit" name="Submit" value="submit">
   
<% End If %>

</form>

</body>
</html>