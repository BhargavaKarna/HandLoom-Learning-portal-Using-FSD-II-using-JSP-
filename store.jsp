<%@page import="java.sql/*"%>
<%
String name=request.getParameter("uname");
String password=request.getparameter("pass");
try{
	Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
	PreparedStatement ps=conn.prepareStatement("insert into signin values(?,?)");
	ps.setstring(1,name);
	ps.setstring(2,password);
	int x=ps.executeUpdate();
	if(x!=0)
		out.print("signup done sucessfully.");
	else
		out.print("Something went rong..");
}
catch(Exception e){
	out.print(e);
}
%>