package id.dev.septiyadi.locapps;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class listdataActivity extends AppCompatActivity {

    ListView lstDATA;
    TextView getIPnya;
    AlertDialog notifikasi;
    AlertDialog.Builder builder;

    String[] dataFOLDER = {
            "Folder Galery Familiy",
            "Folder Edukasi",
            "Folder Kantor",
            "Folder Kegiatan",
            "Folder Kesehatan",
            "Folder Keuangan",
            "Folder Liburan",
            "Folder Materi Persentasi",
            "Folder Pelatihan",
            "Folder Perkuliahan",
            "Folder Plan List",
            "Folder Portofolio",
            "Folder Pribadi",
            "Folder Project",
            "Folder Tim Developer",
            "Folder Transfer"
    };

    Integer[] picDATA = {
            R.drawable.galery,
            R.drawable.edukasi,
            R.drawable.kantor,
            R.drawable.kegiatan,
            R.drawable.kesehatan,
            R.drawable.keuangan,
            R.drawable.liburan,
            R.drawable.persentasi,
            R.drawable.pelatihan,
            R.drawable.perkuliahan,
            R.drawable.planlist,
            R.drawable.portofolio,
            R.drawable.pribadi,
            R.drawable.project,
            R.drawable.timdev,
            R.drawable.transfer
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listdata);


        getIPnya = (TextView)findViewById(R.id.tvgetIP);
        lstDATA = (ListView)findViewById(R.id.idList);

        Bundle tempkirimandata = getIntent().getExtras();
        String terima_iptarget = tempkirimandata.getString("IP");

        getIPnya.setText("HTTPS://" + terima_iptarget);
        System.out.println("Data Kiriman: " + terima_iptarget);

        final String ipTEMP = terima_iptarget;

        final String[] dataLINK = {
                "http://" + ipTEMP + "/FIle%20Galeri%20Family/",
                "http://" + ipTEMP + "/File%20Edukasi/",
                "http://" + ipTEMP + "/File%20Kantor/",
                "http://" + ipTEMP + "/File%20Kegiatan/",
                "http://" + ipTEMP + "/File%20Kesehatan/",
                "http://" + ipTEMP + "/File%20Keuangan/",
                "http://" + ipTEMP + "/File%20Liburan/",
                "http://" + ipTEMP + "/File%20Materi%20Persentasi/",
                "http://" + ipTEMP + "/File%20Pelatihan/",
                "http://" + ipTEMP + "/File%20Perkuliahan/",
                "http://" + ipTEMP + "/File%20Plan%20List/",
                "http://" + ipTEMP + "/File%20Portofolio/",
                "http://" + ipTEMP + "/File%20Pribadi/",
                "http://" + ipTEMP + "/File%20Project/",
                "http://" + ipTEMP + "/File%20Tim%20Developer/",
                "http://" + ipTEMP + "/File%20Transfer/"
        };

        CustomListAdapter AdapterListView = new CustomListAdapter(listdataActivity.this, dataFOLDER, dataLINK, picDATA);
        lstDATA.setAdapter(AdapterListView);

        lstDATA.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int position, long l) {

                String linkDATAConvert = dataLINK.toString();

                builder = new AlertDialog.Builder(listdataActivity.this);

                builder
                        .setTitle("Pilihan Anda " + dataFOLDER[position])
                        .setMessage("Link dari folder ini adalah " + linkDATAConvert + ", tekan Next untuk tampilkan.")
                        .setPositiveButton("Next", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                String nmFolder = dataFOLDER[position];
                                String almLink = dataLINK[position];
                                Integer picIcon = picDATA[position];

                                Bundle kirim = new Bundle();

                                kirim.putString("FLD", nmFolder);
                                kirim.putString("LNK", almLink);
                                kirim.putInt("PCN", picIcon);

                                Intent sent2access = new Intent(listdataActivity.this, accessdataActivity.class);
                                sent2access.putExtras(kirim);
                                startActivity(sent2access);

                                System.out.println("Data yang dikirim 1. " + nmFolder + ", 2. " + almLink + ", 3. " + picIcon);

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                notifikasi = builder.create();
                notifikasi.show();

            }
        });
    }
}
