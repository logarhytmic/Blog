package blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import blog.domain.Recipe;
import blog.service.RecipeService;

@Controller
public class RecipeController {

	@Autowired
	private RecipeService service;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		List<Recipe> listrecipe = service.listAll();
		/* List<Recipe> rlist2 = recipeService.getAllRecipes(); */
		model.addAttribute("listrecipe", listrecipe);
		System.out.print("Get / ");
		return "index";
	}

	@GetMapping("/new")
	public String add(Model model) {
		model.addAttribute("recipe", new Recipe());
		return "new";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveRecipe(@ModelAttribute Recipe std) {
		System.out.println(std);
		service.save(std);
		return "redirect:/";
	}

	@RequestMapping("edit/{id}")
	public ModelAndView showEditRecipePage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("new");
		Recipe std = service.get(id);
		mav.addObject("recipe", std);
		return mav;
	}

	@RequestMapping("/delete/{id}")
	public String deleterecipe(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";
	}
}
