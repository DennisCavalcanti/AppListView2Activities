package com.project.saulopz.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ContactActivity extends AppCompatActivity implements View.OnClickListener{
    private int id;
    private EditText textName;
    private EditText textPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        findViewById(R.id.buttonSave).setOnClickListener(this);
        findViewById(R.id.buttonClose).setOnClickListener(this);

        textName = ((EditText) findViewById(R.id.editTextName));
        textPhone = ((EditText) findViewById(R.id.editTextPhone));

        Bundle args = getIntent().getExtras();
        id = args.getInt("id");
        textName.setText(args.getString("name"));
        textPhone.setText(args.getString("phone"));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonClose:
                setResult(this.RESULT_CANCELED);
                break;
            case R.id.buttonSave:
                Intent data = new Intent();
                Bundle parms = new Bundle();
                parms.putInt("id", id);
                parms.putString("name", textName.getText().toString());
                parms.putString("phone", textPhone.getText().toString());
                data.putExtras(parms);
                setResult(this.RESULT_OK, data);
                break;
        }
        finish();
    }
}
