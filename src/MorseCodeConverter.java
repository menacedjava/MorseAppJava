import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MorseCodeConverter {

    private static final Map<Character, String> morseCode = new HashMap<>();
    private static final Map<String, Character> morseToChar = new HashMap<>();

    static {

        morseCode.put('A', ".-");
        morseCode.put('B', "-...");
        morseCode.put('C', "-.-.");
        morseCode.put('D', "-..");
        morseCode.put('E', ".");
        morseCode.put('F', "..-.");
        morseCode.put('G', "--.");
        morseCode.put('H', "....");
        morseCode.put('I', "..");
        morseCode.put('J', ".---");
        morseCode.put('K', "-.-");
        morseCode.put('L', ".-..");
        morseCode.put('M', "--");
        morseCode.put('N', "-.");
        morseCode.put('O', "---");
        morseCode.put('P', ".--.");
        morseCode.put('Q', "--.-");
        morseCode.put('R', ".-.");
        morseCode.put('S', "...");
        morseCode.put('T', "-");
        morseCode.put('U', "..-");
        morseCode.put('V', "...-");
        morseCode.put('W', ".--");
        morseCode.put('X', "-..-");
        morseCode.put('Y', "-.--");
        morseCode.put('Z', "--..");
        morseCode.put('1', ".----");
        morseCode.put('2', "..---");
        morseCode.put('3', "...--");
        morseCode.put('4', "....-");
        morseCode.put('5', ".....");
        morseCode.put('6', "-....");
        morseCode.put('7', "--...");
        morseCode.put('8', "---..");
        morseCode.put('9', "----.");
        morseCode.put('0', "-----");
        morseCode.put('.', ".-.-.-");
        morseCode.put(',', "--..--");
        morseCode.put('?', "..--..");
        morseCode.put('!', "-.-.--");
        morseCode.put(' ', "/");


        for (Map.Entry<Character, String> entry : morseCode.entrySet()) {
            morseToChar.put(entry.getValue(), entry.getKey());
        }
    }


    public static String textToMorse(String text) {
        StringBuilder morseBuilder = new StringBuilder();
        for (char c : text.toUpperCase().toCharArray()) {
            if (morseCode.containsKey(c)) {
                morseBuilder.append(morseCode.get(c)).append(" ");
            }
        }
        return morseBuilder.toString().trim();
    }


    public static String morseToText(String morse) {
        StringBuilder textBuilder = new StringBuilder();
        String[] morseWords = morse.split(" ");
        for (String morseLetter : morseWords) {
            if (morseToChar.containsKey(morseLetter)) {
                textBuilder.append(morseToChar.get(morseLetter));
            } else if (morseLetter.equals("/")) {
                textBuilder.append(" ");
            }
        }
        return textBuilder.toString();
    }

    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Morse alifbosi dasturi");
            System.out.println("1. Matnni Morse alifbosiga aylantirish");
            System.out.println("2. Morse alifbosini matnga aylantirish");
            System.out.print("Tanlovni kiriting (1 yoki 2): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Scannerni tozalash

            if (choice == 1) {
                System.out.print("Matnni kiriting: ");
                String input = scanner.nextLine();
                String morseResult = textToMorse(input);
                System.out.println("Morse alifbosiga aylantirilgan matn: " + morseResult);
            } else if (choice == 2) {
                System.out.print("Morse alifbosida matnni kiriting: ");
                String input = scanner.nextLine();
                String textResult = morseToText(input);
                System.out.println("Dekodlangan matn: " + textResult);
            } else {
                System.out.println("Noto'g'ri tanlov! Dastur yakunlanadi.");
                System.out.println("ok");
            }

            scanner.close();
        }
    }

