import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
	@Autowired
	CategoryService categoryService;
 
	@RequestMapping(value = "/getAllProducts", method = RequestMethod.GET, headers = "Accept=application/json")
	public List  getProductList() {
		System.out.println("in controller");
		List listOfProducts = sellerService.getAllProducts();
		return listOfProducts;
		
		}
	
	@RequestMapping(value = "/getProduct/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Product getProductById(@PathVariable int id) {
		return sellerService.getProduct(id);
	}
 
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addCountry(@RequestBody Product product) { 
		sellerService.addProduct(product);
 
	}
 
	@RequestMapping(value = "/updateProduct", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateCountry(@RequestBody Product product) {
		sellerService.updateProduct(product);
	}
 
	@RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteCountry(@PathVariable("id") int id) {
		sellerService.deleteProduct(id);  
	} 
}