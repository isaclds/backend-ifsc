package ifsc.edu.xml.services;

import ifsc.edu.xml.webServices.MySoapService;
import org.springframework.stereotype.Service;

@Service
public class MySoapServiceImpl implements MySoapService {

    @Override
    public String sayHello(String name) {
        return "Hello, " + name + " from CXF SOAP!";
    }
}