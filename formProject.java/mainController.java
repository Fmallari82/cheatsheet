
@Controller
@RequestMapping("/languages")
public class LanguageController {
	
	public final LanguageService languageServ;
	public LanguageController(LanguageService languageServ) {
		this.languageServ = languageServ;
	}
	
	@GetMapping("/all")
	public String allLanguage(@ModelAttribute("language") Language language, Model model) {
		model.addAttribute("allLanguage", languageServ.getAll());
		model.addAttribute("language", new Language());
		return "index.jsp";
	}

	@GetMapping("/{id}")
	public String oneLanguage(@PathVariable("id") Long id, Model model) {
		Language oneLanguage = languageServ.findOne(id);
		model.addAttribute("oneLanguage", oneLanguage );
		return "showOne.jsp";
	}
	@GetMapping("/search")
	public String searchLanguage(@RequestParam("search") String Search, Model model) {
		model.addAttribute("allLanguage", languageServ.searchLanguage(Search));
		model.addAttribute("donation", new Language());
		return "index.jsp";
	}
	
	@GetMapping("/new")
	public String newLanguage(@ModelAttribute("language") Language language) {
		
		return "index.jsp";
	}
	
	@PostMapping("/all")
	public String processLanguage(
			@Valid 
			@ModelAttribute("language")
			Language language, 
			BindingResult result,
			Model model) 
	{	
		if(result.hasErrors()) {
			model.addAttribute("allLanguage", languageServ.getAll());
			return "index.jsp";
		}
		languageServ.create(language);
		return "redirect:/languages/all";
	
		}
	@GetMapping("/edit/{id}")
		public String editLanguage (
				@PathVariable("id") Long id, Model model) {
			Language languageToBeEdited = languageServ.findOne(id);
			model.addAttribute("language", languageToBeEdited);
			return "edit.jsp";
		}

	@PutMapping("/edit/process/{id}")
	public String processEditLanguage(
			@Valid 
			@ModelAttribute("language")
			Language language, 
			BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		languageServ.update(language);
		return "redirect:/languages/all";
	
}
	@DeleteMapping("/{id}")
	public String processDelete(@PathVariable("id") Long id) {
		languageServ.deleteByID(id);
		return "redirect:/languages/all";
	}
}


