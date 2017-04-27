package com.in28minutes.todo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class TodoController {
 
	@Autowired
	TodoService service;

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String listTodos(ModelMap model)
	{
		model.addAttribute("todos", service.retrieveTodos("In28Minutes"));
		return "list-todos";
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showTodo(ModelMap model)
	{
		model.addAttribute("todo", new Todo(0, "in28Minutes","Default Description", new Date(), false));
		return "todo";
	}	
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result)
	{
		if (result.hasErrors()){

			return "todo";
		}
		service.addTodo("In28Minutes", todo.getDesc(), new Date(), false);
		model.clear();
		return "redirect:list-todos";
	}	
	
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(ModelMap model, @RequestParam int id)
	{
		service.deleteTodo(id);
		return "redirect:list-todos";
	}
	
}
