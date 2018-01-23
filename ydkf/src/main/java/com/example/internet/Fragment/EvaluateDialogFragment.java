package com.example.internet.Fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

/**
 * author: wangrui
 * date : 2017/8/31
 * description :
 */

public class EvaluateDialogFragment extends DialogFragment {

    private String[] mTitles = {"123", "456", "789"};
    public static final String RESPONSE_EVALUATE = "response_evaluate";

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("").setItems(mTitles, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                setResult(which);
            }
        });
        return builder.create();
    }

    private void setResult(int which) {
        if (getTargetFragment() == null)
            return;
        Intent intent = new Intent();
        intent.putExtra(RESPONSE_EVALUATE, mTitles[which]);
        getTargetFragment().onActivityResult(ContentFragment.REQUEST_EVALUATE,
                Activity.RESULT_OK, intent);
    }
}
