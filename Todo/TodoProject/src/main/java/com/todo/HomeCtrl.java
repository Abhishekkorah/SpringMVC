package com.todo;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.TodoDao;
import com.entities.Todo;

@Controller
public class HomeCtrl {

	@Autowired
	ServletContext context;
	
	@Autowired
	TodoDao todoDao;
	
	@RequestMapping("/home")
	public String home(Model model) {
		String name="home";
		model.addAttribute("page", name);
		
		List<Todo> list = this.todoDao.getAll();
		
		model.addAttribute("todos", list);
		
		return "home";
	}
	
	@RequestMapping("/add")
	public String add(Model model) {
		String name="add";

		Todo todo = new Todo();
		
		model.addAttribute("page", name);
		model.addAttribute("todo", todo);

		return "home";
	}
	
	@RequestMapping(value="/saveTodo", method=RequestMethod.POST)
	public String saveTodo(@ModelAttribute("todo") Todo todo, Model model) {
		System.out.println(todo);
		todo.setTodoDate(new Date());
		
		this.todoDao.save(todo);
		
		model.addAttribute("message", "Successfully Added!!!");
		return "home";
	}
	
}
