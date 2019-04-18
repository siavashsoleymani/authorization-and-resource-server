package ir.caspersia.authorizationandresourceserver.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.List;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Common {

    public static Timestamp now() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static String convertToEnglishDigits(String value) {
        String newValue = value
                .replace("١", "1")
                .replace("٢", "2")
                .replace("٣", "3")
                .replace("٤", "4")
                .replace("٥", "5")
                .replace("٦", "6")
                .replace("٧", "7")
                .replace("٨", "8")
                .replace("٩", "9")
                .replace("٠", "0")
                .replace("۱", "1")
                .replace("۲", "2")
                .replace("۳", "3")
                .replace("۴", "4")
                .replace("۵", "5")
                .replace("۶", "6")
                .replace("۷", "7")
                .replace("۸", "8")
                .replace("۹", "9")
                .replace("۰", "0");

        return newValue;
    }

    public static StringBuilder getFormattedTextFromFile(String path) throws IOException {
        List<String>  lines = Files.readAllLines(Paths.get(path));
        StringBuilder laws  = new StringBuilder();
        for (String e : lines) {
            laws.append(e).append("\n");
        }
        return laws;
    }

    public static void writeFormattedTextToFile(String path, String body) {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(path), "UTF-8"));
            body = body.replaceAll("\\\"", "\"");
            body = body.substring(1, body.length() - 1);
            body = body.replaceAll("\\\\", "");

            writer.write(body);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
