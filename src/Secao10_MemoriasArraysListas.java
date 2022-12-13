import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Secao10_MemoriasArraysListas {
        public static void main(String[] args) {

        /*
        Boxing
            É o processo de conversão de um objeto tipo valor para um objeto tipo referência compatível
            int x = 20;
            Integer obj = x;

        Unboxing
            É o processo de conversão de um objeto tipo referência para um objeto tipo valor compatíve
            int x = 20;
            Integer obj = x;
            int y = (int) obj;

         Wrapper classes
            • São classes equivalentes aos tipos primitivos
            • Boxing e unboxing é natural na linguagem
            • Uso comum: campos de entidades em sistemas de informação (IMPORTANTE!)
            • Pois tipos referência (classes) aceitam valor null e usufruem dos recursos OO
         */

            int x3 = 20;
            Integer obj2 = x3;
            System.out.println(obj2);
            int y = obj2 * 2;
            System.out.println(y);

            String[] vect = new String[] {"Maria", "Bob", "Alex"};
            System.out.println("Aula de Laço");
            for (int i=0; i< vect.length; i++) {
                System.out.println(vect[i]);
            }

            System.out.println("Aula de Laço");
            for (String obj : vect) {
                System.out.println(obj);
            }

            /*----------------------------------------------------------------------------------------------------------
            Lista é uma estrutura de dados:
                • Homogênea (dados do mesmo tipo)
                • Ordenada (elementos acessados por meio de posições)
                • Inicia vazia, e seus elementos são alocados sob demanda
                • Cada elemento ocupa um "nó" (ou nodo) da lista
            Tipo (interface): List ---> OU SEJA NÃO É UMA CLASSE É UMA INTERFACE!
                NÃo pode instanciar uma interface, então tem que colocar dentro de uma classe.
            Classes que implementam: ArrayList (+- se comporta como um vetor), LinkedList, etc.
            Vantagens:
                • Tamanho variável
                • Facilidade para se realizar inserções e deleções
            Desvantagens:
                • Acesso sequencial aos elementos

            Tamanho da lista: size()
            • Obter o elemento de uma posição: get(position)
            • Inserir elemento na lista: add(obj), add(int, obj)
            • Remover elementos da lista: remove(obj), remove(int), removeIf(Predicate)
            • Encontrar posição de elemento: indexOf(obj), lastIndexOf(obj)
            • Filtrar lista com base em predicado:
            List<Integer> result = list.stream().filter(x -> x > 4).collect(Collectors.toList());
            • Encontrar primeira ocorrência com base em predicado:
            Integer result = list.stream().filter(x -> x > 4).findFirst().orElse(null);
            • Assuntos pendentes:
            • interfaces
            • generics
            • predicados (lambda)
             */

            List<String> list = new ArrayList<>();
            //List<String> list = new List<>(); NÃO PODE FAZER ISSO POIS É UMA INTERFACE, ENTÃO PRECISA USAR UMA CLASSE
            // PRA INSTANCIAR
            System.out.println("\nAula de Listas");
            list.add("Maria");
            list.add("Alex");
            list.add("Bob");
            list.add("Anna");
            list.add(2, "Clara"); //inserir um novo elemento da posição 2 da lista, A lista começa com zero
            System.out.println(list.size()); //5
            for (String x2 : list) {
                System.out.println(x2); //Maria, Alex, Clara, Bob, Anna
            }
            System.out.println("\n--------------------- REMOVER DA LISTA");
            list.remove(1); //INDEX COMEÇA DE ZERO, ENTÃO ESSE REMOVE ALEX
            list.remove("Anna");
            //função lambda predicado: retorna V ou F
            list.removeIf(x2 -> x2.charAt(0) == 'M'); //remove maria, se tivessem mais com M removeria o restante
            for (String x2 : list) {
                System.out.println(x2);
            }
            System.out.println("--------------------- ENCONTRAR A POSIÇÃO DE UM ELEMENTO");
            System.out.println("Index of Bob: " + list.indexOf("Bob"));
            System.out.println("Index of Marco: " + list.indexOf("Marco")); //QUANDO NÃO ENCONTRA UM ELEMENTO RETORNA -1

            System.out.println("---------------------");
            list.add("Lorelai Gilmore");
            list.add("Rory Gilmore");
            list.add("Sookie St. James");
            list.add("Lane Kim");
            list.add("Michel Gerard");
            list.add("Luke Danes");
            list.add("Paris Geller");
            list.add("Babette Dell");
            List<String> result = list.stream().filter(x2 -> x2.charAt(0) == 'L').collect(Collectors.toList());
            //como o stream não é compatível com List precisa usar o collect
            for (String x2 : result) {
                System.out.println(x2); //Lorelai Gilmore, Lane Kim, Luke Danes
            }
            System.out.println("---------------------");
            String name = list.stream().filter(x2 -> x2.charAt(0) == 'L').findFirst().orElse(null);
            //retornar o primeiro da lista que tem L
            System.out.println(name); //Lorelai Gilmore

            /* MATRIZES ------------------------------------------------------------------------------------------------
             • Em programação, "matriz" é o nome dado a arranjos bidimensionais
            • Atenção: "vetor de vetores"
            • Arranjo (array) é uma estrutura de dados: • Homogênea (dados do mesmo tipo)
            • Ordenada (elementos acessados por meio de posições)
            • Alocada de uma vez só, em um bloco contíguo de memória
            • Vantagens:
            • Acesso imediato aos elementos pela sua posição
            • Desvantagens:
            • Tamanho fixo
            • Dificuldade para se realizar inserções e deleções
             */

            Scanner sc = new Scanner(System.in);

            System.out.println("\nEscreva a quantidade de linhas");
            int m = sc.nextInt();
            System.out.println("Escreva a quantidade de colunas");
            int n = sc.nextInt();
            int[][] mat = new int[m][n];

            for (int i=0; i<mat.length; i++) {
                for (int j=0; j<mat[i].length; j++) {
                    System.out.println("Escreva o número da matriz da linha " + i + " e coluna " + j + ":");
                    mat[i][j] = sc.nextInt();
                }
            }

            System.out.println("Escreva um dos números ditos acima");
            int x = sc.nextInt();

            for (int i=0; i<mat.length; i++) {
                for (int j=0; j<mat[i].length; j++) {
                    if (mat[i][j] == x) {
                        System.out.println("Position " + i + "," + j + ":");
                        if (j > 0) {
                            System.out.println("Left: " + mat[i][j-1]);
                        }
                        if (i > 0) {
                            System.out.println("Up: " + mat[i-1][j]);
                        }
                        if (j < mat[i].length-1) {
                            System.out.println("Right: " + mat[i][j+1]);
                        }
                        if (i < mat.length-1) {
                            System.out.println("Down: " + mat[i+1][j]);
                        }
                    }
                }
            }

            sc.close();
        }
}
