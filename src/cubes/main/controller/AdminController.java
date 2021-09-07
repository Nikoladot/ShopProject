package cubes.main.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cubes.main.dao.StaticPageDAO;
import cubes.main.dao.CategoryDAO;
import cubes.main.dao.LocationDAO;
import cubes.main.dao.MessageDAO;
import cubes.main.dao.ProductDAO;
import cubes.main.dao.SliderDAO;
import cubes.main.dao.StickerDAO;
import cubes.main.dao.UserDAO;
import cubes.main.entity.StaticPage;
import cubes.main.entity.Category;
import cubes.main.entity.ChangePassword;
import cubes.main.entity.Location;
import cubes.main.entity.Message;
import cubes.main.entity.Product;
import cubes.main.entity.Slider;
import cubes.main.entity.Sticker;
import cubes.main.entity.User;
import cubes.main.service.CategoryService;
import cubes.main.service.StickerService;

@Controller
@RequestMapping(value="/admin/")
public class AdminController {
	
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private StickerService stickerService;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private MessageDAO messageDAO;
	@Autowired
	private StaticPageDAO staticPageDAO;
	@Autowired
	private SliderDAO sliderDAO;
	@Autowired
	private LocationDAO locationDAO;
	@Autowired
	private UserDAO userDAO;
	
	//------------------------------------------------Dashboard--------------------------------------------------------//
	
	@RequestMapping(value = "")
	public String getDashBoardPage(Model model) {
		
		long unreadMessagesCount = messageDAO.getUnreadMessagesCount();
		
		model.addAttribute("unreadMessagesCount", unreadMessagesCount);
		
		return "dashboard";
	}
	

	
	//------------------------------------------------Category-----------------------------------------------------//

	@RequestMapping(value = "category-list")
	public String getCategoryList(Model model) {
		
		List<Category> list = categoryService.getCategoryList();
		model.addAttribute("categories", list);
		
		System.out.println(list.toString());
		
		return "category-list";
	}
	
	@RequestMapping(value = "category-form")
	public String getCategoryForm(Model model) {
		
		model.addAttribute("category", new Category());
		
		return "category-form";
	}
	
	@RequestMapping(value = "category-save")
	public String getCategorySave(@ModelAttribute Category category) {
		
		 categoryService.saveCategory(category);
		
		return "redirect: category-list";
		
	}
	
	@RequestMapping(value = "category-update")
	public String getCategoryUpdate(@RequestParam int id, Model model) {
		
		Category category = categoryService.getCategoryById(id);
		model.addAttribute("category", category);
		
		
		return "category-form";
	}
	
	@RequestMapping(value = "category-delete")
	public String getCategoryDelete(@RequestParam int id) {

		 categoryService.deleteCategory(id);
			
			return "redirect: category-list";
		
	}
	
	//-------------------------------------------Sticker---------------------------------------------------//
	
	
	@RequestMapping(value = "sticker-list")
	public String getStickerList(Model model) {
		
		List<Sticker> list = stickerService.getStickerList();
		model.addAttribute("stickers", list);
		
		System.out.println(list.toString());
		
		return "sticker-list";
	}
	
	@RequestMapping(value = "sticker-form")
	public String getStickerForm(Model model) {
		
		model.addAttribute("sticker", new Sticker());
		
		return "sticker-form";
	}
	
	@RequestMapping(value = "sticker-save")
	public String getStickerSave(@ModelAttribute Sticker sticker) {
		
		stickerService.saveSticker(sticker);
		
		return "redirect: sticker-list";
		
	}
	
	@RequestMapping(value = "sticker-update")
	public String getStickerUpdate(@RequestParam int id, Model model) {
		
		Sticker sticker = stickerService.getStickerById(id);
		model.addAttribute("sticker", sticker);
		
		
		return "sticker-form";
	}
	
	@RequestMapping(value = "sticker-delete")
	public String DeleteSticker(@RequestParam int id) {

		stickerService.getStickerDelete(id);
			
			return "redirect: sticker-list";
		
	}
	
	//---------------------------------------------PRODUCTS---------------------------------------------//
	
	
	@RequestMapping(value = "product-list")
	public String getProductList(Model model) {
		
		List<Product> list = productDAO.getProductList();
		model.addAttribute("products", list);
		
		System.out.println(list.toString());
		
		return "product-list";
	}
	
	@RequestMapping(value = "product-form")
	public String getProductForm(Model model) {
		
		List<Category> categories = categoryService.getCategoryList();
		List<Sticker> stickers = stickerService.getStickerList();
		
		model.addAttribute("product", new Product());
		model.addAttribute("categories", categories);
		model.addAttribute("stickers", stickers);
		
		
		return "product-form";
		
	}
	
	
	@RequestMapping(value = "product-save")
	public String getProductSave(@ModelAttribute Product product) {
		
		Category category = categoryService.getCategoryById(product.getCategory().getId());
		List<Sticker> stickers = new ArrayList<Sticker>();
		for(Sticker sticker : product.getStickers()) {
			
			Sticker tempSticker = stickerService.getStickerById(sticker.getId());
			
			stickers.add(tempSticker);
						
		}	

		
		
		product.setCategory(category);
		product.setStickers(stickers);
		productDAO.saveProduct(product);
		
		
		return "redirect: product-list";
		
	}
	
	@RequestMapping(value = "product-update")
	public String getProductUpdate(@RequestParam int id, Model model) {
		
		Product product = productDAO.getProductById(id);
		
		List<Category> categories = categoryService.getCategoryList();
		List<Sticker> stickers =stickerService.getStickerList();

		
		model.addAttribute("product", product);
		model.addAttribute("categories", categories);
		model.addAttribute("stickers", stickers);

		
		return "product-form";
	}
	
	@RequestMapping(value = "product-delete")
	public String getProductDelete(@RequestParam int id) {

		productDAO.deleteProduct(id);
			
			return "redirect: product-list";
		
	}
	
	@RequestMapping(value = "product-detail")
	public String getProductDetail(@RequestParam int id, Model model) {
		
		Product product = productDAO.getProductById(id);
		
		model.addAttribute("product", product);
		
		
		return "product-detail";
	}
	
	//---------------------------------------------------Message-------------------------------------------------------------------
	
	@RequestMapping(value = "message-list")
	public String getMessageList(Model model) {
		
		List<Message> list = messageDAO.getAllMessages();
		model.addAttribute("messages", list);
		
		return "message-list";
		
	}
		
	@RequestMapping(value = "message-seen")
	public String getMessageSeenPage(@RequestParam int id) {
		
		Message message = messageDAO.getMessageById(id);
				
		message.setIsSeen(true);	
		
		messageDAO.saveMessage(message);
		
		return "redirect: message-list";
	}
	
	//----------------------------------------------Static pages---------------------------------------------------------------//

	
	@RequestMapping(value = "static-page-form")
	public String getAboutUsPage(@RequestParam String page, Model model) {
		
		if(page.equalsIgnoreCase("about")) {
			model.addAttribute("staticPage", staticPageDAO.getStaticPage(1));
		}
		
		else if(page.equalsIgnoreCase("location")) {
			model.addAttribute("staticPage", staticPageDAO.getStaticPage(2));
		}
		
		return "static-page-form";
			
	}
	
	@RequestMapping(value = "static-page-save")
	public String getStaticPageSave(@ModelAttribute StaticPage staticPage) {
	
		staticPageDAO.saveStaticPage(staticPage);
		
		return "static-page-form";
		
	}
	
	//-------------------------------------------------Slider-----------------------------------------------------------------------//
	
	@RequestMapping(value = "slider-list")
	public String getSliderList(Model model) {
		
		model.addAttribute("sliders", sliderDAO.getSliderList());
		
		
		
		
		return "slider-list";
	}
	
	@RequestMapping(value = "slider-form")
	public String getSliderForm(Model model) {
		
		model.addAttribute("slider", new Slider());
		
		
		return "slider-form";
	}
	
	@RequestMapping(value = "slider-update")
	public String getSliderUpdate(@RequestParam int id, Model model) {
		
		Slider s = sliderDAO.getSliderById(id);
		
		model.addAttribute("slider", s);
		
		return "slider-form";
		
	}
	
	@RequestMapping(value = "slider-save")
	public String getSliderSave(@ModelAttribute Slider slider) {
		
		sliderDAO.saveSlider(slider);
		
		return "redirect: slider-list";
	}

	
	@RequestMapping(value = "slider-delete")
	public String getDeleteSlider(@RequestParam int id) {
		
		sliderDAO.getSliderDelete(id);
		
		return "redirect: slider-list";
		
	}
	
	
	
	//----------------------------------------------Location form--------------------------------------------------------==
	
	@RequestMapping(value = "location-list")
	public String getLocationList(Model model) {
		
		List<Location> list = locationDAO.getLocationList();
		model.addAttribute("locations", list);
				
		return "location-list";
	}
	
	@RequestMapping(value = "location-form")
	public String getLocationForm(Model model) {
		
		model.addAttribute("location", new Location());
		
		return "location-form";
	}
	
	@RequestMapping(value = "location-save")
	public String getLocationSave(@ModelAttribute Location location) {
		
		 locationDAO.saveLocation(location);
		
		return "redirect: location-list";
		
	}
	
	@RequestMapping(value = "location-update")
	public String getLocationUpdate(@RequestParam int id, Model model) {
		
		Location location = locationDAO.getLocationById(id);
		model.addAttribute("location", location);
		
		
		return "location-form";
	}
	
	@RequestMapping(value = "location-delete")
	public String getLocationDelete(@RequestParam int id) {

		 locationDAO.deleteLocation(id);
			
			return "redirect: locaton-list";
		
	}

	
//------------------------------------------ User pages --------------------------------
	
	@RequestMapping(value = "user-list")
	public String getUserListPage(Model model) {
		
		
		model.addAttribute("users", userDAO.getAllUsers());
		
		
		return "user-list";
	}
	
	
	@RequestMapping(value = "user-enabled")
	public String getUserEnabled(@RequestParam String username) {
		
		User user = userDAO.getUser(username);
		
		user.setEnabled(!user.getEnabled());
		userDAO.saveUser(user);
		
		
		
		return "redirect: user-list";
		
	}
	
	@RequestMapping(value = "user-delete")
	public String getUserDelete(@RequestParam String username) {
		
		userDAO.deleteUser(username);
		
		return "redirect: user-list";
		
	}
	
	@RequestMapping(value = "user-form")
	public String getUserForm(Model model) {
		
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("userRoles", userDAO.getUserRoles());
		
		return "user-form";
	}
	
	@RequestMapping(value = "user-save")
	public String getUserSave(@ModelAttribute User user) {
		
		
		user.setEnabled(true);
		user.generateBCryptPassword();
		
		userDAO.saveUser(user);
		
		return "redirect: user-list";
		
	}
	
	@RequestMapping(value = "user-update")
	public String getUserUpdate(@RequestParam String username, Model model) {
		
		model.addAttribute("user", userDAO.getUser(username));
		model.addAttribute("userRoles", userDAO.getUserRoles());
		model.addAttribute("isAdmin", true);
		
		return "user-form-update";
	}
	
	@RequestMapping(value = "user-myupdate")
	public String getMyUserUpdate(Principal principal, Model model) {
		
		model.addAttribute("user", userDAO.getUser(principal.getName()));
		
		return "user-form-update";
		
	}
	@RequestMapping(value = "user-change-password")
	public String getChangePasswordPage(Principal principal, Model model) {
		
		model.addAttribute("changePassword", new ChangePassword());
		
		return "user-form-change-password";
	}
	
	@RequestMapping(value = "user-save-change-password")
	public String getChangePassworndSave(@ModelAttribute ChangePassword changePassword, Principal principal, Model model) {
		
		User user = userDAO.getUser(principal.getName());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		if(!changePassword.getNewPassword().equalsIgnoreCase(changePassword.getConfirmPassword())) {
			//ako password nije isti
			model.addAttribute("message", "Nova lozinka i potvrda nove lozinke se ne poklapaju.");
			model.addAttribute("changePassword", changePassword);
			
			
			
		}
		else if(!encoder.matches(changePassword.getOldPassword(), user.getEncodedPassword())) {
			//ako stari password ne odgovara korisniku
			model.addAttribute("message", "Stara lozinka nije odgovarajuca");
			model.addAttribute("changePassword", changePassword);
			
			;
		}
		else {
			user.setPassword(changePassword.getNewPassword());
			user.generateBCryptPassword();
			userDAO.saveUser(user);
			
			model.addAttribute("message", "Uspesno ste promenili lozinku");
			model.addAttribute("changePassword", new ChangePassword());
		}
		
		
		return "user-form-change-password";
	}
	
	
}
