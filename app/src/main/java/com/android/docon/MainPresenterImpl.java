package com.android.docon;

import android.os.Handler;

import com.android.docon.model.Movie;

import java.util.List;

/**
 * Created by Abhishek.Kumar on 2/2/2017.
 */

public class MainPresenterImpl implements MainPresenter, MainInteractor.onNetworkCallFinishListener{

    MainView mMainView;
    MainInteractor mainInteractor;

    public MainPresenterImpl(MainView mainView){
        mMainView = mainView;
        mainInteractor = new MainInteractorImpl();
    }

    @Override
    public void fetchData() {
        if(mMainView != null){
            mMainView.showProgressBar();
        }
        mainInteractor.fetchDataFromNetwork(this);
    }

    @Override
    public void onDestroy() {
        mMainView = null;
    }

    @Override
    public void onSuccess(List<Movie> movies) {
        if(mMainView != null){
            mMainView.hideProgressBar();
            mMainView.setDataToList(movies);
        }
    }

    @Override
    public void onError(String msg) {
        if(mMainView != null){
            mMainView.hideProgressBar();
            mMainView.showError(msg);
        }
    }
}
