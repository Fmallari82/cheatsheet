@Controller
public class MainController {

	private final UserService userServ;
	private final BookService bookServ;
	public MainController(UserService userServ, BookService bookServ) {
		this.userServ = userServ;
		this.bookServ = bookServ;
	}
	
	@GetMapping("/books")
	public String dashboard(HttpSession session, Model model) {
		//if not logged on redirect to registration login page
		if(session.getAttribute("user_id") == null) {
			return "redirect:/login/registration";
		}
		model.addAttribute("allBooks", bookServ.getAll());
		model.addAttribute("loggedInUser", userServ.getUser((Long) session.getAttribute("user_id")));
		return "main/dashboard.jsp";
	}

}