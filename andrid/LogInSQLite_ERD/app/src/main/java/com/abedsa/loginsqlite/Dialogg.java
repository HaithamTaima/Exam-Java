package com.abedsa.loginsqlite;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDialogFragment;


public class Dialogg extends AppCompatDialogFragment {

    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Error")
                .setMessage("راجع الموارد البشرية للتحقق من بياناتك")
                .setPositiveButton("تسجيل الدخول", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });

        return builder.create();
    }
}