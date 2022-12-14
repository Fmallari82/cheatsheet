Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	List<Book> findAll();
}