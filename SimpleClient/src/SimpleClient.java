import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class SimpleClient {
    static ArrayList<String> go() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {// отлавливаем исключения
            Socket s = new Socket("127.0.0.1", 5000);
            InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);
            String str;
            while ((str=reader.readLine())!=null) {
                System.out.println("Пример строки: " + str);
                arrayList.add(str);
            }
            reader. close (); //Закрываем все потоки
        } catch(IOException ex) { //обрабатываем исключение ввода/вывода
            ex.printStackTrace();
        }
        return arrayList;
    }
    public static void main(String[] args) {
        SimpleClient client = new SimpleClient();
        client.go();
    }
}
