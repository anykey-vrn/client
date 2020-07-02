import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.Random;

public class SimpleServer {
    //Intellij Idea при длинной записи оператора сама будет выставлять переносы строк, нет необходимости нажимать Enter по середине записи строки.
    //String[] adList = {"Пример ответа сервера 1", " Пример ответа сервера 2", " Пример ответа сервера 3", " Пример ответа сервера 4" , " Пример ответа сервера 5", "Пример ответа сервера 6", "Пример ответа сервера 7"};
    public void go() {
        try {
            //Приложение будет отслеживать клиентские запросы на порту 5000 на том же компьютере, где выполняется данный код
            ServerSocket serverSock = new ServerSocket(5000);
            //Сервер входит в постоянный цикл, ожидая клиентских подключений
            while(true) {
                Socket sock = serverSock.accept();
                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                int[] advice = getMassive();//Заполним массив случайными значениями и сортируем его
                for (int i=0;i < advice.length;i++) {

                        writer.println(advice[i]);
                        System.out.println(advice[i]);
                  }
                writer.close();
                //System.out.println(advice);
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    } // Закрываем go
    private int[] getMassive() {
        int n, m;
        n = 5; //размер массива
        m = 5;
        Random rnd = new Random();
        int[][] arr = new int[n][m];
        for (int i=0;i < arr.length;i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = rnd.nextInt(10) + 1;
            }
        }
                int[] flat = new int[n * m];

                int ctr = 0;
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < m; l++) {
                        flat[ctr++] = arr[k][l];
                    }
                }

                Arrays.sort(flat);

        return flat;

    }

    public static void main(String[] args) {
        SimpleServer server = new SimpleServer();
        server.go();
    }
}
