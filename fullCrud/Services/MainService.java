@Service
public class BookService {
	

	private final BookRepository bookRepo;
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	public Book getOne(Long id) {
		Optional<Book> book = bookRepo.findById(id);
		return book.isPresent() ? book.get() : null;
	}

	public List<Book> getAll() {
		return (List<Book>) bookRepo.findAll();
	}

	public Book create(Book book) {
		return bookRepo.save(book);
	}

	public Book update(Book book) {
		return bookRepo.save(book);
	}

	public void delete(Long id) {
		bookRepo.deleteById(id);
	}

	
}
Footer
© 2022 GitHub, Inc.
Footer navigation

    Terms
    Privacy
    Security
    Status
    Docs
    Contact GitHub
    Pricing
    API
    Training
    Blog
    About

