package com.archer.demos.dialogfragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.archer.demos.R;

public class DialogFragmentSampleActivity extends AppCompatActivity implements LoginDialogFragment.LoginInputListener {

    private static final String TAG = "DialogFragmentSampleActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_fragment_sample);
    }

    public void showConfirmDialog(View view) {
        FireMissilesDialogFragment fireMissilesDialog = new FireMissilesDialogFragment();
        fireMissilesDialog.show(getSupportFragmentManager(), "FireMissilesDialog");
    }

    public void showEditDialog(View view) {
        EditNameDialogFragment editNameDialog = new EditNameDialogFragment();
        editNameDialog.show(getSupportFragmentManager(), "EditNameDialog");
    }

    public void showLoginDialog(View view) {
        LoginDialogFragment loginDialog = new LoginDialogFragment();
        loginDialog.show(getSupportFragmentManager(), "LoginDialog");
    }

    public void showDialogInDifferentScreen(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        EditNameDialogFragment editNameDialog = new EditNameDialogFragment();
        boolean isLargeLayout = getResources().getBoolean(R.bool.large_layout);
        if (isLargeLayout) {
            editNameDialog.show(fragmentManager, "EditNameDialog");
        } else {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            transaction.replace(R.id.id_ly, editNameDialog).commit();
        }
    }

    public void showLoginDialogWithoutFragment(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.fragment_login_dialog, null))
                .setPositiveButton("Sign in", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Toast.makeText(DialogFragmentSampleActivity.this, "登录", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", null)
                .show();
    }

    @Override
    public void onLoginInputComplete(String username, String password) {
        Toast.makeText(this, "账号="+username+", 密码="+password, Toast.LENGTH_SHORT).show();
    }
}
