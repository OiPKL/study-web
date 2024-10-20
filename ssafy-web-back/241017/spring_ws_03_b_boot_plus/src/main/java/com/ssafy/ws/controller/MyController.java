package com.ssafy.ws.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ws.dto.Book;

import jakarta.servlet.http.HttpSession;

// @Controller: 해당 클래스가 Controller임을 명시합니다.
@Controller
public class MyController {
	/*
	 * # Method Mapping Requests (메서드 요청 매핑)
	 * https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-controller/
	 * ann-requestmapping.html
	 * 
	 * @RequestMapping: 클라이언트의 요청 URL을 어떤 메서드가 처리할지 매핑합니다. - value: 클라이언트의 요청 URL을
	 * 지정합니다. - method: 클라이언트의 요청 방식을 지정합니다.
	 * 
	 * # Handler Method Arguments (핸들러 메서드의 전달인자)
	 * https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-controller/
	 * ann-methods.html
	 * 
	 * ## Handler Method Parameter Types (파라미터 타입) HttpServletRequest: 클라이언트의 요청 정보를
	 * 메서드의 파라미터로 전달받습니다. HttpServletResponse: 클라이언트의 응답 정보를 메서드의 파라미터로 전달받습니다.
	 * HttpSession: 클라이언트의 세션 정보를 메서드의 파라미터로 전달받습니다. Locale: 클라이언트의 지역 정보를 메서드의
	 * 파라미터로 전달받습니다. InputStream, Reader: 클라이언트의 요청 본문을 메서드의 파라미터로 전달받습니다.
	 * OutputStream, Writer: 클라이언트의 응답 본문을 메서드의 파라미터로 전달받습니다. Map, Model, MapModel:
	 * 뷰에 전달할 데이터를 저장하는데 사용합니다. RedirectAttributes: 리다이렉트 시 플래시 속성을 저장하는데 사용합니다.
	 * 
	 * 
	 * ## Handler Method Arguments Annotations (어노테이션)
	 * 
	 * @PathVariable: URL 경로의 일부를 메서드의 파라미터로 전달받습니다. - value: URL 경로의 일부로 사용할 변수 이름을
	 * 지정합니다.
	 * 
	 * @RequestParam: 클라이언트의 요청 파라미터를 메서드의 파라미터로 전달받습니다. - value: 요청 파라미터의 이름을
	 * 지정합니다. - required: 요청 파라미터의 필수 여부를 지정합니다. - defaultValue: 요청 파라미터가 전달되지 않았을 때
	 * 사용할 기본값을 지정합니다.
	 * 
	 * @RequestBody: 클라이언트의 요청 본문을 읽고 객체를 역직렬화하여 메서드의 파라미터로 전달받습니다.
	 * 
	 * @RequestHeader: 클라이언트의 요청 헤더를 메서드의 파라미터로 전달받습니다. - value: 요청 헤더의 이름을 지정합니다. -
	 * required: 요청 헤더의 필수 여부를 지정합니다. - defaultValue: 요청 헤더가 전달되지 않았을 때 사용할 기본값을
	 * 지정합니다.
	 * 
	 * @RequestAttribute: 요청 스코프에 바인딩된 속성을 메서드의 파라미터로 전달받습니다. - value: 요청 스코프에 바인딩된
	 * 속성의 이름을 지정합니다. - required: 요청 스코프에 바인딩된 속성의 필수 여부를 지정합니다.
	 * 
	 * @SessionAttribute: 세션 스코프에 바인딩된 속성을 메서드의 파라미터로 전달받습니다. - value: 세션 스코프에 바인딩된
	 * 속성의 이름을 지정합니다. - required: 세션 스코프에 바인딩된 속성의 필수 여부를 지정합니다.
	 * 
	 * @CookieValue: 클라이언트의 쿠키를 메서드의 파라미터로 전달받습니다. - value: 쿠키의 이름을 지정합니다. -
	 * required: 쿠키의 필수 여부를 지정합니다. - defaultValue: 쿠키가 전달되지 않았을 때 사용할 기본값을 지정합니다.
	 *
	 * ## Handler Method Return Values (핸들러 메서드의 반환값)
	 * 
	 * @ResponseBody: 해당 메서드가 반환하는 값을 응답 본문으로 사용합니다. HttpHeaders: body가 없고 헤더 정보만
	 * 반환합니다. String : 뷰 이름을 반환합니다. ModelAndView: 뷰 이름과 뷰에 전달할 데이터를 함께 반환합니다. Map,
	 * Model, MapModel: 뷰에 전달할 데이터를 반환합니다. void: 메서드가 반환하는 값을 응답 본문으로 사용하지 않고,
	 * ServletResponse, HttpServletResponse, OutputStream, Writer 등의 입력인자를 사용하여 직접
	 * 응답을 생성합니다.
	 */
	private ResourceLoader resourceLoader;

//	@Autowired	: 이거 없어도 들어있는거야!
	public MyController(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	@PostMapping("/upload")
	public String upload(MultipartFile file, Model model) throws IllegalStateException, IOException {
		System.out.println(file.getOriginalFilename());

		if (file != null && file.getSize() > 0) {
			String fileName = file.getOriginalFilename();
			// 코드로 저기 있는 img라고 하는 폴더를 가지고 와야겠다.
			Resource resource = resourceLoader.getResource("classpath:/static/img");
			file.transferTo(new File(resource.getFile(), fileName));
			
			System.out.println("파일 저장 완료");
			
			model.addAttribute("fileName", fileName);
		}

		return "forward:/";
		// return "index";
	}
	
	@GetMapping("/download/{fileName}")
	public String download(@PathVariable String fileName) {
		System.out.println("다운로드 할 file Name : " + fileName);
		return "fileDownloadView";
	}

	// 로그인 처리 메서드
	@PostMapping("/login")
	public String login(HttpSession session, @RequestParam String id, @RequestParam String password, Model model) {
		System.out.println(id);
		System.out.println(password);
		if (id.equals("ssafy") && password.equals("1234")) {
			session.setAttribute("userId", "ssafy");
		}

		return "redirect:/";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	// Q1. context root "/" 으로 요청이 들어오면 "index"이라는 이름의 뷰를 반환하는 메서드
	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}

	// Q2. "/about"으로 POST 요청이 오면 "/test2.jsp"로 리다이렉트하는 메서드
	@PostMapping(value = "/about")
	public String about() {
		return "redirect:/test2.jsp";
	}

	// Q3. articleId라는 경로 변수를 사용하여 "article" 뷰를 반환하는 메서드
	@GetMapping("/articles/{articleId}")
	public String getArticle(@PathVariable("articleId") String articleId, Model model) {
		System.out.println(articleId);
		model.addAttribute("articleId", articleId);
		return "article";
	}

	// Q4. HttpServletRequest와 HttpServletResponse를 사용하여 뷰를 반환하는 메서드
//    @GetMapping("/products")
//    public void getProducts(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String productId = request.getParameter("id");
//        PrintWriter out = response.getWriter();
//        out.print("<html><head><meta charset='UTF-8'><title>MVC 컨트롤러 테스트</title></head>"
//        + "<body><h1>상품 아이디: " + productId + "</h1>"
//        + "<span>이 내용은 ServletResponse에 의해 만들어졌습니다.</span><br>"
//        + "<a href='./'>메인으로</a>"
//        + "</body></html>");
//    }

	@GetMapping("/products")
	public String getProducts(@RequestParam("id") String productId, Model model) throws IOException {
		model.addAttribute("productId", productId);
		return "productDetail";
	}

	// Q5. book이라는 변수를 사용하여 "bookDetails" 뷰를 반환하는 메서드
	@PostMapping("/books")
	public String createBookDetails(Book book, Model model) {
		// 매개변수에 DTO가 들어가 있을 때, Spring이 해당 객체 인스턴스를 생성하고
		// 파라미터 이름과 같은 setter를 호출해서 값을 할당해준다.
		System.out.println(book);
//    	model.addAttribute("book", book);
		model.addAttribute("bookId", book.getId());
		model.addAttribute("title", book.getTitle());
		model.addAttribute("author", book.getAuthor());
		return "bookDetails";
	}

	// Q6. category와 query라는 변수를 사용하여 "searchResults" 뷰를 반환하는 메서드
	@RequestMapping("/search/{category}")
	public String search(@PathVariable String category, @RequestParam String query, Model model) {
		model.addAttribute("query", query);
		model.addAttribute("category", category);
		return "searchResults";
	}
}
