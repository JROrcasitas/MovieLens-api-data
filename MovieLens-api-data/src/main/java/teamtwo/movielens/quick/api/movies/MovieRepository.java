package teamtwo.movielens.quick.api.movies;

import org.springframework.data.repository.CrudRepository;

//Make CRUD operations
public interface MovieRepository extends CrudRepository<Movie, Integer>{
	
	
}
