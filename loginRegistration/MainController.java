@Controller
public class MainController {

	private final UserService userServ;
	public MainController(UserService userServ) {
		this.userServ = userServ;
	}
	
	@GetMapping("/books")
	public String dashboard(HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/login/registration";
		}
		model.addAttribute("loggedInUser", userServ.getUser((Long) session.getAttribute("user_id")));
		return "main/dashboard.jsp";
	}

}
