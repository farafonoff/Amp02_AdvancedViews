package com.github.farafonoff.advancedviews.dummy;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.github.farafonoff.advancedviews.R;

/**
 * Created by beaver on 24.01.2016.
 */
public class TextDialog extends DialogFragment implements DialogInterface.OnClickListener {
    EditText editText;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.add_dialog, null);
        AlertDialog.Builder adb = new AlertDialog.Builder(getActivity())
                .setTitle(R.string.add)
                .setPositiveButton(R.string.add, this)
                .setNegativeButton(android.R.string.no, this)
                .setView(view);
        editText = (EditText) view.findViewById(R.id.textedit);
        return adb.create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case DialogInterface.BUTTON_NEGATIVE:
                dialog.cancel();
                break;
            case DialogInterface.BUTTON_POSITIVE:
                DummyItems.ITEMS.add(0, new DummyItems.DummyItem(editText.getText().toString()));
                dialog.dismiss();
                break;
        }
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
    }
}
