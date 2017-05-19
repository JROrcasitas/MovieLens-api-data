package teamtwo.movielens.quick.api.movies;


import java.util.HashSet;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import teamtwo.movielens.quick.api.genres.Genre;

/**
 * @author jo32
 *Model Class that will be used in JPA
 */
@Entity
@Table(name = "movies", schema = "moviedb")
public class Movie {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="title")
	private String title;
	@Column(name="release_date")
	private String release_date;
	private HashSet<Genre> genres;
	public Movie(String title, 
			String release, 
			HashSet<Genre> genres) {
		this.title = title;
		this.release_date = release;
		this.genres = genres;
	}
	
	public Movie() {

	}
	
	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	@ManyToMany(fetch = FetchType.LAZY,targetEntity=Genre.class, cascade = CascadeType.ALL)
    @JoinTable(name = "genres_movies", schema = "moviedb")
    //joinColumns = @JoinColumn(name = "movie_id", referencedColumnName="id"),
    //inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName="id"))
	public HashSet<Genre> getGenres() {
		return genres;
	}

	public void setGenres(HashSet<Genre> genres) {
		this.genres = genres;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
}
