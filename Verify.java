
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;

public class Verify {

    public static void verify() throws IOException {
        int chances = 6;
        int i, j;
        String attempt = "";
        boolean exists = false;

        ConstructorsTermo ct = new ConstructorsTermo();
        ct.selectedWord = Process.raffle();
        //System.out.println(constructors.selectedWord);
        ct.userWord = "";
        JOptionPane.showMessageDialog(null, "\n COMO JOGAR:\n Você tem 6 tentativas \n V = A letra está na posição correta \n"
                + " A = A letra está na posição errada \n - = A letra não está na palavra");
        
        while (chances > 0) {
            ct.userWord= JOptionPane.showInputDialog(attempt + "\nDigite sua tentativa: ");
            ct.userWord = Process.treatUser(ct.userWord);
            List<String> vocabularyList = Process.reader();
            if (ct.userWord.length() == ct.selectedWord.length()) {
                char[] arrayUserWord = ct.userWord.toCharArray();
                char[] arraySelectedWord = ct.selectedWord.toCharArray();

                if (vocabularyList.contains(ct.userWord.toUpperCase())) {
                    for (i = 0; i < 5; i++) {
                        if (arrayUserWord[i] == arraySelectedWord[i]) {
                            attempt += "V";
                        } else {
                            for (j = 0; j < 5; j++) {
                                if (arrayUserWord[i] == arraySelectedWord[j]) {
                                    exists = true;
                                    break;
                                } else {
                                    exists = false;
                                }
                            }
                            if (exists == true) {
                                attempt += "A";
                            } else {
                                attempt += "-";
                            }
                        }
                    }
                    chances--;
                    attempt += " -> " + ct.userWord + "\n";
                } else {
                    JOptionPane.showMessageDialog(null, "Palavra inexistente.");
                    ct.userWord = ""; //pra não exibir caso seja inexistente
                }
            } else {
                JOptionPane.showMessageDialog(null, "Insira uma palavra com 5 letras.");
            }

            if (ct.userWord.equals(Process.treatWord(ct.selectedWord))) {
                JOptionPane.showMessageDialog(null, "Parabéns! Você acertou!" + "\n"
                        + "Palavra = " + ct.selectedWord);
                chances = 0;
            }
        }
        if (!ct.userWord.equals(Process.treatWord(ct.selectedWord))) {
            JOptionPane.showMessageDialog(null, "Poxa! Você errou!" + "\n"
                    + "A palavra correta era " + ct.selectedWord);
        }
    }
}
