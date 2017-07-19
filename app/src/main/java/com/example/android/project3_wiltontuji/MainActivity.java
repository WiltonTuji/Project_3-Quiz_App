package com.example.android.project3_wiltontuji;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void verificar(View view) {
        total = 0;
        questao1();
        questao2();
        questao3();
        questao4();
        String totalStr = Integer.toString(total);
        String textoToast = getText(R.string.acerto) + " " + totalStr + " " + getText(R.string.questoes);
        Toast.makeText(getApplicationContext(), textoToast, Toast.LENGTH_LONG).show();
    }

    public void questao1() {
        TextView gabarito1 = (TextView) findViewById(R.id.gabarito_1);
        RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.radio_group_1);
        RadioButton radioDo = (RadioButton) findViewById(R.id.radio_do);
        RadioButton radioFa = (RadioButton) findViewById(R.id.radio_fa);
        RadioButton radioSol = (RadioButton) findViewById(R.id.radio_sol);
        if (radioGroup1.getCheckedRadioButtonId() == -1) {
            gabarito1.setText(R.string.vazio);
        }
        if (radioDo.isChecked()) {
            gabarito1.setText(R.string.erradoDo);
        }
        if (radioFa.isChecked()) {
            gabarito1.setText(R.string.erradoFa);
        }
        if (radioSol.isChecked()) {
            gabarito1.setText(R.string.certo);
            total += +1;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void questao2() {
        String resp2;
        TextView gabarito2 = (TextView) findViewById(R.id.gabarito_2);
        EditText respostaUsuario2 = (EditText) findViewById(R.id.resposta_usuario_2);
        resp2 = respostaUsuario2.getText().toString();
        if (Objects.equals(resp2, "Tempo")) {
            resp2 = "tempo";
        }
        if (Objects.equals(resp2, "tempo")) {
            gabarito2.setText(R.string.certo);
            total += +1;
        } else {
            gabarito2.setText(R.string.erradoTempo);
        }
        if (Objects.equals(resp2, "")) {
            gabarito2.setText(R.string.campoVazio);
        }
    }

    private void questao3() {
        boolean checkLento;
        CheckBox checkLento_View = (CheckBox) findViewById(R.id.checkbox_lento);
        checkLento = checkLento_View.isChecked();
        boolean checkSaudosista;
        CheckBox checkSaudosista_View = (CheckBox) findViewById(R.id.checkbox_saudosista);
        checkSaudosista = checkSaudosista_View.isChecked();
        boolean checkMarcia;
        CheckBox checkMarcia_View = (CheckBox) findViewById(R.id.checkbox_marcia_moderato);
        checkMarcia = checkMarcia_View.isChecked();
        boolean checkAllegretto;
        CheckBox checkAllegretto_View = (CheckBox) findViewById(R.id.checkbox_allegretto);
        checkAllegretto = checkAllegretto_View.isChecked();
        boolean checkVibrant;
        CheckBox checkVibrant_View = (CheckBox) findViewById(R.id.checkbox_vibrant);
        checkVibrant = checkVibrant_View.isChecked();

        if (checkLento == true && checkSaudosista == false && checkMarcia == true && checkAllegretto == true && checkVibrant == false) {
            TextView gabarito3 = (TextView) findViewById(R.id.gabarito_3);
            gabarito3.setText(R.string.certo);
            total += +1;
        } else {
            TextView gabarito3 = (TextView) findViewById(R.id.gabarito_3);
            gabarito3.setText(R.string.errado);
        }
    }

    public void questao4() {
        TextView gabarito4 = (TextView) findViewById(R.id.gabarito_4);
        RadioGroup radioGroup4 = (RadioGroup) findViewById(R.id.radio_group_4);
        RadioButton ABCDEFG = (RadioButton) findViewById(R.id.ABCDEFG);
        RadioButton BCDEFGA = (RadioButton) findViewById(R.id.BCDEFGA);
        RadioButton CDEFGAB = (RadioButton) findViewById(R.id.CDEFGAB);
        if (radioGroup4.getCheckedRadioButtonId() == -1) {
            gabarito4.setText(R.string.vazio);
        }
        if (ABCDEFG.isChecked()) {
            gabarito4.setText(R.string.erradoDica);
        }
        if (BCDEFGA.isChecked()) {
            gabarito4.setText(R.string.erradoDica);
        }
        if (CDEFGAB.isChecked()) {
            gabarito4.setText(R.string.certo);
            total += +1;
        }
    }

}
