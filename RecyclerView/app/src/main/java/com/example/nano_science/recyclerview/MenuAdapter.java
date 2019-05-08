package com.example.nano_science.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/*
* RecyclerView.Adapter
* RecyclerView.ViewHolder
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private Context mCtx;
    private List<Menu> menuList;

    public MenuAdapter(Context mCtx, List<Menu> menuList) {
        this.mCtx = mCtx;
        this.menuList = menuList;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_layout, null);
        MenuViewHolder holder = new MenuViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder menuViewHolder, int i) {

        Menu menu = menuList.get(i);

        menuViewHolder.textViewTitle.setText(menu.getTitle());
        menuViewHolder.textViewDesc.setText(menu.getShortdesc());
        menuViewHolder.textViewPrice.setText(String.valueOf(menu.getPrice()));

        menuViewHolder.imageView.setImageDrawable(mCtx.getResources().getDrawable(menu.getImage()));
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    class MenuViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textViewTitle, textViewDesc, textViewPrice;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);

        }
    }
}
