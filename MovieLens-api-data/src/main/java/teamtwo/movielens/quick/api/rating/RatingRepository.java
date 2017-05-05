package teamtwo.movielens.quick.api.rating;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//Make CRUD operations
public interface RatingRepository extends CrudRepository<Rating, String>{
	
	public List<Rating> findByName(String name);
	public List<Rating> findByDescription(String desc);

}
