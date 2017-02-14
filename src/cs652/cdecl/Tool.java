package cs652.cdecl;

import cs652.cdecl.EnglishGenerator;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;


public class Tool {
	public static void main(String[] args) {
		// YOU MUST FILL THIS IN
        //String test = "int *(*f[])();";
        translate("int *(*f[])();");
	}

	public static String translate(String cdeclText) {
		// YOU MUST FILL THIS IN
        ANTLRInputStream input = new ANTLRInputStream(cdeclText);
        CDeclLexer lexer = new CDeclLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CDeclParser parser = new CDeclParser(tokens);
        ParseTree tree = parser.declaration();
        System.out.println(tree.toStringTree(parser));

        EnglishGenerator generator = new EnglishGenerator();
        //System.out.println(generator.visit(tree));
        return generator.visit(tree);
	}
}
