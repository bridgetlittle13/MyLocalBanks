package sg.edu.rp.c346.id22013272.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvdbs;
    TextView tvocbc;
    TextView tvuob;
    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvdbs = findViewById(R.id.textViewDBS);
        tvocbc = findViewById(R.id.textViewOCBC);
        tvuob = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvdbs);
        registerForContextMenu(tvocbc);
        registerForContextMenu(tvuob);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 0, 0, "website");
        menu.add(0, 1, 1, "Contact the bank");
        menu.add(0, 2, 2, "Toggle Favourite");
        if (v == tvdbs) {
            wordClicked = "DBS";
        } else if (v == tvocbc) {
            wordClicked = "OCBC";
        } else if (v == tvuob) {
            wordClicked = "UOB";
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) {
                Intent intentdbsweb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg/index/default.page"));
                startActivity(intentdbsweb);
            } else if (item.getItemId() == 1) {
                Intent intentdbsph = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18001111111"));
                startActivity(intentdbsph);
            } else if (item.getItemId() == 2) {
                if (tvdbs.getCurrentTextColor() == Color.BLACK) {
                    tvdbs.setTextColor(Color.RED);
                } else {
                    tvdbs.setTextColor(Color.BLACK);
                }
                return true;
            }
        } else if (wordClicked.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0) {
                Intent intentocbcweb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com/group/gateway.page"));
                startActivity(intentocbcweb);
            } else if (item.getItemId() == 1) {
                Intent intentocbcph = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18003633333"));
                startActivity(intentocbcph);
            } else if (item.getItemId() == 2) {
                if (tvocbc.getCurrentTextColor()==Color.BLACK) {
                    tvocbc.setTextColor(Color.RED);
                } else {
                    tvocbc.setTextColor(Color.BLACK);
                }
                return true;
            }
        } else if (wordClicked.equalsIgnoreCase("UOB")) {
            if (item.getItemId() == 0) {
                Intent intentuobweb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uobgroup.com/uobgroup/index.page"));
                startActivity(intentuobweb);
            } else if (item.getItemId() == 1) {
                Intent intentuobph = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18002222121"));
                startActivity(intentuobph);
            } else if (item.getItemId() == 2) {
                if (tvuob.getCurrentTextColor() == Color.BLACK) {
                    tvuob.setTextColor(Color.RED);
                } else {
                    tvuob.setTextColor(Color.BLACK);
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.EnglishSelection) {
            tvdbs.setText("DBS");
            tvocbc.setText("OCBC");
            tvuob.setText("UOB");
        } else if (id == R.id.ChineseSelection) {
            tvdbs.setText("星展银行");
            tvocbc.setText("华侨银行");
            tvuob.setText("大华银行");
        } else {
            tvdbs.setText("Error translation");
            tvocbc.setText("Error translation");
            tvuob.setText("Error translation");
        }
        return super.onOptionsItemSelected(item);
    }

}