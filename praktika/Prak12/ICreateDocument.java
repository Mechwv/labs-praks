package praktika.Prak12;

public interface ICreateDocument {
    IDocument CreateNew();
    IDocument CreateOpen(String filename);
}
