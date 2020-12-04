package main.day2;

public class Passwort {
    private final Integer low;
    private final Integer high;
    private final Character letter;
    private final String pw;

    public Passwort(Integer low, Integer high, String letter, String pw) {
        this.low = low;
        this.high = high;
        this.letter = letter.charAt(0);
        this.pw = pw;
    }

    public Passwort(String[] delimeters, String letter, String pw) {
        this.low = Integer.parseInt(delimeters[0]);
        this.high = Integer.parseInt(delimeters[1]);
        this.letter = letter.charAt(0);
        this.pw = pw;
    }

    boolean isValidPart1() {
        int counter = 0;
        for (Character x : pw.toCharArray()) {
            if (x.equals(letter)) {
                counter++;
            }
        }
        return (low <= counter && counter <= high);
    }

    boolean isValidPart2() {
        boolean letterAtLow = letter.equals(pw.toCharArray()[low - 1]);
        boolean letterAtHigh = letter.equals(pw.toCharArray()[high - 1]);
        if ((letterAtLow && !letterAtHigh) || (letterAtHigh && !letterAtLow)) {
            return true;
        }
        return false;
    }
}
