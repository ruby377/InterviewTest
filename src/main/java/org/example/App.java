package org.example;


public class App {
    public String reduceString(String input) {
        if (input == null || input.length() < 3) {
            return input;
        }

        var sb = new StringBuilder();
        var count = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                if (count < 3) {
                    sb.append(String.valueOf(input.charAt(i - 1)).repeat(count));
                }
                count = 1;
            }

            if (i == input.length() - 1) {
                if (count < 3) {
                    sb.append(String.valueOf(input.charAt(i)).repeat(count));
                }
            }
        }

        var reduced = sb.toString();
        System.out.println(reduced);
        return reduced.length() == input.length() ? reduced : reduceString(reduced);
    }

    public String reduceStringAdvanced(String input) {
        if (input == null || input.length() < 3) {
            System.out.println(input);
            return input;
        }

        var sb = new StringBuilder();
        var count = 1;

        for (var i = 1; i < input.length(); i++) {
            var s = String.valueOf(input.charAt(i - 1));
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                if (count < 3) {
                    sb.append(s.repeat(count));
                } else {
                    var prevChar = (char) (input.charAt(i - 1) - 1);
                    if (prevChar >= 'a' && prevChar <= 'z') {
                        sb.append(prevChar);
                        System.out.printf("%s, %s is replaced by %s%n", sb + input.substring(i), s.repeat(count), prevChar);
                    }
                }
                count = 1;
            }

            if (i == input.length() - 1) {
                if (count < 3) {
                    sb.append(String.valueOf(input.charAt(i)).repeat(count));
                } else {
                    var prevChar = (char) (input.charAt(i) - 1);
                    if (prevChar >= 'a' && prevChar <= 'z') {
                        sb.append(prevChar);
                        System.out.printf("%s, %s is replaced by %s%n", sb + input.substring(i), s.repeat(count), prevChar);
                    }
                }
            }
        }

        var reduced = sb.toString();
        if (reduced.length() == input.length()) {
            System.out.println(reduced);
            return reduced;
        } else {
            return reduceStringAdvanced(reduced);
        }
    }
}