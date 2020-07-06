package com.example.mvp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.mvp.R;
import com.example.mvp.databinding.ActivityMainBinding;
import com.example.mvp.model.interactors.impl.GetNextPriceImpl;
import com.example.mvp.presenter.IMainPresenter;
import com.example.mvp.presenter.IMainSingleContractApproach;
import com.example.mvp.presenter.impl.MainPresenterImpl;
//public class MainActivity extends AppCompatActivity implements IMainView OR
public class MainActivity extends AppCompatActivity implements IMainSingleContractApproach.IMainView {

    ActivityMainBinding binding = null;
    IMainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mainPresenter = new MainPresenterImpl(this, new GetNextPriceImpl());

        binding.btnGetPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.onGetPriceClick();
            }
        });
    }

    @Override
    public void showProgress() {
        binding.pbProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        binding.pbProgress.setVisibility(View.GONE);
    }

    @Override
    public void setPrice(String price) {
        binding.txtText.setText(price);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.onDestory();
    }
}
