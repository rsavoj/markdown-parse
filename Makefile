
test: MarkdownParse.class MarkdownParseTest.class
	java MarkdownParse test-file.md
	java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest;

MarkdownParse.class: MarkdownParse.java 
	javac MarkdownParse.java

MarkdownParseTest.class: MarkdownParseTest.java 
	javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java