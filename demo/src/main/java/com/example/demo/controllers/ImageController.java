package com.example.demo.controllers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.example.demo.entity.Image;
import com.example.demo.repositories.ImageRepository;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



@Controller
public class ImageController {
    
    @Autowired
    private ImageRepository uploadRepo;
    @GetMapping("/")
    public String index(Model m) {

        List<Image> list = uploadRepo.findAll();
        List<String> images = new ArrayList<>();
        for (Image i : list) {
            images.add(Base64.getEncoder().encodeToString(i.getData()));
        }

        m.addAttribute("list", list);
        m.addAttribute("images", images);

        return "index";
    }

    @PostMapping("/imageUpload")
    public String imageUpload(@RequestParam MultipartFile img, HttpSession session) {

        Image im = new Image();
        im.setName(img.getOriginalFilename());

        Image uploadImg = uploadRepo.save(im);

        if (uploadImg != null) {
            try {
                //udri ovu komandu da vidis svoj classpath i tek onda kreiras directory static/img u pathu, meni je path bia tek na target i tu di ti zavrsi napravis directory
                //File saveFile = new ClassPathResource("").getFile();
                File saveFile = new ClassPathResource("static/img").getFile();

                Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + img.getOriginalFilename());
                System.out.println(path);
                Files.copy(img.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        session.setAttribute("msg", "Image Upload Sucessfully");

        return "redirect:/";
    }



}
