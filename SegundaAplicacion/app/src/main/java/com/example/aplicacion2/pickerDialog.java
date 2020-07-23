package com.example.aplicacion2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
import java.util.Calendar;

public class pickerDialog extends DialogFragment {

    private DatePickerDialog.OnDateSetListener listener;

    public static pickerDialog newInstance(DatePickerDialog.OnDateSetListener listener){
        pickerDialog fragment = new pickerDialog();
        fragment.setListener(listener);
        return fragment;
    }

    public void setListener(DatePickerDialog.OnDateSetListener listener){
        this.listener = listener;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int año = c.get(Calendar.YEAR);
        int mes = c.get(Calendar.MONTH);
        int dia = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), listener, año, mes, dia);

    }
}