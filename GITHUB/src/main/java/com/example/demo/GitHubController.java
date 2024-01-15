package com.example.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/github")
public class GitHubController {
	 private final GitHubService gitHubService;
	 	@Autowired
	    public GitHubController(GitHubService gitHubService) {
	        this.gitHubService = gitHubService;
	    }

	 	@GetMapping("/repositories")
	    public ResponseEntity<String> getGitHubRepositories() {
	        // You can add any additional logic here before calling the service method
	        return gitHubService.getRepositoriesWithRetry();
	    }
	    
	    @GetMapping("/repositoriesData")
	    public String getGitHubRepositories1() {
	        try {
	            // Define the curl command
	        	 String[] cmd = {
	                     "curl",
	                     "-u", "smartagri101@gmail.com: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",
	                     "-H", "Accept: application/json",
	                     "https://api.github.com/user/repos"
	                 };

	            // Create a ProcessBuilder and start the subprocess
	            ProcessBuilder processBuilder = new ProcessBuilder(cmd);
	            Process process = processBuilder.start();

	            // Create a file to write the response
	            try (BufferedWriter writer = new BufferedWriter(new FileWriter("github_repositories.json"))) {
	                // Read the output of the subprocess and write it to the file
	                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
	                String line;
	                while ((line = reader.readLine()) != null) {
	                    writer.write(line);
	                    writer.newLine();
	                    System.out.println(line);
	                }
	            }
	            
	            // Wait for the subprocess to complete
	            process.waitFor();

	            return "GitHub repositories data has been saved to github_repositories.json";
	        } catch (IOException | InterruptedException e) {
	            e.printStackTrace();
	            return "Error fetching and saving GitHub repositories data";
	        }
	    }
}
/*
 In the example provided, we are running a curl command as a separate program within your Spring Boot application to fetch data from a URL (the GitHub API). The data we fetch is typically in text format, like JSON. To capture this text-based data, we use an InputStreamReader, which helps us read and process the response as text characters.

An InputStreamReader is like a bridge that helps us convert the raw data (bytes) from the curl command's output into understandable text characters. This allows us to read and work with the response data as text, which is the typical format for data received from APIs.

If you were dealing with non-text data or sending data to a subprocess, you might use different tools (e.g., OutputStream and OutputStreamWriter) to handle binary data. In our case, since we're fetching text-based data from the GitHub API, an InputStreamReader is the appropriate tool to read and handle the response data.

*/



