package Testers;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Git.Commit;

class CommitTester {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {

	}
	
	@Test
	void commitTest() throws Exception {
		String pt = "objects/dd4840f48a74c1f97437b515101c66834b59b1be";
		Commit com = new Commit(pt, "summary", "author", null);
		com.createFile();
	}
}
