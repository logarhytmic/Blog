package blog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import blog.domain.Recipe;

@Repository
public interface RecipeRepo extends JpaRepository<Recipe, Integer>  {

	
	
	
}
