package gestioneMaterialeDidattico;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import storageLayer.DatabaseGM;

@WebServlet("/GestoreFeedback")
public class GestoreFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private boolean beforelike = false;
	private boolean beforedislike = false;

	public GestoreFeedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Con il doGet di questa classe è possibile rilasciare feedback
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int numlike = Integer.parseInt(request.getParameter("numlike").trim());
		int numdislike = Integer.parseInt(request.getParameter("numdislike").trim());
		String cliccato = request.getParameter("cliccato").trim();
		int idRisorsa = Integer.parseInt(request.getParameter("idRis").trim());

		if (numlike < 0)
			numlike = 0;

		if (numdislike < 0)
			numdislike = 0;

		int likeAggiornati = numlike;
		int dislikeAggiornati = numdislike;

		System.out.println("cosa ho cliccato  " + cliccato + " num like " + numlike + " num dislike " + numdislike
				+ "id risorsa " + idRisorsa);

		try {
			if (cliccato.equals("like")) {

				if (beforedislike == false) {
					likeAggiornati = DatabaseGM.aggiornaLike(idRisorsa, numlike + 1);
					dislikeAggiornati = numdislike;
					beforelike = true;
					beforedislike = false;
				}

				else {
					likeAggiornati = DatabaseGM.aggiornaLike(idRisorsa, numlike + 1);
					beforelike = true;
					dislikeAggiornati = DatabaseGM.aggiornaDislike(idRisorsa, numdislike - 1);
					beforedislike = false;
				}

			}

			else if (cliccato.equals("dislike")) {

				if (beforelike == false) {
					dislikeAggiornati = DatabaseGM.aggiornaDislike(idRisorsa, numdislike + 1);
					beforelike = false;
					beforedislike = true;
				}

				else {
					likeAggiornati = DatabaseGM.aggiornaLike(idRisorsa, numlike - 1);
					beforelike = false;
					dislikeAggiornati = DatabaseGM.aggiornaDislike(idRisorsa, numdislike + 1);
					beforedislike = true;
				}

			}

			else {

				likeAggiornati = numlike;
				dislikeAggiornati = numdislike;
				// non dovrebbe capitare
			}

		} catch (SQLException e) {
			System.out.println("puo capitare nel caso si errori con il db!!");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("non dovrebbe capitare maii !!");
			e.printStackTrace();
		}

		PrintWriter out = response.getWriter();
		Gson json = new Gson();

		ArrayList<Object> o = new ArrayList<>();
		o.add(likeAggiornati);
		o.add(dislikeAggiornati);

		out.print(json.toJson(o));
		System.out.println(json.toJson(o));

		out.flush();
		out.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
