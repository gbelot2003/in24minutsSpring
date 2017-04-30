package com.in28minutes.todo;

import com.in28minutes.exceptions.ExceptionController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class TodoController {
 
	@Autowired
	TodoService service;

	private Log logger = LogFactory.getLog(ExceptionController.class);
    private String retriveLoggedinUserName() {
        return "gbelot";
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
    }

    private String getLoggedInUserName(ModelMap model) {
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        if (principal instanceof UserDetails)
            return ((UserDetails) principal).getUsername();

        return principal.toString();
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }


	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String listTodos(ModelMap model)
	{
		model.addAttribute("todos", service.retrieveTodos(retriveLoggedinUserName()));
		return "list-todos";
	}



    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showTodo(ModelMap model)
	{
		model.addAttribute("todo", new Todo(0, retriveLoggedinUserName(),"Default Description", new Date(), false));
		return "todo";
	}	
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result)
	{
		if (result.hasErrors()){
			return "todo";
		}
		service.addTodo(retriveLoggedinUserName(), todo.getDesc(), new Date(), false);
		model.clear();
		return "redirect:list-todos";
	}	
	
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(ModelMap model, @RequestParam int id)
	{
		service.deleteTodo(id);
		return "redirect:list-todos";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String updateTodo(ModelMap model, @RequestParam int id)
	{
		throw new RuntimeException("Dummy Exception");
		/**Todo todo = service.retrieveTodo(id);
		model.addAttribute("todo", todo);
		return "todo";**/
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result)
	{
		if (result.hasErrors()){
			return "todo";
		}

		todo.setUser("gbelot");
		service.updateTodo(todo);
		model.clear();
		return "redirect:list-todos";
	}

	@ExceptionHandler(value = Exception.class)
	public String handleError(HttpServletRequest req, Exception exception) {
		logger.error("Request: " + req.getRequestURL() + " raised " + exception);
		return "error-todos";
	}
}
