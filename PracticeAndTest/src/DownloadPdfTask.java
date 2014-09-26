

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

public class DownloadPdfTask extends Task {

    private String server = "http://localhost:1975";

    private String document;

    private String file;

    private Map<String, String> parameters = new HashMap<String, String>();

    public void setServer(String server) {
        this.server = server;
    }

    public void setUserId(String userid) {
        parameters.put("userid", userid);
    }

    public void setPassword(String password) {
        parameters.put("password", password);
    }

    public void setFile(String file) {
        this.file = file;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    @Override
    public void execute() throws BuildException {
        try {
            download(login());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String login() throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(server + "/r/signon/login").openConnection();
        connection.setInstanceFollowRedirects(false);
        connection.setDoOutput(true);
        OutputStreamWriter wr = null;
        try {
            wr = new OutputStreamWriter(connection.getOutputStream());
            wr.write(getParameters());
            wr.flush();
        } finally {
            if (wr != null) {
                wr.close();
            }
        }
        String cookie = connection.getHeaderField("Set-Cookie");
        return cookie.substring(cookie.indexOf("=") + 1, cookie.indexOf(";"));
    }

    private void download(String sessionId) throws IOException {
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        try {
            URLConnection connection = open(sessionId);
            in = new BufferedInputStream(connection.getInputStream());
            out = new BufferedOutputStream(new FileOutputStream(file));
            int length = 0;
            byte[] buffer = new byte[1024];
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    private URLConnection open(String sessionId) throws IOException {
//        URLConnection result = new URL(server + "/r/pdf/download/" + document).openConnection();
    	URLConnection result = new URL(server + "/" + document).openConnection();
        result.setRequestProperty("Cookie", "JSESSIONIDR=" + sessionId);
        return result;
    }

    private String getParameters() throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        for (Entry<String, String> each : parameters.entrySet()) {
            if (result.length() > 0) {
                result.append("&");
            }
            result.append(encode(each.getKey()) + "=" + encode(each.getValue()));
        }
        return result.toString();
    }

    private String encode(String value) throws UnsupportedEncodingException {
        return URLEncoder.encode(value, "UTF-8");
    }

    public static void main(String[] args) {
        DownloadPdfTask task = new DownloadPdfTask();
        task.setServer("http://docs.tobesoft.com");
        task.setUserId("server");
        task.setPassword("0701");
//        task.setDocument("developer_guide_nexacro_14_ko.pdf");
//        task.setFile("developer_guide_nexacro_14_ko.pdf");http://docs.tobesoft.com/user_manuel_x-up.pdf
        task.setDocument("user_manuel_x-up.pdf");
        task.setFile("user_manuel_x-up.pdf");
        task.execute();
        // http://docs.tobesoft.com/developer_guide_nexacro_14_ko.pdf
    	// http://docs.tobesoft.com/user_manuel_x-up.pdf
        // http://docs.tobesoft.com/developer_guide_x-push.pdf
    }

}