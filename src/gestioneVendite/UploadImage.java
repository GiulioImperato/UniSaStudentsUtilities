package gestioneVendite;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;


/**
 * Servlet implementation class UploadImage
 */
@WebServlet("/UploadImage")
public class UploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadImage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	public String doRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		System.out.println("prova");
		if(!ServletFileUpload.isMultipartContent(request)){
			System.out.println("Nulla da caricare");
			return "null"; 
		}
		DiskFileItemFactory itemfactory = new DiskFileItemFactory(); 
		ServletContext servletContext = this.getServletConfig().getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		itemfactory.setRepository(repository);
		ServletFileUpload upload = new ServletFileUpload(itemfactory);
		String path = "C:\\Users\\Angiopasqui\\git\\UniSaStudentsUtilities\\WebContent\\res\\imagesAnnunci\\";
		try{
			List<FileItem>items = upload.parseRequest(request);
			for(FileItem item:items){

				String contentType = item.getContentType();

				if(contentType.equals("image/png")){
					File uploadDir = new File(path);
					File file = File.createTempFile("img",".png",uploadDir);
					item.write(file);
					String name = path+file.getName();

					String sourceImage = "res/imagesAnnunci/"+file.getName();

					request.removeAttribute("srcImage");
					request.setAttribute("srcImage", sourceImage);
					System.out.println(name);
					out.println(sourceImage);
				}
				else if(contentType.equals("image/jpeg")){
					File uploadDir = new File(path);
					File file = File.createTempFile("img",".jpg",uploadDir);
					item.write(file);
					String name = path+file.getName();

					String sourceImage = "res/imagesAnnunci/"+file.getName();
					request.removeAttribute("srcImage");
					request.setAttribute("srcImage", sourceImage);

					System.out.println(name);
					out.println(sourceImage);
				}
				else{
					out.println("possono essere caricati solo file jpeg o png");
				}
				break;
			}

		}
		catch(FileUploadException e){

			out.println("upload fail");
		}
		catch(Exception ex){
			ex.printStackTrace();
			out.println("can't save");
		}
		return "";
	}		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doRequest(request, response); 
	}
}
