import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import org.junit.*;

public class MarkdownParseTest {
    private MarkdownParse parseFile;
    @Before
	public void setUp() throws Exception {
		parseFile = new MarkdownParse();
	}
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void additionFails() {
        assertEquals(4, 3 + 1);
    }

    @Test 
    public void testFileOne() throws IOException{
        
        Path fileName = Path.of("test-file.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links =MarkdownParse.getLinks(contents);
        assertEquals("The test-file.md file gives the correct output",links 
        ,List.of("https://something.com", "some-page.html")  );
    }

    @Test 
    public void testFileTwo() throws IOException{
        
        Path fileName = Path.of("testfile2.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals("The test-file.md file gives the correct output",links ,
        List.of("https://www.google.com/search?q=cat&rlz=1C5CHFA_enUS973US973&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjbxeiawsv1AhUtIUQIHYWmCLUQ_AUoAXoECAIQAw&biw=1018&bih=647&dpr=2#imgrc=0V922RrJgQc9SM", 
        "https://www.google.com/search?q=cat&rlz=1C5CHFA_enUS973US973&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjbxeiawsv1AhUtIUQIHYWmCLUQ_AUoAXoECAIQAw&biw=1018&bih=647&dpr=2#imgrc=0V922RrJgQc9SM")  );
    }

    @Test 
    public void testFileThree() throws IOException{
        
        Path fileName = Path.of("testfile3.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals("The test-file.md file gives the correct output", List.of(), links  );
    }
    @Test 
    public void testFileFour() throws IOException{
        
        Path fileName = Path.of("testfile4.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        
        assertEquals("The test-file.md file gives the correct output", List.of(""), links  );
    }

    @Test 
    public void testSnippet1() throws IOException{
        Path fileName = Path.of("Snippet1.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        
        assertEquals("The test-file.md file gives the correct output", 
        List.of("`google.com, google.com, ucsd.edu"), links  );
    }

    @Test 
    public void testSnippet2() throws IOException{
        Path fileName = Path.of("Snippet2.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        
        assertEquals("The test-file.md file gives the correct output", 
        List.of("a.com, a.com(()), example.com"), links  );
    }

    @Test 
    public void testSnippet3() throws IOException{
        Path fileName = Path.of("Snippet3.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        
        assertEquals("The test-file.md file gives the correct output", 
        List.of("https://ucsd-cse15l-w22.github.io/"), links  );
    }

  
}

