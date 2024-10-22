package com.example.wordcounter;

public class CounterHelper {

    // Metodas žodžiams skaičiuoti
    public int countWords(String text) {
        String trimmedText = text.trim();
        if (trimmedText.isEmpty()) {
            return 0;
        }
        return trimmedText.split("\\s+").length; // Žodžiai atskiriami tarpais
    }

    // Metodas simboliams skaičiuoti
    public int countCharacters(String text) {
        return text.length(); // Skaičiuojame visus simbolius
    }
}
