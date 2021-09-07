package cubes.main.controller;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cubes.main.dao.ProductDAO;
import cubes.main.entity.Category;
import cubes.main.entity.Product;
import cubes.main.entity.Sticker;
import cubes.main.rest.CategoryException;
import cubes.main.rest.MessageResponse;
import cubes.main.rest.StickerException;
import cubes.main.rest.request_body.ProductFilter;
import cubes.main.rest.response.BasicProductResponse;
import cubes.main.rest.response.SettingsResponse;
import cubes.main.service.CategoryService;
import cubes.main.service.StickerService;

@RestController
@RequestMapping(value = "/api")
public class MyRestController {

	@Autowired
	CategoryService categoryService;
	@Autowired
	StickerService stickerService;
	@Autowired
	ProductDAO productDAO;
	
	
	
	
	//-----------------------------------------------------Category-----------------------------------------------------
	
	@GetMapping(value = "/categories")
	public List<Category> getCategories() {
		
		List<Category> list = categoryService.getCategoryList();
		
		return list;
		
	}
	
	@GetMapping(value = "/categories/{id}")
	public Category getCategoryById(@PathVariable int id) {

		Category cat = categoryService.getCategoryById(id);
		
		if(cat == null) {
			
			throw new RuntimeException("Kategorija sa ID "+id+" ne postoji u bazi podataka.");
		}
		
		return cat;
		
	}
	
	@PostMapping(value = "/categories")
	public MessageResponse createCategory(@RequestBody Category category) {
		
		category.setId(0);
		categoryService.saveCategory(category);
		
		return new MessageResponse(HttpStatus.OK.value(), "Uspesno je sacuvana kategorija: "+category, System.currentTimeMillis());
	}
	
	@PutMapping(value = "/categories")
	public MessageResponse updateCategory(@RequestBody Category category) {

		categoryService.saveCategory(category);
		
		return new MessageResponse(HttpStatus.OK.value(), "Uspesno je izmenjena kategorija: "+category, System.currentTimeMillis());
	}
	
	@DeleteMapping(value = "/categories/{id}")
	public MessageResponse deleteCategory(@PathVariable int id) {
		
		Category category = categoryService.getCategoryById(id);
		
		categoryService.deleteCategory(id);
		
		return new MessageResponse(HttpStatus.OK.value(), "Uspesno je izbrisana kategorija: "+category, System.currentTimeMillis());
	}
	
	//---------------------------------------------------Stickers--------------------------------------------------------------------------
	
	@GetMapping(value = "/stickers")
	public List<Sticker> getStickers() {
		
		List<Sticker> list = stickerService.getStickerList();
		
		return list;
		
	}
	
	@GetMapping(value = "/stickers/{id}")
	public Sticker getStickerById(@PathVariable int id) {

		Sticker sticker = stickerService.getStickerById(id);
		
		if(sticker == null) {
			
			throw new StickerException("Sticker sa ID "+id+" ne postoji u bazi podataka.");
		}
		
		return sticker;
		
	}
	
	@PostMapping(value = "/stickers")
	public MessageResponse createSticker(@RequestBody Sticker sticker) {
		
		sticker.setId(0);
		stickerService.saveSticker(sticker);
		
		return new MessageResponse(HttpStatus.OK.value(), "Uspesno je sacuvan stiker: "+sticker, System.currentTimeMillis());
	}
	
	@PutMapping(value = "/stickers")
	public MessageResponse updateCategory(@RequestBody Sticker sticker) {

		stickerService.saveSticker(sticker);
		
		return new MessageResponse(HttpStatus.OK.value(), "Uspesno ste izmenili stiker: "+sticker, System.currentTimeMillis());
	}
	
	@DeleteMapping(value = "/stickers/{id}")
	public MessageResponse deleteSticker(@PathVariable int id) {
		
		Sticker sticker = stickerService.getStickerById(id);
		
		stickerService.getStickerDelete(id);
		
		return new MessageResponse(HttpStatus.OK.value(), "Uspesno ste izbrisali sticker: "+sticker, System.currentTimeMillis());
	}
	
	
	//----------------------------------------------------Settings----------------------------------------------------------
	
	
	@GetMapping(value = "/settings")
	public SettingsResponse getSettings() {
		
		SettingsResponse settings = new SettingsResponse();
		
		settings.setCategories(categoryService.getCategoryList());
		settings.setStickers(stickerService.getStickerList());
		
		return settings;
			
	}
	
	//------------------------------------------------Products---------------------------------------------------------------------
	
	
	@GetMapping(value = "/products")
	public List<Product> getProducts() {
		
		List<Product> products = productDAO.getProductListWithStickers();
		
		return products;
	}
	
	@GetMapping(value = "/basicproducts")
	public List<BasicProductResponse> getBasicProducts() {
		
		List<BasicProductResponse> basicProducts = new ArrayList<BasicProductResponse>();
		List<Product> products = productDAO.getProductListWithStickers();
		
		for(Product p: products) {
			
			basicProducts.add(new BasicProductResponse(p));	
			
		}
		
		return basicProducts;
	}
	
	@PostMapping(value = "/products")
	public MessageResponse saveProduct(@RequestBody Product product) {
		
		product.setId(0);
		productDAO.saveProduct(product);
		
		
		return new MessageResponse(HttpStatus.OK.value(), "Uspesno ste sacuvali proizvod: " + product, System.currentTimeMillis());
		
	}
	
	@PutMapping(value = "/products")
	public MessageResponse updateProduct(@RequestBody Product product) {
		
		productDAO.saveProduct(product);
		
		return new MessageResponse(HttpStatus.OK.value(), "Uspesno ste izmenili proizvod: " + product, System.currentTimeMillis());
		
	}
	
	@DeleteMapping(value = "/products/{id}")
	public MessageResponse deleteProduct(@PathVariable int id) {
		
		Product p = productDAO.getProductById(id);
		
		productDAO.deleteProduct(id);
		
		return new MessageResponse(HttpStatus.OK.value(), "Uspesno ste obrisali proizvod: " + p, System.currentTimeMillis());
		
	}
	
	@GetMapping(value = "/filter-products")
	public List<Product> getProductListFilter(@RequestBody ProductFilter filter) {
		
		List<Product> list = productDAO.getProductList(filter.getCategory(), filter.getPrice(), filter.getStickers());
		
		return list;

	}
}
