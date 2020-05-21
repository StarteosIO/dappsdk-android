package io.starteos.simplewalletdemo;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Authorization successful callback page
 * 1、auth login successful
 * 2、auth transfer successful
 *
 * @author ggband
 */
public class AuthCallbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth_callback);
        initData();
    }

    /**
     * init data
     */
    @SuppressLint("SetTextI18n")
    private void initData() {
        TextView tvAction = findViewById(R.id.tv_action);
        TextView tvResult = findViewById(R.id.tv_result);
        tvResult.setMovementMethod(ScrollingMovementMethod.getInstance());
        Uri uri = getIntent().getData();
        Bundle bundle = getIntent().getExtras();
        if (uri != null) {
            String action = uri.getQueryParameter("action");
            tvAction.setText("action:" + action);
            tvResult.setText("result:" + uri.getQuery());
            String data = bundle.getString("data");
            if (!TextUtils.isEmpty(data)) {
                tvResult.setText("result:" + data);
            }
        }


    }
}
