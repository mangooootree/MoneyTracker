package com.osipov.moneytracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import org.w3c.dom.Text;

public class AddItemActivity extends AppCompatActivity {

    private EditText name;
    private EditText price;
    private Button addBtn;

    public static final String TYPE_KEY = "type";
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        name = findViewById(R.id.item_name);
        price = findViewById(R.id.item_price);
        addBtn = findViewById(R.id.add_btn);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(R.string.itemAdd);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        type = getIntent().getStringExtra(TYPE_KEY);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameValue = name.getText().toString();
                String priceValue = price.getText().toString();

                Item item = new Item(nameValue, priceValue, type);

                Intent intent = new Intent();
                intent.putExtra("item", item);

                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
