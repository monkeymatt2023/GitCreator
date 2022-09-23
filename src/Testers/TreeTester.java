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
import java.io.*;
import java.security.*;

import Git.Tree;

class TreeTester {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		File file = new File("objects/dd4840f48a74c1f97437b515101c66834b59b1be");
		file.delete();
	}

	@Test
	void treeTest() throws Exception {
		ArrayList<String> list = new ArrayList<String>();
		list.add("blob : 81e0268c84067377a0a1fdfb5cc996c93f6dcf9f filename1.txt");
		list.add("blob : 01d82591292494afd1602d175e165f94992f6f5f someOtherFile.jpg");
		list.add("blob : f1d82236ab908c86ed095023b1d2e6ddf78a6d83 anotherFileWhichDoesntExist.txt");
		list.add("tree : bd1ccec139dead5ee0d8c3a0499b42a7d43ac44b file4.txt");
		list.add("tree : e7d79898d3342fd15daf6ec36f4cb095b52fd976 makeupThisName.txt");
		Tree test = new Tree(list);	
		
		File file = new File("objects/dd4840f48a74c1f97437b515101c66834b59b1be");
		assertTrue(file.exists());
		
		Scanner input = new Scanner(file);
		assertTrue(input.nextLine().equals("blob : 81e0268c84067377a0a1fdfb5cc996c93f6dcf9f filename1.txt"));
		assertTrue(input.nextLine().equals("blob : 01d82591292494afd1602d175e165f94992f6f5f someOtherFile.jpg"));
		assertTrue(input.nextLine().equals("blob : f1d82236ab908c86ed095023b1d2e6ddf78a6d83 anotherFileWhichDoesntExist.txt"));
		assertTrue(input.nextLine().equals("tree : bd1ccec139dead5ee0d8c3a0499b42a7d43ac44b file4.txt"));
		assertTrue(input.nextLine().equals("tree : e7d79898d3342fd15daf6ec36f4cb095b52fd976 makeupThisName.txt"));
	}
}
