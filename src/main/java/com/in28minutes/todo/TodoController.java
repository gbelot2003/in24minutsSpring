package com.in28minutes.todo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;		

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
	public String showTodo()
	{
		return "todo";
	}	
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(@RequestParam String desc, ModelMap model)
	{
		service.addTodo("In28Minutes", desc, new Date(), false);
		model.clear();
		return "redirect:list-todos";
	}	
	
}
