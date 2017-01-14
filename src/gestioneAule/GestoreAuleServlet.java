package gestioneAule;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

	/**
	 * <b>Permette di visualizzare la mappa con l'aggiunta delle aule (viewMap)</b>
	 * <b>Permette di visualizzare la mappa con le aule che risultano libere e occupate (statusAula)</b>
	 * <b>Permette di mostrare le informazioni di un'aula come nome e ore in cui l'aula risulta libera (infoAula)</b>
	 * @author Angelo Settembre
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); 
		ArrayList<Aula> arr = new ArrayList<Aula>();
		ArrayList<Aula> auleLibere = new ArrayList<Aula>();
		String nomeAula = request.getParameter("nomeAula");
		String aulaName = "";
		String azione = request.getParameter("azione");
		Giorno giorno = null;

		if(azione.equalsIgnoreCase("viewMap")){
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


				for(int i=0;i<= 30;i++){
					out.write(String.valueOf(x.get(i))+",");
					out.write(String.valueOf(y.get(i))+" ");
				}
				for(int i=0;i<= 30;i++){
					out.write(nome.get(i)+" ");
				}
			}
		}
		
		if(azione.equalsIgnoreCase("statusAula")){
			boolean stato = false;
			Time oraAttuale = new Time(System.currentTimeMillis());
			Time inizio = new Time(oraAttuale.getHours(),0,0);			
			Time fine = new Time(oraAttuale.getHours()+1,0,0);
			Date now = new Date();

			SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); // the day of the week abbreviated
			giorno = Giorno.valueOf(simpleDateformat.format(now));
			try {
				stato = DatabaseGA.getStatusAula(nomeAula, inizio, fine, giorno);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println(stato+" "+"AULA= "+nomeAula);
			
			out.write(String.valueOf(stato));
		}
		
		if(azione.equalsIgnoreCase("infoAula")){
			//VISUALIZZA INFO AULA
			System.out.println("NOME:"+nomeAula);
			ArrayList<OraAula> listOraAula = new ArrayList<OraAula>();



			Date now = new Date();

			SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); // the day of the week abbreviated
			System.out.println(simpleDateformat.format(now));
			try{
				if(simpleDateformat.format(now).equals("lun")){
					giorno = Giorno.valueOf(simpleDateformat.format(now));
					listOraAula = DatabaseGA.visualizzaInfoAula(nomeAula, giorno);
					System.out.println(listOraAula);
					for(OraAula a:listOraAula){
						System.out.println(a.getNome());
						aulaName = a.getNome();
						break;
					}
				}
				if(simpleDateformat.format(now).equals("mar")){
					giorno = Giorno.valueOf(simpleDateformat.format(now));
					listOraAula = DatabaseGA.visualizzaInfoAula(nomeAula, giorno);
					System.out.println(listOraAula);
					for(OraAula a:listOraAula){
						System.out.println(a.getNome());
						aulaName = a.getNome();
						break;
					}
				}
				if(simpleDateformat.format(now).equals("mer")){
					giorno = Giorno.valueOf(simpleDateformat.format(now));
					listOraAula = DatabaseGA.visualizzaInfoAula(nomeAula, giorno);
					System.out.println(listOraAula);
					for(OraAula a:listOraAula){
						System.out.println(a.getNome());
						aulaName = a.getNome();
						break;
					}
				}
				if(simpleDateformat.format(now).equals("gio")){
					giorno = Giorno.valueOf(simpleDateformat.format(now));
					listOraAula = DatabaseGA.visualizzaInfoAula(nomeAula, giorno);
					System.out.println(listOraAula);
					for(OraAula a:listOraAula){
						System.out.println(a.getNome());
						aulaName = a.getNome();
						break;
					}
				}
				if(simpleDateformat.format(now).equals("ven")){
					giorno = Giorno.valueOf(simpleDateformat.format(now));
					listOraAula = DatabaseGA.visualizzaInfoAula(nomeAula, giorno);
					System.out.println(listOraAula);
					for(OraAula a:listOraAula){
						System.out.println(a.getNome());
						aulaName = a.getNome();
						break;
					}
				}
			}  catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Errore"+ e.getMessage());
			}
			finally{
				out.write(aulaName+" ");
				int dim = listOraAula.size();
				String dimensione = String.valueOf(dim);
				out.write(dimensione+" ");
				for(int i=0;i<listOraAula.size();i++){
					out.write(listOraAula.get(i).getOraInizio()+",");
					out.write(listOraAula.get(i).getOraFine()+" ");
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
