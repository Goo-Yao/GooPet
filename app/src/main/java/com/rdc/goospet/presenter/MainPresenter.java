package com.rdc.goospet.presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.CompoundButton;

import com.rdc.goospet.adapter.RVMainAdapter;
import com.rdc.goospet.base.BasePresenter;
import com.rdc.goospet.entity.PetInfo;
import com.rdc.goospet.model.MainModel;
import com.rdc.goospet.model.minterface.MainMInterface;
import com.rdc.goospet.utils.AppConstants;
import com.rdc.goospet.utils.ToastUtil;
import com.rdc.goospet.view.vinterface.MainVInterface;

/**
 * Created by Goo on 2016-9-18.
 */
public class MainPresenter extends BasePresenter<MainVInterface> {

    private MainMInterface mModel;

    public MainPresenter(MainVInterface viewInterface) {
        super(viewInterface);
        mModel = new MainModel();
    }

    /**
     * 获取已配置的RVAdapter
     *
     * @param context
     * @return
     */
    public RVMainAdapter getRVAdapter(final Context context) {
        RVMainAdapter adapter = new RVMainAdapter(context, mModel.getPetData());
        adapter.setOnRvItemClickListener(new RVMainAdapter.OnRvItemClickListener() {
            @Override
            public void onItemClick(View view, PetInfo petInfo) {
                ToastUtil.showToast(context, "PetInfo:" + petInfo.getName() + "\n" + petInfo.getDescription());
            }
        });
        adapter.setOnPetSelectedListener(new RVMainAdapter.OnPetSelectedListener() {

            @Override
            public void onPetSelected(CompoundButton buttonView, int petId) {
                boolean isCheck = buttonView.isChecked();
                if (isCheck) {
                    view.launchDesktopPet();
                }
                switch (petId) {
                    case AppConstants.PET_BIRD:
                        break;
                    case AppConstants.PET_COW:
                        break;
                    case AppConstants.PET_PIG:
                        break;
                    case AppConstants.PET_OWL:
                        break;
                    default:
                        break;
                }
            }
        });
        return adapter;
    }


    public ItemTouchHelper getItemTouchHelper(final RVMainAdapter adapter) {
        return new ItemTouchHelper(new ItemTouchHelper.Callback() {

            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                return makeMovementFlags(ItemTouchHelper.UP |
                        ItemTouchHelper.DOWN, 0);
            }

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                int fromPosition = viewHolder.getAdapterPosition();
                int toPosition = target.getAdapterPosition();
                adapter.swapData(fromPosition, toPosition);
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            }

            @Override
            public boolean isLongPressDragEnabled() {
                return true;
            }

        });
    }


}
