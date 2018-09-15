package com.example.root.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.net.Uri;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;
import android.content.Intent;
import android.view.View;

import org.w3c.dom.Text;


public class Login extends AppCompatActivity {
    private TextView welcome;
    private Button signout;
    private ImageView share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView txtopen = findViewById(R.id.openlink);
        signout = findViewById(R.id.btn_signout);
        share = findViewById(R.id.img_share);

        Intent i = getIntent();
        txtopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWebPage("http://bse.kemdikbud.go.id/index.php/buku/filters?kategori=buku_judul&cari=pengolahan+citra+");
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras!=null){
            String Username = extras.getString("Username");

            welcome = findViewById(R.id.tv_welcome);
            welcome.setText("Selamat datang "+Username);

        }


        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                intent.setAction("com.package.ACTION_LOGOUT");
                Login.this.startActivity(intent);
                finish();
            }
        });

    }

    private void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent broserintent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(broserintent);
    }



    public void Share(View view) {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, "My First App");
        shareIntent.setType("text/plain");
        startActivity(shareIntent);
    }



}
