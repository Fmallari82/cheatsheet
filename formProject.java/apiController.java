
@RestController
@RequestMapping("/api")
public class LanguageApi {

	private final LanguageService languageServ;

	public LanguageApi(LanguageService languageServ) {
		this.languageServ = languageServ;
	}

	// Create
	@PostMapping("/languages")
	public Language createDonation(
			@RequestParam("name") String name, 
			@RequestParam("creator") String creator,
			@RequestParam("version") Double version){ 
		Language newLanguage = new Language(
				name, 
				creator, 
				version);
		return languageServ.create(newLanguage);
	}

	// Read All
	@GetMapping("/languages")
	public List<Language> findAllLanguage() {
		return languageServ.getAll();
	}

	// Read one
	@GetMapping("/languages/{id}")
	public Language findOneLanguage(@PathVariable("id") Long id) {
		return languageServ.findOne(id);
	}

	//Update one
	@PutMapping("/languages/{id}")
	public Language findOneAndUpdate(
        @PathVariable("id") Long id, 
        @RequestParam("name") String name,
        @RequestParam("creator") String creator, 
        @RequestParam("version") Double version,
        @RequestParam("description") String description) {
		return languageServ.update(
				id, 
				name, 
				creator, 
				version, 
				description);
	}

	//Delete 
	@DeleteMapping("/languages/{id}")
	public void destroy(@PathVariable("id") Long id) {
		languageServ.deleteByID(id);
	}
}