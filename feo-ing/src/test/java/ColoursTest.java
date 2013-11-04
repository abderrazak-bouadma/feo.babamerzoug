import com.ing.Colours;
import org.fest.assertions.Assertions;
import org.fest.assertions.MapAssert;
import org.junit.Test;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: merzoug
 * Date: 11/4/13
 * Time: 1:40 PM
 */
public class ColoursTest {

    @Test
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
        Assertions.assertThat(colours.getColour("white",1)).isNotNull().isNotEmpty().isEqualTo("#FFFFFF");
        Assertions.assertThat(colours.getColour("white",0.75f)).isNotNull().isNotEmpty().isEqualTo("#FFFFFA");
        Assertions.assertThat(colours.getColour("white",0.5f)).isNotNull().isNotEmpty().isEqualTo("#FFFFFB");
        Assertions.assertThat(colours.getColour("white",1.1f)).isNotNull().isNotEmpty().isEqualTo("#FFFFFC");
    }

    public void toJSONShouldReturnOriginalCouloursAndApplyBrightness() {
        // TODO returns loaded coulours as a JSON string and apply if provided the brightness value.
    }


}
