package teamtwo.movielens.quick.api.rating;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import teamtwo.movielens.quick.api.movies.Movie;

//Model class
//this needs to be saved to the JPA
//JPA will use this model
@Entity
@Table(name = "ratings")
public class Rating {
	
	@Id
	@Column(name="id")
	private int id;
	@Column(name="user_id")
	private int userId;
	@Column(name="movie_id")
	private int movieId;
	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Column(name="rating")
	private int rating;
	@Column(name="rated_at")
	private String timestamp;
	
	public Rating(int id,
			int userId,
			int movieId, 
			int rating, 
			String timestamp) {
		super();
		this.id = id;
		this.userId = userId;
		this.movieId = movieId;
		this.rating = rating;
		this.timestamp = timestamp;
	}
	
	public Rating() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getTimestmp() {
		return timestamp;
	}

	public void setTimestmp(String timestmp) {
		this.timestamp = timestmp;
	}

	
	
}
