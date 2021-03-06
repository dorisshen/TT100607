package com.test.t100607;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    int sel = -1;
    boolean chk[] = new boolean[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textView);
    }
    public void click1(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("這是對話框");
        builder.setMessage("這是對話框的內容");
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }
    public void click2(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("這是對話框");
        final EditText ed = new EditText(MainActivity.this);
        builder.setView(ed);

        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, ed.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.show();
    }
    public void click3(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("這是對話框");

        final String fruits[] = {"蘋果", "香蕉", "檸檬", "芭樂"};

        builder.setSingleChoiceItems(fruits, sel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sel = which;
                Toast.makeText(MainActivity.this, fruits[which], Toast.LENGTH_SHORT).show();
                tv.setText(fruits[which]);
                dialog.dismiss();
            }
        });

        builder.show();
    }

    public void click4(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("這是對話框");

        final String fruits[] = {"蘋果", "香蕉", "檸檬", "芭樂"};

        builder.setItems(fruits, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, fruits[which], Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        builder.show();
    }

    public void click5(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("這是對話框");

        final String drinks[] = {"汽水", "可樂", "果汁", "紅茶"};
        final boolean tmp[] = chk.clone();
        builder.setMultiChoiceItems(drinks, chk, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

            }
        });

        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String s = "";
                for (int i=0;i<=3;i++)
                {
                    if (chk[i] == true)
                    {
                        s = s + drinks[i];
                    }
                }
                tv.setText(s);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                chk = tmp;
            }
        });

        builder.show();
    }

    public void click6(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("這是自訂對話框");
        LayoutInflater inflater = getLayoutInflater();
        View myView = inflater.inflate(R.layout.mydialog, null);

        Button btn = (Button) myView.findViewById(R.id.button6);
        final TextView tv2 = (TextView) myView.findViewById(R.id.textView2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv2.setText("Hello Hello");
            }
        });

        builder.setView(myView);


        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        builder.show();
    }

    public void click7(View v)
    {
        final ProgressDialog pd = new ProgressDialog(MainActivity.this);
        pd.setTitle("運作中..");
        pd.setMessage("請稍後 ....");
        pd.setCancelable(false);
        pd.show();

        new Thread(){
            @Override
            public void run() {
                super.run();

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        pd.dismiss();
                    }
                });

            }
        }.start();


    }
}
