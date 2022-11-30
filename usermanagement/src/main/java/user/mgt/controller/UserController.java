package user.mgt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
import user.mgt.domain.User;
import user.mgt.service.UserService;

@RestController
@AllArgsConstructor
public class UserController {
	@Autowired
	UserService userService;
	
	private static final String authorizationRequestBaseUri = "oauth2/authorization";
	Map<String, String> oauth2AuthenticationUrls = new HashMap<>();
	private final ClientRegistrationRepository clientRegistrationRepository;
	   
	@RequestMapping("/signin")
    public ModelAndView signin(Model model) throws Exception {
        Iterable<ClientRegistration> clientRegistrations = null;
        ResolvableType type = ResolvableType.forInstance(clientRegistrationRepository)
                .as(Iterable.class);
        if (type != ResolvableType.NONE &&
                ClientRegistration.class.isAssignableFrom(type.resolveGenerics()[0])) {
            clientRegistrations = (Iterable<ClientRegistration>) clientRegistrationRepository;
        }
        assert clientRegistrations != null;
        clientRegistrations.forEach(registration ->
                oauth2AuthenticationUrls.put(registration.getClientName(),
                        authorizationRequestBaseUri + "/" + registration.getRegistrationId()));
        model.addAttribute("urls", oauth2AuthenticationUrls);
 
        ModelAndView mv = new ModelAndView();
		mv.setViewName("SignIn");
        return mv;
    }
	
	@RequestMapping("/signup")
	public ModelAndView signup() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("SignUp");
		return mv;
	}
	
	@RequestMapping("/")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Main");
		return mv;
	}
	
	@PostMapping("/signup")
    public String signup(@ModelAttribute("user") User user) {
		userService.saveUser(user);
        return "redirect/";
    }
}
