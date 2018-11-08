package dataProviders;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import cucumber.runtime.io.ResourceLoader;
import enums.Metals;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        //JsonReader jsonReader = new JsonReader(new FileReader("\\src\\test\\resources\\JDI_ex8_metalsColorsDataSet.json"));

        Type rows = new TypeToken<HashMap<String, MetalsAndColorsData>>() {}.getType();
        Map<String, MetalsAndColorsData> rowData = new Gson().fromJson(contentBuilder.toString(), rows);
        Object[][] dataArray = new Object[rowData.size()][1];
        int i = 0;
        for (Map.Entry entry: rowData.entrySet()) {
            dataArray[i++][0] = entry.getValue();
        }
        return dataArray;
    }
}
