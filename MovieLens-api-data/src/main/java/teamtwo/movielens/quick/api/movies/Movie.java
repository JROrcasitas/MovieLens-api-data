package teamtwo.movielens.quick.api.movies;

import java.util.ArrayList;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
@Table(name = "movies")
public class Movie {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private String release_date;
	
	
	private Set<Genre> genres;
	
	public Movie(String title, 
			String release, 
			Set<Genre> genres) {
		this.title = title;
		this.release_date = release;
		this.genres = genres;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "genres_movies", 
    joinColumns = @JoinColumn(name = "movie_id", 
    referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "genre_id", 
    referencedColumnName = "id"))
	public Set<Genre> getGenres() {
		return genres;
	}

	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}
	
	public Movie() {

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

	public String getRelease() {
		return release_date;
	}

	public void setRelease(String release) {
		this.release_date = release;
	}

	
}
