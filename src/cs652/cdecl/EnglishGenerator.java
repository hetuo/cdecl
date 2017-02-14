package cs652.cdecl;



public class EnglishGenerator extends CDeclBaseVisitor<String> {

    @Override
    public String visitDeclaration(CDeclParser.DeclarationContext ctx)
    {
        return visitChildren(ctx);
    }

    @Override
    public String visitTypename(CDeclParser.TypenameContext ctx) {
        if (ctx.getText().equals("void"))
            return "nothing";
        return ctx.getText();
    }

    @Override public String visitArray(CDeclParser.ArrayContext ctx) {
        System.out.println("array of");
        String result = visit(ctx.declarator());
        return result + " array of";
    }

    @Override public String visitFunc(CDeclParser.FuncContext ctx) {
        String result = visit(ctx.declarator());
        return result + " function returning";
    }

    @Override public String visitVar(CDeclParser.VarContext ctx) {
        System.out.println(ctx.getText() + " is a");
        return ctx.getText() + " is a";
    }

    @Override public String visitPointer(CDeclParser.PointerContext ctx) {
        String result = visit(ctx.declarator());
        return result + " pointer to";
    }

    @Override public String visitGrouping(CDeclParser.GroupingContext ctx) {
        String result = visit(ctx.declarator());
        return result;
    }

    @Override
    public String aggregateResult(String aggregate, String nextResult)
    {
        if (aggregate == null)
            return nextResult;
        if (nextResult == null)
            return aggregate;

        StringBuilder sb = new StringBuilder(nextResult);
        sb.append(" ");
        sb.append(aggregate);
        return sb.toString();
    }
}
