package com.example.absenmanualapps;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    String spinnerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Spinner spinner = findViewById(R.id.label_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        //menampilkan data dari spinner
        ArrayAdapter<CharSequence> adaptor = ArrayAdapter.createFromResource(this, R.array.Keterangan, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adaptor);

        findViewById(R.id.et_tanggal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePicker();
            }
        });
        findViewById(R.id.et_waktu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePicker();
            }
        });
        findViewById(R.id.button_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog();
            }
        });

    }
    //menampilkan item yang dipilih
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String spinnerText = adapterView.getItemAtPosition(i).toString();
        TextView showKeterangan = findViewById(R.id.et_ket);
        showKeterangan.setText(spinnerText);
        if (i != 0) {
            findViewById(R.id.et_keterangan).setVisibility(View.VISIBLE);
        } else {
            findViewById(R.id.et_keterangan).setVisibility(View.GONE);
        }

    }
    //menampilkan item default yang akan tampil yaitu hadir tepat waktu
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        String spinnerText = adapterView.getItemAtPosition(0).toString();
        TextView showKeterangan = findViewById(R.id.et_ket);
        showKeterangan.setText(spinnerText);

    }
    public void showDatePicker(){
        //buat instansiasi
        DialogFragment dateFragment = new DatePickerFragment();
        //ini yang ditampilin
        dateFragment.show(getSupportFragmentManager(), "date-picker");
    }

    public void processDatePickerResult(int day, int month, int year) {
        String day_string = Integer.toString(day);
        String month_string = Integer.toString(month+1);
        String year_string = Integer.toString(year);

        String dateMessage = day_string + "-" + month_string + "-" + year_string;
        EditText input_tanggal = findViewById(R.id.et_tanggal);
        input_tanggal.setText(dateMessage);
    }

    public  void showTimePicker(){
        DialogFragment timeFragment = new TimePickerFragment();
        timeFragment.show(getSupportFragmentManager(), "time-picker");
    }

    public void processTimePickerResult(int hour, int minute) {
        String hour_string = Integer.toString(hour);
        String minute_string = Integer.toString(minute);

        String timeMessage = hour_string + ":" + minute_string;
        EditText input_waktu = findViewById(R.id.et_waktu);
        input_waktu.setText(timeMessage);
    }

    public void showAlertDialog(){
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SecondActivity.this);
        alertBuilder.setTitle("Konfirmasi");
        alertBuilder.setMessage("Apakah kamu yakin data yang akan kamu kirim sudah benar?");

        //untuk buat yes atau no, new dialog untuk callback
        alertBuilder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String doneMessage = "Absen Berhasil";
                Toast.makeText(getApplicationContext(), doneMessage, Toast.LENGTH_SHORT).show();
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
        alertBuilder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "Baik, Anda belum yakin!", Toast.LENGTH_SHORT).show();

            }
        });
        //untuk show button
        alertBuilder.show();
    }
}