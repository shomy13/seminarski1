package rs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletAdminUnosRAm
 */
@WebServlet("/ServletAdminUnosRAm")
public class ServletAdminUnosRAm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdminUnosRAm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sifra = request.getParameter("sifra");
		String proizvodjac = request.getParameter("proizvodjac");
		String model = request.getParameter("model");
		String cena = request.getParameter("cena");
		String brzinaRada = request.getParameter("brzinaRada");
		String kapacitet = request.getParameter("kapacitet");
		String tip = request.getParameter("tip");
		String slika = request.getParameter("slika");
		String garancija = request.getParameter("garancija");
		String akcija = request.getParameter("akcija");
		
		if(sifra !=null && sifra.length()>0&&proizvodjac !=null&& proizvodjac.length()>0&&	model !=null && model.length()>0&&cena !=null&& cena.length()>0
				&&kapacitet !=null&& kapacitet.length()>0&& slika != null && slika.length()>0 &&garancija !=null&& garancija.length()>0
				&&	akcija !=null &&brzinaRada !=null&& brzinaRada.length()>0&& akcija.length()>0){
			try {
				float c4 = Float.parseFloat(cena);
				int gar4=Integer.parseInt(garancija);
				
				ramMemorija ra = new ramMemorija(sifra,proizvodjac,model,brzinaRada,kapacitet,tip,akcija,slika,gar4,c4);
				AdminDAO ud = new AdminDAO();
				ud.insertramMemorija(ra);;
				request.setAttribute("msg2", "Uspesno unesen artikal Ram memorija!");
				request.getRequestDispatcher("UnosAdminProizvod.jsp").forward(request, response);
				
				
			} catch (Exception e) {
				request.setAttribute("msg2", "Cena,garancija i akcija moraju biti broj!!!");
				request.getRequestDispatcher("UnosAdminProizvod.jsp").forward(request, response);
			}
			
			
		}else{
			request.setAttribute("msg2", "Morate popuniti sva polja!!!");
			request.getRequestDispatcher("UnosAdminProizvod.jsp").forward(request, response);
	
	
	}
	}

}
