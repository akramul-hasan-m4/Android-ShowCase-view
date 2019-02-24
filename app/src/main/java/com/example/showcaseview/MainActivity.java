package com.example.showcaseview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.Target;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ShowcaseView sv;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setDynamicSingleTip(R.id.buttonBlocked, "First title", "First msg", 1);
    }

    @Override
    public void onClick(View view) {
        switch (counter) {
            case 1:
                setDynamicSingleTip(R.id.buttonBlocked2, "Second title", "Secind msg",2);
                break;
            case 2:
                setDynamicSingleTip(R.id.btn3, "3rd title", "3rd msg",3);
                sv.setButtonText("Ok");
                break;
            case 3:
                sv.hide();
                break;
            default:
        }
    }

    private void setDynamicSingleTip(int viewId, String title, String message, long shotUniqueId){
        counter++;
        Target viewTarget = new ViewTarget(viewId, this);
        if (sv != null && sv.isShowing()){
            sv.hide();
        }
        sv =  new ShowcaseView.Builder(this)
                .setTarget(viewTarget)
                .setContentTitle(title)
                .setContentText(message)
                .setStyle(R.style.myCustomShowcaseTheme2)
                .singleShot(shotUniqueId)
                .setOnClickListener(this)
                .build();
    }
}
