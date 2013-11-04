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

    private Map<String, int[]> coloursRGB = new HashMap<>();

    public Colours() {
        StringBuffer json = new StringBuffer();
        loadJSON(json);
        removeLeadingTailingCurlyBrackets(json);
        buildMap(json);
    }

    public Map<String, int[]> getColoursRGB() {
        return coloursRGB;
    }

    private void loadJSON(StringBuffer json) {
        try {
            final InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("colours.json");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
            String strLine = null;
            while ((strLine = bufferedReader.readLine()) != null) {
                json.append(strLine);
            }
        } catch (RuntimeException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void buildMap(StringBuffer json) {
        StringTokenizer tokenizer = new StringTokenizer(json.toString(), ",");
        String keyValtoken;
        while (tokenizer.hasMoreTokens()) {
            keyValtoken = tokenizer.nextToken();
            final StringTokenizer kvTokenizer = new StringTokenizer(keyValtoken, ":");
            coloursRGB.put(kvTokenizer.nextToken(), convertToRGB(kvTokenizer.nextToken()));
        }
    }

    private void removeLeadingTailingCurlyBrackets(StringBuffer json) {
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
        return null;
    }
}
