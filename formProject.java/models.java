

@Entity
@Table(name="language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 3, max = 200, message=" name needs to be at least 3 characters long")
    private String name;
    
    @NotNull
    @Size(min = 3, max = 200, message="creator needs to be at least 3 characters long")
    private String creator;
    
    @NotNull
    @Size(min = 3, max = 200, message="Version needs to be at least 3 characters long")
    private String version;
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    

	public Language() {}



	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

}
