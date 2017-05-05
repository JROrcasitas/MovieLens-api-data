package teamtwo.movielens.quick.api.rating;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Derby database is in the class path so not necessary to connect
//Business Service (Typically Singletons) indicated by @Service
@Service
public class RatingService {
	
	@Autowired
	private RatingRepository mrepo;
	//create mutable list
	//use JPA to connect to database
	
	public List<Rating> GetAllRatings(String id){
		//return topics;
		List<Rating> topics = new ArrayList<>();
		mrepo.findAll().forEach(topics::add);
		return topics;
	}
	
	public Rating GetRating(String id){
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return mrepo.findOne(id);
	}
	
	public void addRating(Rating rating){
		//topics.add(topic);
		mrepo.save(rating);
	}
	
	public void updateRating(Rating rating){
		/*for(int i=0;i<topics.size(); i++){
			Topic t = topics.get(i);
			if(t.getId().equals(id)){
				topics.set(i, topic);
				return;
			}
		}*/
		mrepo.save(rating);
	}
	
	public void deleteRating(String id){
		//topics.removeIf(t -> t.getId().equals(id));
		mrepo.delete(id);
	}
}
