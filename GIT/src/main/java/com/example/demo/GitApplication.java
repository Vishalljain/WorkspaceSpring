package com.example.demo;

import java.io.File;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.TextProgressMonitor;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GitApplication {

	private static final String URI = "https://github.com/vishal123456780/GitDockerJenkinsDemo.git";

	public static void main(String[] args)  {
		SpringApplication.run(GitApplication.class, args);
		
		// Set up the credentials provider
        String username = "smartagri101@gmail.com";
        String password = "Vj2008232@";
        UsernamePasswordCredentialsProvider credentialsProvider = 
            new UsernamePasswordCredentialsProvider(username, password);
       
        File localDir = new File("C:\\Users\\IXL1KOR\\Downloads\\git");
        try {
        	ProgressMonitor progressMonitor = new TextProgressMonitor();
			Git.cloneRepository()
			    .setURI(URI)
			    .setCredentialsProvider(credentialsProvider)
			    .setDirectory(localDir)
			    .setProgressMonitor(progressMonitor)
			    .call();
		    System.out.println("Successfully cloned repository from " + URI + " to " + localDir.getAbsolutePath());
        } catch (GitAPIException e) {
            System.err.println("Failed to clone repository from " + URI + " to " + localDir.getAbsolutePath());
            e.printStackTrace();
		
	}
	}

}
