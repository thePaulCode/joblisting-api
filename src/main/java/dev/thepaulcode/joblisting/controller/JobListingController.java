package dev.thepaulcode.joblisting.controller;


//import org.springframework.web.bind.annotation.RequestMapping;
import dev.thepaulcode.joblisting.model.JobListing;
import dev.thepaulcode.joblisting.model.repository.JobListingRepository;
import dev.thepaulcode.joblisting.model.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job-listing/v1/api")
public class JobListingController {
    @Autowired
    JobListingRepository postRepository;  // Injeta o repositório de Posts.
    @Autowired
    SearchRepository searchRepository;  // Injeta o repositório de pesquisa.

//    @ApiIgnore
//    @RequestMapping(value = "/")
//    public void redirect(HttpServletResponse response) throws IOException {
//        // Este método redireciona a raiz para a página Swagger.
//        response.sendRedirect("/swagger-ui.html");
//    }

    @GetMapping("/all-jobs")
    public List<JobListing> getAllJobs() {
        // Retorna uma lista de todos os Posts usando o repositório de Posts.
        return postRepository.findAll();
    }

    // posts/magento
    @GetMapping("/search/{text}")
    public List<JobListing> search(@PathVariable String text) {
        // Este método realiza uma pesquisa por texto usando o repositório de pesquisa.
        return searchRepository.findByText(text);
    }

    @PostMapping("/add-job")
    public JobListing addJob(@RequestBody JobListing post) {
        // Este método adiciona um novo Post usando o repositório de Posts.
        return postRepository.save(post);
    }
}
