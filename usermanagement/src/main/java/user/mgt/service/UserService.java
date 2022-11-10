package user.mgt.service;

import user.mgt.domain.User;
import user.mgt.repository.UserRepository;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	public User saveUser(User user) {
		user.setStatus("T");
        return userRepository.save(user);
    }

}
