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

import java.util.*;
import java.security.*;

import Git.Blob;
import Git.Index;

class IndexTester {
	
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
	void testInit() throws Exception {
		Index i = new Index();
		File file = new File("index.txt");
		assertTrue(file.exists());
		Path path = Paths.get("objects");
		assertTrue(Files.exists(path)); 
	}
	
	@Test
	void testAdd() throws Exception {
		Index i2 = new Index();
		Blob b = new Blob("junit.txt"); 
		i2.addBlobs("junit.txt");
		File file3 = new File("objects/c3499c2729730a7f807efb8676a92dcb6f8a3f8f");
		assertTrue(file3.exists());
	}
	
	@Test
	void testRemove() throws Exception{
		Index i3 = new Index();
		Blob b = new Blob("junit.txt"); 
		i3.addBlobs("junit.txt");
		File file4 = new File("objects/c3499c2729730a7f807efb8676a92dcb6f8a3f8f");
		i3.removeBlob("junit.txt");
	}
}
