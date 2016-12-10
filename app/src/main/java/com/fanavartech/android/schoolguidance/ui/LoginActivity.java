package com.fanavartech.android.schoolguidance.ui;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.fanavartech.android.schoolguidance.R;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText inputPassword, inputUsername;
    private String username, password;
    private Context mContext;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = (Button) findViewById(R.id.btn_login);
        final Typeface type = Typeface.createFromAsset(getAssets(), "fonts/sans_light.ttf");
        btnLogin.setTypeface(type);
        inputPassword = (EditText) findViewById(R.id.input_password);
        inputUsername = (EditText) findViewById(R.id.input_username);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = inputUsername.getText().toString();
                password = inputPassword.getText().toString();
                if (username.isEmpty()) {
                    Snackbar snackbar = Snackbar
                            .make(view, getString(R.string.str_show_complete_username), Snackbar.LENGTH_LONG);
                    TextView tv = (TextView) (snackbar.getView()).findViewById(android.support.design.R.id.snackbar_text);
                    tv.setTextColor(Color.YELLOW);
                    Typeface font = Typeface.createFromAsset(getAssets(), "fonts/sans_light.ttf");
                    tv.setTypeface(font);
                    snackbar.show();
                } else if (password.isEmpty() || inputPassword.getText().length() < 5) {
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.custom_toast_view,
                            (ViewGroup) findViewById(R.id.custom_toast_container));

                    TextView text = (TextView) layout.findViewById(R.id.tv_text_toast);
                    text.setText(R.string.str_show_complete_password);

                    Toast toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                    toast.setDuration(Toast.LENGTH_LONG);
                    toast.setView(layout);
                    toast.show();
                }
                else {
                Intent intent = new Intent(getApplicationContext(), TestActivity.class);
                startActivity(intent);
                finish();}


                //TODO check parameter of server
                //password = md5(password);
                //connectToServer(username, password);

            }
        });
    }

    public void connectToServer(String username, String password) {
        JsonObject json = new JsonObject();
        json.addProperty("username", username);
        json.addProperty("password", password);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("action-type", "parent-login");
        jsonObject.add("action-body", json);

        Ion.with(getApplicationContext())
                .load("esns-server.herokuapp.com/esns/users/parents/login")
                .setJsonObjectBody(jsonObject)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        // do stuff with the result or error
                        try {
                            Log.d("RESULT", result.toString());

                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }


                    }
                });
    }

    private static String md5(String in) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
            digest.reset();
            digest.update(in.getBytes());
            byte[] a = digest.digest();
            int len = a.length;
            StringBuilder sb = new StringBuilder(len << 1);
            for (int i = 0; i < len; i++) {
                sb.append(Character.forDigit((a[i] & 0xf0) >> 4, 16));
                sb.append(Character.forDigit(a[i] & 0x0f, 16));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
