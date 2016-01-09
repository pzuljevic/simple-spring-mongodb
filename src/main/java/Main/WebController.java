package Main;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.Date;

@Controller
public class WebController {

    private final VisitorDescriptorRepository repository;

    @Autowired
    WebController(VisitorDescriptorRepository repository) {
        this.repository = repository;
    }

    private final static ObjectMapper mapper = new ObjectMapper();

    @RequestMapping("/images")
    public String images(@RequestParam(value = "code", defaultValue = "0") String code) {
        repository.save(
                new VisitorDescriptor(
                        new Timestamp(new Date().getTime()),
                        "/images/" + code
                )
        );
        return "Images.html";
    }

    @RequestMapping("/videos")
    public String videos(@RequestParam(value = "code", defaultValue = "0") String code) {
        repository.save(
                new VisitorDescriptor(
                        new Timestamp(new Date().getTime()),
                        "/videos/" + code
                )
        );
        return "Videos.html";
    }

    @RequestMapping("/stats")
    @ResponseBody
    public String showImagesStats() throws JsonProcessingException {
        return mapper.writeValueAsString(repository.findAll());
    }
}