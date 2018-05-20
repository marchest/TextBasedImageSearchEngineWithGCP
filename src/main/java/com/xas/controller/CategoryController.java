package com.xas.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;







import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;









import com.xas.common.model.Category;
import com.xas.common.model.UserProfile;
import com.xas.common.service.ApplicationConfiguration;
import com.xas.common.service.CategoryService;
import com.xas.common.service.LoadUserProfile;
import com.xas.exception.CategoryNotFoundException;

@Controller
@RequestMapping(value="/category")
public class CategoryController extends AbstractController{
	private static final Logger logger = Logger.getLogger(CategoryController.class);
	@Autowired 
	private HttpServletRequest httpSession;
		
	
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private LoadUserProfile loadUserProfile;
	
	@Autowired 
	ApplicationConfiguration appConfig;
	
	@RequestMapping(value="/addImage2",method = RequestMethod.GET)
	public void getPopUp() {
		System.out.println("Category Controller addImage");
		checkSession();
	}
	
	@RequestMapping(value="/userCategories",method=RequestMethod.GET)
	public @ResponseBody List<Category> retrieveUserCategories(){
		return null;
	}
	@RequestMapping(value="/{categoryId}",method=RequestMethod.GET)
	public String showDetails(@PathVariable String categoryId,ModelMap model) throws CategoryNotFoundException {
		boolean flag=false;
		try {
			 flag=false;
			for (Category temp : loadUserProfile.loadUserProfile().getUserCategories()) {
				if (temp.getCategoryId()==Integer.parseInt(categoryId)) {
					model.addAttribute("categoryDetail", temp);
					flag=true;
				}		
			}
			if (!flag) {
				throw new CategoryNotFoundException(Integer.parseInt(categoryId));
			}
		} catch (Exception e) {
			throw new CategoryNotFoundException(Integer.parseInt(categoryId));
		}
	
	
		return "/category/categoryDetails";
	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateCategory(@RequestBody String s,ModelMap model) {
		/*ObjectMapper mapper=new ObjectMapper();
		Category c = null;
		try {
			 c=mapper.readValue(s, Category.class);
			categoryService.updateCategory(c);
			System.out.println(c.getCategoryName());
		} catch (JsonParseException e) {
		
			e.printStackTrace();
		} catch (JsonMappingException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
				
		}
		model.addAttribute("categoryDetail", c);*/
		return "redirect:/";
	}
	@Override
	public String checkSession() {
		UserProfile upf=(UserProfile) httpSession.getSession().getAttribute(appConfig.returnUserProfileFromSession());
		if (upf.getUser()==null) {
			return "redirect:/account/signup#tologin";
		}
		return httpSession.getRequestURI().toString();
	}

	
	

	

}
