package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.surpass.paykey.PayPassDialog;
import com.surpass.paykey.PayPassView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        payDialog();
    }
    /**
     * 余额支付弹框
     */
    private void payDialog() {
        final PayPassDialog dialog=new PayPassDialog(this);
        dialog.getPayViewPass()
                .setShowPrice("100")
                .setPayClickListener(new PayPassView.OnPayClickListener() {
                    @Override
                    public void onPassFinish(String passContent) {
                        //6位输入完成回调
                        Toast.makeText(MainActivity.this, ""+passContent, Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onPayClose() {
                        dialog.dismiss();
                        Toast.makeText(MainActivity.this, "关闭回调", Toast.LENGTH_SHORT).show();
                        //关闭回调
                    }
                    @Override
                    public void onPayForget() {
                        dialog.dismiss();
                        Toast.makeText(MainActivity.this, "忘记密码", Toast.LENGTH_SHORT).show();
                        //点击忘记密码回调
                    }
                });
    }
}
