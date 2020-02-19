package com.example.mykuangjia;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.mykuangjia.ui.home.HomeFragment;
import com.example.mykuangjia.ui.special.SpecialFragment;
import com.example.mykuangjia.ui.classification.ClassificationFragment;
import com.example.mykuangjia.ui.shoppingcart.ShoppingcartFragment;
import com.example.mykuangjia.ui.own.OwnFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fragmentBox)
    FrameLayout fragmentBox;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    private HomeFragment shouye;
    private SpecialFragment zhuanti;
    private ClassificationFragment fenlei;
    private ShoppingcartFragment gouwuche;
    private OwnFragment wode;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        Intent intent  = new Intent(this, TestActivity.class);
//        startActivity(intent);
        initView();

    }

    private void initView() {
        shouye = new HomeFragment();
        zhuanti = new SpecialFragment();
        fenlei = new ClassificationFragment();
        gouwuche = new ShoppingcartFragment();
        wode = new OwnFragment();
        fragmentManager = getSupportFragmentManager();
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch (menuItem.getItemId()){
                    case R.id.shouyeitem:
                        transaction.replace(R.id.fragmentBox,shouye).commit();
                        break;
                    case R.id.zhuantiitem:
                        transaction.replace(R.id.fragmentBox,zhuanti).commit();
                        break;
                    case R.id.fenleiitem :
                        transaction.replace(R.id.fragmentBox,fenlei).commit();
                        break;
                    case R.id.gouwucheitem:
                        transaction.replace(R.id.fragmentBox,gouwuche).commit();
                        break;
                    case R.id.wodeitem :
                        transaction.replace(R.id.fragmentBox,wode).commit();
                        break;
                }
                return false;
            }
        });
    }
}
