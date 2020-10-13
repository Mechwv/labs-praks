package praktika.Prak12;

public class CreateTextDocument implements ICreateDocument {
    @Override
    public IDocument CreateNew() {
        return new TextDocument();
    }

    @Override
    public IDocument CreateOpen(String filename){
        return new TextDocument(filename);
    }
}
