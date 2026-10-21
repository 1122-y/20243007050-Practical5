package com.example.practicalfive;

/**
 * Regular (non-Activity) helper class. Holds the single source of truth for
 * municipality validation and normalisation, so MainActivity and Municipality
 * share exactly the same logic instead of duplicating it.
 */
public class TextProcessor {

    /**
     * @param municipality raw user input, may be null or mixed case.
     * @return the correctly capitalised canonical name ("Beijing", "Shanghai",
     *         "Tianjin" or "Chongqing"), or {@code null} when the input is
     *         null, blank, or not one of the four supported municipalities.
     */
    public static String processMunicipality(String municipality) {
        if (municipality == null || municipality.trim().isEmpty()) {
            return null;
        }

        switch (municipality.trim().toLowerCase()) {
            case "beijing":
                return "Beijing";
            case "shanghai":
                return "Shanghai";
            case "tianjin":
                return "Tianjin";
            case "chongqing":
                return "Chongqing";
            default:
                return null;
        }
    }
}
