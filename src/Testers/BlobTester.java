package Testers;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.security.*;

import Git.Blob;

class BlobTester {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		Path p = Paths.get("junit.txt");
        try {
            Files.writeString(p, "example", StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
        	System.out.println(e.toString());
            e.printStackTrace();
        }
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		File myObj = new File("jnuit.txt"); 
	    if (myObj.delete())
	    	System.out.println("Deleted the file.");
	    else
	    	System.out.println("Failed to delete the file.");
	}

	@Test
	void testBlob() throws Exception {
		Blob b = new Blob("junit.txt"); 
		File file2 = new File("objects/c3499c2729730a7f807efb8676a92dcb6f8a3f8f");
		assertTrue(file2.exists());
	}
}
