package com.Studentapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Studentapp.model.DAOServiceImpl_1_3rd;
import com.Studentapp.model.DAOService_1_2nd;


@WebServlet("/verifylogin")
public class LoginController_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginController_1() { //login controller nam ka hmne ek servlet bnaya
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");//read kr rha h email //controller layer
		String password = request.getParameter("password");// read kr rha h password //controller layer
		
		DAOService_1_2nd service=new DAOServiceImpl_1_3rd();
		service.connectionDB();//database se connect krne k liye 
		
		boolean status = service.verifyCredentials(email, password);
//call kiya he hmne yha se verifycrenditial method ko to check its coorect or not
		
		if(status==true) {
			HttpSession session = request.getSession(true);
			session.setAttribute("email", email);
			session.setMaxInactiveInterval(10);
			
			/*PrintWriter out = response.getWriter();
			out.println("welcome");*/
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/New_Registration_2.jsp");
			rd.forward(request, response);
//ye isliye likha h ku ki jb bhi if condition chlegi to vo new_registration wala JSP ko call kregi			
			
		}else {
			request.setAttribute("error", "invalid username/password");
			//for error msg we set set.attribute here with error msg
			
			RequestDispatcher rd = request.getRequestDispatcher("login_1.jsp");
			rd.forward(request, response);
			//ye hmne is liye likha h jisse vo jsp me pta kr skte k email/password shi he ya nhi
		}
	}

}

//1st- login nam ka ek JSP HTML banaya jo ki hme help krega login page banane me.. 

//2nd- login controller nam ka ek servlet bnaya jisme hamne ek getparameter pass krwa jisme hmne value diya h email or password
//     vo read krne ka kam kr rha he but vo verfiy nhi kr skta h k shi he ya glt bss read kr skta h..

//3rd- fir hmne MODEL Layer banya jise hmne DAOService nam diya or use hmne INTERFACE me bnaya
//     DAOService liya h database se connect krne k liye..

//4th-DAOService me but incomplete method bni he to hme usse INHERITED krna pdega to hm uske liye nyi class bnyenge jisse k vo 
//    inherited ho jye..

//5th-hmne INTERFACE ko complete krne k liye use INHERITED kiya or complete krne k bd vo bn gya POLYMORPHISM..

//6th-ab hme dekhna he k user name or password shi he ya glt...

//7th-to hmne LOGINCONTROLLER me VERIFYCRENDITIAL ko call kr diya jisse vo pta lga ske k email or password shi he ya nhi
//    jiske liye hmne if/else condition lga di check krne k liye..

//8th-hmne if me (STATUS==true) diya 
//    or usme    PrintWriterk out = response.getWriter(); diya
//    or syso kre k jo bhi print krwana he vo likh diya
//    agr contion true he to welcome print krwao nhi to 
//    else me hmne SET.Attribute liya h jisme vo invalid show krega agr condition wrong he to..

//9th-hmne JSP me IF condition di he jisse vo check kr skta h condition true he ya false
//    to hmne GET.Attribute liya h wha pr conition check krne k liye...

//10th-fir hamne abhi tk webapp me JSP banaya h but ab WEB-APP ke andr WEB-INF me folder bnana h uske and JSP banana h..

//11th-JSP me title dena h or heading dena h...

//12th-fir hme LOGINCONTROLLER me jakr if condition se PrintWriter hatha k Request.getDispatcher liya jise k vo New_Registration
//     wale JSP ko call krega or condition check krega...

//13th-fir hme JSP New_Registration me jana h or <form> k andr hme registration page create krna h 
//     bole to email,city,name,mobile dena h or lst me <input action dena h />....

//14th-fir hme JSP me hi New_Registration wale me hi <pre> tag ka use krna h or uske andr sari chize dalni h
//     jese k email,city,mobile,name wali chize jisse k vo hme sari chize alg alg line  me de de....

//15th-fir hme JSP New_Registration me <form> k and <input action="newREG" method="post"> bnani he isko action attribute bolte h..

//16th-fir hme LOGIN_CONTROLLER k sath NEW_REGISTRATION_CONTROLLER bnanna he or uske and hme do-Post method me 
//     request.getParameter pass krwana h sbhi k liye means city,mail,mobile,name ke liye...

//17th-fir hamne usme DAOService service=new DAOServiceImpl(); use kiya do-Post ke andr hi
//                    service.connectionDB();
//                    service.saveReg(name,city,email,mobile);
//     diya jo ki DAOService method ko data snd kr rha h 
//     jo hmne saveReg nam ke value di h usko hme method me convert krna pdega ji ki DAOService me add ho jayegi...

//18th-fir hme DAOServiceImpl me jana h jisme hme uske click krke method add krni h new method
//     new method me hme do-Post se try/catch block pick krke same new method me dalna h
//     lekin usme chiz echange hogi ki executeQuery ki jgha ab executeUpdate a jayega or usme argument update wala pss hoga
//      jo ki (insert into registration values('"+name+"'); dena h....

//19th-fir hme save krna he sari chize fir dekhna h k DATABASE me data save ho rha h ke nhi...

//20th-fir hme New_Registration_Controller me do-Post method me jakr DAOService k niche hme request.getDispatcher likhna he..

//21st-fir hme wha pr request.setAttribute("msg","Record is saved"); likhna he...

//22nd-fir hme JSP New_Registration me jakr if condition lagani he...

//23rd-fir page bn jayega nd data bhi database me chle jayega...

//24th-fir hme WEB-INF me jakr VIEWS k and ek or jsp bnanna pdega jisse ki hm menu or data show kr ske apne web page pe...

//25th-fir hme jsp me jakr <a href="">new registration</a> ka use krna h
//                         <a href="">All registration</a>...

//26th-fir hme dobara jsp NEW REGISTRATION wale me jana h or wha hme jsp file add krni h 
//     jese ki <% include file=Menu.jsp%>...

//27th-fir vo hme run kr ke dekhna h k webpage pe show ho rha he ya nhi vo sari chize...

//28th-fir hme NEW_REGISTRATION_CONTROLLER me jana h wha pr do-get metheod me requewstDispatcher likhna h 
//     jo ki hmne do-Post me likha tha whi chiz e same isme likhna h....

//29th-fir hmne jo webServlet me nam diya tha whi same chiz copy krni h or vo chiz hme MENU JSP me jakr <href> me past krni h..

//30th-fir same chiz 2nd wale <href> value deni listall nam se but ap jo bhi ap chao...

//31st-fir hme ek new Servlet bnanan he jo ki GET_ALL_REGISTRATION k nam se ya kuch bhi nam rkh skte ho ap..

//32nd-fir ap ne jo bhi 2nd <href> me value di h whi value same Web-Servlet me likhna h...

//33th-fir hme GET_ALL_REGISTRATION wale servlet me do-Get method me DAOService wala method likhna hoga
//     DAOservice service=new DAOServiceImpl();
//     service.connectionDB();
//     ResultSet result service.ListRegistration(); or listregistration nam ki ek method create krni hogi jo ki
//     DAOService me rhegi or usko hm kuch bhi nam de skte h method ko to hm Result Set de denge..

//34th-fir hme DAOServiceImpl me jakr wha ek method import krni hogi jo ki LIST_REGISTRATION nam se hogi
//     usme hme try/cath block use krna rhega jisme hme (select * from registration wali chiz us ekrni h)
//     or uska return type result rhega...

//35th-fir hme GET_ALL_REGISTRATION me jakr do-Get method me hme  setAttribute likhna h or sath me getAttribute bhi likhna h 
//     or uske bd hme requestDispatcher bhi likhna h....

//36th-fir hme views me jakr list_all nam ka jsp bnana he... 

//37th-fir hme wha pr ek <table> create krni he usme <tr> tag use krna h uske andr hme <th> tag use kena h 
//     usme hme <th> tak k and <th>name</th> ese sbhi k liye likhna he...

//38th-fir hme usme getAttribute likhna h upcasting k through or resultset ko import krna pdega...

//39th-fir hme while loop likhna pdega like while (Result.next()){...

//40th-phele hmne while loop likha tha but adha hi liha h bcz hm usme pura nhi likh skte he is liye
//     to hm use pura krne k liye dusra tag use krenge like <%}%> iske upr hme same chiz krni h jese hmne <th> tag
//      use k andr likha tha same vese hi likhna h but thoda change h....

//41st-jese ki <td><%=result.getString(1)%></td> is type se 4row likhne he

//42nd-fir hme listALL jsp me jakr <td> <a href="delete?email=<%=reult.getString(3)%>"> delete</a></td> ye likhna he..jo ki
//     datadelete k liye query likhi gyi he

//43rd-fir hme ListAll jsp me jakr email wale column k sath <th>delete</th> ka bnnana he..

//44th-fir hmko delete wali url chalne ke liye new servlet bnana pdega..

//45th-DELETE_REGISTRATIION_CONTROLLER nma ka swervlet bnega jisme hme do-Get method me delete query chlana pdega
//     jisse ki hm use delete kr ske...

//46th-jisme hme controller mtlb k do-get method ko email dena pdega jisse k vo read kr ske uske bd hme model layer bnnai hogi
//     jo ki DAOService wali hogi


//47th-ye kam kese krta VIEWS layer phele CONTROLLER ko call kregi jo ki do-Get method he fir controller call krega Model layer ko jo ki
//     DAOService wali layer he fir vo email delete kr degi fir dobara vo CONTROLLER ko call kregi jisse CONTROLLER dobara data read krega 
//     mtlb k vo dobara data fetch krega or vo list pe chla jyega controller

//48th-usme bad JSP list all me jakr hme update ke liye likhna hota h 
//     <td><a href="update?email=<%=result.getString(2)%>&mobile=<%=result.getString(4)%>">update</a></td>
//     or table me bhi update likhna hota h..

//49th-fir hme ek servlet bnana pdega jo ki UPDATE CONTROLLER ke nam se rhega..

//50th-fir usme get method me hmko request.get parameter email/or mobile k liye likhna hoga
//     fir uske niche hme request.set attribute krna hoga..
//     fir hme uske niche get requestDispatcher likhna hoga...

//51th-fir hme ek JSP file bnnana hoga jo ki UPDATE K nam se rhega..

//52th-usme <form> bna kr email/or mobiler number ka input dena hoga
//     Email<input type="text" name="email" value="<%=request.getAttribute("email")%>"/>
//     Mobile<input type="text" name="mobile"value="<%=request.getAttribute("mobile")%>"/>..

//53th-ab hme UPDATE CONTROLLER me jakr post method me dobara likhna hoga 
//     request,getparameter email/mobile ka fir hme use db se connect krenge jese ki
//     DAOService service=new dAOServiceImpl...
//     fir connection db krenge
//     fir hm service.updateReg(email,mobile); likh kr DAOService me method create krenge
//     fir usko DAOServiceimpl  me dobara method bnayenge..

//54th-fir jo DAOServiceimpl  me method create hui h updateReg ke nam ki usme hm 
//     try cath block likhenge or us try catch block k and hm update ki query chla denge 
//     fir usme  ResultSet result = service.listRegistration();

//     request.setAttribute("result", result);

//     RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/List_All_4.jsp");
//     rd.forward(request, response);
//     ye sb likh denge to ho jayega apna update ka...

//55th-fir hme menu me jakr login k liye ek form create krna hoga jisse ki hm ahse se loh out kr ske..
//     








