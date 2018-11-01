package dataProviders;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DataProviders {

    @DataProvider
    public Object[][] simpleDataProvider() {
        return new Object[][]{
                {"String1", 1},
                {"String2", 2},
                {"String3", 3}
        };
    }

    @DataProvider(parallel = true)
    public Object[][] benefitBlocksDataProvider() {
        return new Object[][]{
                {0, "To include good practices" + "\n" +
                        "and ideas from successful" + "\n" +
                        "EPAM project"},
                {1, "To be flexible and" + "\n" + "customizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base" + "\n" +
                        "(about 20 internal and" + "\n" +
                        "some external projects)," + "\n" +
                        "wish to get more…"}
        };
    }

    @DataProvider
    public Object[][] metalsAndColorsDataProvider() {
        //Load data from JSON
        StringBuilder contentBuilder = new StringBuilder();
        Path path = Paths.get("src\\test\\resources\\JDI_ex8_metalsColorsDataSet.json");
        try (Stream<String> stream = Files.lines(path)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JsonObject jsonObject = new JsonParser().parse(contentBuilder.toString()).getAsJsonObject();
        Object[][] result = new Object[jsonObject.size()][1];
        for (int i = 0; i < jsonObject.size(); i++) {
            result[i][0] = new Gson()
                    .fromJson(jsonObject.getAsJsonObject("data_" + (i + 1)).toString(), MetalsAndColorsData.class);
        }

        return result;
    }
}
