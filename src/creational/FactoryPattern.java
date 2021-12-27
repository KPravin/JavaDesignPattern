package creational;

/**
 * @author Pravin Kumar
 */
public class FactoryPattern {

    public static Parser parserFactory(FileType fileType) throws Exception {

        switch(fileType){
            case PDF:
                return new PDFParser();
            case WORD:
                return new WORDParser();
            case EXCEL:
                return new EXCELParser();
            default:
                throw new Exception("Parser not found for the file type as: " + fileType);
        }
    }

    public static void main(String[] args) throws Exception {
        FactoryPattern pf = new FactoryPattern();

        Parser parser = parserFactory(FileType.EXCEL);
        String parsedContent = parser.parse("test content");
        System.out.println(parsedContent);
    }
}

interface Parser {
    public String parse(String dataToBeParse);
}

enum FileType {
    TEXT, PDF, HTML, DOC, WORD, EXCEL;
}

class PDFParser implements Parser {
    @Override
    public String parse(String dataToBeParse) {
        return "return parsed content from pdf";
    }
}

class TEXTParser implements Parser {
    @Override
    public String parse(String dataToBeParse) {
        return "return parsed content from text";
    }
}

class WORDParser implements Parser {
    @Override
    public String parse(String dataToBeParse) {
        return "return parsed content from Word";
    }
}

class EXCELParser implements Parser {
    @Override
    public String parse(String dataToBeParse) {
        return "return parsed content from Excel";
    }
}