import java.util.Scanner;

// Метод для шифрования текста
public static String encrypt(String text, int shift) {
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < text.length(); i++) {
        char ch = text.charAt(i);

        // Шифруем только буквы
        if (Character.isLetter(ch)) {
            char base = Character.isLowerCase(ch) ? 'a' : 'A';
            ch = (char) ((ch - base + shift) % 26 + base);
        }
        result.append(ch);
    }
    return result.toString();
}

        // Метод для расшифрования текста
        public static String decrypt(String text, int shift) {
            // Для расшифрования используем отрицательное смещение
            return encrypt(text, 26 - shift);
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String choice="";
            System.out.print("Введите текст для шифрования: ");
            String text = scanner.nextLine();
            System.out.print("Введите смещение (число): ");
            int shift = scanner.nextInt();
            do{
                Scanner choiceScanner = new Scanner(System.in);
                System.out.println("Введите действие зашифровать/расшифровать/заменить текст/заменить ключ/закончить: ");
                choice = choiceScanner.nextLine();
                switch (choice)
                {
                    case "зашифровать":
                        String encryptedText = encrypt(text, shift);
                        System.out.println("Зашифрованный текст: " + encryptedText);
                        break;
                    case "расшифровать":
                        String decryptedText = decrypt(text, shift);
                        System.out.println("Расшифрованный текст: " + decryptedText);
                        break;
                    case "заменить текст":
                        Scanner textScanner = new Scanner(System.in);
                        System.out.println("Введите текст для шифрования: ");
                        text = textScanner.nextLine();
                        break;
                    case "заменить ключ":
                        Scanner shiftTextScanner = new Scanner(System.in);
                        System.out.println("Введите смещение (число): ");
                        shift = shiftTextScanner.nextInt();
                        break;
                }

            }while(!choice.equals("закончить"));
            scanner.close();

        }