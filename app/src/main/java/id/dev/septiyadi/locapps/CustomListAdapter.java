package id.dev.septiyadi.locapps;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by septiyadi on 05/02/18.
 */

public class CustomListAdapter extends ArrayAdapter<String>{
    private final Activity contex;
    private final String[] dataFOLDER;
    private final String[] dataLINK;
    private final Integer[] picDATA;

    public CustomListAdapter(Activity contex, String[] dataFOLDER, String[] dataLINK, Integer[] picDATA){
        super(contex, R.layout.item_list, dataFOLDER);

        this.contex = contex;
        this.dataFOLDER = dataFOLDER;
        this.dataLINK = dataLINK;
        this.picDATA = picDATA;
    }

    public View getView(int posisi, View view, ViewGroup parent){
        LayoutInflater inflater = contex.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.item_list, null, true);

        TextView nmFolder = (TextView)rowView.findViewById(R.id.txFolder);
        TextView almtLink = (TextView)rowView.findViewById(R.id.txLink);
        ImageView icnFind = (ImageView)rowView.findViewById(R.id.icLink);

        nmFolder.setText(dataFOLDER[posisi]);
        almtLink.setText(dataLINK[posisi]);
        icnFind.setImageResource(picDATA[posisi]);

        return rowView;

    }
}
