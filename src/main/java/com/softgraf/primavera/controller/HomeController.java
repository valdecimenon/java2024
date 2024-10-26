package com.softgraf.primavera.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.softgraf.primavera.entity.Produto;
import com.softgraf.primavera.repository.ProdutoRepository;

@Controller
public class HomeController {
	
	@Autowired
	private ProdutoRepository repository;
	private final int PAGESIZE = 4; 
	
	private static List<Produto> listarProdutos(){
		Produto p1 = new Produto(1L, "iphone 15 pro 256GB", 10099.0f, 2);
		Produto p2 = new Produto(2L, "SAMSUNG GALAXY S23 ULTRA 1TB", 8600.0f, 3);
		Produto p3 = new Produto(3L, "motorla edge 30 fusion 256GB", 2999.0f, 5);
		return List.of(p1, p2, p3, p1, p2, p3);
	}
	
	
	@GetMapping("model")
	public String homeModel(Model model) {
		List<Produto> lista = listarProdutos();
		model.addAttribute("produtos", lista);
		// redireciona para a view: "templates/home.html"
		return "home";
	}
	
	// ModelMap é uma classe que implementa LinkedHashMap
	@GetMapping("modelmap")
	public String homeModelMap(ModelMap map) {
		List<Produto> lista = listarProdutos();
		map.put("produtos", lista);
		return "home";
	}
	
	@GetMapping("modelandview")
	public ModelAndView homeModelAndView() {
		List<Produto> lista = listarProdutos();
		ModelAndView mview = new ModelAndView("home");
		mview.addObject("produtos", lista);
		return mview;
	}
	
	@GetMapping("homepage")
	public ModelAndView homePage(ModelAndView mview, @SortDefault(sort="id", direction = Sort.Direction.ASC)  @PageableDefault(page=0, size=PAGESIZE) Pageable pageable) {
		mview.setViewName("home");
		Page<Produto> pagina = repository.findAll(pageable);
		
		mview.addObject("produtos", pagina);
		mview.addObject("pageSize", PAGESIZE);
		mview.addObject("hasNext", pagina.hasNext());
		mview.addObject("hasPrevious", pagina.hasPrevious());
		
		mview.addObject("nextPage", pagina.nextOrLastPageable().getPageNumber());
		mview.addObject("previousPage", pageable.previousOrFirst().getPageNumber());
		mview.addObject("lastPage", pagina.getTotalPages() - 1);
		
		return mview;
	}
	
	// Atalho para homepage
	@GetMapping("/")
	public String index() {
		return "redirect:/homepage";
	}
	
	@GetMapping("sobre")
	public String sobre() {
		return "sobre";
	}
	
}
