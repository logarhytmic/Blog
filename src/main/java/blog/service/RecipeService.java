package blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.domain.Recipe;
import blog.repo.RecipeRepo;


@Service
public class RecipeService {

	@Autowired
	private RecipeRepo repo;
	
	public List<Recipe> listAll() {
		return repo.findAll();
	}
	public void save(Recipe std ) {
		repo.save(std);
	}
	
	public Recipe get(int id) {
		return repo.findById(id).get();
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}

	
	
	
}
