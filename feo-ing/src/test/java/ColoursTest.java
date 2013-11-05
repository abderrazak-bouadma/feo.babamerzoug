import com.ing.Colours;
import org.fest.assertions.Assertions;
import org.fest.assertions.MapAssert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: merzoug
 * Date: 11/4/13
 * Time: 1:40 PM
 */
public class ColoursTest {

    public void coulours_json__should_be_loaded_and_parsed_from_construtor() {
        Colours colours = new Colours();
        final Map<String, int[]> rgbMap = colours.getColoursRGB();
        final MapAssert.Entry[] entry = new MapAssert.Entry[]{
                MapAssert.entry("white", new int[]{255, 255, 255}),
                MapAssert.entry("black", new int[]{0, 0, 0}),
                MapAssert.entry("red", new int[]{255, 0, 0}),
                MapAssert.entry("yellow", new int[]{255, 255, 0}),
                MapAssert.entry("green", new int[]{0, 128, 0}),
                MapAssert.entry("blue", new int[]{0, 0, 255}),
                MapAssert.entry("purple", new int[]{128, 0, 128})};
        Assertions.assertThat(rgbMap).isNotEmpty().includes(entry);
    }

    @Test
    public void getCoulourShouldReturnCorrectHEXCoulourValueFromNameAndHandleBrightness() {
        Colours colours = new Colours();
        Assertions.assertThat(colours.getColour("white", 1)).isNotNull().isNotEmpty().isEqualTo("#FFFFFF");
        Assertions.assertThat(colours.getColour("white", 0.75f)).isNotNull().isNotEmpty().isEqualTo("#BFBFBF");
        Assertions.assertThat(colours.getColour("white", 0.5f)).isNotNull().isNotEmpty().isEqualTo("#7F7F7F");
        Assertions.assertThat(colours.getColour("white", 1.1f)).isNotNull().isNotEmpty().isEqualTo("#FFFFFF");

        // brightness 0.5
        Assertions.assertThat(colours.getColour("white", 0.5f)).isNotNull().isNotEmpty().isEqualTo("#7F7F7F");
        Assertions.assertThat(colours.getColour("black", 0.5f)).isNotNull().isNotEmpty().isEqualTo("#000000");
        Assertions.assertThat(colours.getColour("red", 0.5f)).isNotNull().isNotEmpty().isEqualTo("#7F0000");
        Assertions.assertThat(colours.getColour("yellow", 0.5f)).isNotNull().isNotEmpty().isEqualTo("#7F7F00");
        Assertions.assertThat(colours.getColour("green", 0.5f)).isNotNull().isNotEmpty().isEqualTo("#004000");
        Assertions.assertThat(colours.getColour("blue", 0.5f)).isNotNull().isNotEmpty().isEqualTo("#00007F");
        Assertions.assertThat(colours.getColour("purple", 0.5f)).isNotNull().isNotEmpty().isEqualTo("#400040");

        // brightness 0.75
        Assertions.assertThat(colours.getColour("white", 0.75f)).isNotNull().isNotEmpty().isEqualTo("#BFBFBF");
        Assertions.assertThat(colours.getColour("black", 0.75f)).isNotNull().isNotEmpty().isEqualTo("#000000");
        Assertions.assertThat(colours.getColour("red", 0.75f)).isNotNull().isNotEmpty().isEqualTo("#BF0000");
        Assertions.assertThat(colours.getColour("yellow", 0.75f)).isNotNull().isNotEmpty().isEqualTo("#BFBF00");
        Assertions.assertThat(colours.getColour("green", 0.75f)).isNotNull().isNotEmpty().isEqualTo("#006000");
        Assertions.assertThat(colours.getColour("blue", 0.75f)).isNotNull().isNotEmpty().isEqualTo("#0000BF");
        Assertions.assertThat(colours.getColour("purple", 0.75f)).isNotNull().isNotEmpty().isEqualTo("#600060");

    }

    public void toJSONShouldReturnOriginalCouloursAndApplyBrightness() {
        // TODO returns loaded coulours as a JSON string and apply if provided the brightness value.
        Colours colours = new Colours();
        String jsonWithBrightness050 = colours.getJSON(0.50f);
        String jsonWithBrightness075 = colours.getJSON(0.75f);
        Assertions.assertThat(jsonWithBrightness050).isNotNull().isNotEmpty().isEqualTo(loadFixtureAsString("colours-b0.5.json"));
        Assertions.assertThat(jsonWithBrightness050).isNotNull().isNotEmpty().isEqualTo(loadFixtureAsString("colours-b0.75.json"));
    }

    private String loadFixtureAsString(String fixtureFilename) {
        StringBuffer json = new StringBuffer();
        try {
            final InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(fixtureFilename);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
            String strLine = null;
            while ((strLine = bufferedReader.readLine()) != null) {
                json.append(strLine);
            }
        } catch (RuntimeException | IOException e) {
            throw new RuntimeException(e);
        }
        return json.toString();
    }


}
