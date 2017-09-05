package com.example.administrator.simplebootpage;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Administrator on 2017/9/5.
 */

public class FlyHolder extends RecyclerView.ViewHolder {

    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv3;
    private ImageView iv4;
    private ImageView iv5;
    private ImageView iv6;
    private ImageView iv7;
    private ImageView iv8;
    private ImageView iv9;
    private ImageView iv10;
    private ImageView iv12;

    public ImageView getIv1() {
        return iv1;
    }

    public ImageView getIv2() {
        return iv2;
    }

    public ImageView getIv3() {
        return iv3;
    }

    public ImageView getIv4() {
        return iv4;
    }

    public ImageView getIv5() {
        return iv5;
    }

    public ImageView getIv6() {
        return iv6;
    }

    public ImageView getIv7() {
        return iv7;
    }

    public ImageView getIv8() {
        return iv8;
    }

    public ImageView getIv9() {
        return iv9;
    }

    public ImageView getIv10() {
        return iv10;
    }

    public ImageView getIv12() {
        return iv12;
    }

    public ImageView getIv11() {
        return iv11;
    }

    private ImageView iv11;


    public FlyHolder(View itemView) {
        super(itemView);
        iv1 = (ImageView) itemView.findViewById(R.id.iv_1);
        iv2 = (ImageView) itemView.findViewById(R.id.iv_2);
        iv3 = (ImageView) itemView.findViewById(R.id.iv_3);
        iv4 = (ImageView) itemView.findViewById(R.id.iv_4);
        iv5 = (ImageView) itemView.findViewById(R.id.iv_5);
        iv6 = (ImageView) itemView.findViewById(R.id.iv_6);
        iv7 = (ImageView) itemView.findViewById(R.id.iv_7);
        iv8 = (ImageView) itemView.findViewById(R.id.iv_8);
        iv9 = (ImageView) itemView.findViewById(R.id.iv_9);
        iv10 = (ImageView) itemView.findViewById(R.id.iv_10);
        iv11 = (ImageView) itemView.findViewById(R.id.iv_11);
        iv12 = (ImageView) itemView.findViewById(R.id.iv_12);

    }
}
