package com.telerikproject.tvshowcalendar.views.serialInfo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.telerikproject.tvshowcalendar.BaseApplication;
import com.telerikproject.tvshowcalendar.R;
import com.telerikproject.tvshowcalendar.adapters.SeasonsListAdapter;
import com.telerikproject.tvshowcalendar.factories.base.ILoadingFactory;
import com.telerikproject.tvshowcalendar.fragments.base.ILoadingFragment;
import com.telerikproject.tvshowcalendar.modules.ControllerModule;
import com.telerikproject.tvshowcalendar.views.serialInfo.base.ISerialInfoContract;

import javax.inject.Inject;

public class SerialInfoContentFragment extends Fragment implements ISerialInfoContract.View {

    private ISerialInfoContract.Presenter presenter;

    @Inject
    ILoadingFactory loadingFactory;

    View view;
    TextView tvRating;
    ImageView movieImage;
    TextView tvDescription;
    ListView seasons;

    private ILoadingFragment loading;

    public SerialInfoContentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_serial_info_content, container, false);
        this.injectDependencies();

        this.tvRating = (TextView) view.findViewById(R.id.tv_rating);
        this.movieImage = (ImageView) view.findViewById(R.id.movie_image);
        this.tvDescription = (TextView) view.findViewById(R.id.tv_description);
        this.loading = loadingFactory.create();

        seasons = (ListView) view.findViewById(R.id.lv_seasons);
        return view;
    }

    @Override
    public void setPresenter(ISerialInfoContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setTitle(String title) {
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(title);
    }

    @Override
    public void fillInfo(String image, String tvRating, String tvDescription, int numOfSeasons, String tvShowId) {
        this.tvDescription.setText(tvDescription);
        this.tvDescription.setMovementMethod(LinkMovementMethod.getInstance());
        this.tvRating.setText(tvRating);
        Glide.with(getActivity()).load(image).into(movieImage);

        seasons.setAdapter(new SeasonsListAdapter(getActivity(), numOfSeasons, tvShowId));

        justifyListViewHeightBasedOnChildren(seasons);
    }

    @Override
    public void showLoading() {
        this.loading.show();
    }

    @Override
    public void hideLoading() {
        this.loading.hide();
    }

    public static void justifyListViewHeightBasedOnChildren (ListView listView) {

        ListAdapter adapter = listView.getAdapter();

        if (adapter == null) {
            return;
        }
        ViewGroup vg = listView;
        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, vg);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams par = listView.getLayoutParams();
        par.height = totalHeight + (listView.getDividerHeight() * (adapter.getCount() - 1));
        listView.setLayoutParams(par);
        listView.requestLayout();
    }

    private void injectDependencies() {
        BaseApplication
                .from(getContext())
                .getAppComponent()
                .getControllerComponent(new ControllerModule(
                        getActivity(), getFragmentManager()
                ))
                .inject(this);
    }
}
