package com.example.mvp.presenter.impl;

import com.example.mvp.presenter.IMainSingleContractApproach;
import com.example.mvp.view.IMainView;
import com.example.mvp.model.interactors.IGetNextPriceInteractor;
import com.example.mvp.presenter.IMainPresenter;

public class MainPresenterImpl implements IMainPresenter, IMainSingleContractApproach.IGetNextPriceInteractor.OnFinishedListener {

    IMainSingleContractApproach.IMainView mainView;// Represents View
    IMainSingleContractApproach.IGetNextPriceInteractor priceInteractor; //Represents Model

    public MainPresenterImpl(IMainSingleContractApproach.IMainView mainView, IMainSingleContractApproach.IGetNextPriceInteractor priceInteractor){
        this.mainView = mainView;
        this.priceInteractor = priceInteractor;
    }

    @Override
    public void onGetPriceClick() {
        if(mainView != null){
            mainView.showProgress();
        }

        priceInteractor.getNextPrice(this);
    }

    @Override
    public void onDestory() {
        mainView = null;
    }


    @Override
    public void onFinished(String text) {
        if(mainView != null){
            mainView.setPrice(text);
            mainView.hideProgress();
        }
    }
}
