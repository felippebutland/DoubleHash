package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{
        int key;
        DataItem dataItem;
        int size, n;

        System.out.println("Insira o tamanho da tabela hash: ");
        size = getInt();
        System.out.println("Insira o número inicial de itens: ");
        n = getInt();

        HashTable hashTable = new HashTable(size);

        for(int i = 0; i < n; i++){
            key = (int)(Math.random() * 2 * size);
            dataItem = new DataItem(key);
            hashTable.insert(key, dataItem);
        }

        while (true){
            System.out.println("Digite a primeira letra");
            System.out.println("show, insert, delete, find: ");
            char choice = getChar();
            switch (choice){
                case 's':
                    hashTable.displayTable();
                    break;
                case 'i':
                    System.out.println("Insira o valor-chave a ser inserido: ");
                    key = getInt();
                    dataItem = new DataItem(key);
                    hashTable.insert(key, dataItem);
                    break;
                case 'd':
                    System.out.println("Insira o valor-chave para excluir: ");
                    key = getInt();
                    hashTable.delete(key);
                    break;
                case 'f':
                    System.out.println("Insira o valor-chave para pesquisar: ");
                    key = getInt();
                    dataItem = hashTable.find(key);
                    if(dataItem != null)
                        System.out.println("Encontrado " + key);
                    else
                        System.out.println("Não encontrado " + key);
                    break;
                default:
                    System.out.println("Entrada inválida");
            }
        }
    }
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException{
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException{
        String s = getString();
        return Integer.parseInt(s);
    }

}