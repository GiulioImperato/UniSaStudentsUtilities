package gestioneMaterialeDidattico;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import storageLayer.DatabaseGM;

/**
 * Servlet implementation class GestoreDownload
 */
@WebServlet("/GestoreDownload")
public class GestoreDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestoreDownload() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * @author Domenico Antonio Tropeano Tramite la get di questa servlet è
	 *         possibile avviare il download
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idRisorsa"));
		String dip = (String) request.getParameter("dip");
		String degree = (String) request.getParameter("degree");
		String corso = (String) request.getParameter("corso");
		String materiale = (String) request.getParameter("materiale");
		String path = request.getSession().getServletContext()
				.getRealPath("res/uni/" + dip + "/" + degree + "/" + corso + "/" + materiale + "/");
		File f = new File(path + "/" + id);
		ServletContext ctx = getServletContext();
		InputStream fis = new FileInputStream(f);
		String mimeType = ctx.getMimeType(f.getAbsolutePath());
		Risorsa r = DatabaseGM.getRisorsaByID(id);
		String estensione = r.getNome().substring(r.getNome().lastIndexOf(".") + 1);
		String nome = r.getNome().substring(0, r.getNome().lastIndexOf(".") + 1);
		response.setContentType(mimeType != null ? mimeType : "application/octet-stream");
		response.setContentLength((int) f.length());
		response.setHeader("Content-Disposition", "attachment; filename=\"" + nome + estensione + "\"");

		ServletOutputStream os = response.getOutputStream();
		byte[] bufferData = new byte[1024];
		int read = 0;
		while ((read = fis.read(bufferData)) != -1) {
			os.write(bufferData, 0, read);
		}
		fis.close();
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

}
