
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;

public class Process {

    public static List<String> reader() throws FileNotFoundException, IOException {
        List<String> listWords = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\leopp\\OneDrive\\Área de Trabalho\\ProjetoTermo\\src\\dicionario.txt")));
            String line = br.readLine();
            while (line != null) {
                String[] lineWords = line.split("\n");
                for (String word : lineWords) {
                    if (word.length() == 5) {
                        listWords.add(treatWord(word));
                    }
                }
                line = br.readLine();
            }
            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("Erro ao encontrar arquivo: " + e);
        } catch (IOException e) {
            System.out.println("Erro na leitura de arquivo: " + e);
        }
        return listWords;
    }

    public static String raffle() throws IOException {
        List<String> raffled = reader();
        Collections.shuffle(raffled);
        String raffledWord = raffled.get(5);
        return raffledWord;
    }

    public static String treatWord(String raffledWord) {
        raffledWord = raffledWord.toUpperCase();
        raffledWord = raffledWord.replaceAll("[ÁÀÂÃ]", "A");
        raffledWord = raffledWord.replaceAll("[ÓÔÕ]", "O");
        raffledWord = raffledWord.replaceAll("[Ç]", "C");
        raffledWord = raffledWord.replaceAll("[ÉÊ]", "E");
        raffledWord = raffledWord.replaceAll("[Í]", "I");
        raffledWord = raffledWord.replaceAll("[Ú]", "U");
        return raffledWord;
    }

    public static String treatUser(String userWord) {
        userWord = userWord.toUpperCase();
        userWord = userWord.replaceAll("[ÁÀÂÃ]", "A");
        userWord = userWord.replaceAll("[ÓÔÕ]", "O");
        userWord = userWord.replaceAll("[Ç]", "C");
        userWord = userWord.replaceAll("[ÉÊ]", "E");
        userWord = userWord.replaceAll("[Í]", "I");
        userWord = userWord.replaceAll("[Ú]", "U");
        return userWord;
    }

}

