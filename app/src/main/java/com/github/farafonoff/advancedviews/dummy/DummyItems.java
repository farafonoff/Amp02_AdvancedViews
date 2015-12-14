package com.github.farafonoff.advancedviews.dummy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Artem_Farafonov on 12/14/2015.
 */
public class DummyItems {

    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    static String words = "abandoned\n" +
            "able\n" +
            "absolute\n" +
            "adorable\n" +
            "adventurous\n" +
            "academic\n" +
            "acceptable\n" +
            "acclaimed\n" +
            "accomplished\n" +
            "accurate\n" +
            "aching\n" +
            "acidic\n" +
            "acrobatic\n" +
            "complex\n" +
            "complicated\n" +
            "composed\n" +
            "concerned\n" +
            "concrete\n" +
            "confused\n" +
            "conscious\n" +
            "considerate\n" +
            "constant\n" +
            "content\n" +
            "conventional\n" +
            "cooked\n" +
            "cool\n" +
            "cooperative";

    static {
        String[] a_words = words.split("[\n ]");
        for(String word: a_words) {
            ITEMS.add(new DummyItem("http://loremflickr.com/100/100/"+word, word));
        }
    }

    public static class DummyItem {
        DummyItem(String uri, String word) {
            this.imageUri = uri;
            this.word = word;
        }
        String imageUri;
        String word;

        public String getWord() {
            return word;
        }

        public String getImageUri() {

            return imageUri;
        }
    }
}
