test: MarkdownParse.class, MarkdownParseTest.class
	java MarkdownParseTest

MarkdownParse.class: MarkdownParse.java 
	javac MarkdownParse.java

MarkdownParseTest.class: MarkdownParseTest.java 
	javac MarkdownParseTest.java
