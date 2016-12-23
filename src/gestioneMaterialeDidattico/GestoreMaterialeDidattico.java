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

import storageLayer.DatabaseGM;

/**
 * Servlet implementation class GestoreMaterialeDidattico
 */
@WebServlet("/GestoreMaterialeDidattico")
public class GestoreMaterialeDidattico extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String previousPath="";
    static ArrayList<Item> listItem=new ArrayList<>();
    static ArrayList<Risorsa>listRisorse=new ArrayList<>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestoreMaterialeDidattico() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String folderClicked=request.getParameter("folderClicked");
		String folderPath;
		if(previousPath!=""){
			folderPath=previousPath+folderClicked;
		}else{
			folderPath=request.getSession().getServletContext().getRealPath("res/"+folderClicked);
		}
		File folderPointer=new File(folderPath);
		displayDirectoryContents(folderPointer);
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
				Risorsa r=DatabaseGM.getRisorsaByID(Integer.parseInt(file.getName()));
				listRisorse.add(r);
			}
		}
	}

}
