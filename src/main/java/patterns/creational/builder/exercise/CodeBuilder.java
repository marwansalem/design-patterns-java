package patterns.creational.builder.exercise;

class CodeBuilder
{
    private StringBuilder sb;
    private static final String INDENT = "  ";
    private static String LINE_SEPARATOR = System.lineSeparator();
    public CodeBuilder(String className)
    {
        // todo
        sb = new StringBuilder()
            .append("public ")
            .append("class ")
            .append(className)
            .append(LINE_SEPARATOR)
            .append("{")
            .append(LINE_SEPARATOR);
    }

    public CodeBuilder addField(String name, String type)
    {
        // todo
        sb.append(INDENT)
            .append("public ")
            .append(type)
            .append(" ")
            .append(name)
            .append(";")
            .append(LINE_SEPARATOR);
        return this;
    }

    @Override
    public String toString()
    {
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) {
        CodeBuilder cb = new CodeBuilder("Person");
        cb.addField("age", "int");
        cb.addField("name", "String");
        String code = cb.toString();
        System.out.println(code);
    }
}