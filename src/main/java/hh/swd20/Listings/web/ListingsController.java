package hh.swd20.Listings.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.swd20.Listings.domain.ItemRepository;

@Controller
public class ListingsController {
	
	@Autowired
	ItemRepository itemRepository;

	@GetMapping("/Listings")
	public String Listings(Model model) {
		model.addAttribute("items", itemRepository.findAll());
		return "Listings";
	}
	
}
