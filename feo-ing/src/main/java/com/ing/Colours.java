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

            String colorName = kvTokenizer.nextToken();
            colorName = StringUtils.deleteWhitespace(colorName);
            colorName = StringUtils.remove(colorName, "\"");
            final String colorHEXValue = kvTokenizer.nextToken();
            coloursRGB.put(colorName, convertToRGB(colorHEXValue));
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
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < copyColor.length; i++) {
            int n = Integer.parseInt(String.valueOf(copyColor[i]), 10);
            System.out.println("1 ************** " + n);
            n = Math.max(0, Math.min(n, 255));
            System.out.println("2 ************** " + n);
            final String s = "0123456789ABCDEF";
            int a = s.charAt((n - n % 16) / 16) + s.charAt(n % 16);
            System.out.println("3************* " + a);
            System.out.println("--------------------" + Integer.valueOf(a));
            sb.append(a);
        }
        final String result = "#" + sb.toString();
        System.out.println(result);
        return result;
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
}
