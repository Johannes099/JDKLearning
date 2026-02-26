package model.eingabe;

import java.io.*;
import java.util.*;

public class CsvReader {
    private final File file;

    public CsvReader(String path) {
        this.file = new File(path);
    }

    public String read(int row, int column) throws IOException {
        String[] fields = readRow(row);
        if (fields == null || column >= fields.length) return null;
        return fields[column];
    }

    public String[] readRow(int lineIndex) throws IOException {
        if (!file.exists()) return null;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine(); // skip header

            int current = 0;
            String line;
            while ((line = br.readLine()) != null) {
                if (current == lineIndex) {
                    return parseLine(line);
                }
                current++;
            }
        }
        return null;
    }

    public List<String[]> readRows() throws IOException {
        List<String[]> rows = new ArrayList<>();
        if (!file.exists()) return rows;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine(); // skip header
            String line;
            while ((line = br.readLine()) != null) {
                rows.add(parseLine(line));
            }
        }
        return rows;
    }

    private String[] parseLine(String line) {
        List<String> fields = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inQuotes = false;
        int i = 0;

        while (i < line.length()) {
            char c = line.charAt(i);
            if (inQuotes) {
                if (c == '"') {
                    if (i + 1 < line.length() && line.charAt(i + 1) == '"') {
                        sb.append('"');
                        i += 2;
                    } else {
                        inQuotes = false;
                        i++;
                    }
                } else {
                    sb.append(c);
                    i++;
                }
            } else {
                if (c == '"') {
                    inQuotes = true;
                    i++;
                } else if (c == ',') {
                    fields.add(sb.toString());
                    sb.setLength(0);
                    i++;
                } else {
                    sb.append(c);
                    i++;
                }
            }
        }

        fields.add(sb.toString());
        return fields.toArray(new String[0]);
    }
}