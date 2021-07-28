package org.grow90.finmlapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinmlapiApplication {

//    @Autowired
//    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(FinmlapiApplication.class, args);
    }

//    @PostConstruct
//    public void initUsers() {
//        User user = new User(1,"joeydash","joeydash","ADMIN","joeydash@saarang.org","9435840783",true);
//        userRepository.save(user);
//    }
}
