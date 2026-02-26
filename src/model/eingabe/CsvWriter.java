package model.eingabe;

import java.io.*;
import java.util.StringJoiner;

public class CsvWriter {
    private final File file;

    public CsvWriter(String path) {
        this.file = new File(path);
    }

    public void appendRow(String... values) throws IOException {
        boolean newFile = !file.exists();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            if (newFile) {
                // build header: col0, col1, col2, ...
                StringJoiner header = new StringJoiner(",");
                for (int i = 0; i < values.length; i++) {
                    header.add("col" + i);
                }
                bw.write(header.toString());
                bw.newLine();
            }

            StringJoiner row = new StringJoiner(",");
            for (String value : values) {
                row.add(toCsv(value));
            }
            bw.write(row.toString());
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