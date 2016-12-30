package gestioneAule;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import storageLayer.DatabaseGA;

/**
 * Servlet implementation class GestoreAuleServlet
 */
public class GestoreAuleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestoreAuleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); 
		ArrayList<Aula> arr = new ArrayList<Aula>();
		try {
			arr = DatabaseGA.getListaAule();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore"+ e.getMessage());
		}
		finally{
			ArrayList<String> nome = new ArrayList<String>();
			ArrayList<Double> x = new ArrayList<Double>();
			ArrayList<Double> y = new ArrayList<Double>();
			for(Aula a: arr){
				nome.add(a.getNome());
			}
			for(Aula a: arr){
				x.add(a.getCoordinateX());
			}
			for(Aula a: arr){
				y.add(a.getCoordinateY());
			}

			String azione = request.getParameter("azione");
			if(azione!= null){
				if(azione.equalsIgnoreCase("visualizzaMappa")){
					for(int i=0;i<= 30;i++){
						out.write(String.valueOf(x.get(i))+",");
						out.write(String.valueOf(y.get(i))+" ");
					}
					for(int i=0;i<= 30;i++){
						out.write(nome.get(i)+" ");
					}
				}
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
