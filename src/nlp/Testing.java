package nlp;

import java.util.Arrays;

class MyString{
    private char[] characters;

    public MyString(String input) {
        this.characters = input.toCharArray();
    }
    public int length() {
        return characters.length;
    }
    public char charAt(int index) {
        if (index < 0 || index >= characters.length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return characters[index];
    }
    public boolean equals(MyString other) {
        if (other == null || characters.length != other.length()) {
            return false;
        }
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] != other.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public MyString toLowerCase() {
        char[] result = new char[characters.length];
        for (int i = 0; i < characters.length; i++) {
            result[i] = Character.toLowerCase(characters[i]);
        }
        return new MyString(new String(result));
    }
    public MyString toUpperCase() {
        char[] result = new char[characters.length];
        for (int i = 0; i < characters.length; i++) {
            result[i] = Character.toUpperCase(characters[i]);
        }
        return new MyString(new String(result));
    }
    public MyString substring(int startIndex) {
        return substring(startIndex, characters.length);
    }
    public MyString substring(int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex > characters.length || startIndex > endIndex) {
            throw new IndexOutOfBoundsException("Invalid start or end index");
        }
        char[] result = new char[endIndex - startIndex];
        System.arraycopy(characters, startIndex, result, 0, endIndex - startIndex);
        return new MyString(new String(result));
    }
    public int patternMatch(MyString pattern) {
        if (pattern == null || pattern.length() == 0) {
            return -1;
        }

        for (int i = 0; i <= characters.length - pattern.length(); i++) {
            boolean found = true;
            for (int j = 0; j < pattern.length(); j++) {
                if (characters[i + j] != pattern.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public String toString() {
//        return "MyString{" +
//                "characters=" + Arrays.toString(characters) +
//                '}';
        return new String(characters);
    }
}
public class Testing {
    public static void main(String[] args) {
        MyString myString = new MyString("hello WORLD");
        MyString myString1 = new MyString("WORLD");
        System.out.println(myString.toString());
        System.out.println(myString.length());
        System.out.println(myString.charAt(1));
        System.out.println(myString.equals(myString1));
        System.out.println(myString.toUpperCase());
        System.out.println(myString1.toLowerCase());
        System.out.println(myString.substring(2));
        System.out.println(myString.patternMatch(myString1));
    }
}
