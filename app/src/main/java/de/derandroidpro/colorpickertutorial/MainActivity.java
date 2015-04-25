package de.derandroidpro.colorpickertutorial;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import net.margaritov.preference.colorpicker.ColorPickerDialog;


public class MainActivity extends ActionBarActivity {

    Button btn;
    TextView tv;
    RelativeLayout layout;

    ColorPickerDialog colorPickerDialog;
    int color = Color.parseColor("#33b5e5");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.textView);
        layout = (RelativeLayout) findViewById(R.id.layout);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                colorPickerDialog = new ColorPickerDialog(MainActivity.this,color );
                colorPickerDialog.setAlphaSliderVisible(true);
                colorPickerDialog.setHexValueEnabled(true);
                colorPickerDialog.setTitle("Farbe auswählen:");
                colorPickerDialog.setOnColorChangedListener(new ColorPickerDialog.OnColorChangedListener() {
                    @Override
                    public void onColorChanged(int i) {
                        color = i;
                        layout.setBackgroundColor(color);
                        tv.setText("#"+ Integer.toHexString(color));
                    }
                });

                colorPickerDialog.show();


            }
        });


    }



}
