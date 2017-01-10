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


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); 
		ArrayList<Aula> arr = new ArrayList<Aula>();
		ArrayList<Aula> auleLibere = new ArrayList<Aula>();
		String nomeAula = request.getParameter("nomeAula");
		String emailUtente = request.getParameter("emailUtente");
		String feedStatus = request.getParameter("feedStatus");
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
		if(azione.equalsIgnoreCase("feedback")){
			boolean status = Boolean.valueOf(feedStatus);
			try {
				boolean a = DatabaseGA.invioFeedback(status, emailUtente, nomeAula, giorno);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			out.write(String.valueOf(status));
		}
		/*if(azione.equalsIgnoreCase("ricerca")){
			String oraInizio = "09:00:00";
			String oraFine = "10:00:00";
			Date now = new Date();

			SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); // the day of the week abbreviated
			System.out.println(simpleDateformat.format(now));
			giorno = Giorno.valueOf(simpleDateformat.format(now));
			try{
				if(simpleDateformat.format(now).equals("lun")){
					giorno = Giorno.valueOf(simpleDateformat.format(now));
					auleLibere = DatabaseGA.ricercaAule(giorno, Time.valueOf(oraInizio), Time.valueOf(oraFine));
					System.out.println(auleLibere);
				}
				if(simpleDateformat.format(now).equals("mar")){
					giorno = Giorno.valueOf(simpleDateformat.format(now));
					auleLibere = DatabaseGA.ricercaAule(giorno, Time.valueOf(oraInizio), Time.valueOf(oraFine));
					System.out.println(auleLibere);
				}
				if(simpleDateformat.format(now).equals("mer")){
					giorno = Giorno.valueOf(simpleDateformat.format(now));
					auleLibere = DatabaseGA.ricercaAule(giorno, Time.valueOf(oraInizio), Time.valueOf(oraFine));
					System.out.println(auleLibere);
				}
				if(simpleDateformat.format(now).equals("gio")){
					giorno = Giorno.valueOf(simpleDateformat.format(now));
					auleLibere = DatabaseGA.ricercaAule(giorno, Time.valueOf(oraInizio), Time.valueOf(oraFine));
					System.out.println(auleLibere);
				}
				if(simpleDateformat.format(now).equals("ven")){
					giorno = Giorno.valueOf(simpleDateformat.format(now));
					auleLibere = DatabaseGA.ricercaAule(giorno, Time.valueOf(oraInizio), Time.valueOf(oraFine));
					System.out.println(auleLibere);
				}
			}  catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Errore"+ e.getMessage());
			}
			finally{
				ArrayList<String> nome = new ArrayList<String>();
				ArrayList<Double> x = new ArrayList<Double>();
				ArrayList<Double> y = new ArrayList<Double>();
				for(Aula a: auleLibere){
					nome.add(a.getNome());
				}
				for(Aula a: auleLibere){
					x.add(a.getCoordinateX());
				}
				for(Aula a: auleLibere){
					y.add(a.getCoordinateY());
				}

				for(int i=0;i< auleLibere.size();i++){
					out.write(String.valueOf(x.get(i))+",");
					out.write(String.valueOf(y.get(i))+" ");
				}
				for(int i=0;i< auleLibere.size();i++){
					out.write(nome.get(i)+" ");
				}
			}
		}*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
