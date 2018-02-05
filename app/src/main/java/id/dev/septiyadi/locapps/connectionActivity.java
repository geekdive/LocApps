package id.dev.septiyadi.locapps;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class connectionActivity extends AppCompatActivity {

    Button gotoListdata;
    AlertDialog alertMe;
    EditText getIP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);

        gotoListdata = (Button)findViewById(R.id.btnGotoList);
        getIP = (EditText)findViewById(R.id.edIP);

        gotoListdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String content = getIP.getText().toString();
                if (content.matches("")) {
                    Toast.makeText(connectionActivity.this, "Maaf! IP/DNS Kosong Bro!", Toast.LENGTH_SHORT).show();
                    getIP.requestFocus();
                    return;
                }

                AlertDialog.Builder build = new AlertDialog.Builder(connectionActivity.this);

                TextView  putView = (TextView)findViewById(R.id.tvPutIP);

                putView.setText("https://"+content+"/");


                build.setTitle("Peringatan!")
                        .setMessage("Apakah IP/DNS yang anda masukan https://"+content+"/ sudah benar & mengarah pada root folder?")
                        .setPositiveButton("Ya Benar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Bundle kirimKeListData = new Bundle();

                                kirimKeListData.putString("IP", content);

                                Intent kirim = new Intent(connectionActivity.this, listdataActivity.class);
                                kirim.putExtras(kirimKeListData);
                                startActivity(kirim);

                                System.out.println("Data yang dikirim: " + content);
                            }
                        })
                        .setNegativeButton("Ubah IP", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                getIP.requestFocus();
                            }
                        });
                alertMe = build.create();
                alertMe.show();
            }
        });

    }
}

