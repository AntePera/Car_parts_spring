package com.seminar.WebApp.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.seminar.WebApp.entities.Car;
import com.seminar.WebApp.entities.Image;
import com.seminar.WebApp.entities.Issue;
import com.seminar.WebApp.entities.Part;


@Service
public class AdminService {
    
    @Autowired
    RestTemplate restTemplate;

    public List<Integer> pagination(int size, int page)
    {
        int num = size % 10 == 0 ? size / 10 : size / 10 + 1;
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            li.add(i+1);
        }
        size = li.size();
        if (size > 5) {
            if (page > 3 && page < size - 2) {
                li = li.subList(page - 3, page + 1);
            }
            else if (page > 3) {
                li = li.subList(size - 5, size - 1);
            }
            else {
                li = li.subList(0, 4);
            }
        }
        return li;
    }

    public String adminCars(Model model, int page)
    {
        model.addAttribute("car",new Car());

        ResponseEntity<List<Car>> carsResponse = restTemplate.exchange("http://localhost:8080/cars",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Car>>(){});
        List<Car> cars = carsResponse.getBody();
        model.addAttribute("cars", cars.subList((page-1)*10, cars.size() < (page-1)*10+10 ? cars.size() : (page-1)*10+10));

        assert cars != null;
        List<Integer> li = pagination(cars.size(), page);
        model.addAttribute("list", li);
        model.addAttribute("len", li.size());

        return "adminCars";
    }

    public String adminParts(Model model, int page)
    {
        model.addAttribute("part", new Part());

        ResponseEntity<List<Part>> partsResponse = restTemplate.exchange("http://localhost:8080/parts",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Part>>(){});
        List<Part> parts = partsResponse.getBody();

        model.addAttribute("parts", parts.subList((page-1)*10, parts.size() < (page-1)*10+10 ? parts.size() : (page-1)*10+10));

        assert parts != null;
        List<Integer> li = pagination(parts.size(), page);
        model.addAttribute("list", li);
        model.addAttribute("len", li.size());

        return "adminParts";
    }

    public String adminIssues(Model model, int page)
    {
        model.addAttribute("issue", new Issue());

        ResponseEntity<List<Issue>> issueResponse = restTemplate.exchange("http://localhost:8080/issues",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Issue>>(){});
        List<Issue> issues = issueResponse.getBody();

        model.addAttribute("issues", issues.subList((page-1)*10, issues.size() < (page-1)*10+10 ? issues.size() : (page-1)*10+10));

        assert issues != null;
        List<Integer> li = pagination(issues.size(), page);
        model.addAttribute("list", li);
        model.addAttribute("len", li.size());

        return "adminIssues";
    }

    public String adminIssuesToParts(Model model) {
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

        model.addAttribute("issues",issues);
        model.addAttribute("parts",parts);

        return "adminIssuesToParts";
    }
    public String adminCarsToParts(Model model) {
        model.addAttribute("car",new Car());
        model.addAttribute("part", new Part());

        ResponseEntity<List<Part>> partsResponse = restTemplate.exchange("http://localhost:8080/parts",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Part>>(){});
        List<Part> parts = partsResponse.getBody();

        ResponseEntity<List<Car>> carsResponse = restTemplate.exchange("http://localhost:8080/cars",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Car>>(){});
        List<Car> cars = carsResponse.getBody();
        model.addAttribute("cars",cars);
        model.addAttribute("parts",parts);

        return "adminCarsToParts";
    }

    public RedirectView carAdded(Car car)
    {
        restTemplate.postForObject("http://localhost:8080/cars", car,Car.class);
        return new RedirectView("/admin/cars/1");
    }

    public RedirectView issueAdded(Issue issue)
    {
        restTemplate.postForObject("http://localhost:8080/issues", issue,Issue.class);
        return new RedirectView("/admin/issues/1");
    }

    public RedirectView partAdded(Part part,MultipartFile img) throws IOException
    {
        Image image = new Image();
        image.setName(img.getOriginalFilename());
        image.setData(img.getBytes());
        part.setImage(image);
        restTemplate.postForObject("http://localhost:8080/parts", part,Part.class);
        return new RedirectView("/admin/parts/1");
    }

    public RedirectView addIssuesToParts(int partSelect,String issues)
    {
        String[] strings = issues.split(",",0);
        for(String issueID: strings)
        {
            Issue addedIssue = new Issue();
            try
            {
            restTemplate.postForObject("http://localhost:8080/parts/" + partSelect + "/issues/" + issueID,addedIssue,Issue.class);
            }
            catch(Exception e)
            {
                continue;
            }
        }
        
        return new RedirectView("/admin/issuesToParts");
    }

    public RedirectView addCarsToParts(int partSelect,String cars)
    {
        String[] strings = cars.split(",",0);
        for(String carID: strings)
        {
            Car addedCar = new Car();
            try
            {
                restTemplate.postForObject("http://localhost:8080/parts/" + partSelect + "/cars/" + carID,addedCar, Car.class);
            }
            catch(Exception e)
            {
                continue;
            }
        }
        
        return new RedirectView("/admin/carsToParts");
    }

}
