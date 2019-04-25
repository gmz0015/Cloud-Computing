import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

public class testAccountAPI{

    public static void main(String[] args) {
        System.out.println(sendGetRequest());
        System.out.println(sendPostRequest());
    }

    public static String sendGetRequest() {
        String urlParam ="http://localhost:9527/api/account/balance/345897325";

        URLConnection con = null;

        BufferedReader buffer = null;
        StringBuffer resultBuffer = null;

        try {
            URL url = new URL(urlParam);
            con = url.openConnection();

            con.setRequestProperty("Content-Type", "text/plain;charset=GBK");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setUseCaches(false);
            // get response stream
            InputStream inputStream = con.getInputStream();
            // convert stream into string
            resultBuffer = new StringBuffer();
            String line;
            buffer = new BufferedReader(new InputStreamReader(inputStream, "GBK"));
            while ((line = buffer.readLine()) != null) {
                resultBuffer.append(line);
            }
            return resultBuffer.toString();

        }catch(Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    public static String sendPostRequest() {
        String urlParam ="http://localhost:9527/api/account/transfer";

        URLConnection con = null;
        PrintWriter out = null;
        BufferedReader buffer = null;
        StringBuffer resultBuffer = null;

        try {
            URL url = new URL(urlParam);
            con = url.openConnection();

            con.setRequestProperty("accept", "*/*");
            // IMPORT !!!
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setUseCaches(false);
            // get output stream of URLConnection
            out = new PrintWriter(con.getOutputStream());
            // send post parameter
            out.print("fromUserId=345897325&toUserId=392849790&amount=5&appId=0");
            // flush
            out.flush();


            // get response stream
            InputStream inputStream = con.getInputStream();
            // convert stream into string
            resultBuffer = new StringBuffer();
            String line;
            buffer = new BufferedReader(new InputStreamReader(inputStream, "GBK"));
            while ((line = buffer.readLine()) != null) {
                resultBuffer.append(line);
            }
            return resultBuffer.toString();

        }catch(Exception e) {
            e.printStackTrace();
        }

        return "";
    }
}

