package gestioneMaterialeDidattico;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import storageLayer.DatabaseGM;

/**
 * Servlet implementation class GestoreMaterialeDidattico
 */
@WebServlet("/GestoreRicerca")
public class GestoreRicerca extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String previousPath="";
    static ArrayList<Item> listItem=null;
    static ArrayList<Risorsa>listRisorse=null;
    static boolean lastLeaf=false;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestoreRicerca() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String folderClicked=request.getParameter("folderClicked");
		String folderPath;
		listItem=new ArrayList<>();
		listRisorse=new ArrayList<>();
		if(previousPath!=""){
			folderPath=previousPath+folderClicked;
		}else{
			folderPath=request.getSession().getServletContext().getRealPath("res/"+folderClicked);
		}
		previousPath=folderPath+"/";
		File folderPointer=new File(folderPath+"/");
		displayDirectoryContents(folderPointer);
		if(!lastLeaf){
			request.setAttribute("folderArray", listItem);
			request.getRequestDispatcher("MD-navigazione.jsp").forward(request, response);
		}else{
			request.setAttribute("resourceArray", listRisorse);
			request.getRequestDispatcher("MD-DownloadUpload.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public static void displayDirectoryContents(File dir) {
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				Item f=new Item(file.getName());
				listItem.add(f);
			} else {
				int id=Integer.parseInt(file.getName());
				Risorsa r=DatabaseGM.getRisorsaByID(id);
				System.out.println(r);
				System.out.println(id);
				listRisorse.add(r);
				lastLeaf=true;
			}
		}
	}

}
