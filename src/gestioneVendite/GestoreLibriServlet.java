package gestioneVendite;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GestoreLibriServlet
 */
@WebServlet("/GestoreLibriServlet")
public class GestoreLibriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestoreLibriServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String azione = request.getParameter("azione");
		if(azione!=null){
			if(azione.equalsIgnoreCase("inserisciAnnuncio")){
				String titoloLibro = request.getParameter("titolo-libro");
				String autore = request.getParameter("autore-libro");
				CondizioneLibro condizione = CondizioneLibro.valueOf(request.getParameter("condizioni-libro"));
				String corso = request.getParameter("corso-libro");
				
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
