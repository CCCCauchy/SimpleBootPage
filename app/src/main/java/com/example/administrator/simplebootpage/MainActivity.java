package com.example.administrator.simplebootpage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ImageView imageView;
    private BootPageAdapter bootPageAdapter;
    private List<Integer> layoutList;

    private int lastPosition;
    private long lastFlyTime = 0;
    private AnimatorSet animatorSet;
    private List<Animator> animatorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        imageView = (ImageView) findViewById(R.id.iv_woman);
        animatorSet = new AnimatorSet();
        animatorList = new ArrayList<>();
        layoutList = new ArrayList<>();
        layoutList.add(R.layout.view_intro_1);
        layoutList.add(R.layout.view_intro_2);
        layoutList.add(R.layout.view_intro_3);
        layoutList.add(R.layout.view_intro_4);
        layoutList.add(R.layout.view_intro_5);
        layoutList.add(R.layout.view_login);

        bootPageAdapter = new BootPageAdapter(this, layoutList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(bootPageAdapter);
        new SlowlyPagerSnapHelper().attachToRecyclerView(recyclerView);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                lastPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition();
                if (((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition() == (layoutList.size() - 1)) {
                    imageView.setVisibility(View.GONE);
                    return;
                } else {
                    imageView.setVisibility(View.VISIBLE);
                }
                AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
                switch (newState) {
                    case RecyclerView.SCROLL_STATE_DRAGGING:
                        animationDrawable.start();
                        break;
                    case RecyclerView.SCROLL_STATE_IDLE:
                        animationDrawable.stop();
                        imageView.setBackgroundResource(R.drawable.man_run);
                        break;
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int firstPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                int currentPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition();

                //倒数第二页滑动到最后一页
                if (firstPosition == 4 && lastPosition == 4 && currentPosition == -1 && dx > 0 && System.currentTimeMillis() - lastFlyTime > 1000) {
                    lastFlyTime = System.currentTimeMillis();
                    RelativeLayout relativeLayout = (RelativeLayout) recyclerView.getChildAt(lastPosition - firstPosition);
                    FlyHolder flyHolder = (FlyHolder) recyclerView.getChildViewHolder(relativeLayout);
                    if (animatorList.size() == 0) {
                        addAnimator(flyHolder, relativeLayout);
                    }
                    if (animatorSet.getChildAnimations() != null && animatorSet.getChildAnimations().size() == 0) {
                        animatorSet.playTogether(animatorList);
                    }
                    animatorSet.start();
                }

                //最后一页滑动到倒数第二页
                if (lastPosition == 5 && firstPosition == 4 && currentPosition == -1 && dx < 0) {
                    animatorSet.cancel();
                    RelativeLayout relativeLayout = (RelativeLayout) recyclerView.getChildAt(lastPosition - firstPosition - 1);
                    FlyHolder flyHolder = (FlyHolder) recyclerView.getChildViewHolder(relativeLayout);
                    resetViews(flyHolder);
                }

                //倒数第三页滑动到倒数第二页（包涵在倒數第二頁小幅度來回滑動，解決动画效果导致view显示异常）
                if (lastPosition == 4 && firstPosition == 3 && currentPosition == -1) {
                    animatorSet.cancel();
                    RelativeLayout relativeLayout = (RelativeLayout) recyclerView.getChildAt(lastPosition - firstPosition);
                    FlyHolder flyHolder = (FlyHolder) recyclerView.getChildViewHolder(relativeLayout);
                    resetViews(flyHolder);
                }
            }
        });

    }

    /**
     * 竖直平移
     *
     * @param view
     */
    public ValueAnimator verticalRun(final View view, float... values) {
        ValueAnimator animator = ValueAnimator.ofFloat(values);
        animator.setTarget(view);
        animator.setDuration(1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                view.setTranslationY((Float) animation.getAnimatedValue());
            }
        });
        return animator;
    }

    private void addAnimator(FlyHolder flyHolder, RelativeLayout parentView) {
        animatorList.add(verticalRun(flyHolder.getIv1(), flyHolder.getIv1().getHeight(), -parentView.getHeight()));
        animatorList.add(verticalRun(flyHolder.getIv2(), flyHolder.getIv2().getHeight(), -parentView.getHeight()));
        animatorList.add(verticalRun(flyHolder.getIv3(), flyHolder.getIv3().getHeight(), -parentView.getHeight()));
        animatorList.add(verticalRun(flyHolder.getIv4(), flyHolder.getIv4().getHeight(), -parentView.getHeight()));
        animatorList.add(verticalRun(flyHolder.getIv5(), flyHolder.getIv5().getHeight(), -parentView.getHeight()));
        animatorList.add(verticalRun(flyHolder.getIv6(), flyHolder.getIv6().getHeight(), -parentView.getHeight()));
        animatorList.add(verticalRun(flyHolder.getIv7(), flyHolder.getIv7().getHeight(), -parentView.getHeight()));
        animatorList.add(verticalRun(flyHolder.getIv8(), flyHolder.getIv8().getHeight(), parentView.getHeight()));
        animatorList.add(verticalRun(flyHolder.getIv9(), flyHolder.getIv9().getHeight(), parentView.getHeight()));
        animatorList.add(verticalRun(flyHolder.getIv10(), flyHolder.getIv10().getHeight(), parentView.getHeight()));
        animatorList.add(verticalRun(flyHolder.getIv11(), flyHolder.getIv11().getHeight(), parentView.getHeight()));
        animatorList.add(verticalRun(flyHolder.getIv12(), flyHolder.getIv12().getHeight(), parentView.getHeight()));
    }

    /***
     * 将每个view的位置重置
     * @param flyHolder
     */
    private void resetViews(FlyHolder flyHolder) {
        flyHolder.getIv1().setTranslationY(0);
        flyHolder.getIv2().setTranslationY(0);
        flyHolder.getIv3().setTranslationY(0);
        flyHolder.getIv4().setTranslationY(0);
        flyHolder.getIv5().setTranslationY(0);
        flyHolder.getIv6().setTranslationY(0);
        flyHolder.getIv7().setTranslationY(0);
        flyHolder.getIv8().setTranslationY(0);
        flyHolder.getIv9().setTranslationY(0);
        flyHolder.getIv10().setTranslationY(0);
        flyHolder.getIv11().setTranslationY(0);
        flyHolder.getIv12().setTranslationY(0);
    }

}
