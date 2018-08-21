package com.archer.demos.filepath;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.archer.demos.BaseActivity;
import com.archer.demos.R;
import com.mylhyl.acp.Acp;
import com.mylhyl.acp.AcpListener;
import com.mylhyl.acp.AcpOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ChooseFileActivity extends BaseActivity {
    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_choose_file;
    }

    @Override
    protected void initEventAndData() {

    }

    @OnClick(R.id.btn)
    public void onViewClicked(View view) {
        if (Build.VERSION.SDK_INT >= 23) {
            String storageMsg = "存储空间";
            Acp.getInstance(this).request(new AcpOptions.Builder()
                            .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                    Manifest.permission.READ_EXTERNAL_STORAGE)
                            .setDeniedMessage(String.format(getResources().getString(R.string.request_permission_denied_message), storageMsg))
                            .setDeniedSettingBtn("去设置")
                            .setDeniedCloseBtn("退出")
                            .setRationalMessage(String.format(getResources().getString(R.string.request_permission_rational_message), storageMsg))
                            .setRationalBtn("知道了")
                            .build(),

                    new AcpListener() {
                        @Override
                        public void onGranted() {
                            chooseFile();
                        }

                        @Override
                        public void onDenied(List<String> permissions) {
                            ChooseFileActivity.this.finish();
                        }
                    });
        } else {
            chooseFile();
        }
    }

    private void chooseFile() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//        intent.setType("application/msword");   //打开文件类型   Word文档
        intent.setType("*/*");//无类型限制
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, 1);
    }

    private String path;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
            if ("file".equalsIgnoreCase(uri.getScheme())){//使用第三方应用打开
                path = uri.getPath();
                tv.setText(path);
                Toast.makeText(this,path+"11111",Toast.LENGTH_SHORT).show();
                return;
            }
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {//4.4以后
                path = ContentUriUtil.getFilePathForUri(this, uri);
                if (TextUtils.isEmpty(path)) {
                    path = ContentUriUtil.getPath(this, uri);
                }
                if (TextUtils.isEmpty(path)) {
                    path = uri.getPath();
                    if (path != null && path.contains("/storage/")) {
                        path = path.substring(path.indexOf("/storage/"));
                    }
                }
                tv.setText(path);
                Toast.makeText(this,path,Toast.LENGTH_SHORT).show();
            } else {//4.4以下下系统调用方法
                path = ContentUriUtil.getRealPathFromURI(this, uri);
                tv.setText(path);
                Toast.makeText(this, path+"222222", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
