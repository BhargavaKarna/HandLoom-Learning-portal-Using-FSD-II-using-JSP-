import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {
    // Retrieve the user input from the registration form
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    try {
      // Load the MySQL driver
      Class.forName("oracle.jdbc.driver.oracleDriver");

      // Establish a connection
      Connection connection = DriverManager.getConnection("jdbc:oracle:thin:localhost:1521:xe","system","tiger");
       
      // Prepare a statement to insert the user details into the database
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO signin (username, password) VALUES (?, ?)"
      );
      statement.setString(1, username);
      statement.setString(2, password);

      // Execute the statement to insert the user details into the database
      int rowsInserted = statement.executeUpdate();

      // Close the statement and connection
      statement.close();
      connection.close();

      if (rowsInserted > 0) {
        // Redirect the user to a success page
        response.sendRedirect("success.html");
      } else {
        // Redirect the user
	  }
	}
	catch(Exception e)
	{
		System.out.println(ex);
	}
	  }
}
