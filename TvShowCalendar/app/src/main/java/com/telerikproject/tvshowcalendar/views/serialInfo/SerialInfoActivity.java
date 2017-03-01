package com.telerikproject.tvshowcalendar.views.serialInfo;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.telerikproject.tvshowcalendar.BaseApplication;
import com.telerikproject.tvshowcalendar.R;
import com.telerikproject.tvshowcalendar.fragments.ILoadingFragment;
import com.telerikproject.tvshowcalendar.modules.ControllerModule;
import com.telerikproject.tvshowcalendar.views.serialInfo.base.ISerialInfoContract;

import org.w3c.dom.Text;

import javax.inject.Inject;

public class SerialInfoActivity extends AppCompatActivity {

    @Inject
    ISerialInfoContract.Presenter contentPresenter;

    private String id;
    private ILoadingFragment loading;

    @Inject
    FragmentManager fragmentManager;

    @Inject
    ILoadingFragment loadingFragment;

    private SerialInfoContentFragment content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serial_info);

        this.injectDependencies();

        content = (SerialInfoContentFragment) fragmentManager.findFragmentById(R.id.fragment_serial_info_content);

        contentPresenter.setView(content);
        content.setPresenter(contentPresenter);
        this.id = getIntent().getStringExtra("id");
        this.loading = loadingFragment.create(this);


//        contentPresenter.getSerial(id, loading);

//        Toolbar toolbar = (Toolbar) this.findViewById(R.id.toolbar);
//        this.setSupportActionBar(toolbar);
//
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//
//        TextView description = (TextView) this.findViewById(R.id.tv_description);
//        description.setMovementMethod(new ScrollingMovementMethod());

        //examples
//        String serialName = "The Originals";
//        ImageView image = (ImageView) this.findViewById(R.id.serial_image);
//        String uri = "@drawable/the_originals";
//        int imageResource = getResources().getIdentifier(uri, null, getPackageName());

//        toolbar.setTitle(serialName);
//        Drawable res = getResources().getDrawable(imageResource);
//        image.setImageDrawable(res);
        //end examples
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//        case android.R.id.home:
//            onBackPressed();
//            break;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }


    @Override
    protected void onStart() {
        super.onStart();
        this.contentPresenter.getSerial(this.id, this.loading);
    }

    private void injectDependencies() {
        BaseApplication.bind(this)
                .from(this)
                .getAppComponent()
                .getControllerComponent(new ControllerModule(this, getSupportFragmentManager()))
                .inject(this);
    }
}
