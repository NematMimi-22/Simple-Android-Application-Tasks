package com.example.a1181766nematmimi;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class activity_add_boat extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_boat);


        String[] options = { "Red", "Blue","White","Black" };
        final Spinner colorSpinner =(Spinner)
                findViewById(R.id.spinner_Color);
        ArrayAdapter<String> objColorArr = new
                ArrayAdapter<>(this,android.R.layout.simple_spinner_item, options);
        colorSpinner.setAdapter(objColorArr);

        final EditText nameEditText =
                (EditText)findViewById(R.id.edit_boatName);



        Button addBoatButton = (Button) findViewById(R.id.add_boat);
        Button back_button = (Button) findViewById(R.id.back_button);
        addBoatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boat newBoat =new boat();

                if(nameEditText.getText().toString().isEmpty()) newBoat.setmName("No Name");
                else newBoat.setmName(nameEditText.getText().toString());
                newBoat.setmColor(colorSpinner.getSelectedItem().toString());


                DataBaseHelper dataBaseHelper =new DataBaseHelper(activity_add_boat.this,"M1181766",null,1);
                dataBaseHelper.insertBoat(newBoat);


                Intent intent=new Intent(activity_add_boat.this,MainActivity.class);
                activity_add_boat.this.startActivity(intent);
                finish();
            }
        });
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(activity_add_boat.this,MainActivity.class);
                activity_add_boat.this.startActivity(intent);
                finish();
            }
        });



    }
}




