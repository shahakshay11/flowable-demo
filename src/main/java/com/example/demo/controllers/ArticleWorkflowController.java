package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Approval;
import com.example.demo.domain.Article;
import com.example.demo.services.ArticleWorkflowService;
import com.example.demo.services.BpmnParserService;

@RestController
public class ArticleWorkflowController {
	@Autowired
    private ArticleWorkflowService service;
	
	@Autowired
    private BpmnParserService bpmnParserService;
	
    @PostMapping("/submit")
    public void submit(@RequestBody Article article) {
        //service.startProcess(article);
        bpmnParserService.parseBPMNJson();
        
    }
    @GetMapping("/tasks")
    public List<Article> getTasks(@RequestParam String assignee) {
        return service.getTasks(assignee);
    }
    @PostMapping("/review")
    public void review(@RequestBody Approval approval) {
        service.submitReview(approval);
    }
}
