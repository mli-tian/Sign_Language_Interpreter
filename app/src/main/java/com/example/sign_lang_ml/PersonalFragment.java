package com.example.sign_lang_ml;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.sign_lang_ml.dialog.DialogManager;
import com.example.sign_lang_ml.dialog.DialogView;

public class PersonalFragment extends Fragment implements View.OnClickListener {

    private Button logout, about, change, information;
    private DialogView mDialogVisual;
    private SharedPreferences spf;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_personal, container, false);

        find(rootView);

        spf = requireActivity().getSharedPreferences("users", Context.MODE_PRIVATE);
        String fetch_username = spf.getString("username", "");

        mDialogVisual = DialogManager.getInstance().initView(requireActivity(), R.layout.my_dialog_test, Gravity.BOTTOM);
        mDialogVisual.setCanceledOnTouchOutside(false);

        return rootView;
    }

    public void find(View rootView) {
        logout = rootView.findViewById(R.id.log_out);
        about = rootView.findViewById(R.id.about);
        change = rootView.findViewById(R.id.changes);
        information = rootView.findViewById(R.id.information);
        logout.setOnClickListener(this);
        about.setOnClickListener(this);
        change.setOnClickListener(this);
        information.setOnClickListener(this);
    }

    public void checkInfo() {
        Intent intent = new Intent(requireActivity(), showprofile.class);
        startActivity(intent);
    }

    public void changePassword() {
        Intent intent = new Intent(requireActivity(), ModifypwdActivity.class);
        startActivity(intent);
    }

    public void aboutUs() {
        DialogManager.getInstance().show(mDialogVisual);
        mDialogVisual.setCanceledOnTouchOutside(true);
    }

    public void logout() {
        Toast.makeText(requireContext(), "成功退出登录！", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(requireActivity(), LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.information) {
            checkInfo();
        } else if (view.getId() == R.id.log_out) {
            logout();
        } else if (view.getId() == R.id.changes) {
            changePassword();
        } else if (view.getId() == R.id.about) {
            aboutUs();
        }
    }
}

