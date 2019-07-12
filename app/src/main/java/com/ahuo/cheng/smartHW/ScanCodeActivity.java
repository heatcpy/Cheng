package com.ahuo.cheng.smartHW;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import com.ahuo.cheng.R;
import com.covics.zxingscanner.OnDecodeCompletionListener;
import com.covics.zxingscanner.ScannerView;

public class ScanCodeActivity extends Activity implements OnDecodeCompletionListener {

    private ScannerView scannerView;
    private String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_scancode);
        init();
    }

    private void init() {
        scannerView = (ScannerView) findViewById(R.id.scanner_view);
        scannerView.setOnDecodeListener(this);
    }

    @Override	//������ɴ���
    public void onDecodeCompletion(String barcodeFormat, String barcode, Bitmap bitmap) {
        if (barcode == null || "".equals(barcode)) {
            AlertDialog builder = new AlertDialog.Builder(ScanCodeActivity.this).
            setTitle("Error").setMessage("Not Found").show();
        } else {
            string = barcode.substring(barcode.indexOf("?") + 1, barcode.length());
            mShowDialog(string);
        }
    }

    @Override	//���¿�ʼ
    protected void onResume() {
        super.onResume();
        scannerView.onResume();
    }

    @Override	//��ͣ
    protected void onPause() {
        super.onPause();
        scannerView.onPause();
    }

    @Override	//
    protected void onDestroy() {
        super.onDestroy();
    }

    /**/

    private void mShowDialog(final String url) {
        AlertDialog alertDialog = new AlertDialog.Builder(ScanCodeActivity.this).setTitle("The Result")
        .setMessage(url).setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        })
        .setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (url.substring(0, 4).equals("http")) {
                    OpenURL(url);
                } else {
                }
            }
        }).show();
    }
    
    private void OpenURL (String url) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
        finish();
    }	
}	
