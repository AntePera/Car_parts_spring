package com.seminar.WebApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import com.seminar.WebApp.entities.Car;
import com.seminar.WebApp.entities.Issue;
import com.seminar.WebApp.entities.Part;


@Service
public class AdminService {
    
    @Autowired
    RestTemplate restTemplate;

    public String admin(Model model)
    {
        model.addAttribute("car",new Car());
        model.addAttribute("issue", new Issue());
        model.addAttribute("part", new Part());


        ResponseEntity<List<Part>> partsResponse = restTemplate.exchange("http://localhost:8080/parts",
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<Part>>(){});
        List<Part> parts = partsResponse.getBody();

        ResponseEntity<List<Issue>> issueResponse = restTemplate.exchange("http://localhost:8080/issues",
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<Issue>>(){});
        List<Issue> issues = issueResponse.getBody();

        ResponseEntity<List<Car>> carsResponse = restTemplate.exchange("http://localhost:8080/cars",
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<Car>>(){});
        List<Car> cars = carsResponse.getBody();
        model.addAttribute("cars",cars);
        model.addAttribute("issues",issues);
        model.addAttribute("parts",parts);
        return "admin";
    }

    public RedirectView carAdded(Car car)
    {
        restTemplate.postForObject("http://localhost:8080/cars", car,Car.class);
        return new RedirectView("/admin");
    }

    public RedirectView issueAdded(Issue issue)
    {
        restTemplate.postForObject("http://localhost:8080/issues", issue,Issue.class);
        return new RedirectView("/admin");
    }

    public RedirectView partAdded(Part part)
    {
        restTemplate.postForObject("http://localhost:8080/parts", part,Part.class);
        return new RedirectView("/admin");
    }

    public RedirectView addIssuesToParts(int partSelect,String issues)
    {
        String[] strings = issues.split(",",0);
        for(String issueID: strings)
        {
            Issue addedIssue = new Issue();
            restTemplate.postForObject("http://localhost:8080/parts/" + partSelect + "/issues/" + issueID,addedIssue,Issue.class);
        }
        
        return new RedirectView("/admin");
    }
}
