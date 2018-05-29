package moim.prjmoim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Join extends AppCompatActivity {

    EditText etId1, etPwd1, etPwdCheck1, etName1, etPhone1, etEmail1;
    Button btCheck1, btJoin2, btCancel1;
    String sId1, sPwd1, sPwdCheck1, sName1, sPhone1, sEmail1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);

        etId1 = (EditText) findViewById(R.id.etId1);
        etPwd1 = (EditText) findViewById(R.id.etPwd1);
        etPwdCheck1 = (EditText) findViewById(R.id.etPwdCheck1);
        etName1 = (EditText) findViewById(R.id.etName1);
        etPhone1 = (EditText) findViewById(R.id.etPhone1);
        etEmail1 = (EditText) findViewById(R.id.etE_mail1);

        btJoin2 = (Button) findViewById(R.id.btJoin2);
        btJoin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                dataInsert();
            }
        });
    }

    private void dataInsert() {
        new Thread() {
            @Override
            public void run() {

                try {

                    sId1 = etId1.getText().toString();
                    sPwd1 = etPwd1.getText().toString();
                    sName1 = etName1.getText().toString();
                    sPhone1 = etPhone1.getText().toString();
                    sEmail1 = etEmail1.getText().toString();

                    URL setURL = new URL("Http://172.16.14.29/insert.php/");
                    HttpURLConnection http;
                    http = (HttpURLConnection) setURL.openConnection();
                    http.setDefaultUseCaches(false);
                    http.setDoInput(true);
                    http.setRequestMethod("POST");
                    http.setRequestProperty("content-type", "application/x-www-form-urlencoded");
                    StringBuffer buffer = new StringBuffer();
                    buffer.append("name").append("=").append(sId1).append("/").append(sPwd1).append("/").append(sName1).append("/").append(sPhone1).append("/").append(sEmail1).append("/");
                    OutputStreamWriter
                            outStream = new OutputStreamWriter(http.getOutputStream(), "euc-kr");
                    outStream.write(buffer.toString());
                    outStream.flush();
                    InputStreamReader tmp = new InputStreamReader(http.getInputStream(), "euc-kr");
                    final BufferedReader redear = new BufferedReader(tmp);

                    String data;
                    data = redear.readLine();
                    Log.e("RECV DATA", data);

                } catch (Exception e) {
                    Log.e("", "", e);
                }
            }
        }.start();
    }
}




