package model.eingabe;

import java.io.*;

public class CsvWriter {
    private final File file;

    public CsvWriter(String path) {
        this.file = new File(path);
    }

    public void appendRow(String frage, String antwort) throws IOException {
        boolean newFile = !file.exists();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            if (newFile) {
                bw.write("frage,antwort");
                bw.newLine();
            }
            bw.write(toCsv(frage));
            bw.write(",");
            bw.write(toCsv(antwort));
            bw.newLine();
        }
    }

    private String toCsv(String s) {
        if (s == null) return "";
        String x = s.replace("\"", "\"\"");
        if (x.contains(",") || x.contains("\n") || x.contains("\r") || x.contains("\"")) {
            return "\"" + x + "\"";
        }
        return x;
    }
}
