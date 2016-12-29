package gestioneMaterialeDidattico;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import storageLayer.DatabaseGM;

/**
 * Servlet implementation class GestoreMaterialeDidattico
 */

@WebServlet("/GestoreRicerca")
public class GestoreRicerca extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String previousPath = "";
	static ArrayList<Item> listItem = null;
	static ArrayList<Risorsa> listRisorse = null;
	static boolean lastLeaf = false;

	private String home = "";
	private String dip = "";
	private String degree = "";
	private String corso = "";
	private String materiale = "";
	String tipoSuccessivo = "";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestoreRicerca() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * @author Antonio Corsuto & Domenico Antonio Tropeano
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String folderClicked = request.getParameter("folderClicked");
		String typeClicked = request.getParameter("typeClicked");

		String errore = "";
		String requestPath = request.getSession().getServletContext().getRealPath("res/");

		if (typeClicked.equals("home")) {
			home = "";
			dip = "";
			degree = "";
			corso = "";
			materiale = "";
			tipoSuccessivo = "department";
			home = folderClicked;
			previousPath = "";
			lastLeaf = false;
			listItem = null;
			listRisorse = null;

		}

		else if (typeClicked.equals("department")) {

			errore = home + "/";

			tipoSuccessivo = "degree";
			dip = folderClicked;
			degree = "";
			corso = "";
			materiale = "";
			lastLeaf = false;
			listItem = null;
			listRisorse = null;
		}

		else if (typeClicked.equals("degree")) {

			errore = home + "/" + dip + "/";

			tipoSuccessivo = "corso";
			degree = folderClicked;
			corso = "";
			materiale = "";
			lastLeaf = false;
			listItem = null;
			listRisorse = null;
		}

		else if (typeClicked.equals("corso")) {

			errore = home + "/" + dip + "/" + degree + "/";

			tipoSuccessivo = "materiale";
			corso = folderClicked;
			materiale = "";
			lastLeaf = false;
			listItem = null;
			listRisorse = null;
		}

		else if (typeClicked.equals("materiale")) {

			errore = home + "/" + dip + "/" + degree + "/" + corso + "/";

			tipoSuccessivo = "";
			materiale = folderClicked;
			lastLeaf = false;
			listItem = null;
			listRisorse = null;
		}

		else {
			// redirect error page
		}

		String folderPath;

		listItem = new ArrayList<>();
		listRisorse = new ArrayList<>();

		if (previousPath != "") {
			previousPath = requestPath + errore;
			folderPath = previousPath + folderClicked;

		} else {
			folderPath = request.getSession().getServletContext().getRealPath("res/" + folderClicked);
		}
		previousPath = folderPath + "/";

		File folderPointer = new File(folderPath + "/");

		request.setAttribute("home", home);
		request.setAttribute("dip", dip);
		request.setAttribute("degree", degree);
		request.setAttribute("corso", corso);
		request.setAttribute("materiale", materiale);

		try {
			displayDirectoryContents(folderPointer);
		} catch (Exception e) {
			response.sendRedirect("dfdsfds");
		}
		if (!lastLeaf) {
			request.setAttribute("folderArray", listItem);
			request.setAttribute("tiposuccessivo", tipoSuccessivo);
			request.getRequestDispatcher("MD-navigazione.jsp").forward(request, response);
		} else {
			request.setAttribute("resourceArray", listRisorse);
			request.getRequestDispatcher("MD-DownloadUpload.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * Inserisce in un array il contenuto di una folder
	 * 
	 * @param dir
	 * @author Tropeano Domenico Antonio
	 */
	public static void displayDirectoryContents(File dir) throws Exception {
		File[] files = null;
			files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					Item f = new Item(file.getName());
					listItem.add(f);
				} else {
					int id = Integer.parseInt(file.getName());
					Risorsa r = DatabaseGM.getRisorsaByID(id);
					listRisorse.add(r);
					lastLeaf = true;
				}
			}
	}

}
