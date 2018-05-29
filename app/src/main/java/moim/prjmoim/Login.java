package moim.prjmoim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    EditText etId2, etPwd2;
    Button btLogin2, btFindById1, btFindByPwd1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        etId2 = findViewById(R.id.etId2);
        etPwd2 = findViewById(R.id.etPwd2);

        btLogin2 = findViewById(R.id.btLogin2);
        btLogin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btFindById1 = findViewById(R.id.btFindById1);
        btFindById1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FindById.class);
                startActivity(intent);
            }
        });

        btFindByPwd1 = findViewById(R.id.btFindByPwd1);
        btFindByPwd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FindByPwd.class);
                startActivity(intent);
            }
        });
    }
}
