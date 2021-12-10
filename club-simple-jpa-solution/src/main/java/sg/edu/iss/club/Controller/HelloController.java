package sg.edu.iss.club.Controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

		@GetMapping("/hello")
		public String sayHello(Model model) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMM yyyy");
				Calendar cal = Calendar.getInstance();
				model.addAttribute("today", dateFormat.format(cal.getTime()));
				return "clubhousehello"; 
				//this is default for html
				//the formatting will be different for other templates (.jsp, .asp etc) 
		}
}
