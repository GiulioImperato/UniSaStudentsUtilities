package gestioneVendite;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import storageLayer.DatabaseGV;

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
		HttpSession s = request.getSession();
		String azione = request.getParameter("azione");
		
		if(azione!=null){
			if(azione.equalsIgnoreCase("inserisciAnnuncio")){
				
				String titoloLibro = request.getParameter("titolo-libro");
				String autore = request.getParameter("autore-libro");
				CondizioneLibro condizione = CondizioneLibro.valueOf(request.getParameter("condizioni-libro"));
				String corso = request.getParameter("corso-libro");
				String proprietario = (String) s.getAttribute("email");
				String editore = request.getParameter("editore-libro");
				String year = request.getParameter("anno-libro");
				int anno = Integer.parseInt(year);
				String price = request.getParameter("prezzo-libro");
				double prezzo = Double.parseDouble(price);
				String descrizione = request.getParameter("descrizione");
				
				DettagliAnnuncio dt = new DettagliAnnuncio(editore, anno, descrizione, new Date(), "pathProva");
				Annuncio annuncio = new Annuncio(titoloLibro, autore, corso, proprietario, condizione, prezzo, dt);
				try {
					DatabaseGV.addAnnuncio(annuncio, dt);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				response.sendRedirect("/usu/index.jsp");
				
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
