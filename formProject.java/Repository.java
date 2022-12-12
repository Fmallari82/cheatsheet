

@Repository
public interface NameRepository extends CrudRepository<Language, Long> {
    // this method retrieves all the books from the database
    List<Language> findAll();
    // this method finds books with descriptions containing the search string
    List<Language> findByNameContaining(String search);
    // this method counts how many titles contain a certain string
    // Long countByRestaurantNameContaining(String search);
    // this method deletes a book that starts with a specific title
//     Long deleteByNameNameStartingWith(String search);
// }
