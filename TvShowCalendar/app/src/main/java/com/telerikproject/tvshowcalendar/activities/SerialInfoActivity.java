package com.telerikproject.tvshowcalendar.activities;

        import android.graphics.drawable.Drawable;
        import android.media.Image;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.Toolbar;
        import android.text.method.ScrollingMovementMethod;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;

        import com.telerikproject.tvshowcalendar.R;

        import org.w3c.dom.Text;

public class SerialInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serial_info);

        Toolbar toolbar = (Toolbar) this.findViewById(R.id.toolbar);
        this.setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        TextView description = (TextView) this.findViewById(R.id.tv_description);
        description.setMovementMethod(new ScrollingMovementMethod());

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            onBackPressed();
            break;
        }

        return super.onOptionsItemSelected(item);
    }
}
