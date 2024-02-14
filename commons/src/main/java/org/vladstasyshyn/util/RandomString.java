package org.vladstasyshyn.util;

import org.springframework.stereotype.Component;


@Component
public class RandomString {
    private final static char[] ALPHABET = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    public String genarate() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            stringBuilder.append((int) (Math.random() * 10));
            stringBuilder.append(ALPHABET[(int) (Math.random() * ALPHABET.length)]);
        }

        return stringBuilder.toString();
    }
}
