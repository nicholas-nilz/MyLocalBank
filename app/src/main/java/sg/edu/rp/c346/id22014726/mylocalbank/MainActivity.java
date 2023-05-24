package sg.edu.rp.c346.id22014726.mylocalbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView DBS;
    TextView OCBC;
    TextView UOB;
    TextView Title;
    String wordClicked = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBS = findViewById(R.id.DBS);
        OCBC = findViewById(R.id.OCBC);
        UOB = findViewById(R.id.UOB);
        Title = findViewById(R.id.Title);

        registerForContextMenu(DBS);
        registerForContextMenu(OCBC);
        registerForContextMenu(UOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the Bank");

        if (v == DBS) {
            wordClicked = "DBS";
        } else if (v == OCBC) {
            wordClicked = "OCBC";
        } else if (v == UOB) {
            wordClicked = "UOB";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1800111111));
                startActivity(intent);
                return true;
            } else if (wordClicked.equalsIgnoreCase("OCBC")) {
                if (item.getItemId() == 0) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == 1) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1800363333));
                    startActivity(intent);
                    return true;
                } else if (wordClicked.equalsIgnoreCase("UOB")) {
                    if (item.getItemId() == 0) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                        startActivity(intent);
                        return true;
                    } else if (item.getItemId() == 1) {
                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1800222212));
                        startActivity(intent);
                        return true;
                    }
                }
                return super.onContextItemSelected(item);
            }
        }
        return false;
    }
    @Override
        public boolean onCreateOptionsMenu (Menu menu) {
            getMenuInflater().inflate(R.menu.menu, menu);
            return true;
        }


    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.EnglishSelection) {
            DBS.setText("DBS");
            OCBC.setText("OCBC");
            UOB.setText("UOB");
            Title.setText("SG Banking Services");
        }
        else if (id == R.id.ChineseSelection) {
            DBS.setText("星展银行");
            OCBC.setText("华侨银行");
            UOB.setText("大华银行");
            Title.setText("新加坡银行服务");
        } else {
            DBS.setText("Error Translation");
            OCBC.setText("Error Translation");
            UOB.setText("Error Translation");
            Title.setText("Error Translation");
        }
        return super.onOptionsItemSelected(item);
    }
}

