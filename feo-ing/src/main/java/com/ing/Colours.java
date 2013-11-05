package com.ing;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: merzoug
 * Date: 11/4/13
 * Time: 2:05 PM
 */
public class Colours {

    private static final String JSON_COLOURS_SOURCE_FILENAME = "colours.json";
    private final Map<String, int[]> coloursRGB = new HashMap<>();
    private final StringBuffer json = new StringBuffer();

    public Colours() {
        loadJSON();
        cleanJsonString();
        buildMap();
    }

    public Map<String, int[]> getColoursRGB() {
        return coloursRGB;
    }

    private void loadJSON() {
        try {
            final InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(JSON_COLOURS_SOURCE_FILENAME);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
            String oneLine;
            while ((oneLine = bufferedReader.readLine()) != null) {
                json.append(oneLine);
            }
        } catch (RuntimeException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void buildMap() {
        StringTokenizer tokenizer = new StringTokenizer(json.toString(), ",");
        String keyValToken;
        while (tokenizer.hasMoreTokens()) {
            keyValToken = tokenizer.nextToken();
            final StringTokenizer kvTokenizer = new StringTokenizer(keyValToken, ":");
            String colorName = kvTokenizer.nextToken();
            colorName = StringUtils.deleteWhitespace(colorName);
            colorName = StringUtils.remove(colorName, "\"");
            final String colorHEXValue = kvTokenizer.nextToken();
            coloursRGB.put(colorName, convertToRGB(colorHEXValue));
        }
    }

    private void cleanJsonString() {
        json.replace(0, 1, "");
        json.replace(json.length() - 1, json.length(), "");
    }

    private int[] convertToRGB(String hex) {
        final int[] rgb = new int[3];
        rgb[0] = Integer.parseInt(cleanHex(hex).substring(0, 2), 16);
        rgb[1] = Integer.parseInt(cleanHex(hex).substring(2, 4), 16);
        rgb[2] = Integer.parseInt(cleanHex(hex).substring(4, 6), 16);
        return rgb;
    }

    private String cleanHex(String hex) {
        final String s = StringUtils.deleteWhitespace(hex);
        return s.contains("#") ? s.substring(2, s.length() - 1) : s;
    }

    public String getColour(String colorName, float brightness) {
        int[] copyColor = copyColorTab(colorName);
        if (copyColor != null) {
            if (brightness < 1f && brightness >= 0f) {
                applyBrightness(brightness, copyColor);
            }
            return toHEX(copyColor);
        }
        return null;
    }

    private String toHEX(int[] copyColor) {
        final int r = copyColor[0];
        final int g = copyColor[1];
        final int b = copyColor[2];
        return String.format("#%02x%02x%02x", r, g, b).toUpperCase();
    }

    private void applyBrightness(float brightness, int[] copyColor) {
        copyColor[0] = (int) (copyColor[0] * brightness);
        copyColor[1] = (int) (copyColor[1] * brightness);
        copyColor[2] = (int) (copyColor[2] * brightness);
    }

    private int[] copyColorTab(String colorName) {
        final int[] originaleColor = coloursRGB.get(colorName);
        int[] copyColor = new int[3];
        copyColor[0] = originaleColor[0];
        copyColor[1] = originaleColor[1];
        copyColor[2] = originaleColor[2];
        return copyColor;
    }

    public String getJSON(float brightness) {
        Map<String, int[]> result = new HashMap<>();
        if (brightness >= 0 && brightness <= 1) {
            for (Map.Entry<String, int[]> entry : coloursRGB.entrySet()) {
                int[] t = new int[3];
                t[0] = entry.getValue()[0];
                t[1] = entry.getValue()[1];
                t[2] = entry.getValue()[2];
                applyBrightness(brightness, t);
                result.put(entry.getKey(), t);
            }
        } else {
            result.putAll(coloursRGB);
        }
        return buildJSONString(result);
    }

    private String buildJSONString(Map<String, int[]> result) {
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        for (Map.Entry<String, int[]> entry : result.entrySet()) {
            sb.append("\"" + entry.getKey() + "\"");
            sb.append(":");
            sb.append("\"" + toHEX(entry.getValue()) + "\"");
            sb.append(",");
        }
        // removes tailing period and adds last curly bracket
        sb.deleteCharAt(sb.length() - 1).append("}");
        return sb.toString();
    }
}
