package model.eingabe;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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

    // replaces the first data row (row after header), or creates the file if it doesn't exist
    public void replaceFirstRow(String... values) throws IOException {
        List<String> lines = new ArrayList<>();

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    lines.add(line);
                }
            }
        }

        // build the new row
        StringJoiner row = new StringJoiner(",");
        for (String value : values) {
            row.add(toCsv(value));
        }
        String newRow = row.toString();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, false))) {
            if (lines.isEmpty()) {
                // no file existed, create header + row
                StringJoiner header = new StringJoiner(",");
                for (int i = 0; i < values.length; i++) {
                    header.add("col" + i);
                }
                bw.write(header.toString());
                bw.newLine();
                bw.write(newRow);
                bw.newLine();
            } else if (lines.size() == 1) {
                // only header exists, append new row
                bw.write(lines.get(0));
                bw.newLine();
                bw.write(newRow);
                bw.newLine();
            } else {
                // write header as-is, replace first data row, keep the rest
                bw.write(lines.get(0)); // header
                bw.newLine();
                bw.write(newRow);       // replaced first row
                bw.newLine();
                for (int i = 2; i < lines.size(); i++) {
                    bw.write(lines.get(i));
                    bw.newLine();
                }
            }
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