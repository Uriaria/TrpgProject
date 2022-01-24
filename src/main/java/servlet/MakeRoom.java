package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.Room;

@WebServlet("/MakeRoom")
public class MakeRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MakeRoom() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Room.jsp");
		dispatcher.forward(request, response);
		

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Room[] ro = new Room[100];
		for(int i = 0; ro.length > i; i++) {
			ro[i] = new Room();
		}
		String name =request.getParameter("name");
		int no =Integer.parseInt(request.getParameter("no"));
		String passward =request.getParameter("passward");
		if(name != null || no != 0 || passward != null) {
			for(int i = 0; ro.length > i ; i++) {
				if(ro[0].getName(ro, i) == null) {
					ro[0].setName(ro, name, i);
					ro[0].setNo(ro, no, i);
					ro[0].setPassward(ro, passward, i);
					break;
				}
			}
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>部屋一覧</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table border=\"1\" style=\"width:400\">");
		out.println("<table align=\"right\">");
		out.println("<tr bgcolor=\"blue\">");
		//新規登録ボタンでページ移動
		out.println("<th><a href=WEB-INF/jsp/Room.jsp class=btn>ルーム作成</th>");
		out.println("</tr>");
		out.println("</table>");
		out.println("<b>一覧</b>");
		out.println("<table border=\\\"1\\\" style=\\\"width:400\\\">");
		out.println("<tr bgcolor=\"blue\">");
		out.println("<th>ルームNo</th><th>ルーム名</th>");
		out.println("</tr>");
		
		//登録されている内容をNo1から表示
		for(int i = 0; ro[0].getName(ro,i) != null; i++) {
			System.out.println(i);
			out.println("<tr>");
			out.println("<th>" + ro[0].getNo(ro,i) + "</th><th>" + ro[0].getName(ro,i) + "</th>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.println("");
	}
}