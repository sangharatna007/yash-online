
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.yash.model.Category;
import com.yash.service.CategoryServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class AdminControllerTest {
	private static final Logger log = Logger.getLogger(AdminControllerTest.class);
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	@Mock
	public CategoryServiceImpl categoriesServiceImpl;
	@InjectMocks
	private AdminController adminController;
	MockMvc mockmvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockmvc = MockMvcBuilders.standaloneSetup(adminController).build();
	}
	
	@Test
	public void testGetAllCategory() throws Exception{
		List<Category> categoryList=new ArrayList<Category>();
		Category category=new Category(1, "Electronics");
		categoryList.add(category);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter(); 
		String toBeCompareJson = ow.writeValueAsString(categoryList).replace(" ", "").replace("\n", "").replace("\r", ""); 
		Mockito.when(categoriesServiceImpl.getAllCategories()).thenReturn(categoryList); 
		RequestBuilder requestBuilder = MockMvcRequestBuilders
											.get("/cate")
											.contentType(APPLICATION_JSON_UTF8);
		MvcResult result = mockmvc.perform(requestBuilder).andReturn();
		log.info("mock result response code " + result.getResponse().getStatus());
		log.info("mock result response " + result.getResponse().getContentAsString());
		assertEquals(200, result.getResponse().getStatus());
		assertEquals(toBeCompareJson, result.getResponse().getContentAsString().replace(" ", ""));
	}
	
	@Test
	public void testGetProductUnderCategoryById() throws Exception{
		List<Product> productList=new ArrayList<Product>();
		Product product=new	Product(1,"Mobile", 10, 10000.00,1,1,1); 
		productList.add(product);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter(); 
		String toBeCompareJson = ow.writeValueAsString(productList).replace(" ", "").replace("\n", "").replace("\r", "");
		Mockito.when(categoriesServiceImpl.getProductUnderCategory(Matchers.anyInt())).thenReturn(productList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
											.get("/category/{id}/products","1");
		MvcResult result = mockmvc.perform(requestBuilder).andReturn();
		log.info("mock result response code " + result.getResponse().getStatus());
		log.info("mock result response " + result.getResponse().getContentAsString());
		assertEquals(200, result.getResponse().getStatus());
		assertEquals(toBeCompareJson, result.getResponse().getContentAsString().replace(" ", ""));
	}
}
