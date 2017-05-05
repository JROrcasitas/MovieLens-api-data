package teamtwo.movielens.quick.api.rating;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import teamtwo.movielens.quick.api.movies.Movie;

//Model class
//this needs to be saved to the JPA
//JPA will use this model
@Entity
public class Rating {
	
	@Id
	private String id;
	private String name;
	private String description;
	
	@ManyToOne
	private Movie movie;
	
	public Rating(String id, String name, String description, String RatingId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.movie = new Movie(RatingId, "", "");
	}
	
	public Rating() {
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
}
