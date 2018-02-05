package id.dev.septiyadi.locapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

public class accessdataActivity extends AppCompatActivity {

    TextView getNameFolder, getLinkFolder;
    ImageView getIconFolder;
    WebView wView;
    WebSettings setWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accessdata);

        wView = (WebView)findViewById(R.id.idWeb);
        getNameFolder = (TextView)findViewById(R.id.tvgetFOLDER);
        getLinkFolder = (TextView)findViewById(R.id.tvgetLINK);
        getIconFolder = (ImageView)findViewById(R.id.ivgetPIC);

        Bundle getDATAs = getIntent().getExtras();

        String getNMFLD = getDATAs.getString("FLD");
        String getLNK = getDATAs.getString("LNK");
        Integer getICN = getDATAs.getInt("PCN");

        getNameFolder.setText(getNMFLD);
        getLinkFolder.setText(getLNK);
        getIconFolder.setImageResource(getICN);

        setWeb = wView.getSettings();
        setWeb.setJavaScriptEnabled(true);
        wView.setWebViewClient(new WebViewClient());
        wView.loadUrl(getLNK);


        System.out.println("Data yang diterima 1. " + getNMFLD + ", 2. " + getLNK + ", 3. " + getICN);
    }
}
