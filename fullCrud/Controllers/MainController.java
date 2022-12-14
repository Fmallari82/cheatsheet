@Controller
@RequestMapping("/books")
public class BookController {
	
	private final BookService bookServ;
	private final UserService userServ;
	public BookController(BookService bookServ, UserService userServ) {
		this.bookServ = bookServ;
		this.userServ = userServ;
	}
	
	@GetMapping ("/create")
	public String createBook( @ModelAttribute("book") Book book, HttpSession session) {
		//must be logged in to access directory
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		return "books/create.jsp";
	}
	
	@PostMapping("/create")
	public String processCreateBook(
			@Valid
			@ModelAttribute("book") Book book,
			BindingResult result){
		
		if(result.hasErrors()) {
			return "books/create.jsp";
		}
		bookServ.create(book);
		return "redirect:/books";
	}
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long id, Model model, HttpSession session) {
		//must be logged in to access directory
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		Book book = bookServ.getOne(id);
		model.addAttribute("book", book);
		return "books/edit.jsp";
	}
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		bookServ.delete(id);
		return "redirect:/books";
	}
	@PutMapping("/edit/{id}")
	public String processEditBook(
			@PathVariable("id") Long id, 
			@Valid
			@ModelAttribute("book") Book book,
			BindingResult result) {
		if(result.hasErrors()) {
			return "books/edit.jsp";
		}
		bookServ.update(book);
		return "redirect:/books";
	}
	@GetMapping("/view/{id}")
	public String viewBook(@PathVariable("id") Long id, Model model, HttpSession session) {
		//must be logged in to access directory
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		Book book = bookServ.getOne(id);
		model.addAttribute("book", book);
    	User user = userServ.getUser((Long)session.getAttribute("user_id"));
    	model.addAttribute("user", user);
		return "books/show.jsp";
	}
}