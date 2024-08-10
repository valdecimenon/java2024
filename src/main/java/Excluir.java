import java.io.IOException;

import com.softgraf.repository.AlunoRepository;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/excluir")
public class Excluir extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AlunoRepository repository;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String strId = req.getParameter("id");
		if (strId != null) {
			repository.removerPorId(Integer.parseInt(strId));
		}
		
		resp.sendRedirect("index.jsp");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
