package praktika.Prak12;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TextDocument implements IDocument{
    private String name;
    private String data;

    public TextDocument(String name) {
        this.name = name;
    }

    public TextDocument() {}

    @Override
    public String read() throws Exception{
        String path = "praktika/Prak12/txtfiles/"+name;
        List<String> lines = Files.readAllLines(Paths.get(path));
        StringBuilder sb = new StringBuilder();
        for (String line: lines)
            sb.append(line).append('\n');
        return sb.toString();
    }

    @Override
    public void save() throws Exception {
        String save = "praktika/Prak12/txtfiles/"+name;
        Files.writeString(Paths.get(save), data);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
